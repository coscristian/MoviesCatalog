package com.cristian.desarrollo.videotienda.controller.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristian.desarrollo.videotienda.controller.model.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
    List<Movie> findAllByCategoryId(Long categoryId);
}
