package com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO;

import java.io.IOException;
import java.util.Map;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Plaza;

public interface PlazaDAO {

	Map<Integer, Plaza> readPlazas() throws IOException;

	void createPlaza(Plaza plaza);

	Plaza readPlaza(int numeroPlaza) throws IOException;

	void deletePlaza(int numeroPlaza);

	// Falta el update, que de momento no lo vamos a hacer de momento
}
