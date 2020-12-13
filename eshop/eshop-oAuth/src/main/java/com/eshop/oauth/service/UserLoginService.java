package com.eshop.oauth.service;

import com.eshop.oauth.util.AuthToken;

public interface UserLoginService {
    /***
     * 登录：密码模式
     * @param username
     * @param password
     * @param clientId
     * @param clientSecret
     * @param grant_type
     * @return
     */
    AuthToken login(String username, String password, String clientId, String clientSecret, String grant_type);
}
