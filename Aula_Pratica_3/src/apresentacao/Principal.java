package apresentacao;

import java.util.LinkedList;
import java.util.Scanner;
import negocio.ReservaPassagem;
import dados.*;

public class Principal {
	
	private static Scanner leitor = new Scanner(System.in);
	private static ReservaPassagem reservaPassagem = new ReservaPassagem();
	
	public static void main(String[] args) {
		menuPrincipal();
		
	}
	
	public static void exibeMenu() {
		System.out.println("Escolha uma opção:");
		System.out.println("0 - Encerrar");
		System.out.println("1 - Cadastrar Cliente");
		System.out.println("2 - Cadastrar Cidade");
		System.out.println("3 - Realizar Reserva");
		System.out.println("4 - Mostrar Reservas");
	}
	
	public static void menuPrincipal() {
		int escolha = -1;
		while(escolha != 0) {
			exibeMenu();
			escolha = Integer.parseInt(leitor.nextLine());
			switch(escolha) {
			case 1:
				System.out.println("Cadastrar Cliente");
				//Adiciona o cliente a lista de clientes de reservaPassagem
				cadastrarCliente();
				break;
			case 2:
				System.out.println("Cadastrar Cidade");
				//Adiciona a cidade a lista de cidades de reservaPassagem
				cadastrarCidade();
				break;
			case 3:
				System.out.println("Realizar Reserva");
				fazerReserva();
				break;
			case 4:
				System.out.println("Mostrar Reservas");
				mostrarReservas();
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
	
	public static Reserva novaReserva() {
		Reserva nova_reserva = new Reserva();
		System.out.println("------Origem-------");
		nova_reserva.setOrigem(novoCidade());
		System.out.println("------Destino------");
		nova_reserva.setDestino(novoCidade());
		System.out.println("-----Data Voo------");
		nova_reserva.setDataVoo(leitor.nextLine());
		System.out.println("-----Hora Voo------");
		nova_reserva.setHoraVoo(leitor.nextLine());
		System.out.println("-------Classe------");
		nova_reserva.setClasseVoo(leitor.nextLine());
		System.out.println("-----Poltrona------");
		nova_reserva.setPoltrona(Integer.parseInt(leitor.nextLine()));
		System.out.println("------Reserva------");
		nova_reserva.setNumReserva(Integer.parseInt(leitor.nextLine()));
		System.out.println("-------Preço-------");
		nova_reserva.setPreco(Float.parseFloat(leitor.nextLine()));
		System.out.println("-------------------");
		return nova_reserva;
	}
	
	public static void fazerReserva() {
		System.out.print("Informe o cpf do cliente que deseja fazer reserva: ");
		int cpf_aux = Integer.parseInt(leitor.nextLine());
		Reserva ida_aux;
		Cliente cliente_aux = reservaPassagem.getCliente(cpf_aux);
		if (cliente_aux != null) {
			System.out.println("Reservando Ida");
			ida_aux = novaReserva();
			reservaPassagem.reservaIda(cliente_aux, ida_aux);
			System.out.println("Deseja Reservar uma Volta? (s/n)");
			String choose = leitor.nextLine();
			if(choose.equals("s")) {
				Reserva volta_aux = novaReserva();
				System.out.println("Reservando volta");
				reservaPassagem.reservaVolta(cliente_aux, ida_aux, volta_aux);
				System.out.println("Reserva Feita");
			}else {
				System.out.println("Reserva Feita, *Sem volta*");
			}
		}else {
			System.out.println("Cliente não existe");
		}
	}
	
	public static void mostrarReservas() {
		System.out.print("Informe o cpf do cliente que deseja mostrar as reservas ");
		int cpf_aux = Integer.parseInt(leitor.nextLine());
		Cliente cliente_aux = reservaPassagem.getCliente(cpf_aux);
		for(int i=0; i<cliente_aux.qtd_reservas;i++) {
			System.out.println(cliente_aux.reservas[i].toString());
		}
	}
}
