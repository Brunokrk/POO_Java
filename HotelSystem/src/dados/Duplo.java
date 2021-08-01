package dados;

public class Duplo extends Quarto{

	private Double precoDuplo = 700.00; //por noite
	private int ncamas;
	public Duplo(int _codHotel, int _nroa, int _andar, int _ncamas) {
		super(_codHotel, _nroa, _andar);
		this.ncamas = _ncamas;
	}
	@Override
	public String toString() {
		return "Duplo, hotel: "+ super.getCodHotel()+ " Nroa: "+ super.getNroa() +" Andar: "+super.getAndar() ;
	}

}
