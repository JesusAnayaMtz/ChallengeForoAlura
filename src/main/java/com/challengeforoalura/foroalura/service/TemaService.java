package com.challengeforoalura.foroalura.service;

import com.challengeforoalura.foroalura.infra.errors.IntegrityValidation;
import com.challengeforoalura.foroalura.model.curso.Curso;
import com.challengeforoalura.foroalura.model.curso.CursoRepository;
import com.challengeforoalura.foroalura.model.tema.GuardarTema;
import com.challengeforoalura.foroalura.model.tema.NuevoTema;
import com.challengeforoalura.foroalura.model.tema.Tema;
import com.challengeforoalura.foroalura.model.tema.TemaRepository;
import com.challengeforoalura.foroalura.model.usuario.Usuario;
import com.challengeforoalura.foroalura.model.usuario.UsuarioRepository;
import com.challengeforoalura.foroalura.validaciones.TemaValidacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TemaService {

    @Autowired
    private TemaRepository temaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private List<TemaValidacion> temaValidacions;

    public GuardarTema AñadirNuevoTema(NuevoTema nuevoTema){
        var metodoCurso = obtenerCursoSeleccionado(nuevoTema);
        var metodoUsuario = obtenerUsuarioSeleccionado(nuevoTema);

        temaValidacions.forEach(validacion -> validacion.validarTema(nuevoTema));

        var currentDate = LocalDateTime.now();
        var newTema = new Tema(
                nuevoTema.titulo(),
                nuevoTema.mensaje(),
                currentDate,
                metodoUsuario,
                metodoCurso
        );
        temaRepository.save(newTema);
        return new GuardarTema(newTema);
    }

    private Usuario obtenerUsuarioSeleccionado(NuevoTema data){
        if (!usuarioRepository.findById(data.autor()).isPresent()){
            throw new IntegrityValidation("El usuario ingresado es invalido");
        }
        return usuarioRepository.getReferenceById(data.autor());
    }

    private Curso obtenerCursoSeleccionado(NuevoTema data){
        if (!cursoRepository.findById(data.curso()).isPresent()){
            throw new IntegrityValidation("El cuso ingresado es invalido");
        }
        return cursoRepository.getReferenceById(data.curso());
    }


}
