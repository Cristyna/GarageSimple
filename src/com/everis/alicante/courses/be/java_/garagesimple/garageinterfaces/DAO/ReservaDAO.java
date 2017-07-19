package com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Reserva;

public interface ReservaDAO {
	
	void createReserva(Reserva reserva) throws IOException;
	
	Map <String, Reserva> readReservas() throws IOException;

}
