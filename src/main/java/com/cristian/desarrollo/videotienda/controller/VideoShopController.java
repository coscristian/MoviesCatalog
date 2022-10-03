package com.cristian.desarrollo.videotienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cristian.desarrollo.videotienda.service.CatalogService;

import lombok.AllArgsConstructor;

// La clase model va a representar a los datos.

@AllArgsConstructor
// Esta clase se va a encargar de atender todas las peticiones de navegación
@Controller
public class VideoShopController {

    private CatalogService catalogService;

    @GetMapping("/catalog")
    public String goToCatalog(Model model) {

        var categories = this.catalogService.getCategories();

        model.addAttribute("title", "Welcome to my site!!");
        
        model.addAttribute("categories", categories);
        // Retorno cual es el objeto plantilla que le muestre al usuario
        return "catalog";
    }

    @GetMapping("/catalog/{id}")
    public String loadCatalogById(@PathVariable("id") Integer id, Model model) {

        var categoryOp = this.catalogService.getCategoryById(id);
        var categories = this.catalogService.getCategories();
        model.addAttribute("categories", categories);
        
        if(categoryOp.isEmpty()){
            // Mostrar mensaje de error
            model.addAttribute("error", "La categoria no existe");
        }else{
            var category = categoryOp.get(); // Si no está vacío, dame el elemento
            
            // Carga en el modelo el titulo y el id de la categoria    
            model.addAttribute("title", category.getName());
            model.addAttribute("id", category.getId());
            
            var categoryMovies = this.catalogService.getMoviesByCategoryId(id);

            model.addAttribute("movies", categoryMovies);
        }
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
