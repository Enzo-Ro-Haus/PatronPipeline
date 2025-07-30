package com.patronpipeline.patronpipeline.controllers;

import com.patronpipeline.patronpipeline.entities.ContactoUsuario;
import com.patronpipeline.patronpipeline.services.ContactoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContactoController {

    private final ContactoService contactoService;

    @PostMapping("/contactos")
    public ResponseEntity<ContactoUsuario> crearContacto(@RequestParam String email) {
        ContactoUsuario contacto = contactoService.procesarYGuardarContacto(email);
        return ResponseEntity.ok(contacto);
    }
}