package apresentação;

import javax.swing.table.AbstractTableModel;

import dados.Semestre;
import negocio.Sistema;

public class TabelaSemestres extends AbstractTableModel{
	private Sistema sistema = Sistema.getInstance();
	private String[] colunas = {"Semestres"};

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {		
		return sistema.getSemestres().size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		
		return sistema.getSemestres().get(linha);
	}
	
	public String getColumnName(int column) {
		return colunas[column];
	}
	
	public void adicionaSemestre() {
		fireTableStructureChanged();
	}
	
	
	
}
