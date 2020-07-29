package com.cenfotec.examen2.domain;

import org.springframework.data.annotation.Id;

public class Guion {
	@Id
	private String id;
	private Guionista screenwriter;
	private String obra;
	private String genero;
	private String idea;
	private boolean produccion;
	private Actor actorPrincipal;
	private Actor actrizPrincipal;

	public Guion() {
		actorPrincipal = new Actor();
		actrizPrincipal = new Actor();
	}

	public Guion(Guionista screenwriter, String obra, String genero, String idea, boolean produccion,
			Actor actorPrincipal, Actor actrizPrincipal) {
		this.screenwriter = screenwriter;
		this.obra = obra;
		this.genero = genero;
		this.idea = idea;
		this.produccion = produccion;
		this.actorPrincipal = actorPrincipal;
		this.actrizPrincipal = actrizPrincipal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Guionista getScreenwriter() {
		return screenwriter;
	}

	public void setScreenwriter(Guionista screenwriter) {
		this.screenwriter = screenwriter;
	}

	public String getObra() {
		return obra;
	}

	public void setObra(String obra) {
		this.obra = obra;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdea() {
		return idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}

	public boolean getProduccion() {
		return produccion;
	}

	public void setProduccion(boolean produccion) {
		this.produccion = produccion;
	}

	public Actor getActorPrincipal() {
		return actorPrincipal;
	}

	public void setActorPrincipal(Actor actorPrincipal) {
		this.actorPrincipal = actorPrincipal;
	}

	public Actor getActrizPrincipal() {
		return actrizPrincipal;
	}

	public void setActrizPrincipal(Actor actrizPrincipal) {
		this.actrizPrincipal = actrizPrincipal;
	}

	public String toString() {
		StringBuilder value = new StringBuilder("* Guion(");
		value.append("Id: ");
		value.append(id);
		value.append(",Guionista: ");
		value.append(screenwriter);
		value.append(",Nombre de la obra propuesta: ");
		value.append(obra);
		value.append(",Género de la obra: ");
		value.append(genero);
		value.append(",Idea central: ");
		value.append(idea);
		value.append(",Listo para producción: ");
		value.append(produccion);
		value.append(",Actor principal: ");
		value.append(actorPrincipal);
		value.append(",Actriz principal: ");
		value.append(actrizPrincipal);
		value.append(")");
		return value.toString();
	}
}
