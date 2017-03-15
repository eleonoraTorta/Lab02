package it.polito.tdp.alien;

public class Word {
	
	private String alienWord; 
	private String translation;

	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
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

	public String getTranslation() {
		return translation;
	}

	public void aggiornaTraduzione(String translation2) {
		this.translation = translation2;	
	}
	

}
