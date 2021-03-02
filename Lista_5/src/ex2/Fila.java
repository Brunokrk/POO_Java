package ex2;

import java.util.List;
import java.util.ArrayList;

public class Fila<T> {
	private int max;
	private List<T> fila = new ArrayList<T>();
	
	public Fila(int tam) {
		this.max = tam;
	}
	
	public void add(T objeto) {
		try {
			if(this.tamanho()==this.max) {
				throw new FilaCheiaException();
			}else {
				this.fila.add(objeto);
			}
		}catch(FilaCheiaException fc) {
			System.out.println(fc);
		}
	}
	
	public T tirar() {
		T aux;
		try {
			if(this.tamanho()==0) {
				throw new FilaVaziaException();
			}else {
				aux = this.fila.remove(this.fila.size());
				return aux;
			}
		}catch(FilaVaziaException fv) {
			System.out.println(fv);
		}
		return null;
	}
	
	private int tamanho() {
		return fila.size();
	}
	
	public void printFila() {
		for(T item : fila) {
			System.out.println(item.toString());
		}
	}
	
}
