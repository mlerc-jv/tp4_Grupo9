package ar.edu.unju.escmi.tp4.ejercicio1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Jugador> jugadores= new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int opcion;
        do {
        	System.out.println("MENU JUGADORES");
        	System.out.println("1. Alta de jugador");
        	System.out.println("2. Modificar los datos de un jugador");
        	System.out.println("3. Eliminar un jugador");
        	System.out.println("4. Mostrar todos los jugadores");
        	System.out.println("5. Mostrar la cantidad de jugadores en la lista");
        	System.out.println("6. Limpiar toda la lista de jugadores");
        	System.out.println("7. Salir");
        	System.out.println("Ingresar una opcion: ");
        	opcion = sc.nextInt();
        	sc.nextLine();
        	
        	switch(opcion) {
        	case 1:
        		Jugador jugador = new Jugador();
        	    System.out.println("ingresar DNI: ");
        	    jugador.setDni(sc.nextInt());
        	    sc.nextLine();
        	    System.out.println("ingresar nombre: ");
        	    jugador.setNombre(sc.nextLine());
        	    System.out.println("ingresar equipo: ");
        	    jugador.setEquipo(sc.nextLine());
        	    System.out.println("ingresar nacionalidad: ");
        	    jugador.setNacionalidad(sc.nextLine());
        	    System.out.println("ingresar estatura: ");
        	    jugador.setEstatura(sc.nextDouble());
        	    sc.nextLine();
        	    jugadores.add(jugador);
        	    System.out.println("Jugador agregado");
        		break;
        	case 2:
        		System.out.println("Ingresar DNI del jugador: ");
        		int dniMostrar = sc.nextInt();
        		sc.nextLine();
        		for (Jugador j : jugadores) {
        			if(j.getDni()== dniMostrar) {
        				j.mostrarDatos();
        				System.out.println("ingresar nuevo nombre: ");
        				j.setNombre(sc.nextLine());
        				System.out.println("ingresar nuevo equipo: ");
        				j.setEquipo(sc.nextLine());
        				System.out.println("ingresar nueva nacionalidad ");
        				j.setNacionalidad(sc.nextLine());
        				System.out.println("ingresar nueva estatura: ");
        				j.setEstatura(sc.nextDouble());
        				sc.nextLine();
        				System.out.println("Jugador modificado");
        				break;
        			}else {
        				System.out.println("No existe jugador con este DNI");
        			}
        		}
        		break;
        	case 3:
        		System.out.println("Ingresar DNI del jugador: ");
        		int dniEliminar = sc.nextInt();
        		sc.nextLine();
        		Jugador jugadorEliminado=null;
        		for(Jugador j : jugadores) {
        			if(j.getDni()==dniEliminar) {
        				jugadorEliminado=j;
        			}
        		}
        		if (jugadorEliminado != null) {
        			jugadores.remove(jugadorEliminado);
        		}else {
        			System.out.println("no se encuentra el DNI");
        		}
        		break;
        	case 4:
        		for (Jugador j: jugadores) {
        			j.mostrarDatos();
        			System.out.println();
        		}
        		break;
        	case 5:
        		System.out.println("Cantidad de jugadores: " + jugadores.size());
        		break;
        	case 6:
        		jugadores.clear();
        		System.out.println("Lista de jugadores vacia");
        		break;
        	case 7:
        		System.out.println("Programa finalizado");
        		break;
        	default:
        		System.out.println("Opcion invalida");
        		break;
        	}
        }while(opcion !=7 );
    	sc.close();
        
        }
}