package com.patronpipeline.patronpipeline.pipeline.Handlers;

import com.patronpipeline.patronpipeline.entities.ContactoUsuario;

public class BuildContactHandler implements Handler<ContactoUsuario> {

    @Override
    public ContactoUsuario process(ContactoUsuario contacto) {
        return ContactoUsuario.builder()
                .id(contacto.getId())                 // en caso de edición
                .nombre(contacto.getNombre())
                .apellido(contacto.getApellido())
                .correo(contacto.getCorreo())
                .instagram(contacto.getInstagram())
                .web(contacto.getWeb())
                .build();
    }
}