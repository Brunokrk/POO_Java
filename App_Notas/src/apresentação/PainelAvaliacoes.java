package apresenta��o;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PainelAvaliacoes extends JPanel{
	public PainelAvaliacoes() {
		setBackground(Color.decode("#F0FFF0"));
		
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
		setBorder(BorderFactory.createTitledBorder(lineBorder, "Gerenciador de Avalia��es"));
		
	}
}
