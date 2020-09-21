//package com.luke.auth.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
//import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.jwk.JwkTokenStore;
//import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
//
///**
// * @ClassName: AuthorizationServerConfiguration
// * @Description: 授权服务器配置
// * @Author: Luke Fu
// * @Date: 2020/09/17 17:06
// **/
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
//    /**
//     * 认证管理器
//     */
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private RedisConnectionFactory redisConnectionFactory;
//
//    /**
//     * 用户认证器
//     */
//    @Autowired
//    private MyUserDetailService userDetailsService;
//
//    /*
//     * @Author: Luke Fu
//     * @Description: //自定义储存策略
//     * @Date: 2020/9/17
//     * @Param: []
//     * @Return: org.springframework.security.oauth2.provider.token.TokenStore
//     **/
//    @Bean
//    public TokenStore tokenStore() {
//        return new JwkTokenStore("admin");
//    }
//
//    /**
//     * 定义令牌端点上的安全性约 束
//     *
//     * (non-Javadoc)
//     *
//     * @see org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer)
//     * @param security
//     * @throws Exception
//     */
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security.allowFormAuthenticationForClients().tokenKeyAccess("permitAll()")
//                .checkTokenAccess("isAuthenticated()");
//    }
//
//    /**
//     * 用于定义客户端详细信息服务的配置程序。可以初始化客户端详细信息;
//     *
//     * (non-Javadoc)
//     *
//     * @see org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer)
//     * @param clients
//     * @throws Exception
//     */
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        // clients.withClientDetails(clientDetails());
//
//
//        clients.inMemory()
//                .withClient("android").scopes("read").secret(DigestUtil.encrypt("android")).authorizedGrantTypes("password", "authorization_code", "refresh_token")
//                .and()
//                .withClient("webapp").scopes("read").authorizedGrantTypes("implicit")
//                .and()
//                .withClient("browser").authorizedGrantTypes("refresh_token", "password").scopes("read");
//    }
//
//    @Bean
//    public WebResponseExceptionTranslator webResponseExceptionTranslator() {
//        return new MssWebResponseExceptionTranslator();
//    }
//
//    /**
//     * 定义授权和令牌端点以及令牌服务
//     *
//     * (non-Javadoc)
//     *
//     * @see org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer)
//     * @param endpoints
//     * @throws Exception
//     */
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints
//                // 指定认证管理器
//                .authenticationManager(authenticationManager)
//                // 用户账号密码认证
//                .userDetailsService(userDetailsService)
//                // refresh_token
//                .reuseRefreshTokens(false)
//                // 指定token存储位置
//                .tokenStore(tokenStore()).tokenServices(defaultTokenServices());
//    }
//
//    /**
//     * <p>
//     * 注意，自定义TokenServices的时候，需要设置@Primary，否则报错，
//     * </p>
//     *
//     * @return
//     */
//    @Primary
//    @Bean
//    public DefaultTokenServices defaultTokenServices() {
//        DefaultTokenServices tokenServices = new DefaultTokenServices();
//        tokenServices.setTokenStore(tokenStore());
//        tokenServices.setSupportRefreshToken(true);
//        // tokenServices.setClientDetailsService(clientDetails());
//        // token有效期自定义设置，默认12小时
//        tokenServices.setAccessTokenValiditySeconds(60 * 60 * 24 * 7);
//        // tokenServices.setAccessTokenValiditySeconds(60 * 60 * 12);
//        // refresh_token默认30天
//        tokenServices.setAccessTokenValiditySeconds(60 * 60 * 24 * 7);
//        // tokenServices.setRefreshTokenValiditySeconds(60 * 60 * 24 * 7);
//        return tokenServices;
//    }
//
//}
