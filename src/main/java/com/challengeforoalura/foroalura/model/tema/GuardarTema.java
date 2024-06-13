package com.challengeforoalura.foroalura.model.tema;

import java.time.LocalDateTime;

public record GuardarTema(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion
) {
    public GuardarTema(Tema tema){
        this(
                tema.getId(),
                tema.getTitulo(),
                tema.getMensaje(),
                tema.getFechaCreacion()
        );
    }
}
