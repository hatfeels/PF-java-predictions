package com.finaltp.predictions;

import models.*;

public class App {
	public static void main(String[] args) {
		Equipo argentina = new Equipo("Argentina");
		Equipo arabia = new Equipo("Arabia");

		Equipo polonia = new Equipo("Polonia");
		Equipo mexico = new Equipo("México");

		Partido partido1 = new Partido(argentina, 1, 2, arabia);
		Partido partido2 = new Partido(polonia, 0, 0, mexico);

		Pronostico pronostico1 = new Pronostico(partido1, argentina, Resultado.GANA);

		System.out.print(pronostico1.getResultado());

	}

}
