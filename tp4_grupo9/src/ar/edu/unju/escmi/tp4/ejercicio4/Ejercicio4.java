package ar.edu.unju.escmi.tp4.ejercicio4;

import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		HashSet<Cliente> clientes = new HashSet<>();

		int opcion;

		do {
			System.out.println("1 - Crear cliente");
			System.out.println("2 - Mostrar los datos de un cliente");
			System.out.println("3 - Mostrar todos los clientes");
			System.out.println("4 - Mostrar todos los clientes ocasionales y la cantidad");
			System.out.println("5 - Mostrar todos los clientes frecuentes y la cantidad");
			System.out.println("6 - Salir");
			System.out.print("Ingrese una opción: ");

			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {

			case 1:
				System.out.print("Ingrese el DNI: ");
				int dni = scanner.nextInt();
				scanner.nextLine();

				System.out.print("Ingrese el nombre: ");
				String nombre = scanner.nextLine();

				System.out.print("Ingrese el tipo de cliente (ocasional o frecuente): ");
				String tipoCliente = scanner.nextLine();

				Cliente cliente = new Cliente(dni, nombre, tipoCliente);
				clientes.add(cliente);
				break;

			case 2:
				clientes.stream().forEach(System.out::println);
				break;

			case 3:
				System.out.print("Ingrese el DNI del cliente: ");
				int dniBuscar = scanner.nextInt();
				scanner.nextLine();

				long cantidadEncontrados = clientes.stream()
						.filter(c -> c.getDni() == dniBuscar)
						.count();

				if (cantidadEncontrados == 0) {
					System.out.println("No se encontró el dni");
				} else {
					clientes.stream()
							.filter(c -> c.getDni() == dniBuscar)
							.forEach(System.out::println);
				}
				break;

			case 4:
				clientes.stream()
						.filter(c -> c.getTipoCliente().equalsIgnoreCase("ocasional"))
						.forEach(System.out::println);

				long cantidadOcasionales = clientes.stream()
						.filter(c -> c.getTipoCliente().equalsIgnoreCase("ocasional"))
						.count();

				System.out.println("Cantidad de clientes ocasionales: " + cantidadOcasionales);
				break;

			case 5:
				clientes.stream()
						.filter(c -> c.getTipoCliente().equalsIgnoreCase("frecuente"))
						.forEach(System.out::println);

				long cantidadFrecuentes = clientes.stream()
						.filter(c -> c.getTipoCliente().equalsIgnoreCase("frecuente"))
						.count();

				System.out.println("Cantidad de clientes frecuentes: " + cantidadFrecuentes);
				break;

			case 6:
				System.out.println("Fin del programa");
				break;

			default:
				System.out.println("Opción incorrecta");
			}

		} while (opcion != 6);

		scanner.close();
	}

	
}