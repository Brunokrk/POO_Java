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

import dados.Avaliacao;
import dados.Disciplina;
import dados.Semestre;
import negocio.Sistema;

public class PainelAvaliacoes extends JPanel{
	public PainelAvaliacoes() {
		Sistema sistema = Sistema.getInstance();
		setBackground(Color.decode("#F0FFF0"));
		setLayout(null);
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
		setBorder(BorderFactory.createTitledBorder(lineBorder));
		
		JLabel infoSemestreSelec = new JLabel("Escolha o Semestre");
		JLabel infoDisciplinaSelec = new JLabel("Escolha a Disciplina");
		JComboBox<Semestre> boxSemestres = new JComboBox<Semestre>();
		JComboBox<Disciplina> boxDisciplinas = new JComboBox<Disciplina>();
		JComboBox<Avaliacao> boxAvaliacoes = new JComboBox<Avaliacao>();
		JLabel infoNomeLabel = new JLabel("Nome");
		JLabel infoDataLabel = new JLabel("Data");
		JLabel infoNotaLabel = new JLabel("Nota");
		JLabel infoPesoLabel = new JLabel("Peso");
		JLabel infoNomeLabel2 = new JLabel("Nome");
		JLabel infoDataLabel2 = new JLabel("Data");
		JLabel infoNotaLabel2 = new JLabel("Nota");
		JLabel infoPesoLabel2 = new JLabel("Peso");
		JTextField nomeField = new JTextField();
		JTextField dataField = new JTextField();
		JTextField notaField = new JTextField();
		JTextField pesoField = new JTextField();
		JTextField nomeField2 = new JTextField();
		JTextField dataField2 = new JTextField();
		JTextField notaField2 = new JTextField();
		JTextField pesoField2 = new JTextField();
		JButton btnCdstAva = new JButton("Cadastrar");
		JButton btnEditarAva = new JButton ("Editar");
		JButton btnDeleteAva = new JButton("Excluir");
		JButton btnAtualizarDados = new JButton("Refresh");
		
		btnAtualizarDados.setBounds(285, 190, 200, 20);
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
		
		//Painel de Cadastro
		JPanel cadastro = new JPanel();
		cadastro.setBounds(5, 5, 200, 225);
		Border cdstBorder = BorderFactory.createLineBorder(Color.BLACK);
		cadastro.setBackground(Color.decode("#F0FFF0"));
		cadastro.setBorder(BorderFactory.createTitledBorder(cdstBorder, "Cadastrar Avaliação"));
		cadastro.setLayout(null);
		add(cadastro);
		infoNomeLabel2.setBounds(10, 30, 50, 20);
		infoDataLabel2.setBounds(10, 60, 50, 20);
		infoPesoLabel2.setBounds(10, 90, 50, 20);
		infoNotaLabel2.setBounds(10, 120,50, 20);
		nomeField2.setBounds(60, 30, 120, 20);
		dataField2.setBounds(60, 60, 120, 20);
		notaField2.setBounds(60, 120, 120, 20);
		pesoField2.setBounds(60, 90, 120, 20);
		cadastro.add(infoNomeLabel2);
		cadastro.add(infoDataLabel2);
		cadastro.add(infoPesoLabel2);
		cadastro.add(infoNotaLabel2);
		cadastro.add(nomeField2);
		cadastro.add(notaField2);
		cadastro.add(dataField2);
		cadastro.add(pesoField2);
		btnCdstAva.setBounds(10, 150, 180, 20);
		btnCdstAva.setBackground(Color.WHITE);
		btnCdstAva.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Funcionalidades do botão
				//cadastrar Disciplina
				Semestre semestre = (Semestre)boxSemestres.getSelectedItem();
				Disciplina disciplina = (Disciplina)boxDisciplinas.getSelectedItem();
				Avaliacao av = new Avaliacao();
				av.setData(dataField2.getText());
				av.setNome(nomeField2.getText());
				av.setPeso(Double.parseDouble(pesoField2.getText()));
				av.setNota(Double.parseDouble(notaField2.getText()));
				sistema.cadastrarAvaliacao(semestre, disciplina, av);
				dataField2.setText("");
				notaField2.setText("");
				nomeField2.setText("");
				pesoField2.setText("");
				
			}
		});
		cadastro.add(btnCdstAva);
		
		
		
		//Painel de atualização
		JPanel atualizacao = new JPanel();
		atualizacao.setBounds(575, 5, 300, 225);
		atualizacao.setBackground(Color.decode("#F0FFF0"));
		atualizacao.setBorder(BorderFactory.createTitledBorder(cdstBorder, "Atualizar ou Excluir Avaliação"));
		atualizacao.setLayout(null);
		add(atualizacao);
		boxAvaliacoes.setBounds(10,20, 280, 20);
		boxAvaliacoes.setBackground(Color.LIGHT_GRAY);
		boxAvaliacoes.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					//preencher campos com dados da avaliacao
					Avaliacao av =(Avaliacao)boxAvaliacoes.getSelectedItem();
					nomeField.setText(av.getNome());
					dataField.setText(av.getData());
					pesoField.setText(String.valueOf(av.getPeso()));
					notaField.setText(String.valueOf(av.getNota()));
					
					
				}
			}
		});
		atualizacao.add(boxAvaliacoes);
		infoNomeLabel.setBounds(10, 50, 200, 20);
		infoDataLabel.setBounds(10, 80, 200, 20);
		infoNotaLabel.setBounds(10, 110, 200, 20);
		infoPesoLabel.setBounds(10, 140, 200, 20);
		nomeField.setBounds(60, 50, 200, 20);
		dataField.setBounds(60, 80, 200, 20);
		notaField.setBounds(60, 110, 200, 20);
		pesoField.setBounds(60, 140, 200, 20);
		btnEditarAva.setBounds(10, 170, 280, 20);
		btnEditarAva.setBackground(Color.WHITE);
		btnEditarAva.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Avaliacao avB = new Avaliacao();
				avB.setNome(nomeField.getText());
				avB.setData(dataField.getText());
				avB.setNota(Double.parseDouble(notaField.getText()));
				avB.setPeso(Double.parseDouble(pesoField.getText()));
				Avaliacao avA = (Avaliacao)boxAvaliacoes.getSelectedItem();
				Semestre semestre = (Semestre)boxSemestres.getSelectedItem();
				Disciplina disciplina = (Disciplina)boxDisciplinas.getSelectedItem();				
				sistema.editarAvaliacao(avA, avB, semestre, disciplina);
				int i = boxAvaliacoes.getSelectedIndex();
				boxAvaliacoes.removeItem(boxAvaliacoes.getSelectedItem());
				boxAvaliacoes.insertItemAt(avB,i);
			}
		});
		btnDeleteAva.setBounds(10, 195, 280, 20);
		btnDeleteAva.setBackground(Color.WHITE);
		btnDeleteAva.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Avaliacao av = (Avaliacao)boxAvaliacoes.getSelectedItem();
				Disciplina di = (Disciplina)boxDisciplinas.getSelectedItem();
				Semestre se = (Semestre)boxSemestres.getSelectedItem();
				sistema.excluirAvaliacao(se.getIdentificacao(), di.getCodDisciplina(), av.getNome());
				boxAvaliacoes.removeItem(boxAvaliacoes.getSelectedItem());
				nomeField.setText("");
				dataField.setText("");
				notaField.setText("");
				pesoField.setText("");
			}
			
		});
		atualizacao.add(nomeField);
		atualizacao.add(dataField);
		atualizacao.add(notaField);
		atualizacao.add(pesoField);
		atualizacao.add(infoNomeLabel);
		atualizacao.add(infoDataLabel);
		atualizacao.add(infoNotaLabel);
		atualizacao.add(infoPesoLabel);
		atualizacao.add(btnDeleteAva);
		atualizacao.add(btnEditarAva);
		
		
		
		//escolha do semestre em questão para operações
		infoSemestreSelec.setBounds(285, 5, 200, 15);
		add(infoSemestreSelec);
		for(Semestre s : sistema.getSemestres()) {
			boxSemestres.addItem(s);
		}
		boxSemestres.setBounds(285, 25, 200, 20);
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
		
		//escolha da disciplina em questão
		infoDisciplinaSelec.setBounds(285,50,200,15);
		boxDisciplinas.setBounds(285, 70, 200, 20);
		boxDisciplinas.setBackground(Color.LIGHT_GRAY);
		boxDisciplinas.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					Disciplina aux = (Disciplina) e.getItem();
					//continuar, quando selecionar, mostrar avaliações referentes
					boxAvaliacoes.removeAllItems();
					for (Avaliacao av : aux.getAvaliacoes()) {
						boxAvaliacoes.addItem(av);
					}
				}
			}
		});
		add(infoDisciplinaSelec);
		add(boxDisciplinas);
		
	}
}
