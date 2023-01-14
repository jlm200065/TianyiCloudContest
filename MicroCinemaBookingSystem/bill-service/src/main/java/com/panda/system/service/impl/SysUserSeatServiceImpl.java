package com.panda.system.service.impl;

import com.panda.system.domin.SysUserSeat;
import com.panda.system.mapper.SysUserSeatMapper;
import com.panda.system.service.SysUserSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class SysUserSeatServiceImpl implements SysUserSeatService {

    @Autowired
    SysUserSeatMapper sysUserSeatMapper;

    @Override
    public int addUserSeat(SysUserSeat userSeat) {
        return sysUserSeatMapper.addUserSeat(userSeat);
    }

    @Override
    public SysUserSeat findUserId(SysUserSeat userSeat) {
        return sysUserSeatMapper.selectUserId(userSeat);
    }
}
