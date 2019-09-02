package br.com.les.dominio.impl;

public class Estoque extends EntidadeDominio {
	
	private int id;
	private String data;
	private String codigo;
	private int volumeMinimo;
	private int volumeMaximo;
	private int volume;
	private double precoCompra;
	private double precoVenda;
	
	
	
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
	public int getVolumeMinimo() {
		return volumeMinimo;
	}
	public void setVolumeMinimo(int volumeMinimo) {
		this.volumeMinimo = volumeMinimo;
	}
	public int getVolumeMaximo() {
		return volumeMaximo;
	}
	public void setVolumeMaximo(int volumeMaximo) {
		this.volumeMaximo = volumeMaximo;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public double getPrecoCompra() {
		return precoCompra;
	}
	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	
	

}
