package com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO;

import java.io.IOException;
import java.util.List;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Cliente;

public interface ClienteDAO {

	List <Cliente> readClientes() throws IOException;
	
	void createCliente (Cliente cliente);
}