package com.everis.alicante.courses.be.java_.garagesimple.domain;

public class Garage {

	/*
	 * private ArrayList<Plaza> plazas;
	 * 
	 * public Garage(ArrayList<Plaza> plazas) { this.plazas = plazas; }
	 * 
	 * public ArrayList<Plaza> getPlazas() { return plazas; }
	 * 
	 * public void setPlazas(ArrayList<Plaza> plazas) { this.plazas = plazas; }
	 * 
	 * @Override public String toString() { return "Garage [plazas=" + plazas + "]";
	 * }
	 */
	private Plaza[] plazas;
	private String nombreGaraje;

	public Plaza[] getPlazas() {
		return plazas;
	}

	public void setPlazas(Plaza[] plazas) {
		this.plazas = plazas;
	}

	public String getNombreGaraje() {
		return nombreGaraje;
	}

}
