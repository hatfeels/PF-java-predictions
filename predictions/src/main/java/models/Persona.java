package models;

import lombok.Data;

public @Data class Persona {
	
	private String nombre;
	private PronRonda[] rondas;
	
	public Persona(String nombre, PronRonda[] rondas) {
		this.setNombre(nombre);
		this.setRondas(rondas);
	}
	
	public int getPuntajeTotal() {
		int total = 0;
		for(PronRonda ronda: rondas) {
			total = total + ronda.puntaje();
		}
		return total;
	}
}
