package ex2;

import java.util.Random;

public class Matriz {
	public int m, n;
	public int matriz[][];
	private Random gerador = new Random();

	public Matriz(int m, int n) {
		this.m = m;
		this.n = n;
		this.matriz = new int[m][n]; 
	}
	
	public void setMatriz() {
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				this.matriz[i][j] = gerador.nextInt(10);
			}
		}
	}
	
	public int[][] getMatriz() {
		return this.matriz;
	}
	
	
	public void mostraMatriz() {
		for(int i=0; i<m;i++) {
			for(int j=0; j<n; j++) {
				System.out.print("["+this.matriz[i][j]+"]");
			}
			System.out.print("\n");
		}
	}
	
	public void multiplicaMatrizes(Matriz multp, Matriz a, Matriz b) {
		if(a.n == b.m) {
			for(int i=0; i<multp.m; i++) {
				for(int j=0; j<multp.n; j++) {
					for(int k = 0; k<a.n; k++) {
						multp.matriz[i][j]=multp.matriz[i][j] +(a.matriz[i][k] * b.matriz[k][j]);
					}
				}
			}
		}else {
			System.out.println("Não é possível multiplicar as matrizes");
		}
	}
	
	public void somaMatrizes(Matriz soma, Matriz a, Matriz b) {
		if((a.m==b.m)&&(a.n==b.n)) {
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					soma.matriz[i][j] = a.matriz[i][j] + b.matriz[i][j];
				}
			}
		}else {
			System.out.println("Não é possível somar as matrizes");
		}
	}
	
	public void mostraFormatado() {
		for(int i=0; i<m;i++) {
			for(int j=0; j<n; j++) {
				if(j>i) {
					System.out.print("["+this.matriz[i][j]+"]");
				}else {
					System.out.print("[ ]");
				}
			}
			System.out.print("\n");
		}
	}
}








