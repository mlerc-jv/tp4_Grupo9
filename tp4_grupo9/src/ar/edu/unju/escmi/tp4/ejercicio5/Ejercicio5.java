package ar.edu.unju.escmi.tp4.ejercicio5;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		TreeMap<Integer, Producto> productos = new TreeMap<>();

		int opcion;

		do {
			System.out.println("1 - Alta de producto.");
			System.out.println("2 - Mostrar productos.");
			System.out.println("3 - Buscar un producto.");
			System.out.println("4 - Eliminar un producto.");
			System.out.println("5 - Salir.");
			System.out.print("Ingrese una opción: ");

			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				System.out.print("Ingrese la clave del producto: ");
				Integer clave = scanner.nextInt();
				scanner.nextLine();

				if (productos.containsKey(clave)) {
					System.out.println("La clave ya existe.");
				} else {
					Producto producto = new Producto();

					System.out.print("Ingrese la descripción: ");
					producto.setDescripcion(scanner.nextLine());

					System.out.print("Ingrese el precio: ");
					producto.setPrecio(scanner.nextDouble());
					scanner.nextLine();

					System.out.print("Ingrese el año de vencimiento: ");
					int anio = scanner.nextInt();

					System.out.print("Ingrese el mes de vencimiento: ");
					int mes = scanner.nextInt();

					System.out.print("Ingrese el día de vencimiento: ");
					int dia = scanner.nextInt();
					scanner.nextLine();

					producto.setFechaVencimiento(LocalDate.of(anio, mes, dia));

					productos.put(clave, producto);

					System.out.println("Producto agregado.");
				}
				break;

			case 2:
				Iterator<Integer> iterator = productos.keySet().iterator();

				while (iterator.hasNext()) {
					Integer claveProducto = iterator.next();

					System.out.println("Clave: " + claveProducto + " - Valor: " + productos.get(claveProducto));
				}
				break;

			case 3:
				System.out.print("Ingrese la clave del producto: ");
				Integer claveBuscar = scanner.nextInt();
				scanner.nextLine();

				if (productos.containsKey(claveBuscar)) {
					System.out.println("Clave: " + claveBuscar + " - Valor: " + productos.get(claveBuscar));
				}
				break;

			case 4:
				System.out.print("Ingrese la clave del producto: ");
				Integer claveEliminar = scanner.nextInt();
				scanner.nextLine();

				if (productos.containsKey(claveEliminar)) {
					productos.remove(claveEliminar);
				}
				break;

			case 5:
				System.out.println("Fin del programa.");
				break;

			default:
				System.out.println("Opción incorrecta.");
			}

		} while (opcion != 5);

		scanner.close();	
	}

}
