package apresentação;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class AbasApp extends JTabbedPane{
	public AbasApp() {
		this.addTab("Semestres", new PainelSemestres());
		this.addTab("Disciplinas", new PainelDisciplinas());
		this.addTab("Avaliações", new PainelAvaliacoes());
	}
}
