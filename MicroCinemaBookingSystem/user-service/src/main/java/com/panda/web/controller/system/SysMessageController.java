package com.panda.web.controller.system;

import com.panda.common.response.ResponseResult;
import com.panda.system.domin.SysMessage;
import com.panda.system.service.SysMessageService;
import com.panda.system.service.impl.SysMessageServieImpl;
import com.panda.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SysMessageController extends BaseController {

    @Autowired
    SysMessageServieImpl sysMessageService;


//    int addMessage(SysMessage sysMessage);
//
//    List<SysMessage> selectAllFromAndToMessgae(Long userId);
//
//    int updateHaveSeen(Long id);

    @PostMapping("/SysMessage")
    public ResponseResult addMessage(@Validated @RequestBody SysMessage sysMessage){


        return getResult(sysMessageService.addMessage(sysMessage));
    }
    @GetMapping("/SysMessage/{id}")
    public ResponseResult selectAllFromAndToMessgae(@PathVariable Long id){

        return getResult(sysMessageService.selectAllFromAndToMessgae(id));
    }

    @PutMapping("/SysMessage/{id}")
    public ResponseResult updateHaveSeen(@PathVariable Long id){
        return getResult((sysMessageService.updateHaveSeen(id)));
    }




}
