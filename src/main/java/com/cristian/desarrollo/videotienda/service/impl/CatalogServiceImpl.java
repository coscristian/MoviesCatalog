package com.cristian.desarrollo.videotienda.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cristian.desarrollo.videotienda.controller.dto.CategoryDto;
import com.cristian.desarrollo.videotienda.controller.dto.MovieDto;
import com.cristian.desarrollo.videotienda.model.repository.CategoryRepository;
import com.cristian.desarrollo.videotienda.model.repository.MovieRepository;
import com.cristian.desarrollo.videotienda.service.CatalogService;

import lombok.AllArgsConstructor;

@AllArgsConstructor // Crear constructor con atributos
@Service // Aquí hay una clase que implementa una interfaz y hace parte del grupo de servicios (El servicio se coloca en la clase, no en la interfaz)
public class CatalogServiceImpl implements CatalogService{

    // Necesito objetos que me den acceso al almacenamiento de categorias y peliculas
    private final CategoryRepository categoryRepository;
    private final MovieRepository movieRepository;

    // SOLID : 5 principios que deben cumplir todas las clases o moduos.   
    // SRP: Principio de responsabilidad simple (Cada módulo debe servir para una sola cosa)
    // OCP: Principio
    // LSP: 
    // ISP: 
    // DIP: 

   

    @Override
    public List<CategoryDto> getCategories() {
        var categories =  categoryRepository.findAll(Sort.by("name"));

        return categories.stream()
                .map(cat -> new CategoryDto(cat.getName(), cat.getId().intValue()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryDto> getCategoryById(Integer id) { // Recomendable cuando podemos retornar un elemento vacío o lleno, retonar un Optional y luego preguntar si el optional está vacio. (No retornar null)
        
        var category = categoryRepository.findById(id.longValue());
    
        if(category.isEmpty())
            return Optional.empty();

        return Optional.of(new CategoryDto(
            category.get().getName(),
            category.get().getId().intValue()));
    }

    @Override
    public List<MovieDto> getMoviesByCategoryId(Integer categoryId) {

        var movies = movieRepository.findAllByCategoryId(categoryId.longValue());

        // Carga las peliculas correspondientes a la categoria
        var categoryMovies = movies.stream()
            .map(mov -> MovieDto.builder()  // Permite crear el objeto con atributos del constructor que yo desee
                .id(mov.getCode().intValue())
                .length(mov.getLength())
                .name(mov.getName())
                .description(mov.getDescription())
                .imageUrl(mov.getImageUrl())
                .build()) // Construya el objeto
            .collect(Collectors.toList());
        return categoryMovies;
    }
    
}
