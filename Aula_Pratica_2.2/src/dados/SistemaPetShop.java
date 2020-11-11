package dados;
import java.util.Scanner;

public class SistemaPetShop {
	private Veterinario[] veterinarios = new Veterinario[50];
	private int qtdVet;
	private Scanner leitor = new Scanner(System.in);
	
	public void cadastrarVeterinario() {
		Veterinario aux = new Veterinario();
		
		System.out.println("Qual o nome do novo Veterinário?");
		aux.setNome(leitor.nextLine());
		System.out.println("Qual o salário do novo Veterinário?");
		aux.setSalario(Integer.parseInt(leitor.nextLine()));
		veterinarios[qtdVet] = aux;
		this.qtdVet++;
		
	}
	
	public void mostrarVeterinarios() {
		System.out.println("-----------------------------------------------------------");
		for(int i=0; i<this.qtdVet; i++) {
			System.out.println("Identificação: "+ i);
			System.out.println("Veterinário: "+ veterinarios[i].getNome()+"\n");
		}
		System.out.println("-----------------------------------------------------------");
	}
	
	public void cadastrarEnderecoVeterinario() {
		mostrarVeterinarios();
		System.out.println("Deseja cadastrar o endereço de qual veterinário? ");
		int escolha = Integer.parseInt(leitor.nextLine());
		Endereco aux = new Endereco();
		//definir endereco
		System.out.println("Rua: ");
		aux.setRua(leitor.nextLine());
		System.out.println("Número: ");
		aux.setNumero(Integer.parseInt(leitor.nextLine()));
		System.out.println("Bairro: ");
		aux.setBairro(leitor.nextLine());
		System.out.println("Cidade: ");
		aux.setCidade(leitor.nextLine());
		System.out.println("CEP: ");
		aux.setCep(Integer.parseInt(leitor.nextLine()));
		veterinarios[escolha].setEndereco(aux);
	}
	
	public void cadastrarAnimal() {
		mostrarVeterinarios();
		System.out.println("Deseja cadastrar os animais de qual veterinário? ");
		int escolha = Integer.parseInt(leitor.nextLine());
		//
		Animal aux = new Animal();
		System.out.println("Informe o nome do animalzinho: ");
		aux.setNome(leitor.nextLine());
		System.out.println("Informe a espécie do mesmo: ");
		aux.setNome(leitor.nextLine());
		System.out.println("Informe uma descrição: ");
		aux.setDescricao(leitor.nextLine());
		veterinarios[escolha].setAnimal(aux);
	}
	
	public void mostrarAnimais() {
		mostrarVeterinarios();
		System.out.println("Deseja visualizar os animais atendidos por qual veterinário? ");
		int a = Integer.parseInt(leitor.nextLine());
		for(int i = 0; i < veterinarios[a].getQtdAnimais(); i++){
			System.out.println("Identificação: " + i);
			System.out.println("Animal: "+ veterinarios[a].getAnimal(i));
		}
	}
	
	public void cadastrarDono() {
		mostrarVeterinarios();
		System.out.println("Deseja visualizar os animais atendidos por qual veterinário? ");
		int a = Integer.parseInt(leitor.nextLine());
		for(int i = 0; i < veterinarios[a].getQtdAnimais(); i++){
			System.out.println("Identificação: " + i);
			System.out.println("Animal: "+ veterinarios[a].getAnimal(i));
		}
		System.out.println("Deseja cadastrar o dono de qual animal?");
		int escolha = Integer.parseInt(leitor.nextLine());
		Dono aux = new Dono();
		System.out.println("Informe o nome do dono");
		aux.setNome(leitor.nextLine());
		System.out.println("Informe o CPF do dono");
		aux.setCpf(leitor.nextLine());
		//Fazendo o Cadastro
		veterinarios[a].animais[escolha].setDono(aux);
	}
	
	public void cadastrarEnderecoDono() {
		mostrarVeterinarios();
		System.out.println("Deseja visualizar os animais atendidos por qual veterinário? ");
		int a = Integer.parseInt(leitor.nextLine());
		for(int i = 0; i < veterinarios[a].getQtdAnimais(); i++){
			System.out.println("Identificação: " + i);
			System.out.println("Animal: "+ veterinarios[a].getAnimal(i));
		}
		System.out.println("Deseja cadastrar o endereço do dono de qual animal?");
		int escolha = Integer.parseInt(leitor.nextLine());
		Endereco aux = new Endereco();
		System.out.println("Rua: ");
		aux.setRua(leitor.nextLine());
		System.out.println("Numero: ");
		aux.setNumero(Integer.parseInt(leitor.nextLine()));
		System.out.println("Bairro: ");
		aux.setBairro(leitor.nextLine());
		System.out.println("CEP: ");
		aux.setCep(Integer.parseInt(leitor.nextLine()));
		
		veterinarios[a].animais[escolha].d.setEndereco(aux);
	}
	
}
