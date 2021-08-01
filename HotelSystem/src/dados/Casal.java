package dados;

public class Casal extends Quarto{

	private Double precoCasal = 900.20; //por noite
	private int ncamas;
	
	public Casal(int _codHotel, int _nroa, int _andar, int _ncamas) {
		super(_codHotel, _nroa, _andar);
		this.ncamas = _ncamas;
	}

	@Override
	public String toString() {
		return "Casal, hotel: "+ super.getCodHotel()+ " Nroa: "+ super.getNroa() +" Andar: "+super.getAndar() ;
	}
	
}
