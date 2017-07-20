package com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO;

import java.io.IOException;
import java.util.Map;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Vehiculo;

public interface VehiculoDAO {

	Map<String, Vehiculo> readVehiculos() throws IOException;

	void createVehiculo(Vehiculo vehiculo) throws IOException;

	Vehiculo readVehiculo(String matricula) throws IOException;

	void deleteVehiculo(String matricula) throws IOException;

}
