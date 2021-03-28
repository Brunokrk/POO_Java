package ex4;

public enum TipoCliente {
	ESTUDANTE(new Estudante()), FUNCIONARIO(new Funcionario());
	
	private Cliente tipoCliente;
	
	private TipoCliente(Cliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	public Cliente getTipo() {
		return this.tipoCliente;
	}
}
