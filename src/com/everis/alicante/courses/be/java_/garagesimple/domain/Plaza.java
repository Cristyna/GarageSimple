package com.everis.alicante.courses.be.java_.garagesimple.domain;

public class Plaza {
	
	private Cliente cliente;
	private double precio;

	public Plaza(double precio) {
		this.precio = precio;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Plaza [cliente=" + cliente + ", precio=" + precio + "]";
	}

}
