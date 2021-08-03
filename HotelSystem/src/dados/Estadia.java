package dados;

public class Estadia {
	
	private int codestadia;
	private String checkin;
	private String checkout;
	private Double valorextra; //função no banco calcula
	private int codcliente;
	private int nroa;
	
	public Estadia() {
		
	}
	public Estadia(int codestadia, String checkin, String checkout, Double valorextra, int codcliente, int nroa) {
		this.codestadia = codestadia;
		this.checkin = checkin;
		this.checkout = checkout;
		this.valorextra = valorextra;
		this.codcliente = codcliente;
		this.nroa = nroa;
	}
	
	
	public int getNroa() {
		return nroa;
	}
	public void setNroa(int nroa) {
		this.nroa = nroa;
	}
	public int getCodcliente() {
		return codcliente;
	}
	public void setCodcliente(int codcliente) {
		this.codcliente = codcliente;
	}
	public int getCodestadia() {
		return codestadia;
	}
	public void setCodestadia(int codestadia) {
		this.codestadia = codestadia;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public Double getValorextra() {
		return valorextra;
	}
	public void setValorextra(Double valorextra) {
		this.valorextra = valorextra;
	}
	
	
}
