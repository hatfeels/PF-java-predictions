package com.finaltp.predictions.config;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.List;

import lombok.*;

public class Configuracion {

	private static Configuracion configuracion = null;

	// credenciales DB

	private static @Getter final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	private static @Getter String DB_URL;
	private static @Getter String USER;
	private static @Getter String PASS;

	// asignacion de puntos

	private static @Getter String puntosPartido;
	private static @Getter String puntosRonda;
	private static @Getter String puntosFase;

	private Configuracion(String url, String user, String pass, String pPartido, String psRonda, String pFase) {
		DB_URL = url;
		USER = user;
		PASS = pass;

		puntosPartido = pPartido;
		puntosRonda = psRonda;
		puntosFase = pFase;
	};

	public static Configuracion getConfig(List<String[]> config) {
		if (configuracion == null) {
			configuracion = new Configuracion(config.get(0)[0], config.get(0)[1], config.get(0)[2], config.get(1)[0],
					config.get(1)[1], config.get(1)[2]);
		}
		return configuracion;
	}

	public static Configuracion getConfig() throws IOException {
		if (configuracion == null) {
			throw new IOException("Debe ingresar los parametros de configuracion con un archivo CSV");
		} else
			return configuracion;
	}

}
