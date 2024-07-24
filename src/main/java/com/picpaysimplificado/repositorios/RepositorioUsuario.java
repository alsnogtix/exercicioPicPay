package com.picpaysimplificado.repositorios;

import com.picpaysimplificado.domain.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
    Optional<Usuario> buscaUsuarioPorCpf(String cpf);
    Optional<Usuario> buscaUsuarioPorId(Long id);
}
