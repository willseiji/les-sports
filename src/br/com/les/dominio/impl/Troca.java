package br.com.les.dominio.impl;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="troca")
public class Troca extends EntidadeDominio{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_troca")
	private int id;
	@Column
	private String data;
	@Column
	private String codigo;
	@Column
	private String status;
	@Column
	private double valor_total;
	@Column
	private int id_cliente; 
	@Transient
	private Cliente cliente;
	@Transient
	private List<ItemTroca> itensTroca;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ItemTroca> getItensTroca() {
		return itensTroca;
	}

	public void setItensTroca(List<ItemTroca> itensTroca) {
		this.itensTroca = itensTroca;
	}

	public void setValor_total() {
		this.valor_total=valorTotal();
	}
	
	
	
	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public double valorTotal() {
		double valorTotal=0;
		for(int i=0;i<getItensTroca().size();i++) {
			valorTotal+=getItensTroca().get(i).valorTroca();
		}
		return valorTotal;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
