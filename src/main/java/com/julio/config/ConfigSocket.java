package com.julio.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
//Le dice a Spring que esta clase es una clase de configuración, es
//decir, que contiene instrucciones que le dirán a la aplicación cómo debe comportarse
//o configurarse. Aquí estamos configurando WebSockets.
@EnableWebSocketMessageBroker
//Activa el soporte para WebSocket con algo
//llamado "Message Broker". Esto significa que podemos enviar mensajes y recibir
//respuestas sin tener que refrescar la página, y que Spring se encargará de "dirigir"
//esos mensajes de manera ordenada.

public class ConfigSocket implements WebSocketMessageBrokerConfigurer{
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
    // Nos indicará a dónde tenemos que conectarnos,
    // en este caso a http://localhost:4200/chat-websocket
        registry.addEndpoint("chat-websocket")
                .setAllowedOrigins("http://localhost:4200")
                .withSockJS(); //Dominios permitidos
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry  registry){
        registry.enableSimpleBroker("/chat/");
    // El broker se usará para enviar los mensajes a los clientes
        registry.setApplicationDestinationPrefixes("/app");
    }
}