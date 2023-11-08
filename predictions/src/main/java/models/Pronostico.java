package models;

import lombok.Data;

public @Data class Pronostico {
	
	
	private Partido partido;
	private Equipo equipo;
	private Resultado resultado;
	
	public Pronostico(Partido partido, Equipo equipo, Resultado resultado) {
		this.setEquipo(equipo);
		this.setPartido(partido);
		this.setResultado(resultado);
	}
	
	public Boolean puntua() {
		if(this.resultado.toString().compareTo(partido.getResultado(this.equipo)) != 0) {
			return false;
		}else {
			return true;
		}
	}
}
