package com.example.myeongseongservertest;

import com.example.myeongseongservertest.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
