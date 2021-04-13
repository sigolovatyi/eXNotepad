package com.sigolovatyi.note.services.impl;

import com.sigolovatyi.note.persistance.dao.Dao;
import com.sigolovatyi.note.persistance.dao.Movie;
import com.sigolovatyi.note.persistance.repositories.interfaces.FilmRepositories;
import com.sigolovatyi.note.services.interfaces.IDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("hibernate")
public class MovieServiceHibernate implements IDaoService {


    private FilmRepositories filmRepositories;

    @Autowired
    private void setRep(FilmRepositories filmRepositories){
        this.filmRepositories = filmRepositories;
    }

    @Override
    public int createUnit(Dao object) {
        filmRepositories.save((Movie)object);
        return 0;
    }

    @Override
    public Dao getUnit(Long id) {
        return null;
    }

    @Override
    public int updateUnit(Dao film) {
        return 0;
    }

    @Override
    public int deleteUnit(Long id) {
        return 0;
    }

    @Override
    public List<Dao> findAll() {
        List<Dao> result = new ArrayList<>();
        filmRepositories.findAll().forEach(result::add);
        System.out.println(result);
        return result;
    }

}
