package ex1;

import java.util.ArrayList;
import java.util.List;

public class Lista<T> {
	private T[] lista;
	private int size;
	private int i = 0;
	private int f;
	private Iterator<T> iteratorLista = new IteratorLista<T>(this);
	
	public Lista (int size){
		this.size = size;
		this.f = size - 1;
		lista = (T[])(new Object [size]);
	}
	
	public int getI() {
		return i;
	}
	
	public int getF() {
		return f;
	}
	
	public void set(int pos, T elemento) {
		lista[pos] = elemento;
	}
	
	public Iterator<T> getIteratorLista(){
		this.iteratorLista.reset();
		return this.iteratorLista;
	}

	public int getSize() {
		return size;
	}
	
	public T get(int pos) {
		return lista[pos];
	}
}
