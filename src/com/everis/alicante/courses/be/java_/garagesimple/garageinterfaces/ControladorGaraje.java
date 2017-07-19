package com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces;

import java.io.IOException;
import java.util.List;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Reserva;

public interface ControladorGaraje {
	
	void listarPlazasLibres();
	void listarPlazasOcupadas();
	boolean reservarPlaza() throws IOException;
	void listarClientes();
	void listarVehiculos();
	void listarReservas() throws IOException;
	 

}
