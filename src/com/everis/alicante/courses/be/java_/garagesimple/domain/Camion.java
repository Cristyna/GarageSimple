package com.everis.alicante.courses.be.java_.garagesimple.domain;

public class Camion extends Vehiculo {

	private String marca;

	public Camion(String marca, String matricula, Cliente cliente) {
		super(matricula, cliente);
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Camion [marca=" + marca + ", matricula=" + matricula + ", cliente=" + cliente + "]";
	}

	

}
