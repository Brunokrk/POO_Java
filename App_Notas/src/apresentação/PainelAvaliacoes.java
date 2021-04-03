package apresenta��o;

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
		JButton btnCdstDisci = new JButton("Cadastrar");
		JButton btnEditarDis = new JButton ("Editar");
		JButton btnDeleteDis = new JButton("Excluir");
		
		//Painel de Cadastro
		JPanel cadastro = new JPanel();
		cadastro.setBounds(5, 5, 200, 225);
		Border cdstBorder = BorderFactory.createLineBorder(Color.BLACK);
		cadastro.setBackground(Color.decode("#F0FFF0"));
		cadastro.setBorder(BorderFactory.createTitledBorder(cdstBorder, "Cadastrar Avalia��o"));
		cadastro.setLayout(null);
		add(cadastro);
		infoNomeLabel2.setBounds(10, 30, 50, 20);
		infoDataLabel2.setBounds(10, 60, 50, 20);
		infoPesoLabel2.setBounds(10, 90, 50, 20);
		infoNotaLabel2.setBounds(10, 120,50, 20);
		nomeField2.setBounds(60, 30, 120, 20);
		dataField2.setBounds(60, 60, 120, 20);
		notaField2.setBounds(60, 90, 120, 20);
		pesoField2.setBounds(60, 120, 120, 20);
		cadastro.add(infoNomeLabel2);
		cadastro.add(infoDataLabel2);
		cadastro.add(infoPesoLabel2);
		cadastro.add(infoNotaLabel2);
		cadastro.add(nomeField2);
		cadastro.add(notaField2);
		cadastro.add(dataField2);
		cadastro.add(pesoField2);
		btnCdstDisci.setBounds(10, 150, 180, 20);
		btnCdstDisci.setBackground(Color.WHITE);
		btnCdstDisci.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Funcionalidades do bot�o
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
		cadastro.add(btnCdstDisci);
		
		
		
		//Painel de atualiza��o
		JPanel atualizacao = new JPanel();
		atualizacao.setBounds(575, 5, 300, 225);
		atualizacao.setBackground(Color.decode("#F0FFF0"));
		atualizacao.setBorder(BorderFactory.createTitledBorder(cdstBorder, "Atualizar ou Excluir Avalia��o"));
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
		btnEditarDis.setBounds(10, 170, 280, 20);
		btnDeleteDis.setBounds(10, 195, 280, 20);
		atualizacao.add(nomeField);
		atualizacao.add(dataField);
		atualizacao.add(notaField);
		atualizacao.add(pesoField);
		atualizacao.add(infoNomeLabel);
		atualizacao.add(infoDataLabel);
		atualizacao.add(infoNotaLabel);
		atualizacao.add(infoPesoLabel);
		atualizacao.add(btnDeleteDis);
		atualizacao.add(btnEditarDis);
		
		
		
		//escolha do semestre em quest�o para opera��es
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
		
		//escolha da disciplina em quest�o
		infoDisciplinaSelec.setBounds(285,50,200,15);
		boxDisciplinas.setBounds(285, 70, 200, 20);
		boxDisciplinas.setBackground(Color.LIGHT_GRAY);
		boxDisciplinas.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					Disciplina aux = (Disciplina) e.getItem();
					//continuar, quando selecionar, mostrar avalia��es referentes
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
