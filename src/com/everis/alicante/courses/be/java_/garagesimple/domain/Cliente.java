package com.everis.alicante.courses.be.java_.garagesimple.domain;

public class Cliente {
	private String nif;
	private String nombreCompleto;
	
	public Cliente (String nif, String nombreCompleto){
		this.nif= nif;
		this.nombreCompleto= nombreCompleto;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	
	@Override
	public String toString() {
		return "Cliente [nif=" + nif + ", nombreCompleto=" + nombreCompleto + "]";
	}
	
}
