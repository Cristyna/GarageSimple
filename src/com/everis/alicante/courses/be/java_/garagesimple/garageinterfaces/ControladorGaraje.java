package com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces;

import java.io.IOException;

public interface ControladorGaraje {
	
	void listarPlazasLibres();
	void listarPlazasOcupadas();
	boolean reservarPlaza() throws IOException;

}
