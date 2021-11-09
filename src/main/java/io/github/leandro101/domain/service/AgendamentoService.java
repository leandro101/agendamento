package io.github.leandro101.domain.service;

import io.github.leandro101.domain.entity.Agendamento;
import io.github.leandro101.domain.entity.Cliente;
import io.github.leandro101.domain.exception.AgendamentoExistException;
import io.github.leandro101.domain.repository.Agendamentos;
import io.github.leandro101.domain.repository.Clientes;
import io.github.leandro101.domain.util.DataUtils;
import io.github.leandro101.rest.model.dto.ResumoAtendimentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private Agendamentos agendamentos;

    @Autowired
    private Clientes clientes;

    public Agendamento save(Agendamento agendamento) throws AgendamentoExistException {
        if(agendamentos.existsAgendamentoByClienteAndAndDataHora(agendamento.getCliente(), agendamento.getDataHora()))
            throw new AgendamentoExistException(" O AGENDAMENTO JA EXISTE PARA ESSE CLIENTE ");
        return agendamentos.save(agendamento);
    }

    public Agendamento update(Agendamento agendamento) {
        return agendamentos.save(agendamento);
    }

    public List<Agendamento> listarTodos(){
        return agendamentos.findAll();
    }

    public List<Agendamento> listarTodosByDataValor(){
        return agendamentos.listarTodosByDataValor();
    }

    public ResumoAtendimentoDTO sumarizarAtendimento(Integer idCliente, String dataHora){
         BigDecimal total = new BigDecimal(0);
         Cliente cliente = clientes.getClienteById(idCliente);
        LocalDateTime data = DataUtils.stringToLocaDateTime(dataHora);
        agendamentos.findAllByClienteAndDataHoraEquals(cliente, data).forEach(a -> {
            a.getServicos().forEach(s -> {
                total.add(s.getValor());
            });
        });
        return new ResumoAtendimentoDTO(cliente, DataUtils.localDateTimeToString(data), total);
    }

}
