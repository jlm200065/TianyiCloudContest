package com.panda.system.service.impl;

import com.panda.feign.clients.MovieClient;
import com.panda.system.domin.SysCinema;
import com.panda.system.domin.SysMovie;
import com.panda.system.domin.SysSession;
import com.panda.system.mapper.SysCinemaMapper;
import com.panda.system.mapper.SysSessionMapper;
import com.panda.system.service.SysCinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class SysCinemaServiceImpl implements SysCinemaService {

    @Autowired
    private SysCinemaMapper sysCinemaMapper;
    @Autowired
    private SysSessionMapper sysSessionMapper;


    @Autowired
    private MovieClient movieClient;



    private SysCinema addAllMovieToCinema(SysCinema cinema){

        List<SysSession> sessions = sysSessionMapper.findSessionByCinemaId(cinema.getCinemaId());

        Set<Long> movieIds = new HashSet<>();
        for (int i = 0; i < sessions.size(); i++) {
            LocalDate localDate = LocalDate.now();
            if((sessions.get(i).getSessionDate().isAfter(localDate)||sessions.get(i).getSessionDate().isEqual(localDate)) &&
                    (sessions.get(i).getSessionDate().isBefore(localDate.plusDays(5))||sessions.get(i).getSessionDate().isEqual(localDate.plusDays(5)))){
                movieIds.add(sessions.get(i).getMovieId());
            }

        }

        List<SysMovie> movieList = new ArrayList<>();
        List<SysMovie> movies = movieClient.findRemoteAll();
        for (int i = 0; i < movies.size(); i++) {
            if(movieIds.contains(movies.get(i).getMovieId())){
                movieList.add(movies.get(i));
            }
        }
        cinema.setSysMovieList(movieList);
        return cinema;
    }



    @Override
    public SysCinema findCinema(Long id) {
        return addAllMovieToCinema(sysCinemaMapper.findCinema(id));
    }

    @Override
    public int updateCinema(SysCinema sysCinema) {
        return sysCinemaMapper.updateCinema(sysCinema);
    }

    @Override
    public SysCinema findCinemaById(Long id) {
        return addAllMovieToCinema(sysCinemaMapper.findCinemaById(id));
    }

    @Override
    public int addCinema(SysCinema sysCinema) {
        return sysCinemaMapper.addCinema(sysCinema);
    }

    @Override
    public List<SysCinema> findAllCinemas() {
        return sysCinemaMapper.findAllCinemas();
    }

    @Override
    public int deleteCinema(Long id) {
        return sysCinemaMapper.deleteCinema(id);
    }


}
