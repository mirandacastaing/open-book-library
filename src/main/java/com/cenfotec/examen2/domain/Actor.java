package com.cenfotec.examen2.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Actor {
	@Id
	private String id;
	private String nombre;
	private String genero;
	private Date nacimiento;
	private double estatura;
	private String complexion;
	private String ojos;
	private String pelo;
	@Transient
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	@Transient
	private String edadMinima;
	@Transient
	private String edadMaxima;

	public Actor() {
	}

	public Actor(String nombre, String genero, String nacimiento, double estatura, String complexion, String ojos,
			String pelo) throws ParseException {
		this.nombre = nombre;
		this.genero = genero;
		this.nacimiento = format.parse(nacimiento);
		this.estatura = estatura;
		this.complexion = complexion;
		this.ojos = ojos;
		this.pelo = pelo;
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) throws ParseException {
		this.nacimiento = format.parse(nacimiento);
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public String getComplexion() {
		return complexion;
	}

	public void setComplexion(String complexion) {
		this.complexion = complexion;
	}

	public String getOjos() {
		return ojos;
	}

	public void setOjos(String ojos) {
		this.ojos = ojos;
	}

	public String getPelo() {
		return pelo;
	}

	public void setPelo(String pelo) {
		this.pelo = pelo;
	}

	public String getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(String edadMinima) {
		this.edadMinima = edadMinima;
	}

	public String getEdadMaxima() {
		return edadMaxima;
	}

	public void setEdadMaxima(String edadMaxima) {
		this.edadMaxima = edadMaxima;
	}

	public String toString() {
		StringBuilder value = new StringBuilder("* Actor/Actriz(");
		value.append("Id: ");
		value.append(id);
		value.append(",Nombre: ");
		value.append(nombre);
		value.append(",Género: ");
		value.append(genero);
		value.append(",Fecha de nacimiento: ");
		value.append(getCreatedAsShort());
		value.append(",Estatura: ");
		value.append(estatura);
		value.append(",Complexión corporal: ");
		value.append(complexion);
		value.append(",Color de ojos: ");
		value.append(ojos);
		value.append(",Color de pelo: ");
		value.append(pelo);
		value.append(")");
		return value.toString();
	}
}
