package com.challengeforoalura.foroalura.model.tema;

import com.challengeforoalura.foroalura.model.curso.Curso;
import com.challengeforoalura.foroalura.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "temas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @Column(unique = true)
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
    private Integer preguntas;

    public Tema(String titulo, String mensaje, LocalDateTime fechaCreacion, Usuario usuario, Curso curso){
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.autor = usuario;
        this.curso = curso;
        this.preguntas = 0;
        this.estado = false;
    }
}
