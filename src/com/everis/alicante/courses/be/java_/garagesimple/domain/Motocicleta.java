package com.everis.alicante.courses.be.java_.garagesimple.domain;

public class Motocicleta extends Vehiculo implements Aparcable {

	private String marca;

//	public Motocicleta(String marca, String matricula, Cliente cliente) {
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
//
//	@Override
//	public String toString() {
//		return "Motocicleta [marca=" + marca + ", matricula=" + matricula + ", cliente=" + cliente + "]";
//	}

}
