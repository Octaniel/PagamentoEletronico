package com.bsoftware.pagamentoeletronico.service;

import com.bsoftware.pagamentoeletronico.model.*;
import com.bsoftware.pagamentoeletronico.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleFunction;

@Service
public class ModeloService {

    @Autowired
    private FicheiroHeaderClienteRepository ficheiroHeaderClienteRepository;

    @Autowired
    private FicheiroDetalheClienteRepository ficheiroDetalheClienteRepository;

    @Autowired
    private HeaderTrailerMepsRepository headerTrailerMepsRepository;

    @Autowired
    private DetailMepsRepository detailMepsRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    /*TODO: data de processamento deve ser a data atual
       TODO: id ultimo ficheiro deve ser a data do ultimo ficheiro gerado
        TODO: id por dia*/
    public byte[] lerparaDoc() {
        FicheiroHeaderCliente ficheiroHeaderClientesalvar = new FicheiroHeaderCliente();
        List<FicheiroHeaderCliente> all = ficheiroHeaderClienteRepository.findAll();

        LocalDate dataProcessoData = LocalDate.now();
        String mes =""+dataProcessoData.getMonthValue();
        String dia =""+dataProcessoData.getDayOfMonth();
        if(mes.length()==1) mes = "0"+mes;
        if(dia.length()==1) mes = "0"+dia;
        //dia="20";
        String dataProcesso = "";
        List<FicheiroHeaderCliente> allByDataProcessamentoEquals = ficheiroHeaderClienteRepository.findAllByDataProcessamentoLike("%"+dataProcessoData.getYear()+mes+dia+"%");
        FicheiroHeaderCliente ficheiroHeaderCliente1;
        if(allByDataProcessamentoEquals.size()>0){
            ficheiroHeaderCliente1 = allByDataProcessamentoEquals.get(allByDataProcessamentoEquals.size() - 1);
            ficheiroHeaderClientesalvar.setIdPorDia(ficheiroHeaderCliente1.getIdPorDia()+1);
            int i = ficheiroHeaderCliente1.getIdPorDia() + 1;
            dataProcesso = dataProcessoData.getYear()+mes+dia+i;
        }else {
            dataProcesso = ""+dataProcessoData.getYear()+mes+dia+0;
            ficheiroHeaderClientesalvar.setIdPorDia(0);
        }
        FicheiroHeaderCliente one = pegarDadosEstaticosFicheiroHeaderCliente();
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:docs/saida");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            String header = "";
            if(all.size()>0){
                FicheiroHeaderCliente ficheiroHeaderCliente = all.get(all.size() - 1);
                header = "0AEPS"+one.getInstituicaoOrigem()+one.getInstituicaoDestino()+dataProcesso
                        +ficheiroHeaderCliente.getDataProcessamento()+one.getEntidade()+"024                   ";
                ficheiroHeaderClientesalvar.setUltimoFicheiroEmviado(ficheiroHeaderCliente.getDataProcessamento());
            }else{
                header = "0AEPS"+one.getInstituicaoOrigem()+one.getInstituicaoDestino()+dataProcesso
                        +dataProcesso+one.getEntidade()+"024                   ";
                ficheiroHeaderClientesalvar.setUltimoFicheiroEmviado(dataProcesso);
            }
            ficheiroHeaderClientesalvar.setInstituicaoOrigem(one.getInstituicaoOrigem());
            ficheiroHeaderClientesalvar.setInstituicaoDestino(one.getInstituicaoDestino());
            ficheiroHeaderClientesalvar.setDataProcessamento(dataProcesso);
            ficheiroHeaderClientesalvar.setEntidade(one.getEntidade());
            ficheiroHeaderClientesalvar.setDataEnvio(LocalDate.now());
            ficheiroHeaderClienteRepository.save(ficheiroHeaderClientesalvar);
                bw.write(header);
                bw.newLine();
            List<FicheiroDetalheCliente> byFicheiroHeaderClienteId = ficheiroDetalheClienteRepository.findAll();
            byFicheiroHeaderClienteId.forEach(x ->{
                    String detail = "180"+x.getReferencia()+x.getDataLimitePagamento()+x.getMontanteMaximo()+x.getDataInicioPagamento()
                            +x.getMontanteMinimo()+x.getCodigoCliente()+"00";
                    try {
                        bw.write(detail);
                        bw.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                String trailer = "90000000"+byFicheiroHeaderClienteId.size()+"                                                         ";
                bw.write(trailer);
                bw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        byte[] bFile = null;
        try {
            bFile = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bFile;
    }

    private FicheiroHeaderCliente pegarDadosEstaticosFicheiroHeaderCliente() {
        FicheiroHeaderCliente ficheiroHeaderCliente=new FicheiroHeaderCliente();
        ficheiroHeaderCliente.setInstituicaoOrigem("16969696");
        ficheiroHeaderCliente.setInstituicaoDestino("06010101");
        ficheiroHeaderCliente.setEntidade("01590");
        return ficheiroHeaderCliente;
    }

    public void escreverparaDoc(MultipartFile file){
        File file1 = null;
        File file2 = null;
        try {
            file1 = ResourceUtils.getFile("classpath:docs/saida");
            file.transferTo(file1);
            file2 = new File("/home/octaniel/Documentos/teste/arquivo1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file2))) {


            //file2.createNewFile();
            //System.out.println(newFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file1));){
            HeaderTrailerMeps headerMeps=new HeaderTrailerMeps();
            List<DetailMeps> mepsList = new ArrayList<>();
            String s;
            if ((s = br.readLine()) != null) {
                headerMeps.setInstituicaoOrigem(s.substring(5, 13));
                headerMeps.setInstituicaoDestino(s.substring(13,21));
                headerMeps.setDataProcessamento(s.substring(21,30));
                headerMeps.setIdentificacaoUltimoFicheiro(s.substring(30,39));
                headerMeps.setEntidade(s.substring(39,44));
                headerMeps.setTaxaIva(s.substring(47,49));
            }
            while ((s=br.readLine())!=null){
                DetailMeps detailMeps=new DetailMeps();
                if(s.charAt(0)!='9'){
                    detailMeps.setIdentificacaoEgr(s.substring(3,7));
                    detailMeps.setNumeroEgr(s.substring(7,15));
                    detailMeps.setDataHoraTransacaoCliente(s.substring(15,27));
                    detailMeps.setMontantePago(s.substring(27,40));
                    detailMeps.setTarifa(s.substring(40,45));
                    detailMeps.setTipoTerminal(s.substring(45,47));
                    detailMeps.setIdentificacaoTerminal(s.substring(47,57));
                    detailMeps.setIdentificacaoTransacao(s.substring(57,62));
                    detailMeps.setLocalidadeTerminal(s.substring(62,77));
                    detailMeps.setReferenciaPagamento(s.substring(77,86));
                    detailMeps.setModoEnvioComunicacao(s.substring(86,87));
                    detailMeps.setCodigoRespostaEmpresa(s.substring(87,88));
                    detailMeps.setNumeroIdentificacaoResposta(s.substring(88,100));
                    mepsList.add(detailMeps);
                }else {
                    headerMeps.setMontanteTotalTransacoes(s.substring(9,26));
                    headerMeps.setTotalTarifacao(s.substring(26,38));
                    headerMeps.setIva(s.substring(38,50));
                }
            }
            headerTrailerMepsRepository.save(headerMeps);
            mepsList.forEach(x->{
                x.setHeaderMeps(headerMeps);
                detailMepsRepository.save(x);
                valiadar(x.getMontantePago(), x.getReferenciaPagamento());
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void valiadar(String montantePago, String referenciaPagamento) {
        ficheiroDetalheClienteRepository.findAllByStatusEquals(false).forEach(x->{
            Double xMontanteMaximo = Double.parseDouble(x.getMontanteMaximo());
            double xMontanteMinimo = Double.parseDouble(x.getMontanteMinimo());
            double montantePago1 = Double.parseDouble(montantePago);
            if(x.getReferencia().equals(referenciaPagamento)&&x.getMontanteMaximo().equals(montantePago)){
                x.setStatus(true);
                Pagamento pagamento = new Pagamento();
                pagamento.setData(LocalDate.now());
                pagamento.setValor(montantePago1);
                pagamento.setFicheiroDetalheCliente(x);
                ficheiroDetalheClienteRepository.save(x);
                pagamentoRepository.save(pagamento);
            }else if(x.getReferencia().equals(referenciaPagamento)&&xMontanteMinimo<montantePago1){
                xMontanteMaximo-=montantePago1;
                String s = xMontanteMaximo + "";
                String sa = "";
                for (int i=0;i<s.length();i++){
                    if(!("" + s.charAt(i)).equals(".")){
                        if(i==(s.length()-1)&&("" + s.charAt(i)).equals("0")) continue;
                            sa=sa+s.charAt(i);
                    }
                }
                s=sa;
                for (int i=s.length();i<13;i++){
                    s="0"+s;
                }
                x.setMontanteMaximo(s);
                Pagamento pagamento = new Pagamento();
                pagamento.setData(LocalDate.now());
                pagamento.setValor(montantePago1);
                pagamento.setFicheiroDetalheCliente(x);
                ficheiroDetalheClienteRepository.save(x);
                pagamentoRepository.save(pagamento);
            }
        });
    }
}
