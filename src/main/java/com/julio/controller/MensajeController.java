package com.julio.controller;
import com.julio.models.Mensaje;
import com.julio.services.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeController {
    @Autowired
    private MensajeService mensajeService;

    @PostMapping
    public Mensaje guardarMensaje(@RequestBody Mensaje mensaje){
        return mensajeService.guardarMensaje(mensaje);
    }

    @GetMapping
    public List<Mensaje> obtenerTodosLosMensajes(){
        return mensajeService.obtenerTodosLosMensajes();
    }
    @GetMapping("/usuario/{username}")
    public List<Mensaje> obtenerMensajesPorUsuario(@PathVariable String username){
        return mensajeService.obtenerMensajesPorUsuario(username);
    }
}
