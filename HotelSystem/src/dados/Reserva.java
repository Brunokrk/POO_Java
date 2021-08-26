package dados;

import org.bson.types.ObjectId;

public class Reserva {
	private ObjectId idmongo;
	private int codreserva;
	private int nroa;//quarto
	private int codestadia;
	private String diaentrada;
	private String diareserva;
	private int codcliente;
	
	public Reserva() {
		
	}
	
	public Reserva(int codReserva, int nroa, int codestadia, String diaentrada, String diareserva, int codcliente) {
		this.codreserva = codReserva;
		this.nroa = nroa;
		this.codestadia = codestadia;
		this.diaentrada = diaentrada;
		this.diareserva = diareserva;
		this.codcliente = codcliente;
	}
	
	public ObjectId getIdmongo() {
		return idmongo;
	}

	public void setIdmongo(ObjectId idmongo) {
		this.idmongo = idmongo;
	}

	public int getCodreserva() {
		return codreserva;
	}
	public void setCodreserva(int codreserva) {
		this.codreserva = codreserva;
	}
	public int getNroa() {
		return nroa;
	}
	public void setNroa(int nroa) {
		this.nroa = nroa;
	}
	public int getCodestadia() {
		return codestadia;
	}
	public void setCodestadia(int codestadia) {
		this.codestadia = codestadia;
	}
	public String getDiaentrada() {
		return diaentrada;
	}
	public void setDiaentrada(String diaentrada) {
		this.diaentrada = diaentrada;
	}
	public String getDiareserva() {
		return diareserva;
	}
	public void setDiareserva(String diareserva) {
		this.diareserva = diareserva;
	}
	public int getCodcliente() {
		return codcliente;
	}
	public void setCodcliente(int codcliente) {
		this.codcliente = codcliente;
	}

	@Override
	public String toString() {
		return " " + codreserva + ": Quarto " + nroa;
	}
	
	
}
