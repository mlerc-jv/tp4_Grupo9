
package ar.edu.unju.escmi.tp4.ejercicio2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {

		Map<String, Empleado> empleados = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("\n--- MENU EMPLEADOS ---");
			System.out.println("1 - Alta de empleado");
			System.out.println("2 - Mostrar empleados");
			System.out.println("3 - Eliminar empleado");
			System.out.println("4 - Consultar los datos de un empleado");
			System.out.println("5 - Salir");
			System.out.print("Ingrese una opcion: ");
			opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {

			case 1:
				System.out.print("Ingrese dni: ");
				int dni = Integer.parseInt(sc.nextLine());
				System.out.print("Ingrese nombre: ");
				String nombre = sc.nextLine();
				System.out.print("Ingrese apellido: ");
				String apellido = sc.nextLine();
				System.out.print("Ingrese sueldo: ");
				double sueldo = Double.parseDouble(sc.nextLine());
				System.out.print("Ingrese categoria: ");
				char categoria = sc.nextLine().charAt(0);

				Empleado empleado = new Empleado(dni, nombre, apellido, sueldo, categoria);

				// La clave se arma con el dni + la categoria
				String clave = dni + "" + categoria;

				if (empleados.containsKey(clave)) {
					System.out.println("Ya existe un empleado con esa clave.");
				} else {
					empleados.put(clave, empleado);
					System.out.println("Empleado agregado con clave: " + clave);
				}
				break;

			case 2:
				if (empleados.isEmpty()) {
					System.out.println("No hay empleados cargados.");
				} else {
					Iterator<Map.Entry<String, Empleado>> it = empleados.entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry<String, Empleado> entry = it.next();
						System.out.println("Clave: " + entry.getKey() + " -> " + entry.getValue());
					}
				}
				break;

			case 3:
				System.out.print("Ingrese la clave del empleado a eliminar: ");
				String claveEliminar = sc.nextLine();
				if (empleados.containsKey(claveEliminar)) {
					empleados.remove(claveEliminar);
					System.out.println("Empleado eliminado correctamente.");
				} else {
					System.out.println("No se encuentra la clave.");
				}
				break;

			case 4:
				System.out.print("Ingrese la clave del empleado a consultar: ");
				String claveConsulta = sc.nextLine();
				if (empleados.containsKey(claveConsulta)) {
					Empleado emp = empleados.get(claveConsulta);
					System.out.println("Datos del empleado: " + emp);
				} else {
					System.out.println("No se encuentra la clave.");
				}
				break;

			case 5:
				System.out.println("Saliendo...");
				break;

			default:
				System.out.println("Opcion invalida.");
			}

		} while (opcion != 5);

		sc.close();
	}
}

