package com.sigolovatyi.note.persistance.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie extends Dao {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String style;
    private String ref;
    private int advice;

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", style='" + style + '\'' +
                ", references='" + ref + '\'' +
                ", advice=" + (advice==0 ? "unwatched" : advice==1 ? "don't look this" :"to recomended") +
                '}';
    }
}
