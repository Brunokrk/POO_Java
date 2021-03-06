package dados;

import java.util.LinkedList;

public class Cliente {
	private int cpf;
	private String nome;
	private String endereco;
	private int telefone;
	public Reserva reservas[] = new Reserva[20];
	public int qtd_reservas=0;
	
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getCpf() {
		return this.cpf;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public int getTelefone() {
		return this.telefone;
	}
	
	public String toString() {
		return "Nome: "+this.nome+"\n CPF: "+this.cpf+"\n Telefone: "+this.telefone+"\n Endereco: "+this.endereco;
	}
	
	public Reserva[] getReservas(){
		return this.reservas;
	}
	
	public void reservarIda(Reserva reserva) {
		//este seja apenas para idas
		this.reservas[qtd_reservas]= reserva;
		this.qtd_reservas++;
	}
	
	public void reservarVolta(Reserva ida, Reserva volta) {
		//Supondo que este m�todo seja para reservas ida E volta
		ida.setVolta(volta);
	}
	
	public boolean equals(Object o) {
		if(o instanceof Cliente) {
			Cliente c = (Cliente)o;
			if (c.getCpf() == this.getCpf()) {
				return true;
			}
		}
		return false;
	}
}
