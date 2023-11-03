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
		String rondasDir = "C:\\Users\\Ayrton\\Documents\\Ayrton\\Desarrollador Java UTN\\Proyecto final\\Resultados.csv";
		System.out.println("el arcivo esta en => " + rondasDir);
		Partido[] partidos = new Partido[2];
		CSVReader rondasCSV;
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
		String predicionesDir = "C:\\Users\\Ayrton\\Documents\\Ayrton\\Desarrollador Java UTN\\Proyecto final\\Pronostico.csv";
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

					if (fila[1] == "X") {
						System.out.println("GANA");
						 result = Resultado.GANA;
					}
					else if (fila[2].toString() == "X") {
						System.out.println("EMPATA");
						 result = Resultado.EMPATA;
					}
					else if (fila[3].toString() == "X") {
						System.out.println("PIERDE");
						 result = Resultado.PIERDE;
					}
					
					System.out.println(fila[0] + " | " + fila[1] + " | " + fila[2] + " | " + fila[3] + " | " + fila[4]);
					pronosticos[cont] = new Pronostico(partidos[cont], partidos[cont].getEquipo1(), result);
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
		
		sc.close();
		
		// funcion para hacer el puntaje obtenido
		
		int puntaje = 0;
		for(Pronostico partido :pronosticos) {
			System.out.println(partido);
			int result = partido.getPartido().getResultado(partido.getEquipo()).compareTo(partido.getResultado().toString());
			if(result == 0) {
				puntaje = puntaje + 1;
			}
		}
		
		System.out.print(puntaje);

//		int result = pronostico1.getPartido().getResultado(pronostico1.getEquipo()).compareTo(pronostico1.getResultado().toString());

	}

}
