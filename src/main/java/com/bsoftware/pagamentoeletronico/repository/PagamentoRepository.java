package com.bsoftware.pagamentoeletronico.repository;

import com.bsoftware.pagamentoeletronico.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
