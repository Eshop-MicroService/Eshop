package com.microservice.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    /***
     * 创建令牌
     */
    public void testCreateToken(){
        JwtBuilder builder = Jwts.builder();
        builder.setIssuer("Eshop Admin"); //颁发者
        builder.setIssuedAt(new Date()); //颁发时间
        builder.setExpiration(new Date(System.currentTimeMillis()+3600000)); //过期时间
        builder.setSubject("JWT令牌测试"); //主题信息

        //自定义载荷信息
        Map<String,Object> userInfo = new HashMap<String, Object>();
        userInfo.put("company","Eshop");
        builder.addClaims(userInfo);

        builder.signWith(SignatureAlgorithm.HS256,"itcast"); //1.签名算法  2.密钥
        System.out.println(builder.compact());
    }
    /***
     * 令牌解析
     */
    public void parseToken(){
        String token="";
        Jwts.parser()
                .setSigningKey("itcast") //密钥
                .parseClaimsJws(token) //要解析的令牌对象
                .getBody(); //获取解析后的数据
    }
}
