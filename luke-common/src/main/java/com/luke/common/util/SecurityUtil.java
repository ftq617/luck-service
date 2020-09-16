package com.luke.common.util;

import com.luke.common.entity.LukeUser;
import org.springframework.boot.json.JsonParser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Set;

/**
 * 
 * @模块名:oauth2-common
 * @包名:cn.cc.study.common.util
 * @类名称: SecurityUtil
 * @类描述:【类描述】
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月19日下午1:40:38
 */
public class SecurityUtil {

    /**
     * 
     * @方法名:currentUser
     * @方法描述:用于获得当前用户信息
     * @return
     * @修改描述:
     * @版本:1.0
     * @创建人:cc
     * @创建时间:2019年11月19日 下午1:52:00
     * @修改人:cc
     * @修改时间:2019年11月19日 下午1:52:00
     */
    public static LukeUser getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LukeUser user = JsonUtils.paserObject(JsonUtils
                .paserObject(JsonUtils.toJSONString(authentication))
                .getAsJsonObject("userAuthentication").getAsJsonObject("details").getAsJsonObject("principal").toString(),
                LukeUser.class);
        return user;
    }
    /**
     *
     * @方法名:getGrantedAuthoritys
     * @方法描述:用于获得当前权限列表
     * @return
     * @修改描述:
     * @版本:1.0
     * @创建人:cc
     * @创建时间:2019年11月19日 下午1:52:53
     * @修改人:cc
     * @修改时间:2019年11月19日 下午1:52:53
     */
    public static Set <GrantedAuthority> getGrantedAuthoritys() {
        return (Set<GrantedAuthority>) getUser().getAuthorities();
    }

    /**
     * 
     * @方法名:isGrantedAuthority
     * @方法描述:是否含有该权限
     * @param role
     * @return
     * @修改描述:
     * @版本:1.0
     * @创建人:cc
     * @创建时间:2019年11月19日 下午1:53:20
     * @修改人:cc
     * @修改时间:2019年11月19日 下午1:53:20
     */
    public static boolean isGrantedAuthority(String role) {
        return getUser().getAuthorities().stream().filter(auth -> role.equals(auth.getAuthority())).count()>0;
    }

    /**
     * 
     * @方法名:getParam
     * @方法描述:用于获得当前用户属性
     * @param key
     * @return
     * @修改描述:
     * @版本:1.0
     * @创建人:cc
     * @创建时间:2019年11月19日 下午1:53:42
     * @修改人:cc
     * @修改时间:2019年11月19日 下午1:53:42
     */
    public static Object getParam(String key) {
        return getUser().getParams().get(key);
    }
}
