package com.challengeforoalura.foroalura.validaciones;

import com.challengeforoalura.foroalura.model.tema.NuevoTema;
import com.challengeforoalura.foroalura.model.tema.TemaRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TemaExistente implements TemaValidacion{

    @Autowired
    private TemaRepository temaRepository;

    @Override
    public void validarTema(Object data) {
        if (data instanceof NuevoTema){
            NuevoTema nuevoTema = (NuevoTema) data;
            if (nuevoTema.titulo() == null || nuevoTema.mensaje() == null || nuevoTema.autor() == null || nuevoTema.curso() == null){
                return;
            }
            var temaTitulo = temaRepository.findByTitulo(nuevoTema.titulo().replace(" ", ""));
            var temaMensaje = temaRepository.findByMensaje(nuevoTema.mensaje().replace(" ", ""));

            if (temaTitulo != null){
                throw  new ValidationException("El titulo ingresado ya existe");
            }
            if (temaMensaje != null){
                throw new ValidationException("El mensaje ingresado ya existe");
            }
        }
    }
}
