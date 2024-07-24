package com.picpaysimplificado.repositorios;

import com.picpaysimplificado.domain.transacao.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTransacoes extends JpaRepository<Transacao, Long> {

}
