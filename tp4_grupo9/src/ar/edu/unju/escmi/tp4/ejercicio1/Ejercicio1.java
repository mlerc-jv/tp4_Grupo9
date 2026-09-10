package ar.edu.unju.escmi.tp4.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {

		List<Jugador> jugadores = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n--- MENU JUGADORES ---");
			System.out.println("1 - Alta de jugador");
			System.out.println("2 - Modificar los datos de un jugador");
			System.out.println("3 - Eliminar un jugador");
			System.out.println("4 - Mostrar todos los jugadores");
			System.out.println("5 - Mostrar la cantidad de jugadores en la lista");
			System.out.println("6 - Limpiar toda la lista de jugadores");
			System.out.println("7 - Salir");
			System.out.print("Ingrese una opcion: ");
			opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {

			case 1:
				// Constructor por defecto + metodos set
				Jugador jugador = new Jugador();
				System.out.print("Ingrese dni: ");
				jugador.setDni(Integer.parseInt(sc.nextLine()));
				System.out.print("Ingrese nombre: ");
				jugador.setNombre(sc.nextLine());
				System.out.print("Ingrese equipo: ");
				jugador.setEquipo(sc.nextLine());
				System.out.print("Ingrese nacionalidad: ");
				jugador.setNacionalidad(sc.nextLine());
				System.out.print("Ingrese estatura: ");
				jugador.setEstatura(Double.parseDouble(sc.nextLine()));

				jugadores.add(jugador);
				System.out.println("Jugador agregado correctamente.");
				break;

			case 2:
				System.out.print("Ingrese el dni del jugador a modificar: ");
				int dniModificar = Integer.parseInt(sc.nextLine());
				Jugador encontrado = buscarPorDni(jugadores, dniModificar);

				if (encontrado != null) {
					System.out.println("Datos actuales: ");
					encontrado.mostrarDatos();

					System.out.println("Ingrese los nuevos datos (excepto el dni):");
					System.out.print("Nombre: ");
					encontrado.setNombre(sc.nextLine());
					System.out.print("Equipo: ");
					encontrado.setEquipo(sc.nextLine());
					System.out.print("Nacionalidad: ");
					encontrado.setNacionalidad(sc.nextLine());
					System.out.print("Estatura: ");
					encontrado.setEstatura(Double.parseDouble(sc.nextLine()));

					System.out.println("Jugador modificado correctamente.");
				} else {
					System.out.println("No se encuentra el dni");
				}
				break;

			case 3:
				System.out.print("Ingrese el dni del jugador a eliminar: ");
				int dniEliminar = Integer.parseInt(sc.nextLine());
				Jugador aEliminar = buscarPorDni(jugadores, dniEliminar);

				if (aEliminar != null) {
					jugadores.remove(aEliminar);
					System.out.println("Jugador eliminado correctamente.");
				} else {
					System.out.println("No se encuentra el dni");
				}
				break;

			case 4:
				if (jugadores.isEmpty()) {
					System.out.println("No hay jugadores cargados.");
				} else {
					for (Jugador j : jugadores) {
						j.mostrarDatos();
					}
				}
				break;

			case 5:
				System.out.println("Cantidad de jugadores: " + jugadores.size());
				break;

			case 6:
				jugadores.clear();
				System.out.println("Lista de jugadores vaciada.");
				break;

			case 7:
				System.out.println("Saliendo...");
				break;

			default:
				System.out.println("Opcion invalida.");
			}

		} while (opcion != 7);

		sc.close();
	}

	// Metodo auxiliar para buscar un jugador por dni dentro del ArrayList
	private static Jugador buscarPorDni(List<Jugador> jugadores, int dni) {
		for (Jugador j : jugadores) {
			if (j.getDni() == dni) {
				return j;
			}
		}
		return null;
	}
}
