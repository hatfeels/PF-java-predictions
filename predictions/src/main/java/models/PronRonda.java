package models;

import java.util.ArrayList;

import lombok.Data;

public @Data class PronRonda {
	
	
	private ArrayList<Pronostico> pronosticos;
	
	public PronRonda (ArrayList<Pronostico> pronosticos) {
		this.setPronosticos(pronosticos);
	}

	public int puntaje() {
		int parcial = 0;
		for(Pronostico partido: pronosticos) {
			if (partido.puntua()) {
				parcial++;
			}
		}
		if(parcial == pronosticos.size()) {
			parcial = parcial + 2;
		}
		return parcial;
	}
}
