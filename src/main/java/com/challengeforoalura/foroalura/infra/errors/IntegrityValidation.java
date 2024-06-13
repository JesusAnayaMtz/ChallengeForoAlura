package com.challengeforoalura.foroalura.infra.errors;

public class IntegrityValidation extends RuntimeException{
    public IntegrityValidation(String mensaje){
        super(mensaje);
    }
}
