package com.patronpipeline.patronpipeline.pipeline.Handlers;

import com.patronpipeline.patronpipeline.entities.ContactoUsuario;

public class CapitalizeNamesHandler implements com.patronpipeline.patronpipeline.pipeline.Handlers.Handler<ContactoUsuario> {
    @Override
    public ContactoUsuario process(ContactoUsuario input) {
        input.setNombre(capitalize(input.getNombre()));
        input.setApellido(capitalize(input.getApellido()));
        return input;
    }

    private String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }
}