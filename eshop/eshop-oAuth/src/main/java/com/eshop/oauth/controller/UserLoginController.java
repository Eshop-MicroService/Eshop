package com.eshop.oauth.controller;

import com.eshop.oauth.service.LoginService;
import com.eshop.oauth.service.UserLoginService;
import com.eshop.oauth.util.AuthToken;
import com.eshop.oauth.util.CookieUtil;
import com.google.j2objc.annotations.AutoreleasePool;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 描述
 *
 * @author admin
 * @version 0.0.1
 * @package com.eshop.oauth.controller *
 * @since 0.0.1
 */

@RestController
@RequestMapping(value = "/user")
public class UserLoginController {
    @Value("${auth.clientId}")
    private String clientId;

    @Value("${auth.clientSecret}")
    private String clientSecret;

    @Autowired
    private UserLoginService userLoginService;
    /***
     * 登录方法
     */
    @RequestMapping(value = "/login")
    public Result login(String username,String password)throws Exception {
        //调用userLoginService实现登录
        String grant_type="password";
        AuthToken authToken = userLoginService.login(username,password,clientId,clientSecret,grant_type);
        if(authToken!=null){
            return new Result(true,StatusCode.OK,"登录成功！",authToken);

        }
        return new Result(false,StatusCode.LOGINERROR,"登录失败！");
    }
}

//@RestController
//@RequestMapping("/user")
//public class UserLoginController {
//
//    @Autowired
//    private LoginService loginService;
//
//    @Value("${auth.clientId}")
//    private String clientId;
//
//    @Value("${auth.clientSecret}")
//    private String clientSecret;
//
//    private static final String GRAND_TYPE = "password";//授权模式 密码模式
//
//
//    @Value("${auth.cookieDomain}")
//    private String cookieDomain;
//
//    //Cookie生命周期
//    @Value("${auth.cookieMaxAge}")
//    private int cookieMaxAge;
//
//
//    /**
//     * 密码模式  认证.
//     *
//     * @param username
//     * @param password
//     * @return
//     */
//    @RequestMapping("/login")
//    public Result<Map> login(String username, String password) {
//        //登录 之后生成令牌的数据返回
//        AuthToken authToken = loginService.login(username, password, clientId, clientSecret, GRAND_TYPE);
//
//
//        //设置到cookie中
//        saveCookie(authToken.getAccessToken());
//        return new Result<>(true, StatusCode.OK,"令牌生成成功",authToken);
//    }
//
//    private void saveCookie(String token){
//        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
//        CookieUtil.addCookie(response,cookieDomain,"/","Authorization",token,cookieMaxAge,false);
//    }
//}
