package com.finaltp.predictions.config;

import java.util.List;

import lombok.*;

public class Configuracion {
	
	// credenciales DB
	

	private @Getter  final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private @Getter  String DB_URL;
	
	private @Getter  String USER;
	private @Getter  String PASS;
	
	
	// asignacion de puntos

	private @Getter  String puntosPartido;
	private @Getter  String puntosRonda;
	private @Getter  String puntosFase;
	
	public Configuracion(List<String[]> config) {
		DB_URL = config.get(0)[0];
		USER  = config.get(0)[1];
		PASS = config.get(0)[2];
		
		puntosPartido = config.get(1)[0];
		puntosRonda = config.get(1)[1];
		puntosFase = config.get(1)[2];
	}
	
	
}
