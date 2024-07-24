package com.picpaysimplificado.domain.user;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name="usuarios")
@Table(name="usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String sobrenome;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    private String senha;

    private BigDecimal saldo;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
}
