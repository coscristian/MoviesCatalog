package com.cristian.desarrollo.videotienda.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cristian.desarrollo.videotienda.controller.dto.UserRequest;
import com.cristian.desarrollo.videotienda.controller.dto.UserResponse;
import com.cristian.desarrollo.videotienda.controller.model.entity.User;
import com.cristian.desarrollo.videotienda.controller.model.repository.UserRepository;
import com.cristian.desarrollo.videotienda.service.SecurityService;

import lombok.AllArgsConstructor;

@Service // Es un servicio para Spring
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService{

    private final UserRepository userRepository;

    @Override
    public UserResponse validateUser(String username, String password) {
        /* 
        var userOp = userRepository.findById(username);
        if(userOp.isEmpty()){
            throw new RuntimeException("Usuario no existente!!");
        }

        var user = userOp.get();
        if(!user.getActive()){
            throw new RuntimeException("Usuario Inactivo");
        }

        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Credenciales Ivalidas!!");
        }
        */
        var userOp = userRepository.findByUsernameAndPasswordAndActiveIsTrue(username, password);
        if(userOp.isEmpty()){
            throw new RuntimeException("Usuario no existente!!");
        }

        var user = userOp.get();
        return UserResponse.builder()   // Conversión de un objeto tipo user a objeto tipo user de respuesta
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .admin(user.getAdmin())
                .build();
    }

    @Override
    public void createUser(UserRequest user) {
        
        var userOp = userRepository.findById(user.getUsername());
        if (userOp.isPresent())
            throw new RuntimeException("El usuario ya existe, no puede utilizar ese nombre de usuario.");
        
        userOp = userRepository.findByEmail(user.getEmail());
        if (userOp.isPresent())
            throw new RuntimeException("Ya existe un usuario registrado con ese correo electronico.");

        var userDb = new User();
        userDb.setUsername(user.getUsername());
        userDb.setPassword(user.getPassword());
        userDb.setName(user.getName());
        userDb.setEmail(user.getEmail());
        userDb.setActive(true);
        userDb.setAdmin(user.getAdmin());
        
        userDb = userRepository.save(userDb);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
            .map(u -> UserResponse.builder()
                .username(u.getUsername())
                .name(u.getName())
                .email(u.getEmail())
                .admin(u.getAdmin())
                .build())
            .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        var userOp = userRepository.findById(username);
        if(userOp.isEmpty()){
            throw new RuntimeException("El usuario no existe");
        }
        var user = userOp.get();
        return UserResponse.builder()   // Conversión de un objeto tipo user a objeto tipo user de respuesta
                .username(user.getUsername())
                .name(user.getName())
                .email(user.getEmail())
                .admin(user.getAdmin())
                .build();
    }

    @Override
    public void updateUser(UserRequest user) {
        
        
    }

    @Override
    public void deleteUser(String username) {
        
        
    }

    @Override
    public void activateUser(String username) {
        var userOp = userRepository.findById(username);
        if(userOp.isEmpty())
            throw new RuntimeException("El usuario no existe");

        var user = userOp.get();
        user.setActive(true);
        userRepository.save(user);        
    }

    @Override
    public void inactivateUser(String username) {
        
        var userOp = userRepository.findById(username);
        if(userOp.isEmpty())
            throw new RuntimeException("El usuario no existe");

        var user = userOp.get();
        user.setActive(false);
        userRepository.save(user);
        
    }
    
}
