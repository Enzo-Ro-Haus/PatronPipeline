package com.patronpipeline.patronpipeline.repositories;

import com.patronpipeline.patronpipeline.entities.ContactoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<ContactoUsuario, Long> {

}