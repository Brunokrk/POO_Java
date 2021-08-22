package apresentacao;

import javax.swing.table.AbstractTableModel;

import negocio.Sistema;
import negocio.SistemaMongo;

public class TabelaEmpregados extends AbstractTableModel {
	private SistemaMongo sistemaMongo = SistemaMongo.getInstance();
	private String[] colunas = {"Empregados"};
	
	@Override
	public int getColumnCount() {
		return 1;
	}
	@Override
	public int getRowCount() {		
		return sistemaMongo.getEmpregados().size();
	}
	@Override
	public Object getValueAt(int linha, int coluna) {
		return sistemaMongo.getEmpregados().get(linha);
	}
	public String getColumnName(int column) {
		return colunas[column];
	}
	public void adicionaEmpregado() {
		fireTableStructureChanged();
	}
	
	
	
}
