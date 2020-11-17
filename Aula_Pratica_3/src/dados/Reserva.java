package dados;

public class Reserva {
	private int numReserva;
	private String dataVoo;
	private String horaVoo;
	private float preco;
	private String classeVoo;
	private boolean idaEvolta;
	private int poltrona;
	private Cidade origem;
	private Cidade destino;
	
	
	public void setNumReserva(int numReserva) {
		this.numReserva = numReserva;
	}
	public int getNumReserva() {
		return this.numReserva;
	}
	
	public void setDataVoo(String dataVoo) {
		this.dataVoo = dataVoo;
	}
	public String getDataVoo() {
		return this.dataVoo;
	}
	
	public void setHoraVoo(String horaVoo) {
		this.horaVoo = horaVoo;
	}
	public String getHoraVoo() {
		return this.horaVoo;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public float getPreco() {
		return this.preco;
	}
	
	public void setClasseVoo(String classeVoo) {
		this.classeVoo = classeVoo;
	}
	public String getClasseVoo() {
		return this.classeVoo;
	}
	
	public void setIdaEVolta(boolean idaEvolta) {
		this.idaEvolta = idaEvolta;
	}
	public boolean getIdaEVolta() {
		return this.idaEvolta;
	}
	
	public void setPoltrona(int poltrona) {
		this.poltrona = poltrona;
	}
	public int getPoltrona() {
		return this.poltrona;
	}
	
	public void setOrigem(Cidade origem) {
		this.origem = origem;
	}
	public Cidade getOrigem() {
		return this.origem;
	}

	public void setDestino(Cidade destino) {
		this.destino = destino;
	}
	public Cidade getDestino() {
		return this.destino;
	}
}
