package com.cristian.desarrollo.videotienda.controller.dto;

import lombok.Data;

@Data
public class LoginRequest { 
    // Datos que voy a recibir desde el formulario
    private String username;
    private String password;
}
