package com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO;

import java.io.IOException;
import java.util.List;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Reserva;

public interface ReservaDAO {
	
	void createReserva(Reserva reserva) throws IOException;
	
	List<Reserva> readReservas() throws IOException;

}
