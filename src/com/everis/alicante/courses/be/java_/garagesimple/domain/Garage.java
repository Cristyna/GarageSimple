package com.everis.alicante.courses.be.java_.garagesimple.domain;

import java.util.List;

public class Garage {

	private List<Plaza> plazas;
	private String nombreGaraje;



	public List<Plaza> getPlazas() {
		return plazas;
	}



	public void setPlazas(List<Plaza> plazas) {
		this.plazas = plazas;
	}



	public String getNombreGaraje() {
		return nombreGaraje;
	}

}
