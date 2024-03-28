package com.mapeamento.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataPedido;
    private Double valorTotal;    
   
    
    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente"/*, nullable = false*/)
    private Cliente cliente;

    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fornecedor"/*, nullable = false*/)
    private Fornecedor fornecedor;

	public Pedido(Date dataPedido, Double valorTotal, Cliente cliente, Fornecedor fornecedor) {
		this.dataPedido = dataPedido;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.fornecedor = fornecedor;
	}
    
    

    
}