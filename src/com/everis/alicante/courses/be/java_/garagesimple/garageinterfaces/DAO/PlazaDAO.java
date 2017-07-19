package com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO;


import java.io.IOException;
import java.util.List;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Plaza;

public interface PlazaDAO {
	
	List<Plaza>  readPlazas() throws IOException;

	void createPlaza(List<Plaza> plazas);
}
