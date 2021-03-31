package apresentação;
//Tela Principal -> JFrame

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Aplicativo extends JFrame {
	
	
	public static void main(String[] args) {
		Aplicativo frame = new Aplicativo();
		frame.setVisible(true);
		
	}
	
	public Aplicativo() {
		setTitle("Gerenciador de Notas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 900, 300);
		setResizable(false);
		this.add(new AbasApp());
		
		
		
		
		//pane.addTab("Semestres", null, painelSemestre, "Informações semestres");
		
	}
}
