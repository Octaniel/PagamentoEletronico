package com.bsoftware.pagamentoeletronico.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Integer id;

    @Column(name = "dt_pagamento")
    private LocalDate data;

    @Column(name = "valor_pagamento")
    private Double valor;

    @JoinColumn(name = "ficheiro_detalheid")
    @ManyToOne
    private FicheiroDetalheCliente ficheiroDetalheCliente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public FicheiroDetalheCliente getFicheiroDetalheCliente() {
        return ficheiroDetalheCliente;
    }

    public void setFicheiroDetalheCliente(FicheiroDetalheCliente ficheiroDetalheCliente) {
        this.ficheiroDetalheCliente = ficheiroDetalheCliente;
    }
}
