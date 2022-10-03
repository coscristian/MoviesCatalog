package com.cristian.desarrollo.videotienda.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  // Esta clase hace referencia a una tabla que voy a tener en la base de datos
@Table(name = "Categoria") // Nombre de la tabla
@Data // Setters y getters
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id // Hace referencia a una llave primaria en la tabla
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Columna o campo de la tabla obligatorio
    @Column(name = "nombre", nullable = false, length = 100) 
    private String name;

    @OneToMany(mappedBy = "category")// Relacion de uno a muchos
    private List<Movie> movies;

    public Category(String name) {
        this.name = name;
    }

}
