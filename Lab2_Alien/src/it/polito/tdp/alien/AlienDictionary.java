package it.polito.tdp.alien;

import java.util.LinkedList;

public class AlienDictionary {
	
	private LinkedList <Word> dizionario = new LinkedList <Word>();
	private LinkedList <WordEnhanced> dizionarioBis = new LinkedList <WordEnhanced>();
	
	//USANDO CLASSE WORD
	
/*	public void addWord (String alienWord, String translation){
		boolean presente = false;
		for( Word word : dizionario){
			if(word.compare(alienWord)==true){
				presente= true;
				word.aggiornaTraduzione(translation);
			}
		}
		if( presente == false){
			Word w = new Word(alienWord, translation);
			dizionario.add(w);
		}
	}
	
	public String translateWord (String alienWord){
		for( Word w : dizionario){
			if(w.compare(alienWord)==true){
				return w.getTranslation();
			}
		}
		return null;
	}
*/	
	
	//USANDO CLASSE WORDENHANCED
	
	public void addWord(String alienWord, String translation){
		boolean presente = false;
		for( WordEnhanced w : dizionarioBis){
			if(w.compare(alienWord)==true){
				w.addTraduzione(translation);
				presente = true;
			}
		}
		if( presente == false){
			WordEnhanced w = new WordEnhanced(alienWord);
			w.addTraduzione(translation);
			dizionarioBis.add(w);
		}
	}
	
	public String translateWord (String alienWord){
		for( WordEnhanced w : dizionarioBis){
			if(w.compare(alienWord)==true){
				return w.getTraduzioni();
			}
		}
		return null;
	}

	public String translateWordParticolare(String alienWord) {
		int indice=0;
		for( int i =0; i<alienWord.length(); i++){
			if( alienWord.charAt(i)== '?'){
				indice = i;
			}
		}
		for(char c ='a'; c<=122  ; c++){
			String parola = alienWord.substring(0, indice);
			parola =  parola +c + alienWord.substring(indice+1);
			for( WordEnhanced w : dizionarioBis){
				if(w.compare(parola)==true){
					return w.getTraduzioni();
				}
			}
		}
		return null;
	}

}
