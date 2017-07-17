package com.everis.alicante.courses.be.java_.garagesimple.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControladorGarajeConArrays implements ControladorGaraje {

	@Override
	public void listarPlazasLibres() {
		List<Plaza> plazaslibres= new ArrayList<Plaza>();
		
		Plaza[] plazas= GarageMainProfe.getGaraje().getPlazas();
		
		for (int i = 0; i < plazas.length; i++) {
			Plaza plaza = plazas[i];
			
			if(plaza.getLibre()) {
				plazaslibres.add(plaza);
			}
			
		}
		//listar por pantalla
		for (Plaza plaza : plazaslibres) {
			System.out.println(plaza);
		}
	}

	@Override
	public void listarPlazasOcupadas() {
List<Plaza> plazaslibres= new ArrayList<Plaza>();
		
		Plaza[] plazas= GarageMainProfe.getGaraje().getPlazas();
		
		for (int i = 0; i < plazas.length; i++) {
			Plaza plaza = plazas[i];
			
			if(!plaza.getLibre()) {
				listarPlazasOcupadas.add(plaza);
			}
			
		}
		//listar por pantalla
		for (Plaza plaza : listarPlazasOcupadas) {
			System.out.println(plaza);
		}
		
	}

	@Override
	public boolean reservarPlaza() {
		// logica de crear cliente
		Cliente cliente = new Cliente();

		// vamos a escribir por pantalla un menu para meter los datos del cliente
	
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
		Scanner in= new Scanner(System.in);
				
		switch (in.nextInt()) {
		case 1:
			vehiculo= new Coche();
			break;
		case 2:
			vehiculo= new Motocicleta();
			break;
		case 3:
			vehiculo= new Camion();
			break;

		default:
			break;
		}
		
		System.out.println("Introduce la matricula de tu vehiculo");
		Scanner in2=new Scanner (System.in);
		String matriculaIntroducida = in2.nextLine();
		vehiculo.setMatricula(matriculaIntroducida);
		
		System.out.println("Introduce la marca de tu vehiculo");
		Scanner in3=new Scanner (System.in);
		String marcaIntroducida = in3.nextLine();
		if (vehiculo instanceof Coche) {
			((Coche)(vehiculo)).setMarca(marcaIntroducida);//para utilizar los argumentos del hijo hay que castear
			}
						
		cliente.setVehiculo(vehiculo);
		in.close();
		// logica de si hay vacias
		boolean hayplaza = false;
		Garage garaje = GarageMainProfe.getGaraje();
		Plaza[] plazas = garaje.getPlazas();

		for (int i = 0; i < plazas.length; i++) {

			Plaza plaza = plazas[i];

			if (plaza.getLibre()&& vehiculo instanceof Aparcable) {
				plaza.setCliente(cliente);
				hayplaza = true;
				return hayplaza;
			}

		}
		return hayplaza;
	}
	// si hay plazas libres seteamos un cliente a la plaza que queramos

}
