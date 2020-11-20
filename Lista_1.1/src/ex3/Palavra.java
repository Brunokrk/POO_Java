package ex3;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Palavra {
	private String word;
	private byte[] lista;
	public int consonants;
	public int vogals;
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getWord() {
		return this.word;
	}
	
	public void setLista() {
		byte[] aux = this.word.getBytes();
		this.lista = aux;
	}
	
	public byte[] getLista() {
		return this.lista;
	}
	
	public byte[] inverteString() {
		byte[] aux = this.word.getBytes();
		byte[] newString = new byte[aux.length];
		
		for(int i =0; i < aux.length; i++) {
			newString[i] = aux[aux.length - i -1];
		}
		return newString;
	}
	
	public void setVogalsAndConsonants() {
		for(int cont =0; cont < this.word.length(); cont++) {
			if (word.charAt(cont)=='a'||word.charAt(cont)=='e'||word.charAt(cont)=='i'||word.charAt(cont)=='i'||word.charAt(cont)=='u') {
				this.vogals ++;
			}else {
				this.consonants++;
			}
		}
	}
		
}
