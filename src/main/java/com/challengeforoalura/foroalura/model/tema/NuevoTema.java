package com.challengeforoalura.foroalura.model.tema;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NuevoTema(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Long autor,
        @NotNull Long curso
) {
}
