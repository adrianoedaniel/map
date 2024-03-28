package com.mapeamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapeamento.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}
