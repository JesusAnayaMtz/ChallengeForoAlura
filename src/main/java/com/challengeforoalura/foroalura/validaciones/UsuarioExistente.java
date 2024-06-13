package com.challengeforoalura.foroalura.validaciones;

import com.challengeforoalura.foroalura.model.usuario.AutenticacionUsuario;
import com.challengeforoalura.foroalura.model.usuario.UsuarioRepository;

public class UsuarioExistente {
    private UsuarioRepository usuarioRepository;

    public void isUserExist(AutenticacionUsuario autenticacionUsuario){
        var usuario = usuarioRepository.findByEmail(autenticacionUsuario.email());
    }
}
