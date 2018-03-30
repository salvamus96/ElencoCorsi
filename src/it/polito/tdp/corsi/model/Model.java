package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.db.StudenteDAO;

public class Model {

	private List <Corso> corsi ;
	
	private CorsoDAO corsoDAO;
	private StudenteDAO studenteDAO;
	
	public Model () {
		corsoDAO = new CorsoDAO ();
		studenteDAO = new StudenteDAO ();
	}
	
	
	public List <Corso> listaCorsiSemestre (int pd){
				
		// OPZIONE 1 : leggo tutto e filtro io
//		this.corsi = corsoDAO.listAll();
//		List <Corso> risultato = new ArrayList <> ();
//		
//		for (Corso c : this.corsi) {
//			if (c.getPd() == pd)
//				risultato.add(c);
//		}
//		return risultato;
		
		
		// OPZIONE 2 : faccio lavorare il database
		return corsoDAO.listByPD(pd);
		
	}
	
	public String getNomeCognomeFromMatricola (int matricola) {
	
		Studente s = studenteDAO.getStudenteByMatricola(matricola);
		if (s == null)
			//la matricola non esiste
			return "Matricola non esistente";
	
		return s.getNome() + " " + s.getCognome();
	}


	public List<Studente> getStudentiFromCodIns(String codins) {
		List <Studente> studenti = studenteDAO.getStudentiByCodIns(codins);
		
		return studenti;
	}

	/**
	 * Caricamento una sola volta di tutti i corsi sfruttando
	 * un meccanismo di cache
	 * @return
	 */
	public List<Corso> listaCorsi (){
		if (this.corsi == null)
			this.corsi = corsoDAO.listAll();
		
		return corsi;
	}
	
	
	public Map<Corso, Stats> getStats() {
	
		Map <Corso, Stats> corsoMap = new HashMap <Corso, Stats> ();
		
		for (Corso c : this.listaCorsi()) {
			Stats stats = corsoDAO.getStatsFromCodIns(c.getCodIns());
			corsoMap.put(c, stats);	
		}
		
		return corsoMap;
	}


}