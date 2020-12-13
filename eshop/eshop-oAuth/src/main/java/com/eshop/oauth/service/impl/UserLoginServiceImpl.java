package com.eshop.oauth.service.impl;

import com.eshop.oauth.service.UserLoginService;
import com.eshop.oauth.util.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Map;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    //实现请求发送
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    /***
     * 登录实现
     * @param username
     * @param password
     * @param clientId
     * @param clientSecret
     * @param grant_type
     * 参数传递：
     * 账号： username=
     * 密码： password=
     * 授权方式： grant_type=password
     * @return
     *
     */
    @Override
    public AuthToken login(String username, String password, String clientId, String clientSecret, String grant_type) {


        //选中认证服务的地址
//        ServiceInstance serviceInstance = loadBalancerClient.choose("user-auth");
//        if (serviceInstance == null) {
//            throw new RuntimeException("找不到对应的服务");
//        }
        //获取令牌的url
        //String path = serviceInstance.getUri().toString() + "/oauth/token";
        String path = "http://localhost:9001/oauth/token";
        //定义body
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        //授权方式
        formData.add("grant_type", "password");
        //账号
        formData.add("username", username);
        //密码
        formData.add("password", password);
        //定义头
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add("Authorization", httpbasic(clientId, clientSecret));
        //指定 restTemplate当遇到400或401响应时候也不要抛出异常，也要正常返回值
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                //当响应的值为400或401时候也要正常响应，不要抛出异常
                if (response.getRawStatusCode() != 400 && response.getRawStatusCode() != 401) {
                    super.handleError(response);
                }
            }
        });
        Map map = null;
        try {
            //http请求spring security的申请令牌接口
            ResponseEntity<Map> mapResponseEntity = restTemplate.exchange(path, HttpMethod.POST,new HttpEntity<MultiValueMap<String, String>>(formData, header), Map.class);
            //获取响应数据
            map = mapResponseEntity.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
        if(map == null) {
            //jti是jwt令牌的唯一标识作为用户身份令牌
            throw new RuntimeException("创建令牌失败！");
        }

        //将响应数据封装成AuthToken对象
        AuthToken authToken = new AuthToken();
        //访问令牌(jwt)
        String accessToken = (String) map.get("access_token");
        //刷新令牌(jwt)
        String refreshToken = (String) map.get("refresh_token");
        //jti，作为用户的身份标识
        String jwtToken= (String) map.get("jti");
        authToken.setJti(jwtToken);
        authToken.setAccessToken(accessToken);
        authToken.setRefreshToken(refreshToken);
        return authToken;
//        //获取指定服务的注册数据
//        ServiceInstance serviceInstance = loadBalancerClient.choose("user-auth");
//        //String url = serviceInstance.getUri()+"/oauth/token";
//        String url = "http://localhost:9001/oauth/token";
//
//        //请求提交的数据封装
//        MultiValueMap<String,String> parameterMap = new LinkedMultiValueMap<String,String>();
//        parameterMap.add("username",username);
//        parameterMap.add("password",password);
//        parameterMap.add("grant_type",grant_type);
//
//        //请求头封装
//        String Authorization = "Basic"+ new String(Base64.getEncoder().encode((clientId + ":" + clientId).getBytes()),"UTF-8");
//        MultiValueMap headerMap = new LinkedMultiValueMap();
//        headerMap.add("Authorization",Authorization);
//
//        //HttpEntity->创建该对象
//        HttpEntity httpEntity = new HttpEntity(parameterMap, headerMap);
//        /***
//         * 请求地址
//         * 提交方式
//         * 请求提交的数据信息封装 请求体 请求头
//         * 返回数据需要转换的类型
//         */
//        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
//            @Override
//            public void handleError(ClientHttpResponse response) throws IOException {
//                //当响应的值为400或401时候也要正常响应，不要抛出异常
//                if (response.getRawStatusCode() != 400 && response.getRawStatusCode() != 401) {
//                    super.handleError(response);
//                }
//            }
//        });
//        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);
//
//        //用户登录后的令牌信息
//        Map<String,String> map = response.getBody();
//        //将令牌信息转换成AuthToken对象
//        AuthToken authToken = new AuthToken();
//        authToken.setRefreshToken(map.get("refresh_token"));
//        authToken.setAccessToken(map.get("access_token"));
//
//        authToken.setJti(map.get("jti"));
//        return authToken;
    }
    /***
     * base64编码
     * @param clientId
     * @param clientSecret
     * @return
     */
    private String httpbasic(String clientId,String clientSecret){
        //将客户端id和客户端密码拼接，按“客户端id:客户端密码”
        String string = clientId+":"+clientSecret;
        //进行base64编码
        byte[] encode = Base64Utils.encode(string.getBytes());
        return "Basic "+new String(encode);
    }
}
