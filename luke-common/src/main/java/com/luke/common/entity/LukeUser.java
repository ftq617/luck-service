package com.luke.common.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: LukeUser
 * @Description: 用户的基本信息
 * @Author: Luke Fu
 * @Date: 2020/09/16 11:14
 **/
@Data
public class LukeUser implements UserDetails {

    private String id;
    private String username;
    private String password;
    private String phone;
    private String key;
    private String sourceId;


    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    /**
     * 角色列表
     */
    private Set<GrantedAuthority> authorities;

    /**
     * 用户属性
     */
    private Map< String, Object > params;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
