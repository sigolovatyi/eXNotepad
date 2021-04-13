package com.sigolovatyi.note.services.interfaces;

import com.sigolovatyi.note.persistance.dao.Dao;

import java.util.List;

public interface IDaoService {
    int createUnit(Dao object);
    Dao getUnit(Long id);
    int updateUnit(Long id);
    int deleteUnit(Long id);
    List<Dao> findAll();

}
