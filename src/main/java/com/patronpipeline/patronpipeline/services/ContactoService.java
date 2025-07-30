package com.patronpipeline.patronpipeline.services;

import com.patronpipeline.patronpipeline.entities.ContactoUsuario;
import com.patronpipeline.patronpipeline.pipeline.Handlers.*;
import com.patronpipeline.patronpipeline.pipeline.Pipeline;
import com.patronpipeline.patronpipeline.repositories.ContactoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactoService {

    private final ContactoRepository repository;

    public ContactoUsuario procesarYGuardarContacto(String email) {
        ContactoUsuario contacto = ContactoUsuario.builder()
                .correo(email)
                .build();

        new Pipeline<ContactoUsuario>()
                .addHandler(new ParseEmailHandler())
                .addHandler(new CapitalizeNamesHandler())
                .addHandler(new InstagramHandler())
                .addHandler(new BuildWebHandler())
                .addHandler(new BuildContactHandler())
                .execute(contacto);

        return repository.save(contacto);
    }
}