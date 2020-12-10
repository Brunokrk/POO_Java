package Principal;

public class Bicicleta extends Veiculo {
	private int numeroMarchas;

	public int getNumeroMarchas() {
		return numeroMarchas;
	}

	public void setNumeroMarchas(int numeroMarchas) {
		this.numeroMarchas = numeroMarchas;
	}
	
	public String info() {
		return "\nBicicleta\n" + "Cor: "+this.getCor()+"\nNumero de marchas: "+this.numeroMarchas+"\n";
	}
	
	
}
