package com.challengeforoalura.foroalura.controller;

import com.challengeforoalura.foroalura.model.tema.NuevoTema;
import com.challengeforoalura.foroalura.service.TemaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temas")
public class TemaController {

    @Autowired
    private TemaService temaService;

    @PostMapping("/registrar")
    @Transactional
    public ResponseEntity nuevoTema(@RequestBody @Valid NuevoTema nuevoTema){
        var respuesta = temaService.AñadirNuevoTema(nuevoTema);
        return ResponseEntity.ok(respuesta);
    }
}
