package com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO;

import java.io.IOException;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Reserva;

public interface ReservaDAO {
	
	void saveReserva(Reserva reserva) throws IOException;

}
