package apresenta��o;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class AbasApp extends JTabbedPane{
	public AbasApp() {
		this.addTab("Semestres", new PainelSemestres());
		this.addTab("Disciplinas", new PainelDisciplinas());
		this.addTab("Avalia��es", new PainelAvaliacoes());
	}
}
