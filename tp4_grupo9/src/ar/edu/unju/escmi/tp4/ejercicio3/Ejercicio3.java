package ar.edu.unju.escmi.tp4.ejercicio3;
import java.util.Scanner;
import java.util.TreeSet;
public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Paciente> pacientes = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
        	System.out.println("MENU PACIENTES");
        	System.out.println("1. Alta de paciente");
        	System.out.println("2. Mostrar todos los pacientes");
        	System.out.println("3. Mostrar el paciente que se encuentra en la mitad de la lista");
        	System.out.println("4. Mostrar el primer paciente de la lista");
        	System.out.println("5. Mostrar el ultimo paciente de la lista");
        	System.out.println("6. Filtrar por historia clinica");
        	System.out.println("7. Salir");
        	System.out.println("Ingresar una opcion: ");
        	opcion = sc.nextInt();
        	sc.nextLine();
        	
        	switch(opcion) {
            case 1:
            	Paciente paciente = new Paciente();
            	System.out.println("Ingresar DNI: ");
            	paciente.setDni(sc.nextInt());
            	sc.nextLine();
            	System.out.println("Ingresar nombre: ");
            	paciente.setNombre(sc.nextLine());
            	System.out.println("Ingresar apellido: ");
            	paciente.setApellido(sc.nextLine());
            	System.out.println("Ingresar numero de historia clinica: ");
            	paciente.setNroHistoriaClinica(sc.nextInt());
            	sc.nextLine();
            	System.out.println("Ingresar obra social: ");
            	paciente.setObraSocial(sc.nextLine());
            	pacientes.add(paciente);
            	System.out.println("Paciente agregado");
            	break;
            case 2:
            	if (pacientes.isEmpty()) {
            		System.out.println("No hay pacientes");
            	}else {
            	pacientes.stream().forEach(System.out::println);
            	}
            	break;
            case 3:
                if (pacientes.isEmpty()) {
                    System.out.println("No hay pacientes");
                } else {
                	int posicion = pacientes.size() / 2;
                    Paciente[] arreglo = pacientes.toArray(new Paciente[0]);
                    System.out.println("Paciente de la mitad: ");
                    System.out.println(arreglo[posicion]);
                }
                break;
            case 4:
            	 if (pacientes.isEmpty()) {
            	        System.out.println("No hay pacientes");
            	    } else {
            	        System.out.println("Primer paciente: ");
            	        System.out.println(pacientes.first());
            	    }
            	break;
            case 5:
            	if (pacientes.isEmpty()) {
                    System.out.println("No hay pacientes");
                } else {
                    System.out.println("Ultimo paciente: ");
                    System.out.println(pacientes.last());
                }
            	break;
            case 6:
            	System.out.println("Ingresar numero de historia clinica: ");
                int nroHistoriaClinica = sc.nextInt();
                pacientes.stream().filter(p -> p.getNroHistoriaClinica() > nroHistoriaClinica).forEach(System.out::println);
            	break;
            case 7:
            	System.out.println("Programa finalizado");
            	break;
            default:
            	System.out.println("opcion invalida");
            	break;
            }
        }while (opcion !=7);
        sc.close(); 
	}
}
