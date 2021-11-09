package io.github.leandro101.rest.model.dto;

import io.github.leandro101.domain.entity.Cliente;
import io.github.leandro101.domain.entity.Servico;

import java.util.List;

public class AgendamentoDTO {

    private Integer id;
    private Cliente cliente;
    private String dataHora;
    private String observacao;
    private List<Servico> servicos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
