package com.eshop.token;

import com.alibaba.fastjson.JSON;
import org.springframework.core.io.ClassPathResource;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/***
 * 令牌的创建和解析
 */
public class CreateJwtTest {

    /***
     * 创建令牌
     */
    @Test
    public void testCreateToken() {

        //证书文件路径
        String key_location = "eshop.jks";
        //秘钥库密码
        String key_password = "eshopjks";
        //秘钥密码
        String keypwd = "eshopjks";
        //秘钥别名
        String alias = "eshop";

        //访问证书路径 读取jks的文件
        ClassPathResource resource = new ClassPathResource(key_location);

        //创建秘钥工厂
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(resource, key_password.toCharArray());

        //读取秘钥对(公钥、私钥)
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias, keypwd.toCharArray());

        //获取私钥->RSA
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        //创建令牌需要私钥加盐
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("nickname", "tomcat");
        payload.put("address", "Shanghai");
        payload.put("role", "admin,user");

        //生成Jwt令牌
        Jwt jwt = JwtHelper.encode(JSON.toJSONString(payload), new RsaSigner(privateKey));


        //取出令牌数据
        String token = jwt.getEncoded();
        System.out.println(token);
    }

        /***
         * 解析令牌
         */
        @Test
        public void testParseToken(){
            String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhZGRyZXNzIjoiU2hhbmdoYWkiLCJyb2xlIjoiYWRtaW4sdXNlciIsIm5pY2tuYW1lIjoidG9tY2F0In0.EuFtNP0NE3KPZdy5OVQXQkjvekNNU48ABRiVJAwLlf1bmXiG83SqoL2Em6QcQ3K6-S_tJMgHh176gZCBR2cdqRcosj0_ME6xRxlAntYUll2DuB9WAigeL7y1LQe8rtPdv6bBJ36uLynK2OmY4DS1xWyJuLyLwChsrgbWKqWcxv72kVcEhRqC-spvz0qq3gVRfJWolC5gNvYhxwcKZo8xTS7U9upEdzeCRBew0pz7MtK2CSZhP9RJUrROFt4-jiFZsfwnLsT31Ev4H8ofrxJeQle6-gaPI2Xj-LlMiXM3QA6rOjcF7aqE-TI7QPE4q5u1wwFcYz9VNCIZVYWJbL6Fhg";
            String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgnqvymd7Fg1An8NnmEwrsW1vrrlBKpGX0FFumMY01Fu02w5FFIJQAKTTititSPHTsTvvRdWWsHXJIoLcUIhhgLl4KWAJOoGfQrF+RMncRaj6859kyfVcp1v55X2i16qNjWE5u7bYGB/brva8znolJOYErXusyE7OpoHrh50M1GFkY5HhOuwtSLOoWN0tHPf0kwDdKCYkwAN/+0PhSfKVblznFNEmUwuzfEAuwrtGXVF9aOOuhEdt1CZ2wwhlDdruORiVeRgNng8mJ5M1kV+TQKp4SpOgU/0SGGGacQYoWD88d9PaB4apRV2KZQBDxpS2LDWDSCjV4P9EvHRc+8we2wIDAQAB-----END PUBLIC KEY-----";
            Jwt jwt = JwtHelper.decodeAndVerify(token,
                    new RsaVerifier(publickey));
            String claims = jwt.getClaims();
            System.out.println(claims);
        }

        @Test
        public void testDecodeBase64() throws Exception{
            //Basic
            String str = "ZXNob3A6ZXNob3A=";
            byte[] decode = Base64.getDecoder().decode(str);
            String decodestr = new String(decode,"UTF-8");
            System.out.println(decodestr);
            //密钥: clientID:clientpswd->Base64
        }


}
