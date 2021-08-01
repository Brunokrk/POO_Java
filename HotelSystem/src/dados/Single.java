package dados;

public class Single extends Quarto{

	private Double precoSingle = 325.20; //por noite
	
	public Single(int _codHotel, int _nroa, int _andar) {
		super(_codHotel, _nroa, _andar);
	}

	@Override
	public String toString() {
		return "Single, hotel: "+ super.getCodHotel()+ " Nroa: "+ super.getNroa() +" Andar: "+super.getAndar() ;
	}
	
	
}
