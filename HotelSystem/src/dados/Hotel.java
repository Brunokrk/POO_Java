package dados;

public class Hotel {
	private int codHotel;
	private String nome;
	private String cidade;
	private String estado;
	private String rua;
	private String bairro;
	private int numero;
	private int telefone;
	
	
	@Override
	public boolean equals (Object obj) {
		if(obj instanceof Hotel) {
			Hotel aux = (Hotel) obj;
			if(this.codHotel == aux.getCodHotel()) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}


	public int getCodHotel() {
		return codHotel;
	}


	public void setCodHotel(int codHotel) {
		this.codHotel = codHotel;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public int getTelefone() {
		return telefone;
	}


	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
	
}
