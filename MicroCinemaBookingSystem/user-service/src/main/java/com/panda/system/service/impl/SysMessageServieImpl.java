package com.panda.system.service.impl;

import com.panda.system.domin.SysMessage;
import com.panda.system.mapper.SysMessageMapper;
import com.panda.system.service.SysMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class SysMessageServieImpl implements SysMessageService {

    @Autowired
    private SysMessageMapper sysMessageMapper;

    @Override
    public int addMessage(SysMessage sysMessage) {
        return sysMessageMapper.addMessage(sysMessage);
    }

    @Override
    public List<SysMessage> selectAllFromAndToMessgae(Long userId) {
        return sysMessageMapper.selectAllFromAndToMessgae(userId);
    }

    @Override
    public int updateHaveSeen(Long id) {
        return sysMessageMapper.updateHaveSeen(id);
    }
}
