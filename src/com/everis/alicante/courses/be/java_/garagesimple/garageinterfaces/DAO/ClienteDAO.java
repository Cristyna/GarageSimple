package com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO;

import java.io.IOException;
import java.util.Map;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Cliente;

public interface ClienteDAO {

	 Map<String,Cliente> readClientes() throws IOException;
	 
	 void createCliente(Cliente cliente) throws IOException;
	 
	 Cliente readCliente(String nif) throws IOException;
	 
	 void deleteCliente(String nif);
}
