package com.bsoftware.pagamentoeletronico.repository;

import com.bsoftware.pagamentoeletronico.model.FicheiroDetalheCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FicheiroDetalheClienteRepository extends JpaRepository<FicheiroDetalheCliente, Integer> {
    List<FicheiroDetalheCliente> findAllByStatusEquals(Boolean status);
}
