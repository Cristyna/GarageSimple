package com.everis.alicante.courses.be.java_.garagesimple.garage;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Garage;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Plaza;
import com.everis.alicante.courses.be.java_.garagesimple.garage.controller.ControladorGarajeConArrays;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.ControladorGaraje;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.PlazaDAO;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.Impl.PlazaDAOFileImp;

public class GarageMainProfe {

	// public static ArrayList<Cliente> clientes = new ArrayList<>();
	//
	// public static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
	//
	// public static ArrayList<Plaza> plazas = new ArrayList<>();

	static Garage garaje;

	public static Garage getGaraje() {
		return garaje;
	}

	static ControladorGaraje controlador;

	public static void main(String[] args) throws IOException {
		// inicializar los componentes de la aplicación
		inicializarComponentes();

		// System.out.println(clientes.toString()+"\n");
		// System.out.println(vehiculos.toString()+"\n");
		// System.out.println(garaje.toString()+"\n");

		// iniciar la aplicacion o listar menu

		iniciarAplicacion();

	}

	private static void iniciarAplicacion() throws IOException {
		System.out.println("Bienvenido a nuestro garaje, seleccione una opción: ");
		System.out.println("1: Listar Plazas garaje libres");
		System.out.println("2: Listar Plazas garaje ocupadas");
		System.out.println("3: Reservar plazas");
	
		Scanner in = new Scanner(System.in);
		Integer opcion = in.nextInt();
		Boolean resultado = true;

		System.out.println("Ha elegido la opción: " + opcion);
		switch (opcion) {
		case 1:
			controlador.listarPlazasLibres();

			break;
		case 2:
			controlador.listarPlazasOcupadas();

			break;
		case 3:
			resultado = controlador.reservarPlaza();
			break;
		
		default:
			System.out.println("Error");
			break;
		}
		// logica de si habia plaza o no

		if (opcion == 3 && resultado) {
			System.out.println("Se ha reservado su plaza");
		} else if (opcion == 3) {
			System.out.println("No hay plazas disponibles");
		}

		iniciarAplicacion();
	}

	public static void inicializarComponentes() throws IOException {

		// 30 plazas de garaje puesto a ficheros ya
		garaje = new Garage();
		
		PlazaDAO plazaDao= new PlazaDAOFileImp();
		
		//Plaza[] plazas= plazaDao.readPlazas();
		
		List<Plaza>plazasTemp=plazaDao.readPlazas();
		
		garaje.setPlazas(plazasTemp);
		
		controlador=new ControladorGarajeConArrays();
				
		
	}

}
