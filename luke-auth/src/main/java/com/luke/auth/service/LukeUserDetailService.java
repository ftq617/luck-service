package com.luke.auth.service;

import com.luke.common.entity.LukeUser;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: UserDetailService
 * @Description:
 * @Author: Luke Fu
 * @Date: 2020/09/18 11:25
 **/
@Service
public class LukeUserDetailService implements UserDetailsService {


    private PasswordEncoder passwordEncoder = new SCryptPasswordEncoder();

    Map<String,LukeUser> users = new HashMap<>();

    {
      users.put("luke",LukeUser.builder()
              .username("luke")
              .password(passwordEncoder.encode("123456"))
              .phone("15970954230")
              .accountNonLocked(true)  // 锁定性 :true:未锁定 false:已锁定
              .enabled(true) // 可用性 :true:可用 false:不可用
              .credentialsNonExpired(true) // 有效性 :true:凭证有效 false:凭证无效
              .accountNonExpired(true)  // 过期性 :true:没过期 false:过期
              .build());
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        LukeUser user = users.get(name);
        if (user == null){
            throw new UsernameNotFoundException(name + "不存在！");
        }

        return users.get(name);
    }
}
