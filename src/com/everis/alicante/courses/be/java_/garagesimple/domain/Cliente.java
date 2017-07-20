package com.everis.alicante.courses.be.java_.garagesimple.domain;

public class Cliente {
	private String nif;
	private String nombreCompleto;
	private Vehiculo vehiculo;

	// public Cliente (String nif, String nombreCompleto){
	// this.nif= nif;
	// this.nombreCompleto= nombreCompleto;
	// }

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
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
		return "Cliente [nif=" + nif + ", nombreCompleto=" + nombreCompleto + ", vehiculo=" + vehiculo + "]";
	}

	public String convierteAFormatoTxt() {

		String str = "";

		str = str.concat(String.valueOf(this.nif));
		str = str.concat(";");
		str = str.concat(String.valueOf(this.nombreCompleto));
		str = str.concat(";");
		str = str.concat(this.getVehiculo().getMatricula());

		return str;
	}

}
