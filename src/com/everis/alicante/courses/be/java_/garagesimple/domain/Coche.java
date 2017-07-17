package com.everis.alicante.courses.be.java_.garagesimple.domain;

public class Coche extends Vehiculo implements Aparcable {

	private String marca;

//	public Coche(String marca, String matricula, Cliente cliente) {
//		super(matricula, cliente);
//		this.marca = marca;
//	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public void aparcar() {
		System.out.println("Puedo aparcar");
	}

//	@Override
//	public String toString() {
//		return "Coche [marca=" + marca + ", matricula=" + matricula + ", cliente=" + cliente + "]";
//	}
}
