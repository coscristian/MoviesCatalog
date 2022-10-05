package com.cristian.desarrollo.videotienda.service;

import java.util.List;

import com.cristian.desarrollo.videotienda.controller.dto.UserRequest;
import com.cristian.desarrollo.videotienda.controller.dto.UserResponse;

public interface SecurityService {

    // Métodos para la gestión de usuarios

    UserResponse validateUser(String username, String password);

    List<UserResponse> getAllUsers();

    UserResponse getUserByUsername(String username);

    void createUser(UserRequest user); // UserRequest: cuales son los datos que voy a traer del front para guardar el usuario

    void updateUser(UserRequest user);

    void deleteUser(String username);

    void activateUser(String username);

    void inactivateUser(String username);

}
