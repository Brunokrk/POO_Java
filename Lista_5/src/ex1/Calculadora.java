package ex1;

import java.util.Scanner;

public class Calculadora {
	
	private static Scanner s = new Scanner(System.in);
	private static Idioma e  = new Espanhol();
	private static Idioma pt = new Portugues();
	private static Idioma i = new Ingles();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//executar(e);
		//executar(pt);
		executar(i);
		
	}
	
	public static void somar(Idioma aux) {
		System.out.println(aux.requisitarValor());
		int x =Integer.parseInt(s.nextLine());
		System.out.println(aux.requisitarValor());
		int y =Integer.parseInt(s.nextLine());
		System.out.println(aux.somarValores(x, y));
	}
	
	public static void multiplicar(Idioma aux) {
		System.out.println(aux.requisitarValor());
		int x =Integer.parseInt(s.nextLine());
		System.out.println(aux.requisitarValor());
		int y =Integer.parseInt(s.nextLine());
		System.out.println(aux.multiplicarValores(x, y));
	}
	
	public static void mmc(Idioma aux) {
		System.out.println(aux.requisitarValor());
		int x =Integer.parseInt(s.nextLine());
		System.out.println(aux.requisitarValor());
		int y =Integer.parseInt(s.nextLine());
		System.out.println(aux.mmcValores(x, y));
	}
	
	public static void executar(Idioma aux) {
		System.out.println(aux.boasVindas());
		somar(aux);
		multiplicar(aux);
		mmc(aux);
		System.out.println(aux.finalizar());
	}
}
