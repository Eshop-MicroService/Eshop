package com.eshop.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

public class JwtUtil {
    // 有效期为
    public static final Long JWT_TIL = 3600000L;

    // Jwt令牌信息
    public static final String JWT_KEY="itcast";

    /***
     * 创建令牌
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(String id,String subject, Long ttlMillis) {
        // 指定算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        // 当前系统时间
        long nowMillis = System.currentTimeMillis();
        //令牌签发时间
        Date now = new Date(nowMillis);

        //如果令牌有效期为null，则默认设置有效期1小时
        if(ttlMillis==null){
            ttlMillis=JwtUtil.JWT_TIL;
        }
        //令牌过期时间设置
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);

        //生成密钥
        SecretKey secretKey = generalKey();

        //封装Jwt令牌信息
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuer("admin")
                .setIssuedAt(now)
                .signWith(signatureAlgorithm,secretKey)
                .setExpiration(expDate);
        return builder.compact();
    }


    /***
     * 生成加密 secretKey
     * @return
     */
    public static SecretKey generalKey(){
        byte[] encodedKey = Base64.getEncoder().encode(JwtUtil.JWT_KEY.getBytes());
        SecretKey key = new SecretKeySpec(encodedKey, 0,encodedKey.length, "AES");
        return key;

    }

    /***
     * 解析令牌数据
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
