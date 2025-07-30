package com.patronpipeline.patronpipeline.pipeline.Handlers;

import com.patronpipeline.patronpipeline.entities.ContactoUsuario;

public class ParseEmailHandler implements Handler<ContactoUsuario> {
    @Override
    public ContactoUsuario process(ContactoUsuario input) {
        String correo = input.getCorreo();
        String[] partes = correo.split("@");
        String[] nombrePartes = partes[0].split("\\.");
        input.setNombre(nombrePartes[0]);
        input.setApellido(nombrePartes.length > 1 ? nombrePartes[1] : "");
        // guardamos dominio completo para usarlo después
        input.setWeb(partes[1]); // provisional, lo reescribiremos en BuildWebHandler
        return input;
    }
}