package com.mapeamento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapeamento.entities.Fornecedor;
import com.mapeamento.repository.FornecedorRepository;


@Service
public class FornecedorService {

	private final FornecedorRepository fornecedorRepository;

	@Autowired
	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}
	public List<Fornecedor> buscaTodos(){
		return fornecedorRepository.findAll();
	}
	public Fornecedor buscaId(Long id) {
		Optional <Fornecedor> fornecedor = fornecedorRepository.findById(id);
		return fornecedor.orElse(null);
	}
	public Fornecedor salva(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);		
	}
	public Fornecedor alterar(Long id, Fornecedor alterarC) {
		Optional <Fornecedor> existeFornecedor = fornecedorRepository.findById(id);
		if (existeFornecedor.isPresent()) {
			alterarC.setId(id);;
			return fornecedorRepository.save(alterarC);
		}
		return null;
	}
	public boolean apagar(Long id) {
		Optional <Fornecedor> existe = fornecedorRepository.findById(id);
		if (existe.isPresent()) {
			fornecedorRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
