package it.polito.tdp.alien;

import java.util.LinkedList;

public class WordEnhanced {
	
	private String alienWord; 
	private LinkedList <String> traduzioni = new LinkedList <String>();

	public WordEnhanced(String alienWord) {
		this.alienWord = alienWord;

	}

	public boolean compare(String alienWordDaControllare){
		if(alienWord.compareTo(alienWordDaControllare)==0){
			return true;
		}
		return false;
	}

	public String getAlienWord() {
		return alienWord;
	}

	
	public void addTraduzione(String translation) {
		for(String s : traduzioni){
			if(s.compareTo(translation)==0){
				return;
			}
		}
		traduzioni.add(translation);	
	}
	
	public String getTraduzioni(){
		String risultato = "";
		for(String s : traduzioni){
			risultato = risultato + s + "\n";
		}
		return risultato;
	}
	

	


}
