package com.finaltp.predictions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import models.*;

public class App {

	@SuppressWarnings("null")
	public static  void main(String[] args) throws IOException {

		// lee y setea las derecciones de los archivos CSV

		Scanner sc = new Scanner(System.in);
		System.out.println("ingresa la ubicacion del archivo de resultados");
		String rondasDir = sc.nextLine();
		System.out.println("el arcivo esta en => " + rondasDir);
		CSVReader rondasCSV;
		Partido[] partidos = new Partido[2];
		try {
			rondasCSV = new CSVReader(new FileReader(rondasDir));
			String[] fila = null;
			try {
				int cont = 0;
				while ((fila = rondasCSV.readNext()) != null) {
					System.out.println(fila[0] + " | " + fila[1] + " | " + fila[2] + " | " + fila[3]);
					partidos[cont] = new Partido(new Equipo(fila[0]), Integer.parseInt(fila[1]), Integer.parseInt(fila[2]),
							new Equipo(fila[3]));
					cont = cont + 1;
				}
			} catch (CsvValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("se creo correctamente");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("ingresa la ubicacion del archivo del pronostico");
		String predicionesDir = sc.nextLine();
		System.out.println("el arcivo esta en => " + predicionesDir);
		Pronostico[] pronosticos = new Pronostico[2];
		CSVReader pronosticoCSV;
		try {
			pronosticoCSV = new CSVReader(new FileReader(predicionesDir));
			String[] fila = null;
			Resultado result = null;
			try {
				int cont = 0;
				while ((fila = pronosticoCSV.readNext()) != null) {
					if ( "x".equalsIgnoreCase(fila[1])){
						 result = Resultado.GANA;
					}
					else if ("x".equalsIgnoreCase(fila[2])) {
						 result = Resultado.EMPATA;
					}
					else if ("x".equalsIgnoreCase(fila[3])) {
						 result = Resultado.PIERDE;
					}
					System.out.println(fila[0] + " | " + fila[1] + " | " + fila[2] + " | " + fila[3] + " | " + fila[4]);
					pronosticos[cont] = new Pronostico(partidos[cont], partidos[cont].getEquipo1(), result);
					cont = cont +1;
				}
			} catch (CsvValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// funcion para hacer el puntaje obtenido
		
		int puntaje = 0;
		for(Pronostico partido :pronosticos) {
			System.out.println(partido);
			int result = partido.getPartido().getResultado(partido.getEquipo()).compareTo(partido.getResultado().toString());
			if(result == 0) {
				puntaje = puntaje + 1;
			}
		}
		sc.close();
		
		System.out.print(puntaje);

	}

}
