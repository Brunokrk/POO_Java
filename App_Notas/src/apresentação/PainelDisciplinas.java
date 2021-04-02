package apresentação;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import dados.Disciplina;
import dados.Semestre;
import negocio.Sistema;

public class PainelDisciplinas extends JPanel {
	
	
	public PainelDisciplinas() {
		Sistema sistema = Sistema.getInstance();
		setBackground(Color.decode("#F0FFF0"));
		setLayout(null);
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
		setBorder(BorderFactory.createTitledBorder(lineBorder));
		
		JButton btnAtualizarDados = new JButton("Refresh");
		JLabel infoSemestreSelec = new JLabel("Escolha o Semestre");
		JComboBox<Semestre> boxSemestres = new JComboBox<Semestre>();
		JLabel infoNomeLabel = new JLabel("Nome");
		JLabel infoCodDLabel = new JLabel("Código");
		JLabel infoProfLabel = new JLabel("Professor");
		JLabel infoNomeLabel2 = new JLabel("Nome");
		JLabel infoCodDLabel2 = new JLabel("Código");
		JLabel infoProfLabel2 = new JLabel("Professor");
		JTextField nomeField = new JTextField();
		JTextField profField = new JTextField();
		JTextField codDField = new JTextField();
		JTextField nomeField2 = new JTextField();
		JTextField profField2 = new JTextField();
		JTextField codDField2 = new JTextField();
		JButton btnCdstDisci = new JButton("Cadastrar");
		JComboBox<Disciplina> boxDisciplinas = new JComboBox<Disciplina>();
		JButton btnSelectSem = new JButton("Selecionar");
		
		btnAtualizarDados.setBounds(345, 190, 200, 20);
		btnAtualizarDados.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<Semestre> aux = sistema.getSemestres();
				boxSemestres.removeAllItems();
				for(Semestre s : aux) {
					boxSemestres.addItem(s);
				}
			}
		});
		add(btnAtualizarDados);
		
		//painel de cadastro
		JPanel cadastro = new JPanel();
		cadastro.setBounds(5, 5, 200, 225);
		Border cdstBorder = BorderFactory.createLineBorder(Color.BLACK);
		cadastro.setBackground(Color.decode("#F0FFF0"));
		cadastro.setBorder(BorderFactory.createTitledBorder(cdstBorder, "Cadastrar Disciplina"));
		cadastro.setLayout(null);
		add(cadastro);
			//cadastrando nome
		infoNomeLabel.setBounds(10,20, 50, 20);
		cadastro.add(infoNomeLabel);
		nomeField.setBounds(70, 20, 120, 20);
		cadastro.add(nomeField);
			//cadastrando codigo
		infoCodDLabel.setBounds(10,50, 50, 20);
		cadastro.add(infoCodDLabel);
		codDField.setBounds(70, 50, 120, 20);
		cadastro.add(codDField);
			//cadastrando professor
		infoProfLabel.setBounds(10, 80, 100, 20);
		cadastro.add(infoProfLabel);
		profField.setBounds(70, 80, 120, 20);
		cadastro.add(profField);
			//botão cadastrar
		btnCdstDisci.setBounds(10, 110, 180, 20);
		btnCdstDisci.setBackground(Color.WHITE);
		btnCdstDisci.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Funcionalidades do botão
				//cadastrar Disciplina
				Semestre semestre = (Semestre)boxSemestres.getSelectedItem();
				Disciplina disciplina = new Disciplina();
				disciplina.setNome(nomeField.getText());
				disciplina.setCodDisciplina(codDField.getText());
				disciplina.setProfessor(profField.getText());
				sistema.cadastrarDisciplina(semestre, disciplina);
			}
		});
		cadastro.add(btnCdstDisci);
		
		
		//painel de atualização
		JPanel atualizacao = new JPanel();
		atualizacao.setBounds(675, 5, 200, 225);
		atualizacao.setBackground(Color.decode("#F0FFF0"));
		atualizacao.setBorder(BorderFactory.createTitledBorder(cdstBorder, "Atualizar ou Excluir Disciplina"));
		atualizacao.setLayout(null);
		add(atualizacao);
		boxDisciplinas.setBounds(10,20, 180, 20);
		infoNomeLabel2.setBounds(10,60, 50, 20);
		infoCodDLabel2.setBounds(10,90, 50, 20);
		infoProfLabel2.setBounds(10,120, 100, 20);
		nomeField2.setBounds(70, 60, 120, 20);
		codDField2.setBounds(70, 90, 120, 20);
		profField2.setBounds(70, 120, 120, 20);
		atualizacao.add(infoNomeLabel2);
		atualizacao.add(infoProfLabel2);
		atualizacao.add(infoCodDLabel2);
		atualizacao.add(nomeField2);
		atualizacao.add(codDField2);
		atualizacao.add(profField2);
		atualizacao.add(boxDisciplinas);
		
			//Exclusão de uma disciplina
			//Semestre aux = boxSemestres.getSelectedItem();
			//for(Disciplina d : boxSemestres.getS)
		
		
		//escolha do semestre em questão para operações
		infoSemestreSelec.setBounds(345, 5, 200, 15);
		add(infoSemestreSelec);
		for(Semestre s : sistema.getSemestres()) {
			boxSemestres.addItem(s);
		}
		boxSemestres.setBounds(345, 25, 200, 20);
		boxSemestres.setBackground(Color.LIGHT_GRAY);
		boxSemestres.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					Semestre aux = (Semestre) e.getItem();
					boxDisciplinas.removeAllItems();
					for(Disciplina d : aux.getDisciplinas()) {
						boxDisciplinas.addItem(d);
					}
				}
			}
		});
		add(boxSemestres);
		
	}
	
	
}
