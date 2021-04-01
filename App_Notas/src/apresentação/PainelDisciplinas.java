package apresentação;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import dados.Semestre;

public class PainelDisciplinas extends JPanel {
	public PainelDisciplinas() {
		setBackground(Color.decode("#F0FFF0"));
		setLayout(null);
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
		setBorder(BorderFactory.createTitledBorder(lineBorder));
		
		JLabel infoSemestreSelec = new JLabel("Escolha o Semestre");
		JComboBox<Semestre> boxSemestres = new JComboBox<Semestre>();
		
		//painel de cadastro
		JPanel cadastro = new JPanel();
		cadastro.setBounds(5, 5, 200, 225);
		Border cdstBorder = BorderFactory.createLineBorder(Color.BLACK);
		cadastro.setBackground(Color.decode("#F0FFF0"));
		cadastro.setBorder(BorderFactory.createTitledBorder(cdstBorder, "Cadastrar Disciplina"));
		cadastro.setLayout(null);
		add(cadastro);
		
		//painel de atualização
		JPanel atualizacao = new JPanel();
		atualizacao.setBounds(675, 5, 200, 225);
		atualizacao.setBackground(Color.decode("#F0FFF0"));
		atualizacao.setBorder(BorderFactory.createTitledBorder(cdstBorder, "Atualizar Disciplina"));
		atualizacao.setLayout(null);
		add(atualizacao);
		
		//escolha do semestre em questão para operações
		infoSemestreSelec.setBounds(385, 5, 200, 15);
		add(infoSemestreSelec);
		
	}
}
