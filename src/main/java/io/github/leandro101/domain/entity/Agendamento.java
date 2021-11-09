package io.github.leandro101.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Cliente cliente;
    private LocalDateTime dataHora;
    private String observacao;
    @OneToMany
    private List<Servico> servicos;

    public Agendamento(){}

    public Agendamento(Integer id, Cliente cliente, LocalDateTime dataHora, String observacao, List<Servico> servicos) {
        this.id = id;
        this.cliente = cliente;
        this.dataHora = dataHora;
        this.observacao = observacao;
        this.servicos = servicos;
    }

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

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return Objects.equals(id, that.id) && Objects.equals(cliente, that.cliente)
                && Objects.equals(dataHora, that.dataHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, dataHora);
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", dataHora=" + dataHora +
                ", observacao='" + observacao + '\'' +
                ", servicos=" + servicos +
                '}';
    }
}
