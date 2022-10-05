package com.cristian.desarrollo.videotienda.controller.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristian.desarrollo.videotienda.controller.model.entity.User;

public interface UserRepository extends JpaRepository<User, String>{ // primer parametro: La entidad(clase) a la que voy a aplicar el repo, tipo de dato de la primaeyKey
    Optional<User> findByUsernameAndPasswordAndActiveIsTrue(String username, String password);

    Optional<User> findByEmail(String email);
}
