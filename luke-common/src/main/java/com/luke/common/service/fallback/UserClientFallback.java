package com.luke.common.service.fallback;

import com.luke.common.service.UserClient;
import org.springframework.stereotype.Component;

/**
 * @ClassName: TestServiceFallback
 * @Description:
 * @Author: Luke Fu
 * @Date: 2020/09/09 11:16
 **/
@Component
public class UserClientFallback implements UserClient{

    public String getUser(String id) {
        return id+" getData 出错了！";
    }

    public String getUserDetail(String id) {
        return id+" getOther 出错了！";
    }
}
