package com.panda.system.service.impl;

import com.panda.feign.clients.MovieClient;
import com.panda.system.domin.SysMovie;
import com.panda.system.domin.SysSession;
import com.panda.system.domin.vo.SysSessionVo;
import com.panda.system.mapper.SysSessionMapper;
import com.panda.system.service.SysSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysSessionServiceImpl implements SysSessionService {

    @Autowired
    private SysSessionMapper sysSessionMapper;



    @Autowired
    private MovieClient movieClient;


    public List<SysSession> addMoviesToSessions(List<SysSession> sessions){

        for(int i = 0; i < sessions.size(); i++){
            SysSession tempSession = sessions.get(i);
            long movieId = sessions.get(i).getMovieId();
            SysMovie movie = movieClient.findReomoteMovieById(movieId);
            tempSession.setSysMovie(movie);
            sessions.set(i, tempSession);
        }
        return sessions;
    }

    public SysSession addMovieToSession(SysSession session){
        long movieId = session.getMovieId();
        SysMovie movie = movieClient.findReomoteMovieById(movieId);
        session.setSysMovie(movie);
        return session;
    }





    @Override
    public List<SysSession> findByVo(SysSessionVo sysSessionVo) {
        return addMoviesToSessions(sysSessionMapper.findByVo(sysSessionVo));
    }

    @Override
    public List<SysSession> findSessionByMovieIdOrHallId(SysSession sysSession) {
        return addMoviesToSessions(sysSessionMapper.findSessionByMovieIdOrHallId(sysSession));
    }

    @Override
    public SysSession findSessionById(Long id) {

        return addMovieToSession(sysSessionMapper.findSessionById(id));
    }

    @Override
    public SysSession findOneSession(Long id) {

        return addMovieToSession(sysSessionMapper.findOneSession(id));
    }

    @Override
    public int addSession(SysSession sysSession) {
        return sysSessionMapper.addSession(sysSession);
    }

    @Override
    public int updateSession(SysSession sysSession) {
        return sysSessionMapper.updateSession(sysSession);
    }

    @Override
    public int deleteSession(Long[] ids) {
        int rows = 0;
        for (Long id : ids) {
            rows += sysSessionMapper.deleteSession(id);
        }
        return rows;
    }

    @Override
    public List<SysSession> findSessionByMovieId(Long movieId) {
        return addMoviesToSessions(sysSessionMapper.findSessionByMovieId(movieId));
    }

    @Override
    public List<SysSession> findSessionByCinemaId(Long cinemaId) {
        return addMoviesToSessions(sysSessionMapper.findSessionByCinemaId(cinemaId));
    }

    @Override
    public int deleteSessionByCinemaId(Long cinemaId) {
        return sysSessionMapper.deleteSessionByCinemaId(cinemaId);
    }
}
