package com.panda.feign.clients;

import com.panda.system.domin.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service")
public interface UserClient {


    //远程过程调用  订单 --》 用户
    @GetMapping("/sysSession/remoteForBill/{userId}")
    public SysUser remoteFindUserByIdForBill(@PathVariable Long userId);
}
