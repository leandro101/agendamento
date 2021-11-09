package io.github.leandro101.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    private String descricao;
    @Column(name = "valor", precision = 20, scale = 2)
    private BigDecimal valor;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Servico servico = (Servico) o;
        return Objects.equals(codigo, servico.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Servico{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }
}
