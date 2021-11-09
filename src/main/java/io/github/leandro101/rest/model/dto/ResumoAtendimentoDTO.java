package io.github.leandro101.rest.model.dto;

import io.github.leandro101.domain.entity.Cliente;

import java.math.BigDecimal;

public class ResumoAtendimentoDTO {

    private Cliente cliente;
    private String data;
    private BigDecimal valorTotal;

    public ResumoAtendimentoDTO(){}

    public ResumoAtendimentoDTO(Cliente cliente, String data, BigDecimal valorTotal) {
        this.cliente = cliente;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
