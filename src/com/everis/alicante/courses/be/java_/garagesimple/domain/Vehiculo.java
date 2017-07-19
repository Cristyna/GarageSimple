package com.everis.alicante.courses.be.java_.garagesimple.domain;

public class Vehiculo {
	
	private String matricula;
	private String tipoVehiculo;

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + "]";
	}

}
