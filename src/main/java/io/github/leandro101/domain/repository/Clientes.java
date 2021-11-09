package io.github.leandro101.domain.repository;

import io.github.leandro101.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    Cliente getClienteById(Integer id);

    boolean existsByCpf(String cpf);

}
