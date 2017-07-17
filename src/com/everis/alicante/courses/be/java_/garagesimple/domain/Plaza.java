package com.everis.alicante.courses.be.java_.garagesimple.domain;

public class Plaza {
	
	private Cliente cliente;
	private double precio;
	private int numeroPlaza;
	

//	public Plaza(double precio) {
//		this.precio = precio;
//	}

	public Boolean getLibre() {
		if(cliente==null) {
			return true;
		}
		else {
			return false;
		}
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	@Override
	public String toString() {
		return "Plaza [cliente=" + cliente + ", precio=" + precio + ", numeroPlaza=" + numeroPlaza + "]";
	}


	

	public int getNumeroPlaza() {
		return numeroPlaza;
	}

	public void setNumeroPlaza(int numeroPlaza) {
		this.numeroPlaza = numeroPlaza;
	}
	
	public boolean estaLibre() {
		if(cliente==null) {
			return true;
		}
		else {
			return false;
		}
	}

}
