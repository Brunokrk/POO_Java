package ex4;

public enum TipoDia {
	SEGUNDA(new Util()), TERCA(new Util()), QUARTA(new Feriado()), QUINTA(new Util()), SEXTA(new FimDeSemana());
	
	private Dia tipoDia;
	
	private TipoDia(Dia tipoDia) {
		this.tipoDia = tipoDia;
	}
	
	public Dia getTipo() {
		return this.tipoDia;
	}
}
