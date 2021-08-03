package apresentacao;

import javax.swing.table.AbstractTableModel;

import negocio.Sistema;

public class TabelaEmpregados extends AbstractTableModel {
	private Sistema sistema = Sistema.getInstance();
	private String[] colunas = {"Empregados"};
	
	@Override
	public int getColumnCount() {
		return 1;
	}
	@Override
	public int getRowCount() {		
		return sistema.getEmpregados().size();
	}
	@Override
	public Object getValueAt(int linha, int coluna) {
		return sistema.getEmpregados().get(linha);
	}
	public String getColumnName(int column) {
		return colunas[column];
	}
	public void adicionaEmpregado() {
		fireTableStructureChanged();
	}
	
	
	
}
