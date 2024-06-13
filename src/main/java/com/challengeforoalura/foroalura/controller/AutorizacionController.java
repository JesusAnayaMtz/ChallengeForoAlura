package com.challengeforoalura.foroalura.controller;

import com.challengeforoalura.foroalura.infra.security.DatosJWTToken;
import com.challengeforoalura.foroalura.infra.security.TokenService;
import com.challengeforoalura.foroalura.model.usuario.AutenticacionUsuario;
import com.challengeforoalura.foroalura.model.usuario.RegistroUsuario;
import com.challengeforoalura.foroalura.model.usuario.Usuario;
import com.challengeforoalura.foroalura.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/auth")
public class AutorizacionController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    @Transactional
    public ResponseEntity registro(@RequestBody @Valid RegistroUsuario registroUsuario, UriComponentsBuilder uriComponentsBuilder){
        var response = usuarioService.registrarUsuario(registroUsuario);

        if (Boolean.FALSE.equals(response)){
            return ResponseEntity.badRequest().body("Email Ya Esta En Uso");
        }
        return ResponseEntity.ok("Usuario Creado Correctamente");
    }

    @PostMapping("/login")
    public ResponseEntity inisioSesion(@RequestBody @Valid AutenticacionUsuario autenticacionUsuario){
        Authentication autenticacionToken = new UsernamePasswordAuthenticationToken(autenticacionUsuario.email(), autenticacionUsuario.password());
        var usuarioAutenticado = authenticationManager.authenticate(autenticacionToken);
        var jwtToken = tokenService.generadorToken((Usuario) usuarioAutenticado.getPrincipal());

        return ResponseEntity.ok(new DatosJWTToken(jwtToken));
    }

}
