package dados;

public class Estadia {
	
	private int codestadia;
	private String checkin;
	private String checkout;
	private Double valorextra; //função no banco calcula
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
