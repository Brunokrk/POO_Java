package dados;

public class Suite extends Quarto{
	private int ncamas;
	private Double precoSuite = 670.30; //por noite
	public Suite(int _codHotel, int _nroa, int _andar, int _ncamas) {
		super(_codHotel, _nroa, _andar);
		this.ncamas = _ncamas;
	}
	public int getNcamas() {
		return ncamas;
	}
	public void setNcamas(int ncamas) {
		this.ncamas = ncamas;
	}
	@Override
	public String toString() {
		return "Suite, hotel: "+ super.getCodHotel()+ " Nroa: "+ super.getNroa() +" Andar: "+super.getAndar() ;
	}

}
