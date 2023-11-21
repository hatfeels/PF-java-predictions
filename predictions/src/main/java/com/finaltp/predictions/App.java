package com.finaltp.predictions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.*;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import models.*;

public class App {

	public static void main(String[] args) throws IOException {

		// lee y setea las derecciones de los archivos CSV

		Scanner sc = new Scanner(System.in);

//	     ------------------------Torneo---------------------------

		System.out.println("ingresa la ubicacion del archivo de resultados");
//		String rondasDir = "C:\\Users\\Ayrton\\Documents\\Ayrton\\Desarrollador Java UTN\\Proyecto final\\ResultadosCompleto.csv";
		String rondasDir = sc.nextLine();
		System.out.println("el arcivo esta en => " + rondasDir);
		CSVReader rondasCSV;
		ArrayList<Ronda> torneo = new ArrayList<Ronda>();

		rondasCSV = new CSVReader(new FileReader(rondasDir));

		try {

			List<String[]> datos = rondasCSV.readAll();
			int rondaActual = 1;
			ArrayList<Partido> ronda = new ArrayList<Partido>();
			for (String[] partido : datos) {
				if (Integer.parseInt(partido[0]) == rondaActual) {
					ronda.add(new Partido(new Equipo(partido[1]), Integer.parseInt(partido[2]),
							Integer.parseInt(partido[3]), new Equipo(partido[4])));
				} else {
					torneo.add(new Ronda(partido[0], ronda));
					rondaActual++;
				}
				for (String ele : partido) {
					System.out.print(ele + " | ");
				}
				System.out.println();
			}
			torneo.add(new Ronda(Integer.toString(rondaActual), ronda));

			// Comprueva si se crearon
//			System.out.println(torneo);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		rondasCSV.close();

//     ------------------------Pronostico---------------------------

		System.out.println("ingresa la ubicacion del archivo del pronostico");
//		String predicionesDir = "C:\\Users\\Ayrton\\Documents\\Ayrton\\Desarrollador Java UTN\\Proyecto final\\PronosticoCompleto.csv";
		String predicionesDir = sc.nextLine();
		System.out.println("el arcivo esta en => " + predicionesDir);

		CSVReader pronosticoCSV;
		pronosticoCSV = new CSVReader(new FileReader(predicionesDir));
		ArrayList<Persona> participantes = new ArrayList<Persona>();
		ArrayList<PronRonda> predictTorneo = new ArrayList<PronRonda>();
		ArrayList<Pronostico> predictRonda = new ArrayList<Pronostico>();

		try {
			List<String[]> datos = pronosticoCSV.readAll();
			String personaActial = null;
			int rondaActual = 1;
			int partidoActual = 0;


			for (String[] pronostico : datos) {

				if (personaActial == null)
					personaActial = pronostico[0];
				if (personaActial.equalsIgnoreCase(pronostico[0])) {
					if (Integer.parseInt(pronostico[1]) == rondaActual) {
						crearPredict(pronostico, torneo, rondaActual, partidoActual, predictRonda);
					} else {
						predictTorneo.add(new PronRonda(predictRonda));
						predictRonda = new ArrayList<Pronostico>();
						rondaActual++;
						partidoActual = 0;
						crearPredict(pronostico, torneo, rondaActual, partidoActual, predictRonda);
					}
				} else {
					predictTorneo.add(new PronRonda(predictRonda));
					participantes.add(new Persona(personaActial, predictTorneo));
					personaActial = pronostico[0];
					predictTorneo = new ArrayList<PronRonda>();
					predictRonda = new ArrayList<Pronostico>();
					rondaActual = 1;
					partidoActual = 0;
					crearPredict(pronostico, torneo, rondaActual, partidoActual, predictRonda);
				}

				for (String p : pronostico) {
					System.out.print(p + " | ");
				}
				System.out.println();
			}
			predictTorneo.add(new PronRonda(predictRonda));
			participantes.add(new Persona(personaActial, predictTorneo));
			
			for (Persona puntos : participantes) {
				System.out.println(puntos.getNombre() + ": "+puntos.getPuntajeTotal());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sc.close();
		pronosticoCSV.close();

	}

	// funcion para crear predicciones individuales

	static void crearPredict(String[] pronostico, ArrayList<Ronda> torneo, int rondaActual, int partidoActual,
			ArrayList<Pronostico> predictRonda) {
		// Buscar el partido correspondiente en la ronda actual
		Partido partido = buscarPartido(torneo, rondaActual, pronostico[2], pronostico[6]);
		Resultado result = null;
		if ("x".equalsIgnoreCase(pronostico[3])) {
			result = Resultado.GANA;
		} else if ("x".equalsIgnoreCase(pronostico[4])) {
			result = Resultado.EMPATA;
		} else if ("x".equalsIgnoreCase(pronostico[5])) {
			result = Resultado.PIERDE;
		}

	    if (partido != null) {
	        predictRonda.add(new Pronostico(partido, new Equipo(pronostico[2]), result));
//	        System.out.println(predictRonda.toString());
	    } else {
	        System.out.println("Error: No se encontró el partido correspondiente para el pronóstico.");
	    }
	}
	static Partido buscarPartido(ArrayList<Ronda> torneo, int rondaActual, String equipoLocal, String equipoVisitante) {
	    for (Partido partido : torneo.get(rondaActual - 1).getPartidos()) {
	        if (partido.getEquipo1().getNombre().equalsIgnoreCase(equipoLocal)
	                && partido.getEquipo2().getNombre().equalsIgnoreCase(equipoVisitante)) {
	            return partido;
	        }
	    }
	    return null; 
	}
}