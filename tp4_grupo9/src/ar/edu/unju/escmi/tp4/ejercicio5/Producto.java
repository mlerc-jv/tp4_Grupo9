package ar.edu.unju.escmi.tp4.ejercicio5;

import java.time.LocalDate;

public class Producto {
	
	private String descripcion;
	private double precio;
	private LocalDate fechaVencimiento;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	@Override
	public String toString() {
		return "Producto [descripcion=" + descripcion + ", precio=" + precio + ", fechaVencimiento="
				+ fechaVencimiento + "]";
	}
}
