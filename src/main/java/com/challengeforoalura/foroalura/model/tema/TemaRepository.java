package com.challengeforoalura.foroalura.model.tema;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TemaRepository extends JpaRepository<Tema, Long> {

//    @Query("""
//                SELECT t.titulo
//                FROM Tema t
//                WHERE REPLACE(t.titulo, " ", "") = :titulo
//                """)
    String findByTitulo(String title);

//    @Query("""
//                SELECT t.mensaje
//                FROM Tema t
//                WHERE REPLACE(t.mensaje, " ", "") = :mensaje
//                """)
    String findByMensaje(String message);
}
