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

@Controller
public class MovieController {

    @Autowired
    @Qualifier("hibernate")
    IDaoService service;

    @GetMapping("/movies")
    public String startFilm(){
        return "request_film";
    }

    @GetMapping("/movies/insert_film")
    public ResponseEntity insert(){
        service.createUnit(new Movie());
        return new ResponseEntity("Movie had added", HttpStatus.OK);
    }

    @PostMapping("/movies/create_some_film")
    public ResponseEntity insert(@ModelAttribute("movie") Movie movie){
        service.createUnit(movie);
        return new ResponseEntity("movie had added", HttpStatus.CREATED);
    }

    @GetMapping("/movies/getAll")
    public String getAll(Model model){
        List<Dao> all = service.findAll();
        model.addAttribute("movies", all);
        return "watch_all";
    }

//    @PostMapping
//    public String update
}
