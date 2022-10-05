package com.cristian.desarrollo.videotienda.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristian.desarrollo.videotienda.controller.dto.LoginRequest;
import com.cristian.desarrollo.videotienda.service.SecurityService;

import lombok.AllArgsConstructor;

// Servicios REST: Donde enviar informacion en JSON y la recibo en JSON

@AllArgsConstructor
@RestController // Voy a publicar unos metodos, esos metodos van a recibirun cuerpo y devuelven unos datos
@RequestMapping("api/login") // Cuando escriban esta ruta, necesito ejecutar una función que va a estar en esta clase
public class LoginRestController {
    
    // Operaciones Servicios Rest:
    // POST -> Insertar (Create)  --> Usar para peticiones en donde no quiero mostrar los datos en la URL
    // GET -> Consultar / Listar (Read)  
    // PUT -> Actualizar (Update)
    // PATCH -> Actualizar Campo (No quiero modificar todo el objeto(Solo algún atributo))
    // DELETE -> Borrar (Delete)

    private SecurityService securityService; // Permite acceder a los metodos de creacion de usario, validacion...

    // ResponseEntity: Sirve para enviar codigos de error o de exito de un servidor HTTP
    @PostMapping // Solicitud de método Post. Cuando le hagan un llamado post a la ruta dada llame este metodo. @RequestBody
    public ResponseEntity<?> login(@RequestBody LoginRequest user) { // LoginRequest es un objeto que tiene solamente los atributos necesarios que me envian en el formulario
        try{
            var response = securityService.validateUser(user.getUsername(), user.getPassword());
            return ResponseEntity.ok(response); // Todo salió bien, retorna un mensaje 200 y en el cuerpo el objeto que quiero devolver
        }catch(RuntimeException ex) { 
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ex.getMessage()); // Retorna un error 400 y una cadena(La de la excepcion)
        }
    }
}
