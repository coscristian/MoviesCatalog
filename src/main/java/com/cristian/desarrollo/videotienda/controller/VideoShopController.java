package com.cristian.desarrollo.videotienda.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cristian.desarrollo.videotienda.controller.dto.CategoryDto;
import com.cristian.desarrollo.videotienda.controller.dto.MovieDto;

// La clase model va a representar a los datos.

// Esta clase se va a encargar de atender todas las peticiones de navegación
@Controller
public class VideoShopController {

    private final List<CategoryDto> categories = Arrays.asList(
        new CategoryDto("Action", 1),
        new CategoryDto("Comedy", 2),
        new CategoryDto("Romance", 3),
        new CategoryDto("Sci-fi", 4)
    );

    private final List<MovieDto> movies = Arrays.asList(
        new MovieDto(1, "Matrix", 4, "The best of the best", 120),
        new MovieDto(2, "Dumb and Dumber", 2, "Esta pelicula trata de ...", 90)
    );
    
    @GetMapping("/catalog")
    public String goToCatalog(Model model) {
        model.addAttribute("title", "Welcome to my site!!");
        
        model.addAttribute("categories", categories);
        // Retorno cual es el objeto plantilla que le muestre al usuario
        return "catalog";
    }

    @GetMapping("/catalog/{id}")
    public String loadCatalogById(@PathVariable("id") Integer id, Model model) {
        
        var category = categories.stream()
            .filter(c -> c.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("La categoria no existe"));

        // Carga en el modelo el titulo y el id de la categoria    
        model.addAttribute("title", category.getName());
        model.addAttribute("id", category.getId());
        model.addAttribute("categories", categories);

        // Carga las peliculas correspondientes a la categoria
        var categoryMovies = movies.stream()
            .filter(m -> m.getCategoryId().equals(id))
            .collect(Collectors.toList());

        model.addAttribute("movies", categoryMovies);

        return "catalog";
    }

    @GetMapping("/contact")
    public String goToContact(Model model) {
        return "contact";
    }

    @GetMapping("/login")
    public String goToLogin(Model model) {
        return "login";
    }

}
