package com.patronpipeline.patronpipeline.pipeline.Handlers;

import com.patronpipeline.patronpipeline.entities.ContactoUsuario;

public class BuildWebHandler implements Handler<ContactoUsuario> {
    @Override
    public ContactoUsuario process(ContactoUsuario input) {
        String dominioFull = input.getWeb();
        input.setWeb("https://" + dominioFull);
        return input;
    }
}