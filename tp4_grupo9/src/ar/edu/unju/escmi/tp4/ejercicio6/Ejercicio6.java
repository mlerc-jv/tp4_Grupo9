package ar.edu.unju.escmi.tp4.ejercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Libro> libros = new ArrayList<Libro>();

		int opcion;

		do {
			System.out.println("\n1 - Alta de Libro");
			System.out.println("2 - Mostrar libros");
			System.out.println("3 - Buscar y mostrar un libro");
			System.out.println("4 - Ordenar libros");
			System.out.println("5 - Modificar datos de un libro");
			System.out.println("6 - Eliminar un libro");
			System.out.println("7 - Salir");
			System.out.println("Ingrese una opcion:");

			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {

			case 1:
				Libro libro = new Libro();

				System.out.println("Ingrese ISBN:");
				libro.setIsbn(sc.nextLine());

				System.out.println("Ingrese titulo:");
				libro.setTitulo(sc.nextLine());

				System.out.println("Ingrese cantidad de paginas:");
				libro.setCantidadPaginas(sc.nextInt());
				sc.nextLine();

				System.out.println("Ingrese autor:");
				libro.setAutor(sc.nextLine());

				libros.add(libro);

				System.out.println("Libro creado correctamente");
				break;

			case 2:
				for (int i = 0; i < libros.size(); i++) {
					System.out.println("----------------------");
					libros.get(i).mostrarDatos();
				}
				break;

			case 3:
				System.out.println("Ingrese ISBN del libro:");
				String isbnBuscar = sc.nextLine();

				boolean encontrado = false;

				for (int i = 0; i < libros.size(); i++) {
					if (libros.get(i).getIsbn().equals(isbnBuscar)) {
						libros.get(i).mostrarDatos();
						encontrado = true;
					}
				}

				if (!encontrado) {
					System.out.println("libro no encontrado");
				}
				break;

			case 4:
				Collections.sort(libros);
				System.out.println("Libros ordenados por titulo");
				break;

			case 5:
				System.out.println("Ingrese ISBN del libro:");
				String isbnModificar = sc.nextLine();

				boolean encontradoModificar = false;

				for (int i = 0; i < libros.size(); i++) {
					if (libros.get(i).getIsbn().equals(isbnModificar)) {

						libros.get(i).mostrarDatos();

						System.out.println("Ingrese nuevo titulo:");
						libros.get(i).setTitulo(sc.nextLine());

						System.out.println("Ingrese nueva cantidad de paginas:");
						libros.get(i).setCantidadPaginas(sc.nextInt());
						sc.nextLine();

						System.out.println("Ingrese nuevo autor:");
						libros.get(i).setAutor(sc.nextLine());

						encontradoModificar = true;
						System.out.println("Datos modificados correctamente");
					}
				}

				if (!encontradoModificar) {
					System.out.println("libro no encontrado");
				}
				break;

			case 6:
				System.out.println("Ingrese ISBN del libro:");
				String isbnEliminar = sc.nextLine();

				boolean encontradoEliminar = false;

				for (int i = 0; i < libros.size(); i++) {
					if (libros.get(i).getIsbn().equals(isbnEliminar)) {
						libros.remove(i);
						encontradoEliminar = true;
						System.out.println("Libro eliminado correctamente");
						break;
					}
				}

				if (!encontradoEliminar) {
					System.out.println("libro no encontrado");
				}
				break;

			case 7:
				System.out.println("Fin del programa");
				break;

			default:
				System.out.println("Opcion incorrecta");
			}

		} while (opcion != 7);

		sc.close();
	}
}
