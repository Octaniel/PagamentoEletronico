package com.bsoftware.pagamentoeletronico.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_ficheiro_detalhe_cliente")
public class FicheiroDetalheCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ficheiro_detalhe_cliente")
    private Integer id;

    @Column(name = "referencia_ficheiro_detalhe_cliente")
    private String referencia;

    @Column(name = "data_limite_pagamento_ficheiro_detalhe_cliente")
    private String dataLimitePagamento;

    @Column(name = "montante_maximo_ficheiro_detalhe_cliente")
    private String montanteMaximo;

    @Column(name = "data_inicio_pagamento_ficheiro_detalhe_cliente")
    private String dataInicioPagamento;

    @Column(name = "montante_minimo_ficheiro_detalhe_cliente")
    private String montanteMinimo;

    @Column(name = "codigo_cliente_ficheiro_detalhe_cliente")
    private String codigoCliente;

    @Column(name = "status_ficheiro_detalhe_cliente")
    private Boolean status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FicheiroDetalheCliente that = (FicheiroDetalheCliente) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDataLimitePagamento() {
        return dataLimitePagamento;
    }

    public void setDataLimitePagamento(String dataLimitePagamento) {
        this.dataLimitePagamento = dataLimitePagamento;
    }

    public String getMontanteMaximo() {
        return montanteMaximo;
    }

    public void setMontanteMaximo(String montanteMaximo) {
        this.montanteMaximo = montanteMaximo;
    }

    public String getDataInicioPagamento() {
        return dataInicioPagamento;
    }

    public void setDataInicioPagamento(String dataInicioPagamento) {
        this.dataInicioPagamento = dataInicioPagamento;
    }

    public String getMontanteMinimo() {
        return montanteMinimo;
    }

    public void setMontanteMinimo(String montanteMinimo) {
        this.montanteMinimo = montanteMinimo;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
