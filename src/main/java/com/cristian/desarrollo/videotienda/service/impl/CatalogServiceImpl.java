package com.cristian.desarrollo.videotienda.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cristian.desarrollo.videotienda.controller.dto.CategoryDto;
import com.cristian.desarrollo.videotienda.controller.dto.MovieDto;
import com.cristian.desarrollo.videotienda.service.CatalogService;

@Service // Aquí hay una clase que implementa una interfaz y hace parte del grupo de servicios (El servicio de coloca en la clase, no en la interfaz)
public class CatalogServiceImpl implements CatalogService{

    // SOLID : 5 principios que deben cumplir todas las clases o moduos.   
    // SRP: Principio de responsabilidad simple (Cada módulo debe servir para una sola cosa)
    // OCP: Principio
    // LSP: 
    // ISP: 
    // DIP: 

    private final List<CategoryDto> categories = Arrays.asList(
        new CategoryDto("Action", 1),
        new CategoryDto("Comedy", 2),
        new CategoryDto("Romance", 3),
        new CategoryDto("Sci-fi", 4)
    );

    private final List<MovieDto> movies = Arrays.asList(
        new MovieDto(1, "Matrix", 4,
             "The best of the best",
             120,
             "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/950/public/media/image/2016/11/matrix.jpg?itok=y_D1-7f-"),
        
        new MovieDto(2, "Hang Over", 2,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum non erat sed tortor tristique blandit in vitae nisl. Integer eros nibh, semper vitae dui quis.",
            120,
            "https://www.scrolldroll.com/wp-content/uploads/2022/04/The-Hangover-Best-Hindi-Dubbed-Comedy-Movies-scaled.jpeg"),
        new MovieDto(3, "Hitch", 2,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum non erat sed tortor tristique blandit in vitae nisl. Integer eros nibh, semper vitae dui quis.",
            120,
            "https://m.media-amazon.com/images/M/MV5BNzYyNzM2NzM2NF5BMl5BanBnXkFtZTcwNjg5NTQzMw@@._V1_.jpg"),

        new MovieDto(4, "Grown Ups", 2,
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum non erat sed tortor tristique blandit in vitae nisl. Integer eros nibh, semper vitae dui quis.",
            120,
            "https://images-na.ssl-images-amazon.com/images/S/pv-target-images/8cc65b37e1c6a637d213a6e784f6400e1e991aa3cf3564322050ceaba2aafa2a._RI_V_TTW_.jpg"),
        
        new MovieDto(5, "Dumb and Dumber", 2,
             "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum non erat sed tortor tristique blandit in vitae nisl. Integer eros nibh, semper vitae dui quis.",
             90,
             "https://m.media-amazon.com/images/I/71SId+DDZOL._SY445_.jpg")
    );

    @Override
    public List<CategoryDto> getCategories() {
        return categories;
    }

    @Override
    public Optional<CategoryDto> getCategoryById(Integer id) { // Recomendable cuando podemos retornar un elemento vacío o lleno, retonar un Optional y luego preguntar si el optional está vacio. (No retornar null)
        var category = categories.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst();

        return category;
    }

    @Override
    public List<MovieDto> getMoviesByCategoryId(Integer categoryId) {
        // Carga las peliculas correspondientes a la categoria
        var categoryMovies = movies.stream()
            .filter(m -> m.getCategoryId().equals(categoryId))
            .collect(Collectors.toList());
        return categoryMovies;
    }
    
}
