package com.panda.system.service;

import com.panda.system.domin.SysMessage;

import java.util.List;

public interface SysMessageService {


    int addMessage(SysMessage sysMessage);

    List<SysMessage> selectAllFromAndToMessgae(Long userId);

    int updateHaveSeen(Long id);

}
