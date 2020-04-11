package it.polito.tdp.anagrammi.model;

import java.util.*;

public class TestRicerca {

	public static void main(String[] args) {

		Model model = new Model();
		
		List<String> an = model.anagrammi("eat");
		System.out.println(an);		
		
	}

}
