package com.cristian.desarrollo.videotienda.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Usando Lombok
@Data // Métodos Getter y Setter
@NoArgsConstructor // Constructor sin atributos
@AllArgsConstructor // Constructor con todos los atributos
public class MovieDto {
    private Integer id;
    private String name;
    private Integer categoryId;
    private String description;
    private Integer duration;
    private String imageUrl;
}
