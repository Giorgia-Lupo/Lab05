package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	List<String> trovate = new ArrayList<>();
	List<String> corrette = new ArrayList<>();
	List<String> sbagliate = new ArrayList<>();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {

    	String s = txtParola.getText();
    	
    	trovate = this.model.anagrammi(s);
    	
    	for(String si : trovate) {
    		if(this.model.getCorretto(si)) 
    			corrette.add(si);
    		else
    			sbagliate.add(si);
    	}
    	
    	String a="";
    	if(corrette.size()!=0) {
	    	for(String ss : this.corrette) {
	    		a += ss +"\n";
	    	}
	    	txtCorretti.appendText(a);
    	}
    	
    	String b="";
    	if(sbagliate.size()!=0) {
    	for(String ss : this.sbagliate) {
				b += ss +"\n";
			}
			txtErrati.appendText(b);
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.trovate.clear();
    	this.corrette.clear();
    	this.sbagliate.clear();
    	txtParola.clear();
    	txtCorretti.clear();
    	txtErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    public void setModel(Model model) {
    	this.model = model;
    }
}
