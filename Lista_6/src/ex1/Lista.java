package ex1;

import java.util.ArrayList;
import java.util.List;

public class Lista<T> {
	private List<T> listaGenerica;
	private int size;
	
	public Lista (List<T> lista){
		this.listaGenerica = lista;
		this.size = listaGenerica.size();
	}
	
	
}
