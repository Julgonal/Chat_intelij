package com.julio.controller;
import com.julio.models.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import com.julio.repositories.MensajeRepository;

import java.time.LocalDateTime;

@Controller
public class ChatControllers {
    @Autowired
    private MensajeRepository mensajeRepository; // Inyecion del repositorio
    @MessageMapping("/mensaje")
    @SendTo("/chat/mensaje")
    public Mensaje recibeMensaje(Mensaje mensaje){
        mensaje.setFechaEnvio(LocalDateTime.now());

        if (mensaje.getUsername() == null || mensaje.getUsername().isEmpty())
            mensaje.setUsername("Usuario anónimo");

        Mensaje mensajeGuardado = mensajeRepository.save(mensaje);
        System.out.println("Mensaje guardado: " + mensajeGuardado);
        return mensajeGuardado;
    }
}
