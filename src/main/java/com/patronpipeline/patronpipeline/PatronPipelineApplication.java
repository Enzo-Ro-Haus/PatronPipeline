package com.patronpipeline.patronpipeline;

import com.patronpipeline.patronpipeline.entities.ContactoUsuario;
import com.patronpipeline.patronpipeline.pipeline.Handlers.BuildWebHandler;
import com.patronpipeline.patronpipeline.pipeline.Handlers.CapitalizeNamesHandler;
import com.patronpipeline.patronpipeline.pipeline.Handlers.InstagramHandler;
import com.patronpipeline.patronpipeline.pipeline.Handlers.ParseEmailHandler;
import com.patronpipeline.patronpipeline.pipeline.Pipeline;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatronPipelineApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PatronPipelineApplication.class, args);
    }

    //Ejemplo:
    @Override
    public void run(String... args) {
        // 1. Construimos el ContactoUsuario sólo con el e-mail
        ContactoUsuario contacto = ContactoUsuario.builder()
                .correo("maria.hernandez@fullmascotas.com")
                .build();

        // 2. Montamos y ejecutamos el pipeline de Handlers
        Pipeline<ContactoUsuario> pipeline = new Pipeline<>();
        pipeline
                .addHandler(new ParseEmailHandler())
                .addHandler(new CapitalizeNamesHandler())
                .addHandler(new InstagramHandler())
                .addHandler(new BuildWebHandler());

        ContactoUsuario procesado = pipeline.execute(contacto);

        // 3. Imprimimos el resultado (usa toString() de tu entidad)
        System.out.println(">>> Contacto procesado: " + procesado);
    }
}
