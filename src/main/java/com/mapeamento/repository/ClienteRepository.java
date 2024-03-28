package com.mapeamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapeamento.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
