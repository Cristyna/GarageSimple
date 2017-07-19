package com.everis.alicante.courses.be.java_.garagesimple.domain;

import java.util.List;
import java.util.Map;

public class Garage {
	
	//modelo de datos

	private List<Plaza> plazas;
	
	//Informacion auxiliar util
	
	private Map<String,Reserva> reservas;
	
	private Map<String,Cliente> vehiculos;
	
	private Map<String,Cliente> clientes;
	
	private String nombreGaraje;


	public Map<String, Reserva> getReservas() {
		return reservas;
	}



	public void setReservas(Map<String, Reserva> reservas) {
		this.reservas = reservas;
	}



	public Map<String, Cliente> getVehiculos() {
		return vehiculos;
	}



	public void setVehiculos(Map<String, Cliente> vehiculos) {
		this.vehiculos = vehiculos;
	}



	public Map<String, Cliente> getClientes() {
		return clientes;
	}



	public void setClientes(Map<String, Cliente> clientes) {
		this.clientes = clientes;
	}



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
