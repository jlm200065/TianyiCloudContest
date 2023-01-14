package com.panda.system.service;

import com.panda.system.domin.SysHall;

import java.util.List;


public interface SysHallService {
    List<SysHall> findAllHalls(SysHall sysHall);
    List<SysHall> findHallsInGivenCenimaId(Long cinemaId);
    SysHall findHallById(SysHall sysHall);

    int addHall(SysHall sysHall);

    int updateHall(SysHall sysHall);

    int deleteHall(SysHall[] sysHall);

    int deleteHallByCinemaId(Long cinemaId);
}
