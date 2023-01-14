package com.panda.feign.clients;

import com.panda.common.response.ResponseResult;
import com.panda.system.domin.SysMovie;
import com.panda.system.domin.vo.SysMovieVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "movie-service")
public interface MovieClient {
    @GetMapping("/sysMovie/remote/find")
    List<SysMovie> findRemoteAllMovies(SysMovieVo sysMovieVo);


    @GetMapping("/sysMovie/remote/find/{id}")
    SysMovie findReomoteMovieById(@PathVariable Long id);

    @GetMapping("/sysMovie/remote/findAll")
    List<SysMovie> findRemoteAll();


    @GetMapping("/sysMovie/{id}")
    SysMovie findOneMovie(@PathVariable Long id);

    @PutMapping("/sysMovie")
    ResponseResult updateMovie(@Validated @RequestBody SysMovie sysMovie);




}
