package com.eshop.oauth.config;
import com.eshop.oauth.util.UserJwt;
import com.eshop.user.feign.UserFeign;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/*****
 * 自定义授权认证类
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ClientDetailsService clientDetailsService;

    @Autowired
    private UserFeign userFeign;

    /****
     * 自定义授权认证
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //客户端使用静态方式认证：所有用户都提供eshop:eshop的clientId和clientSecret
        //客户端信息认证: start

        //取出身份，如果身份为空说明没有认证
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //没有认证统一采用httpbasic认证，httpbasic中存储了client_id和client_secret，开始认证client_id和client_secret
        if(authentication==null){
            // 查询数据库
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(username);
            if(clientDetails!=null){
                //秘钥
                String clientSecret = clientDetails.getClientSecret();
                //静态方式
                return new User(
                        username,   //clientId
                        new BCryptPasswordEncoder().encode(clientSecret), //clientSecret->加密
                        AuthorityUtils.commaSeparatedStringToAuthorityList("")); //权限
                //数据库查找方式
                //return new User(username,clientSecret, AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            }
        }
        //客户端认证: end

        //用户身份认证需要到数据库查找/
        //用户信息认证: start
        if (StringUtils.isEmpty(username)) {
            return null;
        }

        //数据库加载查询用户信息
        Result<com.eshop.user.pojo.User> userResult = userFeign.findById(username);

        //客户端id ：eshop
        //客户端密钥 ： eshop

        //普通用户->账号：任意账号  密码：12345678

//        if(userResult==null || userResult.getData()==null) {
//            return null;
//        }
        //根据用户名查询用户信息
        //String pwd = new BCryptPasswordEncoder().encode("12345678");



        String pwd = userResult.getData().getPassword();
        //创建User对象
        String permissions = "user,admin"; //指定用户的角色信息


        UserJwt userDetails = new UserJwt(username,pwd,AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));

        //

        return userDetails;
    }
}
