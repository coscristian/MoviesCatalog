package com.cristian.desarrollo.videotienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// La clase model va a representar a los datos.

// Esta clase se va a encargar de atender todas las peticiones de navegación
@Controller
public class VideoShopController {
    
    @GetMapping("/catalog")
    public String goToCatalog(Model model) {
        model.addAttribute("title", "Bienvenidos a mi página");
        // Retorno cual es el objeto plantilla que le muestre al usuario
        return "catalog";
    }


}
