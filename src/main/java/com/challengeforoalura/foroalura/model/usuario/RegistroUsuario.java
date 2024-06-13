package com.challengeforoalura.foroalura.model.usuario;

import jakarta.validation.constraints.NotBlank;

public record RegistroUsuario(
        String nombre,
        String email,
        String password) {
}
