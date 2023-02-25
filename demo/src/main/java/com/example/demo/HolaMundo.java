package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {
    @GetMapping("/api/hello")
    public String hello(){
        return "Hola Mundo";
    }

    @PostMapping("/api/holaPersona")
    public Persona holaPersona(){
        return new Persona("Fran","Navarro");
    }

}
