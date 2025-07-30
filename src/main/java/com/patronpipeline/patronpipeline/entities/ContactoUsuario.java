package com.patronpipeline.patronpipeline.entities;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactoUsuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String correo;
    private String instagram;
    private String web;

    @Override
    public String toString() {
        return String.format("%s %s | Correo: %s | IG: %s | Web: %s",
                nombre, apellido, correo, instagram, web);
    }
}