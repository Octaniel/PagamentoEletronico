package com.bsoftware.pagamentoeletronico.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_header_trailer_meps")
public class HeaderTrailerMeps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_header_meps")
    private Integer id;

    @Column(name = "instituicao_origem_header_meps")
    private String instituicaoOrigem;

    @Column(name = "instituicao_destino_header_meps")
    private String instituicaoDestino;

    @Column(name = "data_processamento_header_meps")
    private String dataProcessamento;

    @Column(name = "identificacao_ultimo_ficheiro_header_meps")
    private String identificacaoUltimoFicheiro;

    @Column(name = "entidade_header_meps")
    private String entidade;

    @Column(name = "taxa_iva_header_meps")
    private String taxaIva;

    @Column(name = "montante_total_transacoes_trailer_meps")
    private String montanteTotalTransacoes;

    @Column(name = "total_tarifacao_trailer_meps")
    private String totalTarifacao;

    @Column(name = "iva_trailer_meps")
    private String iva;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeaderTrailerMeps that = (HeaderTrailerMeps) o;
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

    public String getIdentificacaoUltimoFicheiro() {
        return identificacaoUltimoFicheiro;
    }

    public void setIdentificacaoUltimoFicheiro(String identificacaoUltimoFicheiro) {
        this.identificacaoUltimoFicheiro = identificacaoUltimoFicheiro;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public String getTaxaIva() {
        return taxaIva;
    }

    public void setTaxaIva(String taxaIva) {
        this.taxaIva = taxaIva;
    }

    public String getMontanteTotalTransacoes() {
        return montanteTotalTransacoes;
    }

    public void setMontanteTotalTransacoes(String montanteTotalTransacoes) {
        this.montanteTotalTransacoes = montanteTotalTransacoes;
    }

    public String getTotalTarifacao() {
        return totalTarifacao;
    }

    public void setTotalTarifacao(String totalTarifacao) {
        this.totalTarifacao = totalTarifacao;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }
}
