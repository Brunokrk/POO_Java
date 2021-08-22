package dados;

import org.bson.types.ObjectId;

public class QuartoMongo {
	private ObjectId idMongo;
	private int codHotel;
	private int nroa; //codigo do quarto
	private int andar;
	private String tipo;
	private Double preco;
	private int ncamas;
	
	//construtor 
	public QuartoMongo() {
	}
	
	public QuartoMongo(int _codHotel, int _nroa, int _andar) {
		this.codHotel = _codHotel;
		this.nroa = _nroa;
		this.andar= _andar;
	}
	
	
	
	public ObjectId getIdMongo() {
		return idMongo;
	}

	public void setIdMongo(ObjectId idMongo) {
		this.idMongo = idMongo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getNcamas() {
		return ncamas;
	}

	public void setNcamas(int ncamas) {
		this.ncamas = ncamas;
	}

	public int getCodHotel() {
		return codHotel;
	}
	public void setCodHotel(int codHotel) {
		this.codHotel = codHotel;
	}
	public int getNroa() {
		return nroa;
	}
	public void setNroa(int nroa) {
		this.nroa = nroa;
	}
	public int getAndar() {
		return andar;
	}
	public void setAndar(int andar) {
		this.andar = andar;
	}
	@Override
	public String toString() {
		
		
		return "Hotel=" + codHotel + ", nroa=" + nroa + ", andar=" + andar ;
	}
}
