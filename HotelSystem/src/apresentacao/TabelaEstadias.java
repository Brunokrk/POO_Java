package apresentacao;

import javax.swing.table.AbstractTableModel;

import negocio.Sistema;

public class TabelaEstadias extends AbstractTableModel {
	private Sistema sistema = Sistema.getInstance();
	private String[] colunas = {"Reservas"};
	
	@Override
	public int getColumnCount() {
		return 1;
	}
	@Override
	public int getRowCount() {		
		return sistema.getReservas().size();
	}
	@Override
	public Object getValueAt(int linha, int coluna) {
		return sistema.getReservas().get(linha);
	}
	public String getColumnName(int column) {
		return colunas[column];
	}
	public void adicionaReserva() {
		fireTableStructureChanged();
	}
	
	
	
}

