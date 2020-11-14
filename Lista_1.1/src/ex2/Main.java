package ex2;
import java.util.Scanner;

public class Main {
	
	private static Scanner leitor = new Scanner(System.in);
	public static void main(String[] args) { 
		System.out.println("Informe o número de linhas das matrizes");
		int m = Integer.parseInt(leitor.nextLine());
		System.out.println("Informe o número de colunas das matrizes");
		int n = Integer.parseInt(leitor.nextLine());
		Matriz matrizA = new Matriz(m,n);
		Matriz matrizB = new Matriz(m,n);
		Matriz multp = new Matriz(n,m);
		Matriz soma = new Matriz(m,n);
		
		matrizA.setMatriz();
		System.out.println("MATRIZ A:");
		matrizA.mostraMatriz();
		
		matrizB.setMatriz();
		System.out.println("MATRIZ B:");
		matrizB.mostraMatriz();
		
		System.out.println("Multiplicação:");
		multp.multiplicaMatrizes(multp, matrizA, matrizB);
		multp.mostraMatriz();
		
		System.out.println("Soma:");
		soma.somaMatrizes(soma, matrizA, matrizB);
		soma.mostraMatriz();
		
		System.out.println("=======Apenas celulas acima da diagonal principal=======");
		System.out.println("Multiplicação:");
		multp.mostraFormatado();
		System.out.println("Soma:");
		soma.mostraFormatado();
	}
	
		
	
}
