package com.finaltp.predictions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import models.*;

public class App {

	@SuppressWarnings("null")
	public static  void main(String[] args) throws IOException{

		// lee y setea las derecciones de los archivos CSV

		Scanner sc = new Scanner(System.in);
		System.out.println("ingresa la ubicacion del archivo de resultados");
		String rondasDir = "C:\\Users\\Ayrton\\Documents\\Ayrton\\Desarrollador Java UTN\\Proyecto final\\ResultadosCompleto.csv";
		System.out.println("el arcivo esta en => " + rondasDir);
		CSVReader rondasCSV;
		Partido[] partidos = new Partido[2];
		Ronda[] torneo = null;
		
		try {
			rondasCSV = new CSVReader(new FileReader(rondasDir));
			String[] fila = null;
			while((fila = rondasCSV.readNext()) != null) {
				System.out.println(fila[0] + " | " + fila[1] + " | " + fila[2] + " | " + fila[3] + " | " + fila[4]);
			}
		}catch (CsvValidationException e){
			
		}
		

//		System.out.println("ingresa la ubicacion del archivo del pronostico");
//		String predicionesDir = "C:\\Users\\Ayrton\\Documents\\Ayrton\\Desarrollador Java UTN\\Proyecto final\\PronosticoCompleto.csv";
//		System.out.println("el arcivo esta en => " + predicionesDir);
//		Pronostico[] pronosticos = new Pronostico[2];
//		CSVReader pronosticoCSV;
//		try {
//			pronosticoCSV = new CSVReader(new FileReader(predicionesDir));
//			String[] fila = null;
//			Resultado result = null;
//			try {
//				int cont = 0;
//				while ((fila = pronosticoCSV.readNext()) != null) {
//					if ( "x".equalsIgnoreCase(fila[1])){
//						 result = Resultado.GANA;
//					}
//					else if ("x".equalsIgnoreCase(fila[2])) {
//						 result = Resultado.EMPATA;
//					}
//					else if ("x".equalsIgnoreCase(fila[3])) {
//						 result = Resultado.PIERDE;
//					}
//					System.out.println(fila[0] + " | " + fila[1] + " | " + fila[2] + " | " + fila[3] + " | " + fila[4]);
//					pronosticos[cont] = new Pronostico(partidos[cont], partidos[cont].getEquipo1(), result);
//					cont = cont +1;
//				}
//				pronosticoCSV.close();
//			} catch (CsvValidationException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		


		sc.close();
		

	}

}
