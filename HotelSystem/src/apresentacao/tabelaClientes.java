package apresentacao;

import javax.swing.table.AbstractTableModel;

import negocio.Sistema;
import negocio.SistemaMongo;

public class tabelaClientes extends AbstractTableModel {
	private SistemaMongo sistemaMongo = SistemaMongo.getInstance();
	private String[] colunas = {"Clientes"};
	
	@Override
	public int getColumnCount() {
		return 1;
	}
	@Override
	public int getRowCount() {		
		return sistemaMongo.getClientes().size();
	}
	@Override
	public Object getValueAt(int linha, int coluna) {
		return sistemaMongo.getClientes().get(linha);
	}
	public String getColumnName(int column) {
		return colunas[column];
	}
	public void adicionaCliente() {
		fireTableStructureChanged();
	}
	
	
	
}
