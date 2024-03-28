package com.mapeamento.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mapeamento.entities.Fornecedor;
import com.mapeamento.service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    private FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping
    public List<Fornecedor> getAll() {
        return fornecedorService.buscaTodos();
    }

    @GetMapping("/{id}")
    public Fornecedor getById(@PathVariable Long id) {
        return fornecedorService.buscaId(id);
    }

    @PostMapping
    public Fornecedor create(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.salva(fornecedor);
    }

    @PutMapping("/{id}")
    public Fornecedor update(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        return fornecedorService.alterar(id, fornecedor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        fornecedorService.apagar(id);
    }
}