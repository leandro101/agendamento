package io.github.leandro101.domain.repository;

import io.github.leandro101.domain.entity.Agendamento;
import io.github.leandro101.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface Agendamentos extends JpaRepository<Agendamento, Integer> {

    boolean existsAgendamentoByClienteAndAndDataHora(Cliente cliente, LocalDateTime dataHora);

    List<Agendamento> findAllByClienteAndDataHoraEquals(Cliente cliente, LocalDateTime dataHora);

    @Query(value = "SELECT *                                                                    " +
            "       FROM AGENDAMENTO a INNER JOIN AGENDAMENTO_SERVICOS ON (ID = AGENDAMENTO_ID) " +
            "                          INNER JOIN SERVICO ON (SERVICOS_CODIGO = CODIGO)         " +
            "       ORDER BY DATA_HORA, VALOR", nativeQuery = true)
    List<Agendamento> listarTodosByDataValor();


}
