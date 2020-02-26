package com.bsoftware.pagamentoeletronico.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_ficheiro_header_cliente")
public class FicheiroHeaderCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fic_cliente")
    private Integer id;

    @Column(name = "instituicao_origem_fic_cliente")
    private String instituicaoOrigem;

    @Column(name = "instituicao_destino_fic_cliente")
    private String instituicaoDestino;

    @Column(name = "data_processamento_fic_clientecol")
    private String dataProcessamento;

    @Column(name = "ultimo_ficheiro_enviado_fic_cliente")
    private String ultimoFicheiroEmviado;

    @Column(name = "entidade_fic_cliente")
    private String entidade;

    @Column(name = "data_envio")
    private LocalDate dataEnvio;

    @Column(name = "id_por_dia")
    private Integer idPorDia;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FicheiroHeaderCliente that = (FicheiroHeaderCliente) o;
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

    public String getInstituicaoOrigem() {
        return instituicaoOrigem;
    }

    public void setInstituicaoOrigem(String instituicaoOrigem) {
        this.instituicaoOrigem = instituicaoOrigem;
    }

    public String getInstituicaoDestino() {
        return instituicaoDestino;
    }

    public void setInstituicaoDestino(String instituicaoDestino) {
        this.instituicaoDestino = instituicaoDestino;
    }

    public String getDataProcessamento() {
        return dataProcessamento;
    }

    public void setDataProcessamento(String dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }

    public String getUltimoFicheiroEmviado() {
        return ultimoFicheiroEmviado;
    }

    public void setUltimoFicheiroEmviado(String ultimoFicheiroEmviado) {
        this.ultimoFicheiroEmviado = ultimoFicheiroEmviado;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Integer getIdPorDia() {
        return idPorDia;
    }

    public void setIdPorDia(Integer idPorDia) {
        this.idPorDia = idPorDia;
    }
}
