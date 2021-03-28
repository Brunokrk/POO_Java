package ex1;



public class IteratorLista<T> implements Iterator<T> {
	private Lista<T> lista;
	private int atualI = 0;
	private int atualF;
	private int ii;
	private int ff;
	private int contF = 0; //quantas vezes foi retornado um item partindo do final da lista
	
	public IteratorLista (Lista<T> lista) {
		this.lista = lista;
		this.atualF = lista.getSize()-1;
	}
	
	@Override
	public void reset() {
		atualI = 0;
		atualF =lista.getSize() - 1;
	}
	
	@Override
	public boolean hasNext() {
		if(atualI < atualF-1) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public T next() {
		ii = atualI;
		ff = atualF;
		boolean itfinal = false; //para controlar o que será retornado no final
		if(atualI > contF) {
			//hora de iterar no final
			atualF --;
			contF ++;
			itfinal = true;
		}else {
			//hora de iterar no inicio
			atualI ++;
		}
		if(atualI >= atualF - 1) {
			reset();
		}
		
		if(itfinal) {
			return lista.get(ff);
		}else {
			return lista.get(ii);
		}
	}
	
}
