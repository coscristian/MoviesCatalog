package com.cristian.desarrollo.videotienda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Servicios REST: Donde enviar informacion en JSON y la recibo en JSON

@RestController // Voy a publicar unos metodos, esos metodos van a recibirun cuerpo y devuelven unos datos
@RequestMapping("api/login") // Cuando escriban esta ruta, necesito ejecutar una función que va a estar en esta clase
public class LoginRestController {
    
    // Operaciones Servicios Rest:
    // POST -> Insertar (Create)
    // GET -> Consultar / Listar (Read)
    // PUT -> Actualizar (Update)
    // DELETE -> Borrar (Delete)




}
