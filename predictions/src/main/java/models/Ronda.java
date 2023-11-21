package models;

import java.util.ArrayList;

import lombok.Data;

public @Data class Ronda {
	
	private String ronda;
	private ArrayList<Partido> partidos;
	
	public Ronda (String ronda, ArrayList<Partido> partidos) {
		this.setPartidos(partidos);
		this.setRonda(ronda);
	}

}
