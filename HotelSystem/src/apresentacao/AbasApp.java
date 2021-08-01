package apresentacao;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class AbasApp extends JTabbedPane{
	public AbasApp() {
		this.addTab("Clientes", new PainelUm());
		
		//this.addTab("Disciplinas", new PainelDisciplinas());
		//this.addTab("Avaliações", new PainelAvaliacoes());
	}
}