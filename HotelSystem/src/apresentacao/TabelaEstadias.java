package apresentacao;

import javax.swing.table.AbstractTableModel;

import negocio.Sistema;
import negocio.SistemaMongo;

public class TabelaEstadias extends AbstractTableModel {
	private SistemaMongo sistemaMongo = SistemaMongo.getInstance();
	private String[] colunas = {"Estadias"};
	
	@Override
	public int getColumnCount() {
		return 1;
	}
	@Override
	public int getRowCount() {		
		return sistemaMongo.getEstadias().size();
	}
	@Override
	public Object getValueAt(int linha, int coluna) {
		return sistemaMongo.getEstadias().get(linha);
	}
	public String getColumnName(int column) {
		return colunas[column];
	}
	public void adicionaEstadia() {
		fireTableStructureChanged();
	}
	
	
	
}

