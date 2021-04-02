package apresentação;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import dados.Semestre;
import negocio.Sistema;


public class PainelSemestres extends JPanel {
	
	public PainelSemestres() {
		Sistema sistema = Sistema.getInstance();
		JTextField cadastroField = new JTextField();
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
		JLabel infoCadastroField = new JLabel("Cadastre um Semestre:");
		JLabel infoExclusaoField = new JLabel("Selecione o Semestre para excluir:");
		JLabel infoGerRelaField = new JLabel("Selecione o Semestre para gerar um Relatório");
		JComboBox<Semestre> boxSemestres = new JComboBox<Semestre>();
		//BoxSemestres box = BoxSemestres.getInstance();
		JButton btnCdstSem = new JButton("Cadastrar"); 
		JButton btnExclSem = new JButton("Excluir");
		JButton btnGerRela = new JButton("Gerar");
		JScrollPane painelScrollTabelaSemestres = new JScrollPane();
		JTable tabelaSemestres;
		TabelaSemestres itensTabSem = new TabelaSemestres();
		
		//JButton btnExclAll = new JButton("Limpar"); -> ideia caso sobre tempo
		
		
		setBackground(Color.decode("#F0FFF0"));
		setBorder(BorderFactory.createTitledBorder(lineBorder));
		setLayout(null);
		
		//Caixa de Texto para inserir nome do semestre
		infoCadastroField.setBounds(25, 25, 200, 15);
		add(infoCadastroField);
		cadastroField.setColumns(15);
		cadastroField.setBounds(25, 50, 200, 20);
		cadastroField.setBackground(Color.LIGHT_GRAY);
		add(cadastroField);
			//Botão para realizar o cadastro
		btnCdstSem.setBounds(250, 50, 100, 20);
		btnCdstSem.setBackground(Color.white);
		btnCdstSem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Funcionalidades do Botão
				//cadastrar semestre
				Semestre semestre = new Semestre();
				semestre.setIdentificacao(cadastroField.getText());
				sistema.cadastrarSemestre(semestre);
				Semestre nvSemestre = sistema.getSemestre(semestre.getIdentificacao());
				boxSemestres.addItem(nvSemestre);

				itensTabSem.adicionaSemestre();
			}
		});
		add(btnCdstSem);
		
		//Tabela dos semestres
		tabelaSemestres = new JTable(itensTabSem);
		painelScrollTabelaSemestres.setViewportView(tabelaSemestres);
		painelScrollTabelaSemestres.setBounds(500, 25, 200, 175);
		add(painelScrollTabelaSemestres);
	
		
		
		//Caixa de texto para excluir semestre
		infoExclusaoField.setBounds(25,125, 200, 15);
		add(infoExclusaoField);
		for (Semestre s : sistema.getSemestres()) {
			boxSemestres.addItem(s);
		}
		boxSemestres.setBounds(25, 150, 200, 20);
		boxSemestres.setBackground(Color.LIGHT_GRAY);
		add(boxSemestres);
			//Botão para realizar Exclusão
		btnExclSem.setBounds(250, 150, 100, 20);
		btnExclSem.setBackground(Color.white);
		btnExclSem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Funcionalidades do Botão Exclusão
				Semestre aux = (Semestre) boxSemestres.getSelectedItem();
				sistema.excluirSemestre(aux.getIdentificacao());
				boxSemestres.removeItem(boxSemestres.getSelectedItem());
			}
		});
		add(btnExclSem);
			
		//Relatórios
		infoGerRelaField.setBounds(465, 5, 270, 15);
		add(infoGerRelaField);
		btnGerRela.setBounds(500, 205, 200, 20);
		btnGerRela.setBackground(Color.WHITE);
		btnGerRela.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Funcionalidades do Botão Exclusão
				Semestre auxiliar = (Semestre)tabelaSemestres.getValueAt(tabelaSemestres.getSelectedRow(), tabelaSemestres.getSelectedColumn());
				sistema.gerarPDF(auxiliar.getIdentificacao());
			}
		});
		add(btnGerRela);
		
	}
	
}
