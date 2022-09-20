package com.cristian.desarrollo.videotienda.service;

import java.util.List;
import java.util.Optional;

import com.cristian.desarrollo.videotienda.controller.dto.CategoryDto;
import com.cristian.desarrollo.videotienda.controller.dto.MovieDto;

public interface CatalogService { // Métodos que el controlador va a poder utilizar
    List<CategoryDto> getCategories();
    
    //Contenedor en donde podré tener datos, si no exite el dato no retorna NullPointerException
    Optional<CategoryDto> getCategoryById(Integer id);  // Optional sirve para evitar NullPointerException

    List<MovieDto> getMoviesByCategoryId(Integer categoryId);

}
