package com.sigolovatyi.note.persistance.repositories.interfaces;

import com.sigolovatyi.note.persistance.dao.Movie;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FilmRepositories extends CrudRepository<Movie, Long> {

    @Modifying
    @Query("update Movie m set m.advice=?1 where m.id=?2")
    void updateMoviesAdviceById(Integer advice, Long id);

}
