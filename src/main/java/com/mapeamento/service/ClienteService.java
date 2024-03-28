package com.mapeamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapeamento.entities.Cliente;
import com.mapeamento.repository.ClienteRepository;


@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	public List<Cliente> buscaTodos(){
		return clienteRepository.findAll();
	}
	public Cliente buscaId(Long id) {
		Optional <Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElse(null);
	}
	public Cliente salva(Cliente cliente) {
		return clienteRepository.save(cliente);		
	}
	public Cliente alterar(Long id, Cliente alterarC) {
		Optional <Cliente> existeCliente = clienteRepository.findById(id);
		if (existeCliente.isPresent()) {
			alterarC.setId(id);;
			return clienteRepository.save(alterarC);
		}
		return null;
	}
	public boolean apagar(Long id) {
		Optional <Cliente> existe = clienteRepository.findById(id);
		if (existe.isPresent()) {
			clienteRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
