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
        List<Dao> all = getDaoList(0);
        model.addAttribute("movies", all);
        return "watch_all";
    }

    @GetMapping("/movies/recommend/{id}")
    public String updateById(Model model, @PathVariable("id") Long id){
        service.updateUnit(id);
        return getAll(model);
    }

    @GetMapping("/movies/{id}")
    public String deleteById(Model model, @PathVariable("id") Long id){
        service.deleteUnit(id);
        return getAll(model);
    }

    @GetMapping("/movies/recommend")
    public String getRecommend(Model model){
        List<Dao> all = getDaoList(2);
        model.addAttribute("movies", all);
        return "watch_recommend";
    }

    private List<Dao> getDaoList(int variable){
        return service.findAll()
                .stream()
                .filter((a)->((Movie)a).getAdvice()==variable)
                .collect(Collectors.toList());
    }
}
