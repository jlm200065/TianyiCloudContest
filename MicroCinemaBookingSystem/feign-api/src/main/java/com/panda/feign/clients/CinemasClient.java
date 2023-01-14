package com.panda.feign.clients;

import com.panda.common.response.ResponseResult;
import com.panda.system.domin.SysMovie;
import com.panda.system.domin.SysSession;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "cinemas-service")
public interface CinemasClient {
    @GetMapping("/sysSession/{id}")
    SysSession findOneSession(@PathVariable Long id);

    //远程过程调用  订单 --》 片场
    @GetMapping("/sysSession/remoteForBill/{sessionId}")
    public SysSession remoteFindSessionByIdForBill(@PathVariable Long sessionId);

    @PutMapping("/sysSession")
    ResponseResult updateSession(@RequestBody SysSession sysSession);


}
