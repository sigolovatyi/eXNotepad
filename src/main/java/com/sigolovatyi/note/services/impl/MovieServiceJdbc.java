package com.sigolovatyi.note.services.impl;

import com.sigolovatyi.note.persistance.dao.Dao;
import com.sigolovatyi.note.persistance.dao.Movie;
import com.sigolovatyi.note.services.interfaces.IDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;
import java.util.List;

@Service("jdbc")
public class MovieServiceJdbc implements IDaoService {

    private JdbcTemplate template;

    @Autowired
    public void setJddbc(JdbcTemplate template) throws SQLException {
        this.template = template;
    }


    @Override
    public int createUnit(@RequestBody Dao film) {
        Movie tmp = (Movie) film;
        System.out.println(tmp);
        template.execute("insert into films\n" +
                "(title)\n" +
                "values\n" +
                "('"+tmp.getTitle()+"')");
        return 0;
    }

    @Override
    public Movie getUnit(Long id) {
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
        return null;
    }
}
