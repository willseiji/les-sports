package br.com.les.dominio.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cupom")
public class Cupom extends EntidadeDominio{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_endereco")
	private int id;
	@Column(name="data_criacao")
	private String Data;
	@Column(name="data_validade")
	private String DataValidade;
	@Column
	private  String codigo;
	@Column
	double valor;
	@Column
	private int id_cliente;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getDataValidade() {
		return DataValidade;
	}
	public void setDataValidade(String dataValidade) {
		DataValidade = dataValidade;
	}
	
	
	
	
}
