package com.cenfotec.examen2.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Guionista {
	@Id
	private String id;
	private String nombre;
	private String direccion;
	private String email;
	private Date nacimiento;
	@Transient
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public Guionista() {
	}

	public Guionista(String nombre, String direccion, String email, String nacimiento) throws ParseException {
		this.nombre = nombre;
		this.direccion = direccion;
		this.email = email;
		this.nacimiento = format.parse(nacimiento);
	}

	public String getCreatedAsShort() {
		return format.format(nacimiento);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) throws ParseException {
		this.nacimiento = format.parse(nacimiento);
	}

	public String toString() {
		StringBuilder value = new StringBuilder("* Guionista(");
		value.append("Id: ");
		value.append(id);
		value.append(",Nombre: ");
		value.append(nombre);
		value.append(",Dirección: ");
		value.append(direccion);
		value.append(",Email: ");
		value.append(email);
		value.append(",Fecha de nacimiento: ");
		value.append(getCreatedAsShort());
		value.append(")");
		return value.toString();
	}
}
