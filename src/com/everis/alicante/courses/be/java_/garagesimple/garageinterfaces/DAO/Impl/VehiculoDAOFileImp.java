package com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.Impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Plaza;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Reserva;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Vehiculo;
import com.everis.alicante.courses.be.java_.garagesimple.garage.GarageMainProfe;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.VehiculoDAO;

public class VehiculoDAOFileImp implements VehiculoDAO {

	@Override
	public List<Vehiculo> readVehiculo() throws IOException {
		List<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
		String linea;
		
		File file = new File("src/resources/Reservas.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer= new BufferedReader(reader);
		
		while ((linea=buffer.readLine())!=null) {
			
			if(!linea.contains("MATRICULA")) {
				
				Vehiculo vehiculo= new Vehiculo();
				
				String[] temp= linea.split(";");
				
				vehiculo.setMatricula((temp[0]));
				
				vehiculo.setTipoVehiculo(temp[1]);
				
								
				vehiculos.add(vehiculo);
			}
					
	}
		reader.close();
		
		return vehiculos;
	
	}

	@Override
	public void createVehiculo() {
		// TODO Auto-generated method stub

	}

}
