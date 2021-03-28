package ex4;

public class PratoBuffet {
	private Double peso;
	private TipoCliente tipoCliente;
	private TipoDia tipoDia;
	
	
	public Double calculaTotal() {
		return tipoCliente.getTipo().calculaFatorCliente(tipoDia.getTipo().calculaFatorDia(peso));
	}
	
	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public TipoDia getTipoDia() {
		return tipoDia;
	}

	public void setTipoDia(TipoDia tipoDia) {
		this.tipoDia = tipoDia;
	}
	
	
	
}
