package it.polito.tdp.anagrammi.DAO;

import java.util.List;

import it.polito.tdp.anagrammi.model.Parola;

public class TestDB {

	public static void main(String[] args) {
		
		ParolaDAO dao = new ParolaDAO();
		dao.getTutteLeParole();
		
	}

}
