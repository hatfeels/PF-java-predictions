package com.finaltp.predictions.config;

import java.sql.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConecctionDB {

	private static Connection conn = null;
	
	private static EntityManagerFactory factory = null;
	
	private ConecctionDB() {};

	public static EntityManager getEntityManager() {
		if (factory == null)
			factory = Persistence.createEntityManagerFactory("PREDICTIONS");
		EntityManager manager = factory.createEntityManager();
		return manager;
	}


	public static Connection getConexion() {
		if (conn == null) {
			try {
				try {
					Class.forName(Configuracion.getJDBC_DRIVER());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(Configuracion.getDB_URL(), Configuracion.getUSER(),
						Configuracion.getPASS());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

}
