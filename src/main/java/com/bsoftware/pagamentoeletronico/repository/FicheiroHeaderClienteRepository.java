package com.bsoftware.pagamentoeletronico.repository;

import com.bsoftware.pagamentoeletronico.model.FicheiroHeaderCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FicheiroHeaderClienteRepository extends JpaRepository<FicheiroHeaderCliente, Integer> {
    List<FicheiroHeaderCliente> findAllByDataProcessamentoLike(String tg);
}
