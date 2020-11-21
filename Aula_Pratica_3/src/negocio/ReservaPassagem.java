package negocio;

import dados.*;
import java.util.LinkedList;
public class ReservaPassagem {
	private Cidade listaDeCidades []= new Cidade[20];
	private Cliente listaDeClientes [] = new Cliente[20];
	private int quantCidades;
	private int quantClientes;
	
	public void cadastrarCidade(Cidade cidade) {
		listaDeCidades[quantCidades] = cidade;
		quantCidades++;
	}
	
	public Cliente getCliente(int cpf_key) {
		int a = 0;
		for(int i=0; i<quantClientes; i++) {
			if(this.listaDeClientes[i].getCpf()==cpf_key) {
				return this.listaDeClientes[i];
			}
		}
		return null;
	}
	
	public void cadastrarCliente(Cliente cliente) {
		listaDeClientes[quantClientes]=cliente;
		quantClientes++;
	}
	
	public void reservaIda(Cliente cliente, Reserva reserva) {
		if(clienteCadastrado(cliente)) {
			cliente.reservarIda(reserva);
		}else {
			System.out.println("Cliente nao cadastrado");
		}
	}
	
	public void reservaVolta(Cliente cliente, Reserva ida, Reserva volta) {
		if(clienteCadastrado(cliente)) {
			cliente.reservarVolta(ida, volta);
		}else {
			System.out.println("Cliente nao cadastrado");
		}
	}
	
	private boolean clienteCadastrado(Cliente cliente) {
		//Apenas vai retornar true se o cpf for igual
		for(int i=0; i<quantClientes;i++) {
			if(listaDeClientes[i].getCpf() == cliente.getCpf()) {
				return true;
			}
		}
		return false;
	}
	
	public Reserva[] mostrarReservas(int cpf) {
		for(int i=0; i<quantClientes;i++) {
			if(listaDeClientes[i].getCpf()==cpf) {
				return listaDeClientes[i].getReservas();
			}
		}
		return null;
	}
	
	public Cidade[] mostrarCidades() {
		return listaDeCidades;
	}
	
	public Cliente[] mostrarClientes() {
		return listaDeClientes;
	}
}
