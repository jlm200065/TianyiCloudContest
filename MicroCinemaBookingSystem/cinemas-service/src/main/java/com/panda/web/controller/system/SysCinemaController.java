package com.panda.web.controller.system;

import com.panda.common.response.ResponseResult;
import com.panda.feign.clients.MovieClient;
import com.panda.system.domin.SysCinema;
import com.panda.system.domin.SysSession;
import com.panda.system.service.impl.SysCinemaServiceImpl;
import com.panda.system.service.impl.SysHallServiceImpl;
import com.panda.system.service.impl.SysSessionServiceImpl;
import com.panda.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class SysCinemaController extends BaseController {

    @Autowired
    private SysCinemaServiceImpl sysCinemaService;

    @Autowired
    private SysHallServiceImpl sysHallService;

    @Autowired
    private SysSessionServiceImpl sysSessionService;

    @Autowired
    private MovieClient movieClient;



//    @GetMapping("/sysCinema")
//    public ResponseResult findCinema() {
//        return getResult(sysCinemaService.findCinema());
//    }

    @PutMapping("/sysCinema/update")
    public ResponseResult updateCinema(@Validated @RequestBody SysCinema sysCinema) {
        return getResult(sysCinemaService.updateCinema(sysCinema));
    }

    @GetMapping(value = {"/sysCinema/find/{cinemaId}/{movieId}", "/sysCinema/find/{cinemaId}"})
    public ResponseResult findCinemaById(@PathVariable Long cinemaId, @PathVariable(required = false) Long movieId) {
        SysCinema cinema = sysCinemaService.findCinemaById(cinemaId);
        if (movieId == null || movieId == 0) {
            movieId = cinema.getSysMovieList().size() > 0 ? cinema.getSysMovieList().get(0).getMovieId() : 0;
        }
        List<SysSession> sessions = null;
        if (movieId != null && movieId != 0) {


            sessions = sysSessionService.findSessionByMovieId(movieId);
        }

        sessions = sessions.stream()
                .filter((SysSession s) -> s.getCinemaId()== cinemaId)
                .collect(Collectors.toList());

        System.out.println(sessions.size());

        HashMap<String, Object> response = new HashMap<>();
        response.put("cinema", cinema);
        response.put("sessions", sessions);
        return getResult(response);
    }

    @GetMapping("/sysCinema/all")
    public ResponseResult findAllCinemas() {
        return getResult(sysCinemaService.findAllCinemas());
    }

    @GetMapping("/sysCinema/{cinemaId}")
    public ResponseResult findCinemaById(@PathVariable Long cinemaId) {
        return getResult(sysCinemaService.findCinemaById(cinemaId));
    }

    @PostMapping("/sysCinema")
    public ResponseResult addCinema(@Validated @RequestBody SysCinema sysCinema){
        return getResult(sysCinemaService.addCinema(sysCinema));
    }

     @DeleteMapping("/sysCinema/{cinemaId}")
     public ResponseResult DeleteCinemaById(@PathVariable Long cinemaId) {

        sysSessionService.deleteSessionByCinemaId(cinemaId);
        sysHallService.deleteHallByCinemaId(cinemaId);

        return getResult(sysCinemaService.deleteCinema(cinemaId));
     }

}
