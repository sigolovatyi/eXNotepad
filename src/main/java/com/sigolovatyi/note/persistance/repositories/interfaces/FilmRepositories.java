package com.sigolovatyi.note.persistance.repositories.interfaces;

import com.sigolovatyi.note.persistance.dao.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FilmRepositories extends CrudRepository<Movie, String> {

}
