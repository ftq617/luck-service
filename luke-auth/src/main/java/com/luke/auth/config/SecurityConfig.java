package com.luke.auth.config;

import com.luke.auth.service.LukeUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

/**
 * @模块名:oauth2-server
 * @包名:cn.cc.study.config
 * @类名称: SecurityConfig
 * @类描述:【类描述】Security配置
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月18日下午4:11:12
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LukeUserDetailService userDetailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new SCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .logout()
                .and()
                .csrf().disable();
    }

    /**
     * 实现认证策略
     * 
     * (non-Javadoc)
     * 
     * @see WebSecurityConfigurerAdapter#configure(AuthenticationManagerBuilder)
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService)
                .passwordEncoder(passwordEncoder());
        //自定义 数据库  用户查询验证查询
        //auth.jdbcAuthentication().dataSource().authoritiesByUsernameQuery().groupAuthoritiesByUsername().usersByUsernameQuery();
        // 内存用户验证
        //auth.inMemoryAuthentication().withUser("a").password("123").accountExpired().accountLocked().authorities().disabled().roles();
    }

}
