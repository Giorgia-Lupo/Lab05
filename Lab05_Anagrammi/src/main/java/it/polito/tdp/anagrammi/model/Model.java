package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;

public class Model {

	private ParolaDAO dao;
	private List<String> soluzione;

	public Model() {
		this.dao = new ParolaDAO();
		this.soluzione = new ArrayList<String>();
	}
	
	public List<String> anagrammi(String parola){		
		parola = parola.toUpperCase();
		List<Character> disponibili = new ArrayList<>();
		
		for(int i=0; i<parola.length(); i++) {
			disponibili.add(parola.charAt(i));
		}
		
		recursive("", 0, disponibili);
		
		return this.soluzione;
	}

	public void recursive (String parziale, int livello, List<Character> disponibili) {
		
		if(disponibili.size()==0) {
			this.soluzione.add(parziale);
		}
		
		for(Character c : disponibili) {
			String tentativo = parziale + c;
			List<Character> rimanenti = new ArrayList<>(disponibili);
			rimanenti.remove(c);
			recursive(tentativo, livello+1, rimanenti);
		}
		
		
		
	
	}
	
	public List<Parola> getTutteLeParole() {
		return this.dao.getTutteLeParole();
	}
	
	public boolean getCorretto (String parolaAnagrammata) {
		return this.dao.getCorretto(parolaAnagrammata);
	}
	
}

	
	
	

