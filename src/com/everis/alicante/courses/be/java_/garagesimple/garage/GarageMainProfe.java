package com.everis.alicante.courses.be.java_.garagesimple.garage;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Garage;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Plaza;
import com.everis.alicante.courses.be.java_.garagesimple.garage.controller.ControladorGarajeImp;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.ControladorGaraje;

public class GarageMainProfe {

	static Garage garaje;

	static ControladorGaraje controlador;
	// declaracion de las fechas como atributos estáticos de la clase:
	static Date fechaInicio = null;
	static Date fechaFin = null;

	public static void main(String[] args) throws IOException, ParseException {
		// inicializar los componentes de la aplicación
		inicializarComponentes();

		// iniciar la aplicacion o listar menu

		iniciarAplicacion();

	}

	private static void iniciarAplicacion() throws IOException, ParseException {
		System.out.println("*********************************************************");

		System.out.println("Bienvenido a nuestro garaje, seleccione una opción: ");
		System.out.println("1: Listar Plazas garaje libres");
		System.out.println("2: Listar Plazas garaje ocupadas");
		System.out.println("3: Reservar plazas");
		System.out.println("4: Listar clientes");
		System.out.println("5: Listar reservas");
		System.out.println("6: Listar vehiculos");
		System.out.println("7: Listar por fecha de reserva");

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		Integer opcion = in.nextInt();
		Boolean resultado = true;
		Map<Integer, Plaza> mapa = null;

		System.out.println("Ha elegido la opción: " + opcion);
		
		try {
			
		switch (opcion) {
		case 1:
			mapa = controlador.listarPlazasLibres();
			break;
		case 2:
			controlador.listarPlazasOcupadas();
			break;
		case 3:
			resultado = controlador.reservarPlaza();
			break;
		case 4:
			controlador.listarClientes();
			break;
		case 5:
			controlador.listarReservas();
			break;
		case 6:
			controlador.listarVehiculos();
			break;
		case 7:
			validarFechasEntrada();
			controlador.listarReservasByFecha(fechaInicio, fechaFin);
			break;
		default:
			System.out.println("Error");
			break;
		}

		if (opcion == 1) {

			for (Iterator<Plaza> iterator = mapa.values().iterator(); iterator.hasNext();) {

				Plaza plaza = (Plaza) iterator.next();

				System.out.println("Plaza libre numero: " + plaza.getNumeroPlaza());

			}
		}

		if (opcion == 3 && resultado) {
			System.out.println("Se ha reservado su plaza");
		} else if (opcion == 3) {
			System.out.println("No hay plazas disponibles");
		}

		iniciarAplicacion();
		
		} catch (Exception e) {
			
		}

	}

	public static void inicializarComponentes() throws IOException {

		garaje = new Garage();
		controlador = new ControladorGarajeImp();

		// como ya podemos leer de los ficheros ya no necesitamos que la aplicacion lo
		// guarde en memoria

		// PlazaDAO plazaDAO= new PlazaDAOFileImp();
		// ReservaDAO reservaDAO= new ReservaDAOFileImp();
		// ClienteDAO clienteDAO = new ClienteDAOFileImp();
		// VehiculoDAO vehiculoDAO= new VehiculoDAOFileImp();

		// garaje.setPlazas(plazaDAO.readPlazas());
		//
		// garaje.setClientes(clienteDAO.readClientes());
		//
		// garaje.setVehiculos(vehiculoDAO.readVehiculo());
		//
		// garaje.setReservas(reservaDAO.readReservas());

	}

	public static void validarFechasEntrada() {

SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
		
		if(fechaInicio==null){
		
			System.out.println("Introduce la fecha de Inicio para la busqueda en formato dd/MM/yyyy: ");
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			String tmp=in.nextLine();		
			
			try {			
				fechaInicio=formatter.parse(tmp);	
				
				System.out.println("Introduce la fecha de Fin para la busqueda en formato dd/MM/yyyy: ");
				in = new Scanner(System.in);
				tmp=in.nextLine();
				
				fechaFin=formatter.parse(tmp);
				
			} catch (Exception e) {
				
				System.out.println("La fecha introducida es incorrecta");
				validarFechasEntrada();
			}
		}
		else if(fechaFin==null){
			
			System.out.println("Introduce la fecha de Fin para la busqueda en formato dd/MM/yyyy: ");
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			String tmp = in.nextLine();
			
			try {
				
				fechaFin=formatter.parse(tmp);
				
			} catch (ParseException e) {	
				
				System.out.println("La fecha introducida es incorrecta");
				validarFechasEntrada();
			}

		}

	}

}
