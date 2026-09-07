package ar.edu.unju.escmi.tp4.ejercicio3;

public class Paciente implements Comparable<Paciente>{
	private int dni, nroHistoriaClinica;
	private String nombre, apellido, obraSocial;
	
	public Paciente() {
		
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNroHistoriaClinica() {
		return nroHistoriaClinica;
	}

	public void setNroHistoriaClinica(int nroHistoriaClinica) {
		this.nroHistoriaClinica = nroHistoriaClinica;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public void setObraSocial(String obraSocial) {
		this.obraSocial = obraSocial;
	}
	@Override
	public int compareTo(Paciente otro) {
		return Integer.compare(this.nroHistoriaClinica, otro.nroHistoriaClinica);
	}
	@Override
	public String toString() {
	    return "Paciente [DNI: " + dni + ", nombre: " + nombre + ", apellido: " + apellido
	            + ", numero historia clinica: " + nroHistoriaClinica + ", Obra social: " + obraSocial + "]";
	}
}
