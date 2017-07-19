package com.everis.alicante.courses.be.java_.garagesimple.garage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Camion;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Cliente;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Coche;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Garage;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Motocicleta;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Plaza;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Reserva;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Vehiculo;
import com.everis.alicante.courses.be.java_.garagesimple.garage.GarageMainProfe;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.Aparcable;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.ControladorGaraje;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.ReservaDAO;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.Impl.ReservaDAOFileImp;

public class ControladorGarajeImp implements ControladorGaraje {

	@Override
	public void listarPlazasLibres() {

		List<Plaza> plazaslibres = new ArrayList<Plaza>();

		List<Plaza> plazas = GarageMainProfe.getGaraje().getPlazas();

		for (Plaza plaza : plazas) {

			if (plaza.getLibre()) {
				plazaslibres.add(plaza);
			}

		}
		// listar por pantalla

		for (Plaza plaza1 : plazaslibres) {
			System.out.println(plaza1);
		}
	}

	@Override
	public void listarPlazasOcupadas() {

		List<Plaza> plazasOcupadas = new ArrayList<Plaza>();

		List<Plaza> plazas = GarageMainProfe.getGaraje().getPlazas();

		for (Plaza plaza : plazas) {

			if (!plaza.getLibre()) {
				plazasOcupadas.add(plaza);
			}

		}
		// listar por pantalla

		for (Plaza plaza1 : plazasOcupadas) {
			System.out.println(plaza1);
		}

	}

	@Override
	public boolean reservarPlaza() throws IOException {
		// añadimos funcionalidad reserva y que lo guarde en el fichero
		ReservaDAO dao = new ReservaDAOFileImp();

		// logica de crear cliente
		Cliente cliente = new Cliente();

		// vamos a escribir por pantalla un menu para meter los datos del cliente
		// si hay plazas libres seteamos un cliente a la plaza que queramos

		System.out.println("Por favor introduce tus datos para reservar la plaza");

		System.out.println("Introduce tu nif");
		Scanner nifEntrada = new Scanner(System.in);
		String nif = nifEntrada.nextLine();
		cliente.setNif(nif);

		System.out.println("Introduce tu nombre completo");
		Scanner nombreEntrada = new Scanner(System.in);
		String nombre = nombreEntrada.nextLine();
		cliente.setNombreCompleto(nombre);

		Vehiculo vehiculo = null;

		System.out.println("Tipo de vehiculo del propietario");
		System.out.println("1:Coche");
		System.out.println("2:Moto");
		System.out.println("3:Camion");
		Scanner in = new Scanner(System.in);

		switch (in.nextInt()) {
		case 1:
			vehiculo = new Coche();
			break;
		case 2:
			vehiculo = new Motocicleta();
			break;
		case 3:
			vehiculo = new Camion();
			break;

		default:
			break;
		}

		System.out.println("Introduce la matricula de tu vehiculo");
		Scanner in2 = new Scanner(System.in);
		String matriculaIntroducida = in2.nextLine();
		vehiculo.setMatricula(matriculaIntroducida);

		System.out.println("Introduce la marca de tu vehiculo");
		Scanner in3 = new Scanner(System.in);
		String marcaIntroducida = in3.nextLine();
		if (vehiculo instanceof Coche) {
			((Coche) (vehiculo)).setMarca(marcaIntroducida);// para utilizar los argumentos del hijo hay que castear
		}

		cliente.setVehiculo(vehiculo);

		// logica de si hay vacias
		boolean hayplaza = false;

		Garage garaje = GarageMainProfe.getGaraje();

		List<Plaza> plazas = garaje.getPlazas();

		for (Plaza plaza : plazas) {

			if (plaza.getLibre() && vehiculo instanceof Aparcable) {
				plaza.setCliente(cliente);
				hayplaza = true;

				Reserva reserva = new Reserva();
				reserva.setCliente(cliente);
				reserva.setPlaza(plaza);
				reserva.setFechaReserva(Calendar.getInstance().getTime());
				reserva.setCodigoReserva("AUN NO PODEMOS");
				dao.createReserva(reserva);

				return hayplaza;

			}

		}
		return hayplaza;
	}

	public void listarClientes() {

		Map<String, Cliente> clientes = GarageMainProfe.getGaraje().getClientes();

		Collection<Cliente> collection = clientes.values();

		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			Cliente cliente = (Cliente) iterator.next();

			System.out.println(cliente.getNombreCompleto());

		}

		// System.out.println(clientes.keySet());

		// System.out.println("-----------------------------------------------------");

		// System.out.println(clientes.values());

		// System.out.println("-----------------------------------------------------");

		// clientes.values().contains("PEPE");

		// Cliente cliente= clientes.get("74011290G");

		// System.out.println(cliente);
	}

	@Override
	public void listarVehiculos() {
//		Map<String, Cliente> vehiculos = GarageMainProfe.getGaraje().getClientes().get(key);
//
//		Collection<Cliente> collection = clientes.values();

	}

	@Override
	public void listarReservas() throws IOException {
		ReservaDAO reservaDAO= new ReservaDAOFileImp();
		Map<String, Reserva> reservas = reservaDAO.readReservas();
		
		Collection<Reserva> listaReservas= reservas.values();
		
		for (Reserva reserva : listaReservas) {
			
			System.out.println("Numero de plaza reservada: "+ reserva.getPlaza().getNumeroPlaza());
			System.out.println("Cliente: "+ reserva.getCliente().getNombreCompleto());
			System.out.println("Vehiculo: "+ reserva.getCliente().getVehiculo().getMatricula()+"-"+reserva.getCliente().getVehiculo().getTipoVehiculo());
			
			
		}
	}


	

}
