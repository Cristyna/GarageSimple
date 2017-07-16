package com.everis.alicante.courses.be.java_.garagesimple.domain;

public class Vehiculo {
	protected String matricula;
	protected Cliente cliente;
	
	public Vehiculo (String matricula, Cliente cliente){
		this.matricula= matricula;
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	} 
	


}
