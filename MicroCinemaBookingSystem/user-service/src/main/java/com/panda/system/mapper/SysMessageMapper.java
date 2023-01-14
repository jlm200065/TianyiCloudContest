package com.panda.system.mapper;

import com.panda.system.domin.SysMessage;

import java.util.List;

public interface SysMessageMapper {

    int addMessage(SysMessage sysMessage);

    List<SysMessage> selectAllFromAndToMessgae(Long userId);

    int updateHaveSeen(Long id);



}
