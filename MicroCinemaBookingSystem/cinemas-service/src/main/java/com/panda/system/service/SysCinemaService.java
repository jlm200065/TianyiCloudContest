package com.panda.system.service;

import com.panda.system.domin.SysCinema;

import java.util.List;


public interface SysCinemaService {

    SysCinema findCinema(Long id);

    int updateCinema(SysCinema sysCinema);

    SysCinema findCinemaById(Long id);


    int addCinema(SysCinema sysCinema);

    List<SysCinema> findAllCinemas();

    int deleteCinema(Long id);

}
