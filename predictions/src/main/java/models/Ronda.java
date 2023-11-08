package models;

import lombok.Data;

public @Data class Ronda {
	
	private String ronda;
	private Partido[] partidos;
	
	public Ronda (String ronda, Partido[] partidos) {
		this.setPartidos(partidos);
		this.setRonda(ronda);
	}

}
