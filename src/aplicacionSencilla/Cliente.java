package aplicacionSencilla;

import java.util.Date;

public class Cliente {

	private String nombre,apellido,provincia;
	private Date fechaAlta;
	
	public Cliente(String nombre, String apellido, Date fecha, String provincia) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.fechaAlta=fecha;
		this.provincia=provincia;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getProvincia() {
		return provincia;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}
	
	public String[] arrayDatos() {
		String[] datos=new String[4];
		datos[0]=nombre;
		datos[1]=apellido;
		datos[2]=fechaAlta.toString();
		datos[3]=provincia;
		
		return datos;
	}
}
