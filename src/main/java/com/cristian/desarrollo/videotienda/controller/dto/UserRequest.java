package com.cristian.desarrollo.videotienda.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRequest {
    private String username;

    private String password;
    
    private String name;

    private String email;
    
    private Boolean admin;
}
