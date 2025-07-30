package com.patronpipeline.patronpipeline.pipeline.Handlers;

import com.patronpipeline.patronpipeline.entities.ContactoUsuario;

public class InstagramHandler implements Handler<ContactoUsuario> {
    @Override
    public ContactoUsuario process(ContactoUsuario input) {
        String dominioFull = input.getWeb(); // lo guardamos en ParseEmailHandler
        String nombreDominio = dominioFull.contains(".")
                ? dominioFull.substring(0, dominioFull.indexOf('.'))
                : dominioFull;
        input.setInstagram("@" + nombreDominio);
        return input;
    }
}