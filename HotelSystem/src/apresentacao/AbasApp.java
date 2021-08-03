package apresentacao;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class AbasApp extends JTabbedPane{
	public AbasApp() {
		this.addTab("Cadastros", new PainelUm());
		
		this.addTab("Visualizações", new PainelDois());
		
	}
}