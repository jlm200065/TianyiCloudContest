package com.panda.system.service;

import com.panda.system.domin.SysUserSeat;

public interface SysUserSeatService {
    int addUserSeat(SysUserSeat userSeat);
    SysUserSeat findUserId(SysUserSeat userSeat);

}
