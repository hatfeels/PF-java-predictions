package models;

import lombok.Data;

public @Data class PronRonda {
	
	private Pronostico[] pronosticos;
	
	public PronRonda (Pronostico[] pronosticos) {
		this.setPronosticos(pronosticos);
	}

	public int puntaje() {
		int parcial = 0;
		for(Pronostico partido: pronosticos) {
			if (partido.puntua()) {
				parcial++;
			}
		}
		if(parcial == pronosticos.length) {
			parcial = parcial + 2;
		}
		return parcial;
	}
}
