package com.panda.system.mapper;

import com.panda.system.domin.SysHall;

import java.util.List;


public interface SysHallMapper {
    List<SysHall> findAllHalls(SysHall sysHall);

    List<SysHall> findHallsInGivenCenimaId(Long cinemaId);

    SysHall findHallById(SysHall sysHall);

    int addHall(SysHall sysHall);

    int updateHall(SysHall sysHall);

    int deleteHall(SysHall sysHall);

    int deleteHallByCinemaId(Long cinemaId);




}
