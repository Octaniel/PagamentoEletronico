package com.bsoftware.pagamentoeletronico.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_detail_meps")
public class DetailMeps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail_meps")
    private Integer id;

    @Column(name = "identificacao_egr_detail_meps")
    private String identificacaoEgr;

    @Column(name = "numero_egr_detail_meps")
    private String numeroEgr;

    @Column(name = "data_hora_tranzacao_cliente_detail_meps")
    private String dataHoraTransacaoCliente;

    @Column(name = "montante_pago_detail_meps")
    private String montantePago;

    @Column(name = "tarifa_detail_meps")
    private String tarifa;

    @Column(name = "tipo_terminal_detail_meps")
    private String tipoTerminal;

    @Column(name = "identificacao_terminal_detail_meps")
    private String identificacaoTerminal;

    @Column(name = "identificacao_transacao_detail_meps")
    private String identificacaoTransacao;

    @Column(name = "localidade_terminal_detail_meps")
    private String localidadeTerminal;

    @Column(name = "referencia_pagamento_detail_meps")
    private String referenciaPagamento;

    @Column(name = "modo_envio_comunicacao_detail_meps")
    private String modoEnvioComunicacao;

    @Column(name = "codigo_resposta_empresa_detail_meps")
    private String codigoRespostaEmpresa;

    @Column(name = "numero_identificacao_resposta_detail_meps")
    private String numeroIdentificacaoResposta;

    @JoinColumn(name = "header_meps_id")
    @ManyToOne
    private HeaderTrailerMeps headerMeps;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetailMeps that = (DetailMeps) o;
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

    public String getIdentificacaoEgr() {
        return identificacaoEgr;
    }

    public void setIdentificacaoEgr(String identificacaoEgr) {
        this.identificacaoEgr = identificacaoEgr;
    }

    public String getNumeroEgr() {
        return numeroEgr;
    }

    public void setNumeroEgr(String numeroEgr) {
        this.numeroEgr = numeroEgr;
    }

    public String getDataHoraTransacaoCliente() {
        return dataHoraTransacaoCliente;
    }

    public void setDataHoraTransacaoCliente(String dataHoraTransacaoCliente) {
        this.dataHoraTransacaoCliente = dataHoraTransacaoCliente;
    }

    public String getMontantePago() {
        return montantePago;
    }

    public void setMontantePago(String montantePago) {
        this.montantePago = montantePago;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public String getTipoTerminal() {
        return tipoTerminal;
    }

    public void setTipoTerminal(String tipoTerminal) {
        this.tipoTerminal = tipoTerminal;
    }

    public String getIdentificacaoTerminal() {
        return identificacaoTerminal;
    }

    public void setIdentificacaoTerminal(String identificacaoTerminal) {
        this.identificacaoTerminal = identificacaoTerminal;
    }

    public String getIdentificacaoTransacao() {
        return identificacaoTransacao;
    }

    public void setIdentificacaoTransacao(String identificacaoTransacao) {
        this.identificacaoTransacao = identificacaoTransacao;
    }

    public String getLocalidadeTerminal() {
        return localidadeTerminal;
    }

    public void setLocalidadeTerminal(String localidadeTerminal) {
        this.localidadeTerminal = localidadeTerminal;
    }

    public String getReferenciaPagamento() {
        return referenciaPagamento;
    }

    public void setReferenciaPagamento(String referenciaPagamento) {
        this.referenciaPagamento = referenciaPagamento;
    }

    public String getModoEnvioComunicacao() {
        return modoEnvioComunicacao;
    }

    public void setModoEnvioComunicacao(String modoEnvioComunicacao) {
        this.modoEnvioComunicacao = modoEnvioComunicacao;
    }

    public String getCodigoRespostaEmpresa() {
        return codigoRespostaEmpresa;
    }

    public void setCodigoRespostaEmpresa(String codigoRespostaEmpresa) {
        this.codigoRespostaEmpresa = codigoRespostaEmpresa;
    }

    public String getNumeroIdentificacaoResposta() {
        return numeroIdentificacaoResposta;
    }

    public void setNumeroIdentificacaoResposta(String numeroIdentificacaoResposta) {
        this.numeroIdentificacaoResposta = numeroIdentificacaoResposta;
    }

    public HeaderTrailerMeps getHeaderMeps() {
        return headerMeps;
    }

    public void setHeaderMeps(HeaderTrailerMeps headerMeps) {
        this.headerMeps = headerMeps;
    }
}
