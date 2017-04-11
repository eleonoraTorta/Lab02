package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	AlienDictionary dizionario;
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	dizionario= new AlienDictionary();
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	String stringa = txtWord.getText();
    	
    	//controllo sull'input
    	if(stringa == null || stringa.length() == 0){
    		txtResult.setText("Inserire una o due parole.");
    		return;
    	}
    	
    	String ar[] =stringa.split(" ");
  
    	if(ar.length == 1){
    		String alienWord = ar[0].toLowerCase();
    		if( alienWord.matches("[a-zA-Z]*")){
    			txtResult.setText(dizionario.translateWord(alienWord));
    		}
    		for(int i =0; i<alienWord.length();i++){
    			if(alienWord.charAt(i) == '?'){
    			txtResult.setText(dizionario.translateWordParticolare(alienWord));
    			}
    		}
    	}
    	if(ar.length == 2){
    		String alienWord = ar[0].toLowerCase();
    		String traduzione = ar[1].toLowerCase();
    		if( alienWord.matches("[a-zA-Z]*") && traduzione.matches("[a-zA-Z]*")){
    		dizionario.addWord(alienWord, traduzione);
    		}
    	}
    	makeGUIVisible(true);
    	txtWord.clear();
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	makeGUIVisible(false);
    }
    
    private void makeGUIVisible(boolean visible){
    	txtResult.setVisible(visible);
    	btnReset.setVisible(visible);
    	
    }
}
