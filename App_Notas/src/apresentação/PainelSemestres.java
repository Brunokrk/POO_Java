package apresentação;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class PainelSemestres extends JPanel {
	public PainelSemestres() {
		JTextField cadastroField = new JTextField();
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
		JLabel infoCadastroField = new JLabel("Cadastre um Semestre:");
		JLabel infoExclusaoField = new JLabel("Selecione o Semestre para excluir:");
		
		
		setBackground(Color.decode("#F0FFF0"));
		setBorder(BorderFactory.createTitledBorder(lineBorder));
		setLayout(null);
		
		//Caixa de Texto para inserir nome do semestre
		infoCadastroField.setBounds(25, 25, 200, 15);
		add(infoCadastroField);
		cadastroField.setColumns(15);
		cadastroField.setBounds(25, 50, 200, 20);
		add(cadastroField);
		
		//Caixa de texto para excluir semestre
		infoExclusaoField.setBounds(25,100, 200, 15);
		add(infoExclusaoField);
		//A caixa de texto deve ser uma lista de seleção (aberta para baixo)
		
		
		//Criar Botão de Cadastro 
		
		
		
		
	}
}
