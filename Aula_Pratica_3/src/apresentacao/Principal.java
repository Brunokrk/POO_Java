package apresentacao;

import negocio.ReservaPassagem;
import java.util.Scanner;
import dados.Cliente;
import dados.Cidade;

public class Principal {
	
	private static Scanner leitor = new Scanner(System.in);
	private static ReservaPassagem reservaPassagem = new ReservaPassagem();
	
	public static void main(String[] args) {
		
		
	}
	
	public static void exibeMenu() {
		System.out.println("Escolha uma opção:");
		System.out.println("0 - Encerrar");
		System.out.println("1 - Realizar Reserva");
		System.out.println("2 - Cadastrar Cliente");
		System.out.println("3 - Mostrar Reservas");
		System.out.println("4 - Cadastrar Cidade");
	}
	
	public static void menuPrincipal() {
		int escolha = -1;
		while(escolha != 0) {
			exibeMenu();
			escolha = Integer.parseInt(leitor.next());
			switch(escolha) {
			case 1:
				System.out.println("Realizar Reserva");
				//fazerReserva();
				break;
			
			case 2:
				System.out.println("Cadastrar Cliente");
				cadastrarCliente();
				break;
			case 3:
				System.out.println("Mostrar Reservas");
				//mostrarReservas();
				break;
			default:
				System.out.println("Número Invalido");
				break;
			}
		}
	}
	
	public static Cliente novoCliente() {
		Cliente novo_cliente = new Cliente();
		System.out.println("Informe cpf do cliente: ");
		novo_cliente.setCpf(Integer.parseInt(leitor.nextLine()));
		System.out.println("Digite o nome do cliente: ");
		novo_cliente.setNome(leitor.nextLine());
		System.out.println("Digite o endereço do cliente: ");
		novo_cliente.setEndereco(leitor.nextLine());
		return novo_cliente;
	}
	
	public static void cadastrarCliente() {
		reservaPassagem.cadastrarCliente(novoCliente());
	}
	
	public static Cidade novoCidade() {
		Cidade novo_cidade = new Cidade();
		System.out.println("Informe nome da cidade: ");
		novo_cidade.setNome(leitor.nextLine());
		System.out.println("Informe estado da cidade: ");
		novo_cidade.setEstado(leitor.nextLine());
		
		return novo_cidade;
	}
	
	public static void cadastrarCidade() {
		reservaPassagem.cadastrarCidade(novoCidade());
	}
	
	
}
