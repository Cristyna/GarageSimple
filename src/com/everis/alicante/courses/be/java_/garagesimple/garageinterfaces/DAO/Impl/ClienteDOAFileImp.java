package com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.Impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Cliente;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Plaza;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Reserva;
import com.everis.alicante.courses.be.java_.garagesimple.garage.GarageMainProfe;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.ClienteDAO;

public class ClienteDOAFileImp implements ClienteDAO {

	@Override
	public List<Cliente> readClientes() throws IOException {
		List<Cliente> clientes= new ArrayList<Cliente>();
		String linea;
		
		File file = new File("src/resources/Clientes.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer= new BufferedReader(reader);
		
		while ((linea=buffer.readLine())!=null) {
			
			if(!linea.contains("NIF")) {
				
				Cliente clienteTemp= new Cliente();
				
				String[] temp= linea.split(";");
				
				clienteTemp.setNif(temp[0]);
				clienteTemp.setNombreCompleto(temp[1]);
				//clienteTemp.getVehiculo().setMatricula(temp[2]);
							
						
				clientes.add(clienteTemp);
			}
					
	}
		reader.close();
		
		return clientes;
	}

	@Override
	public void createCliente(Cliente cliente) {
		// TODO Auto-generated method stub

	}

}
