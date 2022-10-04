package com.cristian.desarrollo.videotienda.controller.model.entity;

import javax.persistence.Entity; // JPA: Java Persistance Entity
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Entity  // Esta clase hace referencia a una tabla que voy a tener en la base de datos
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id // Es la llave primaria de la tabla
    private Long code;

    private String name;
    private String description;
    private Integer length;
    private String imageUrl;

    @ManyToOne // Relacion de muchos a unos
    private Category category;



}
