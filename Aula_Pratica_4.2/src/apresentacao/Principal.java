package apresentacao;

import java.util.Scanner;
import dados.*;
import negocio.*;

public class Principal {
	private static Scanner leitor= new Scanner(System.in);
	private static Sistema sistema =  new Sistema();
	
	public static Animal novoAnimalPadrao() {
		Animal animal = new Animal();
		System.out.println("Informe o nome do animal");
		animal.setNome(leitor.nextLine());
		System.out.println("Informe a especie do animal");
		animal.setEspecie(leitor.nextLine());
		System.out.println("Informe a altura do animal");
		animal.setAltura(leitor.nextFloat());
		System.out.println("Informe o comprimento do animal");
		animal.setComprimento(leitor.nextFloat());
		System.out.println("Informe a largura do animal");
		animal.setLargura(leitor.nextFloat());
		System.out.println("Informe a idade do animal");
		animal.setIdade(Integer.parseInt(leitor.nextLine()));
		System.out.println("Informe a cor do animal");
		animal.setCor(leitor.nextLine());
		
		return animal;
	}
	
	public static Peixe novoPeixe() {
		Peixe peixe = new Peixe();
		System.out.println("Informe a temperatura ideal do peixe");
		peixe.setTemperaturaIdeal(leitor.nextFloat());
		System.out.println("Informe a largura do peixe");
		peixe.setLargura(leitor.nextFloat());
		System.out.println("Informe a altura do peixe");
		peixe.setAltura(leitor.nextFloat());
		System.out.println("Informe o comprimento do peixe");
		peixe.setComprimento(leitor.nextFloat());
		
		return peixe;
	}
	
	public static void cadastrarAnimal() {
		System.out.println("Animal:");
		System.out.println("1 -> Padrão");
		System.out.println("2 -> Peixe");
		
		int escolha = Integer.parseInt(leitor.nextLine());
		
		switch(escolha) {
		case 1:
			sistema.cadastrarAnimais(novoAnimalPadrao());
			break;
		case 2: 
			sistema.cadastrarAnimais(novoPeixe());
			break;
		default:
			System.out.println("Escolha invalida!");
		}
	}
	
	public static Viveiro novoViveiroPadrao() {
		Viveiro viveiro = new Viveiro();
		
		System.out.println("Informe o nome do viveiro");
		viveiro.setNome(leitor.nextLine());
		System.out.println("Informe o comprimento do viveiro");
		viveiro.setComprimento(leitor.nextFloat());
		System.out.println("Informe a largura do viveiro");
		viveiro.setLargura(leitor.nextFloat());
		
		return viveiro;
	}
	
	public static Aquario novoAquario() {
		Aquario aquario = new Aquario();
		System.out.println("Informe o nome do aquario");
		aquario.setNome(leitor.nextLine());
		System.out.println("Informe o comprimento do aquario");
		aquario.setComprimento(leitor.nextFloat());
		System.out.println("Informe a largura do aquario");
		aquario.setLargura(leitor.nextFloat());
		System.out.println("Informe a altura do aquario");
		aquario.setAltura(leitor.nextFloat());
		System.out.println("Informe a temperatura do aquario");
		aquario.setTemperatura(leitor.nextFloat());
		
		return aquario;
	}
	
	public static void cadastrarViveiro() {
		System.out.println("Viveiro:");
		System.out.println("1 -> Padrão");
		System.out.println("2 -> Aquário");
		
		int escolha = Integer.parseInt(leitor.nextLine());
		
		switch(escolha) {
		case 1:
			sistema.cadastrarViveiro(novoViveiroPadrao());;
			break;
		case 2: 
			sistema.cadastrarViveiro(novoAquario());
			break;
		default:
			System.out.println("Escolha invalida!");
		}
	}
	
	public static void exibirViveiros() {
		for(int i=0; i<sistema.getNumViveiros(); i++) {
			System.out.println("Local--"+i+":\n"+sistema.getViveiros()[i].toString()+"\n");
		}
	}
	
	public static void exibirAnimais() {
		for(int i=0; i<sistema.getNumAnimais(); i++) {
			System.out.println("Animal--"+i+":\n"+sistema.getAnimais()[i].toString());
		}
	}
	
	public static Animal escolherAnimal() {
		exibirAnimais();
		System.out.println("Escolha um animal: ");
		int escolha = Integer.parseInt(leitor.nextLine());
		
		if(escolha < sistema.getNumAnimais()) {
			return sistema.getAnimais()[escolha];
		}
		return null;
	}
	
	public static Viveiro escolherViveiro() {
		exibirViveiros();
		System.out.println("Escolha um viveiro: ");
		int escolha = Integer.parseInt(leitor.nextLine());
		
		if(escolha < sistema.getNumViveiros()) {
			return sistema.getViveiros()[escolha];
		}
		return null;
	}
	
	public static void alocarAnimal() {
		Animal animal = escolherAnimal();
		Viveiro viveiro = escolherViveiro();
		
		boolean retorno = sistema.alocarAnimal(animal, viveiro);
		
		if (retorno == true) {
			System.out.println("Animal alocado com sucesso");
		}else {
			System.out.println("Animal não pode ser alocado");
		}
	}
	
	public static void imprimeMenu() {
		System.out.println("Escolha uma opçao");
		System.out.println("0-Sair");
		System.out.println("1-Cadastrar Animal");
		System.out.println("2-Cadastrar Viveiro");
		System.out.println("3-Alocar Animal");
	}
	
	public static void main(String[] args) {
		int opcao = -1;
		
		while(opcao != 0) {
			imprimeMenu();
			opcao = Integer.parseInt(leitor.nextLine());
			switch(opcao) {
			case 0:
				break;
			case 1:
				cadastrarAnimal();
				break;
			case 2:
				cadastrarViveiro();
				break;
			case 3:
				alocarAnimal();
				break;
			}
		
		}
	}
}
