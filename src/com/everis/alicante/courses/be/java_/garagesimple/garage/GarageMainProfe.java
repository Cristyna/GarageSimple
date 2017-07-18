package com.everis.alicante.courses.be.java_.garagesimple.garage;

import java.util.Scanner;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Garage;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Plaza;
import com.everis.alicante.courses.be.java_.garagesimple.garage.controller.ControladorGarajeConArrays;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.ControladorGaraje;

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

	public static void main(String[] args) {
		// inicializar los componentes de la aplicación
		inicializarComponentes();

		// System.out.println(clientes.toString()+"\n");
		// System.out.println(vehiculos.toString()+"\n");
		// System.out.println(garaje.toString()+"\n");

		// iniciar la aplicacion o listar menu

		iniciarAplicacion();

	}

	private static void iniciarAplicacion() {
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

	public static void inicializarComponentes() {

		// 30 plazas de garaje
		garaje = new Garage();
		Plaza[] plazas = new Plaza[30];
		for (int i = 0; i < plazas.length; i++) {
			Plaza plazaTemp = new Plaza();
			plazaTemp.setNumeroPlaza(i + 1);
			if (i < 10) {
				plazaTemp.setPrecio(50);

			} else if (i < 20) {
				plazaTemp.setPrecio(75);

			} else {
				plazaTemp.setPrecio(100);
			}
			plazas[i] = plazaTemp;
		}

		garaje.setPlazas(plazas);
		controlador = new ControladorGarajeConArrays();

		// //4 clientes
		// clientes.add(new Cliente("74011290G","Shassa Miau Miau"));
		// clientes.add(new Cliente("48521478K","Troklos Miau Miau"));
		// clientes.add(new Cliente("78917895S","Rosita Miau Miau"));
		// clientes.add(new Cliente("12345678F","Pirata Miau Miau"));
		//
		//
		// //5 vehiculos
		// vehiculos.add(new Coche("SEAT", "5719BKJ", clientes.get(2)));
		// vehiculos.add(new Coche("Jaguar", "4952GHR", clientes.get(0)));
		// vehiculos.add(new Motocicleta("Triumph", "8621OKG", clientes.get(0)));
		// vehiculos.add(new Motocicleta("Suzuki", "1287HYR", clientes.get(3)));
		// vehiculos.add(new Camion("Pegaso", "5697ESU", clientes.get(1)));

	}

}
