package com.cristian.desarrollo.videotienda.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cristian.desarrollo.videotienda.model.entity.Category;

/* Para generar una implementación automatica de la interfaz
    se debe heredar la clase JpaRepositoryy enviarle como argumento
    cual es la clase repositorio que va a manejar y cual es el tipo de dato del 
    campo primary key
*/
public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
