package apresentação;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import persistencia.SemestreDAO;
import dados.Semestre;
import java.util.List;

public class BoxSemestres extends JPanel {
	private static BoxSemestres instance = null;
	private List<Semestre> semestres;
	public JComboBox<Semestre> boxSemestres = new JComboBox<Semestre>();
	
	
	private BoxSemestres() {
		
	}
	
	public static BoxSemestres getInstance() {
		if(instance == null) {
			instance =  new BoxSemestres();
		}
		return instance;
	}
	
	public void atualizaComboBox(List<Semestre> semestres) {
		Boolean flag = true;
		for (Semestre s : semestres) {
			for(Semestre s2 : this.semestres) {
				if(s.equals(s2)) {
					flag = false;
				}
			}
			if(flag == true) {
				boxSemestres.addItem(s);
			}
			flag = true;
		}
		
		this.semestres = semestres;
	}

	public void setSemestres(List<Semestre> semestres) {
		this.semestres = semestres;
	}
	
	
}
