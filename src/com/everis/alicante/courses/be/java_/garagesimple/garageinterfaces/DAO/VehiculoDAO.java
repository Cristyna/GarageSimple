package com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Vehiculo;

public interface VehiculoDAO {
	
	Map <String,Vehiculo> readVehiculo() throws IOException;
	
	void createVehiculo();

}
