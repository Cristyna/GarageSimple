package com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO;

import java.io.IOException;
import java.util.Map;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Reserva;

public interface ReservaDAO {

	Map<String, Reserva> readReservas() throws IOException;

	void createReserva(Reserva reserva) throws IOException;

}
