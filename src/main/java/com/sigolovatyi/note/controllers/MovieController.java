package com.sigolovatyi.note.controllers;

import com.sigolovatyi.note.persistance.dao.Dao;
import com.sigolovatyi.note.persistance.dao.Movie;
import com.sigolovatyi.note.services.interfaces.IDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MovieController {

    @Autowired
    @Qualifier("hibernate")
    IDaoService service;

    @GetMapping("/movies/add_film")
    public String startFilm(){
        return "request_film";
    }

    @GetMapping("/movies")
    public String insert(){
        return "movies";
    }

    @PostMapping("/movies/create_some_film")
    public ResponseEntity insert(@ModelAttribute("movie") Movie movie){
        service.createUnit(movie);
        return new ResponseEntity("movie had added", HttpStatus.CREATED);
    }

    @GetMapping("/movies/get_all")
    public String getAll(Model model){
        List<Dao> all = service.findAll();
        model.addAttribute("movies", all);
        return "watch_all";
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id){
        service.deleteUnit(id);
        return new ResponseEntity("Movie had deleted", HttpStatus.OK);
    }

    @GetMapping("/movies/recommend/{id}")
    public ResponseEntity updateById(@PathVariable("id") Long id){
        service.updateUnit(id);
        return new ResponseEntity("film added to recommend list", HttpStatus.OK);
    }

    @GetMapping("/movies/recommend")
    public String getRecommend(Model model){
        List<Dao> all = service.findAll()
                .stream()
                .filter((a)->((Movie)a).getAdvice()==2)
                .collect(Collectors.toList());
        model.addAttribute("movies", all);
        return "watch_recommend";
    }
}
