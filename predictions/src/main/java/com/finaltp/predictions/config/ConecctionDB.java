package com.finaltp.predictions.config;

import java.sql.*;


public class ConecctionDB {
	
	private static Connection conn = null;
	private static Statement stmt = null;
	
	private void ConecctionDB() {};
	
	public static Connection conexion(Configuracion config) {
		if (conn == null) {
			try {
				try {
					Class.forName(config.getJDBC_DRIVER());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				conn = DriverManager.getConnection(config.getDB_URL(), config.getUSER(), config.getPASS());
				stmt = conn.createStatement();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return conn;
	}
	
	public static ResultSet consulta(String query) {
		ResultSet result;
		try {
			result = stmt.executeQuery(query);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
