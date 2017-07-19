package com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.Impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Plaza;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Reserva;
import com.everis.alicante.courses.be.java_.garagesimple.garage.GarageMainProfe;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.ReservaDAO;

public class ReservaDAOFileImp implements ReservaDAO {

	@Override
	public void createReserva(Reserva reserva) throws IOException {
		
		
		File file = new File("src/resources/Reservas.txt");
		FileWriter writer = new FileWriter(file,true);
		BufferedWriter buffer= new BufferedWriter(writer);
		
		buffer.newLine();
		
		buffer.write(reserva.convierteAFormatoTxt());
				
		
		buffer.close();
	}

	@Override
	public Map<String,Reserva> readReservas() throws IOException {
		
		Map<String,Reserva> reservas= new TreeMap<String,Reserva>();
		
		String linea;
		
		File file = new File("src/resources/Reservas.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer= new BufferedReader(reader);
		
		while ((linea=buffer.readLine())!=null) {
			
			if(!linea.contains("CODIGO_RESERVA")) {
				
				Reserva reserva= new Reserva();
				
				String[] temp= linea.split(";");
				
				reserva.setCodigoReserva(temp[0]);
				
				Plaza plaza=GarageMainProfe.getGaraje().getPlazas().get(Integer.parseInt(temp[1]));
				
				reserva.setPlaza(plaza);
				
				reserva.setCliente(GarageMainProfe.getGaraje().getClientes().get(temp[2]));
				
				reserva.getCliente().setVehiculo(GarageMainProfe.getGaraje().getVehiculos().get(temp[3]));
				
				reservas.put(reserva.getCodigoReserva(), reserva);
			}
					
	}
		reader.close();
		
		return reservas;
	
}
	}
