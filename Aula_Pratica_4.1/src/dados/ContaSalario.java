package dados;

public class ContaSalario extends ContaBancaria {
	
	private int cnpjEmpresa;
	
	public ContaSalario() {
		super();
	}
	
	
	public void setCnpjEmpresa(int cnpj) {
		this.cnpjEmpresa = cnpj;
	}
	public boolean depositar(float valor, int cnpjEmpresa) {
		if(cnpjEmpresa == this.cnpjEmpresa) {
			this.saldo += valor;
			return true;
		}
		return false;
	}
	
	@Override
	public String gerarExtrato() {
		return "Conta Salario: \n" + "CNPJ da Empresa: "+this.cnpjEmpresa+"\n"+super.gerarExtrato();
	}
	
	@Override
	public String toString() {
		return "Conta Salario: \n" + super.toString() + "\n"+ "CNPJ: "+this.cnpjEmpresa;
	}
}
