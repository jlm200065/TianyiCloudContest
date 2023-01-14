package com.panda.web.controller.system;

import com.panda.common.response.ResponseResult;
import com.panda.system.domin.SysUserSeat;
import com.panda.system.service.SysUserSeatService;
import com.panda.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class SysUserSeatController extends BaseController {

    @Autowired
    private SysUserSeatService sysUserSeatService;
    @PostMapping("/sysUserSeat" )
    public ResponseResult addUserSeat(@Validated @RequestBody SysUserSeat sysUserSeat) {
        return getResult(sysUserSeatService.addUserSeat(sysUserSeat));
    }

    @RequestMapping("/sysUserSeat/getUser")
    public ResponseResult findUserId(@RequestBody SysUserSeat sysUserSeat){
        return getResult(sysUserSeatService.findUserId(sysUserSeat));
    }
}
