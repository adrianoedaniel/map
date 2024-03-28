package com.mapeamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapeamento.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
