package dados;

public class Quarto {
	private int codHotel;
	private int nroa; //codigo do quarto
	private int andar;
	
	//construtor 
	public Quarto(int _codHotel, int _nroa, int _andar) {
		this.codHotel = _codHotel;
		this.nroa = _nroa;
		this.andar= _andar;
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
	
	
	
}
