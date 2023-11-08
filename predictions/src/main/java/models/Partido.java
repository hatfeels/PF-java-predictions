package models;

import lombok.Data;

public @Data class Partido {

	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;

	public Partido(Equipo equipo1, int goles1, int goles2, Equipo equipo2) {
		this.setEquipo1(equipo1);
		this.setGolesEquipo1(goles1);
		this.setEquipo2(equipo2);
		this.setGolesEquipo2(goles2);
	}

	public String getResultado(Equipo equipo) {
		if (equipo == equipo1) {
			if (golesEquipo1 == golesEquipo2) {
				Resultado resultado = Resultado.EMPATA;
				return resultado.name();
			} else if (golesEquipo1 > golesEquipo2) {
				Resultado resultado = Resultado.GANA;
				return resultado.name();
			} else {
				Resultado resultado = Resultado.PIERDE;
				return resultado.name();
			}

		} else {
			if (golesEquipo2 == golesEquipo1) {
				Resultado resultado = Resultado.EMPATA;
				return resultado.name();
			} else if (golesEquipo2 > golesEquipo1) {
				Resultado resultado = Resultado.GANA;
				return resultado.name();
			} else {
				Resultado resultado = Resultado.PIERDE;
				return resultado.name();
			}
		}
	}
}
