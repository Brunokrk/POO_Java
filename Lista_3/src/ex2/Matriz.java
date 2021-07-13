package ex2;

import java.util.List;
import java.util.ArrayList;

public class Matriz<T> {
	private int n=0;
	private int m=0;
	private T matriz[][];
	
	public Matriz(int m, int n) {
		this.n = n;
		this.m = m;
	
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				matriz[i][j] = null;
			}
		}
	}
	public boolean set(T objeto, int i, int j) {
		if(i <= m && j<=n) {
			matriz[i][j] = objeto;
			return true;
		}else {
			return false;
			
		}
	}
	public T get(int i, int j) {
		if(i <= m && j<=n) {
			return matriz[i][j];
		}else {
			return null;
		}
	}
	public List<T> getLinha(int linha){
		List<T> line = new ArrayList<T>();
		for(int j=0; j<m; j++){
			line.add(matriz[linha][j]);
		}
		return line;
	}
	public List<T> getColuna(int coluna){
		List<T> column = new ArrayList<T>();
		for(int i=0; i<n; i++){
			column.add(matriz[i][coluna]);
		}
		return column;
	}
	public List<T> diagonalPrincipal(){
		List<T> diagonal = new ArrayList<T>();
		for(int i=0; i<n; i++){
			for(int j =0; j<m; j++) {
				if(i==j) {
					diagonal.add(matriz[i][j]);
				}
			}
		}
		return diagonal;
	}
	
	public List<T> diagonalSecundaria(){
		List<T> diagonalsec = new ArrayList<T>();
		for(int i=0; i<n; i++){
			for(int j =0; j<m; j++) {
				if(i+j == m) {
					diagonalsec.add(matriz[i][j]);
				}
			}
		}
		return diagonalsec;
	}
	
}





