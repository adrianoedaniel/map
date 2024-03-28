package com.mapeamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapeamento.entities.Cliente;
import com.mapeamento.entities.Fornecedor;
import com.mapeamento.entities.Pedido;
import com.mapeamento.repository.PedidoRepository;


@Service
public class PedidoService {

	private final PedidoRepository pedidoRepository;

	@Autowired
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	public List<Pedido> buscaTodos(){
		return pedidoRepository.findAll();
	}
	public Pedido buscaId(Long id) {
		Optional <Pedido> pedido = pedidoRepository.findById(id);
		return pedido.orElse(null);
	}
	public Pedido salva(Pedido pedido) {					
		return pedidoRepository.save(pedido) ; 

	}
	public Pedido alterar(Long id, Pedido alterarC) {
		Optional <Pedido> existePedido = pedidoRepository.findById(id);
		if (existePedido.isPresent()) {
			alterarC.setId(id);;
			return pedidoRepository.save(alterarC);
		}
		return null;
	}
	public boolean apagar(Long id) {
		Optional <Pedido> existe = pedidoRepository.findById(id);
		if (existe.isPresent()) {
			pedidoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
