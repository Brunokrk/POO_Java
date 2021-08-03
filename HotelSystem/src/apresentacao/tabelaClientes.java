package apresentacao;

import javax.swing.table.AbstractTableModel;

import negocio.Sistema;

public class tabelaClientes extends AbstractTableModel {
	private Sistema sistema = Sistema.getInstance();
	private String[] colunas = {"Clientes"};
	
	@Override
	public int getColumnCount() {
		return 1;
	}
	@Override
	public int getRowCount() {		
		return sistema.getClientes().size();
	}
	@Override
	public Object getValueAt(int linha, int coluna) {
		return sistema.getClientes().get(linha);
	}
	public String getColumnName(int column) {
		return colunas[column];
	}
	public void adicionaCliente() {
		fireTableStructureChanged();
	}
	
	
	
}
