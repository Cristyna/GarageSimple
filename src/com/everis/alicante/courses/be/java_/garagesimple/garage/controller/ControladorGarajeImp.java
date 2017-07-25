package com.everis.alicante.courses.be.java_.garagesimple.garage.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.everis.alicante.courses.be.java_.garagesimple.domain.Camion;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Cliente;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Coche;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Motocicleta;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Plaza;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Reserva;
import com.everis.alicante.courses.be.java_.garagesimple.domain.Vehiculo;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.Aparcable;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.ControladorGaraje;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.ClienteDAO;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.PlazaDAO;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.ReservaDAO;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.VehiculoDAO;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.Impl.ClienteDAOFileImp;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.Impl.PlazaDAOFileImp;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.Impl.ReservaDAOFileImp;
import com.everis.alicante.courses.be.java_.garagesimple.garageinterfaces.DAO.Impl.VehiculoDAOFileImp;
import com.everis.alicante.courses.be.java_.garagesimple.utils.ValidadorNIF;

public class ControladorGarajeImp implements ControladorGaraje {

	@Override
	public Map<Integer, Plaza> listarPlazasLibres() throws IOException, ParseException {

		PlazaDAO plazaDao = new PlazaDAOFileImp();

		Map<Integer, Plaza> plazasTotales = plazaDao.readPlazas();

		ReservaDAO reservaDAO = new ReservaDAOFileImp();

		Collection<Reserva> reservas = reservaDAO.readReservas().values();

		for (Reserva reserva : reservas) {

			plazasTotales.remove(Integer.parseInt(reserva.getCodigoReserva()));

		}

		return plazasTotales;

	}

	@Override
	public void listarPlazasOcupadas() throws IOException, ParseException {

		ReservaDAO reservaDAO = new ReservaDAOFileImp();

		Collection<Reserva> reservas = reservaDAO.readReservas().values();

		System.out.println("PLAZAS OCUPADAS");

		for (Reserva reserva : reservas) {

			System.out.println("La plaza nuemeo: " + reserva.getCodigoReserva() + " esta reservada");

		}

	}

	@Override
	public boolean reservarPlaza() throws IOException, ParseException {

		// logica de crear cliente
		Cliente cliente = new Cliente();

		// añadimos funcionalidad reserva y que lo guarde en el fichero
		ReservaDAO daoReserva = new ReservaDAOFileImp();
		ClienteDAO daoCliente = new ClienteDAOFileImp();
		VehiculoDAO daoVehiculo = new VehiculoDAOFileImp();

		// vamos a escribir por pantalla un menu para meter los datos del cliente
		// si hay plazas libres seteamos un cliente a la plaza que queramos

		System.out.println("Por favor introduce tus datos para reservar la plaza");

		boolean nifCorrecto = false;
		String nif = "";

		while (!nifCorrecto) {

			System.out.println("Inserte el nif del cliente");
			Scanner in = new Scanner(System.in);
			nif = in.nextLine();
			nifCorrecto = ValidadorNIF.validaNif(nif);
			if (nifCorrecto == false) {
				System.out.println("NIF INCORRECTO");
			}
		}
		cliente.setNif(nif);

		System.out.println("Introduce tu nombre completo");
		Scanner nombreEntrada = new Scanner(System.in);
		String nombre = nombreEntrada.nextLine();
		cliente.setNombreCompleto(nombre);

		Vehiculo vehiculo = null;

		System.out.println("Tipo de vehiculo del propietario");
		System.out.println("1:Coche");
		System.out.println("2:Motocicleta");
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
		vehiculo.setTipoVehiculo(vehiculo.getClass().getSimpleName());

		// if (vehiculo instanceof Coche) {
		// vehiculo.setTipoVehiculo("Coche");
		// }//otra forma de escribir lo mismo que tomamos por reflexion

		// System.out.println("Introduce la marca de tu vehiculo");
		// Scanner in3 = new Scanner(System.in);
		// String marcaIntroducida = in3.nextLine();
		// if (vehiculo instanceof Coche) {
		// ((Coche) (vehiculo)).setMarca(marcaIntroducida);// para utilizar los
		// argumentos del hijo hay que castear
		// }

		cliente.setVehiculo(vehiculo);

		// logica de si hay plazas vacias

		boolean hayplaza = false;

		Map<Integer, Plaza> plazas = listarPlazasLibres();

		for (Plaza plaza : plazas.values()) {

			if (vehiculo instanceof Aparcable) {

				hayplaza = true;

				Reserva reserva = new Reserva();
				reserva.setCliente(cliente);
				reserva.setPlaza(plaza);
				reserva.setFechaReserva(Calendar.getInstance().getTime());
				reserva.setCodigoReserva(String.valueOf(plaza.getNumeroPlaza()));

				daoReserva.createReserva(reserva);

				daoCliente.createCliente(cliente);

				daoVehiculo.createVehiculo(vehiculo);

				return hayplaza;
			}
		}

		return hayplaza;

	}

	public void listarClientes() throws IOException {

		ClienteDAO daoCliente = new ClienteDAOFileImp();
		// VehiculoDAO daoVehiculo= new VehiculoDAOFileImp();

		Map<String, Cliente> clientes = daoCliente.readClientes();

		Collection<Cliente> collection = clientes.values();

		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			Cliente cliente = (Cliente) iterator.next();

			System.out.println(cliente.getNombreCompleto() + ";" + cliente.getNif());

			// para que me de tambien la matricula y el tipo de vehiculo

		}

	}

	@Override
	public void listarReservas() throws IOException, ParseException {

		ReservaDAO reservaDAO = new ReservaDAOFileImp();

		Map<String, Reserva> reservas = reservaDAO.readReservas();

		Collection<Reserva> listaReservas = reservas.values();

		for (Reserva reserva : listaReservas) {

			System.out.println("Numero de plaza reservada: " + reserva.getPlaza().getNumeroPlaza());
			System.out.println("Cliente: " + reserva.getCliente().getNombreCompleto());
			System.out.println("Vehiculo: " + reserva.getCliente().getVehiculo().getMatricula() + "-"
					+ reserva.getCliente().getVehiculo().getTipoVehiculo());

		}

	}

	@Override
	public void listarVehiculos() throws IOException {

		VehiculoDAO daoVehiculo = new VehiculoDAOFileImp();

		Collection<Vehiculo> vehiculos = daoVehiculo.readVehiculos().values();

		for (Vehiculo vehiculo : vehiculos) {

			System.out.println(vehiculo.getMatricula() + "-" + vehiculo.getTipoVehiculo());

		}

	}

	@Override
	public void listarReservasByFecha(Date fechaInicio, Date fechaFin) throws IOException, ParseException {

		ReservaDAO reservaDAO = new ReservaDAOFileImp();

		Map<String, Reserva> reservas = reservaDAO.readReservas();

		for (Reserva reserva : reservas.values()) {

			if (reserva.getFechaReserva().before(fechaFin) &&

					reserva.getFechaReserva().after(fechaInicio)) {

				System.out.println("Reserva: " + reserva);

			}

		}

	}
}
