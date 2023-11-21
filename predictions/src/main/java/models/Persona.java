package models;

import java.util.ArrayList;

import lombok.Data;

public @Data class Persona {
	
	private String nombre;
	private ArrayList<PronRonda> rondas;
	
	public Persona(String nombre, ArrayList<PronRonda> rondas) {
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
