package io.github.leandro101.domain.repository;

import io.github.leandro101.domain.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Servicos extends JpaRepository<Servico, Integer> {

    Servico getServicoByCodigo(Integer codigo);

    boolean existsByDescricao(String descricao);

}
