package com.panda.system.service.impl;

import com.panda.feign.clients.CinemasClient;
import com.panda.feign.clients.UserClient;
import com.panda.system.domin.SysBill;
import com.panda.system.domin.SysSession;
import com.panda.system.domin.SysUser;
import com.panda.system.mapper.SysBillMapper;
import com.panda.system.service.SysBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Service;

import java.util.List;

@EnableFeignClients(basePackages = "com.panda.feign.clients")
@Service
public class SysBillServiceImpl implements SysBillService {

    @Autowired
    private SysBillMapper sysBillMapper;

    @Autowired
    private UserClient userClient;

    @Autowired
    private CinemasClient cinemasClient;


    public List<SysBill> addUserAndSessionByBill(List<SysBill> billList){
        for (int i = 0; i < billList.size(); i++) {
            SysUser sysUser = userClient.remoteFindUserByIdForBill(billList.get(i).getUserId());
            SysSession sysSession = cinemasClient.remoteFindSessionByIdForBill(billList.get(i).getSessionId());


            SysBill sysBill = new SysBill(billList.get(i), sysSession, sysUser);
            billList.set(i, sysBill);
        }
        return billList;
    }
    public SysBill addUserAndSessionByBill(SysBill sysBill){
        SysUser sysUser = userClient.remoteFindUserByIdForBill(sysBill.getUserId());
        SysSession sysSession = cinemasClient.remoteFindSessionByIdForBill(sysBill.getSessionId());
        sysBill.setSysUser(sysUser);
        sysBill.setSysSession(sysSession);
        return sysBill;
    }



    @Override
    public List<SysBill> findAllBills(SysBill sysBill) {
        return addUserAndSessionByBill(sysBillMapper.findAllBills(sysBill));
    }

    @Override
    public SysBill findBillById(Long id) {
        return addUserAndSessionByBill(sysBillMapper.findBillById(id));
    }

    @Override
    public Object addBill(SysBill sysBill) {

        int rows = sysBillMapper.addBill(sysBill);
        return rows > 0 ? sysBill : rows;
    }

    @Override
    public int updateBill(SysBill sysBill) {

        return sysBillMapper.updateBill(sysBill);
    }

    @Override
    public int deleteBill(Long[] ids) {
        int rows = 0;
        for (Long id : ids) {
            rows += sysBillMapper.deleteBill(id);
        }
        return rows;
    }

    @Override
    public List<SysBill> findTimeoutBill() {

        return addUserAndSessionByBill(sysBillMapper.findTimeoutBill());
    }

}
