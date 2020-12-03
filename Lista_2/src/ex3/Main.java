package ex3;

import ex2.*;

public class Main {
	private static Carro c1 = new Carro("rosa", "onix", "chevrolet");
	private static Carro c2 = new Carro("rosa", "onix", "chevrolet");
	private static Carro c3 = new Carro("onix", "chevrolet");
	
	private static Comida f1 = new Comida("Arroz", "300.30", "2.0", "200.0", "0.0");
	private static Comida f2 = new Comida("Lasanha", "600.0");
	
	private static Revista r1 = new Revista("Recreio", "Abril", "janeiro", "19,90");
	private static Revista r2;
	
	private static Livro l1 = new Livro("Bruno", "Livro A");
	private static Livro l2 = new Livro("Bruno", "Livro A", "Editora A");
	
	private static Pais p1;
	private static Pais p2;
	
	public static void main(String[] args) {
		manipulandoCarro();
		//manipulandoComida();
		//manipulandoLivro();
		//manipulandoPais(); 
		//manipulandoRevista();
	}
	
	public static void manipulandoCarro() {
		System.out.println(c1.equals(c2)); //retornará true se todos os atributos forem iguais
		System.out.println(c3.toString()); //Cor default = prateado
		c3.setCor("rosa"); //transformando c3 em um objeto igual aos outros
		System.out.println(c3.equals(c1));
		
		//Modificando todos os atributos de c1
		c1.setCor("Preto");
		c1.setModelo("Ka");
		c1.setMarca("ford");
		//Printando um atributo com get
		System.out.println(c1.getCor());
		
		//Modificando todos os atributos de c2
		c2.setCor("Preto Fosco");
		c2.setMarca("Honda");
		c2.setModelo("Civic");
		
		//Printando todas as instâncias
		System.out.println(c1.toString()+ "\n--------------");
		System.out.println(c2.toString()+ "\n--------------");
		System.out.println(c3.toString()+ "\n--------------");
	}
	
	public static void manipulandoComida() {
		System.out.println(f1.equals(f2)); //retornará true se todos os atributos forem iguais
		System.out.println(f1.toString()+"\n---------------");
		System.out.println(f2.toString()+"\n---------------");
	}
	
	public static void manipulandoLivro() {
		l1.setEditora("Editora A");
		System.out.println(l1.equals(l2));//retornará true se todos os atributos forem iguais
		System.out.println(l1.toString()+"\n---------------");
		System.out.println(l2.toString()+"\n---------------");
	}
	
	public static void manipulandoRevista() {
		r2.setEditora("aaabbccc");
		r2.setMes_publicacao("fevereiro");
		r2.setNome("dddeeefff");
		r2.setPreco("89,99");
		
		System.out.println(r2.equals(r1));//retornará true se todos os atributos forem iguais
		System.out.println(r1.toString()+"\n---------------");
		System.out.println(r2.toString()+"\n---------------");
	}
	
	public static void manipulandoPais() {
		p1.setArea("3000000 km^2");
		p1.setContinente("ALALALA");
		p1.setNome("AAbbCCddEf");
		p1.setPopulacao("200000000");
		
		p2.setArea("3000000 km^2");
		p2.setContinente("ALALALA");
		p2.setNome("AAbbCCddEf");
		p2.setPopulacao("200000000");
		
		System.out.println(p1.equals(p2));
		
		System.out.println(p1.toString()+"\n---------------");
		System.out.println(p2.toString()+"\n---------------");
		
	}
}

