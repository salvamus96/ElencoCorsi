package it.polito.tdp.corsi.model;

import java.util.List;
import java.util.Map;

public class TestModel {

	public static void main(String[] args) {
	
		Model m = new Model ();
		
		// # 1 
		List <Corso> corsi = m.listaCorsiSemestre(2);
		
		System.out.println("##### Elenco dei corsi del 2° semestre #####");
		for (Corso c : corsi)
			System.out.println(c);

		// # 2
		System.out.print("\n \nStudente con matricola 148072: ");
		System.out.println(m.getNomeCognomeFromMatricola(148072));
		
		// # 3
		List <Studente> studenti = m.getStudentiFromCodIns("02AQJPG");

		System.out.println("\n \n##### Elenco degli studenti iscritti al corso con codins 02AQJPG #####");
		for (Studente s : studenti)
			System.out.println(s);
		
		
		
		// # 4
		
		// Carico i corsi in una struttura dati, si crea una CACHE
//		m.listaCorsi();
		System.out.println("\n \n##### Statistiche dei corsi #####");
		
		
		// Carico le statiche per ciascun corso
		Map <Corso, Stats> statistiche = m.getStats();
		for (Corso c : statistiche.keySet()) {
			System.out.println(c);
			System.out.println(statistiche.get(c));
//			System.out.println("\n");
		}
		
	}

}
