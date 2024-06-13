package com.challengeforoalura.foroalura.service;

import com.challengeforoalura.foroalura.model.perfil.PerfilRepository;
import com.challengeforoalura.foroalura.model.usuario.RegistroUsuario;
import com.challengeforoalura.foroalura.model.usuario.Usuario;
import com.challengeforoalura.foroalura.model.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;



    public boolean registrarUsuario(RegistroUsuario registroUsuario){
        if(registroUsuario.email() != null && usuarioRepository.existsByEmail(registroUsuario.email()).booleanValue()){
            return false;
        }
        var datosPerfil = perfilRepository.findByNombre("ROLE_USER");
        var nuevoUsuario = new Usuario(
                registroUsuario.nombre(),
                registroUsuario.email(),
                passwordEncoder.encode(registroUsuario.password()),
                Set.of(datosPerfil)
        );
        usuarioRepository.save(nuevoUsuario);
        return  true;
    }
}
