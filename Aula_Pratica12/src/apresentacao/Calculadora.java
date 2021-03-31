package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Calculadora extends JFrame {

	private JPanel painel = new JPanel();

	private JPanel painelEntrada = new JPanel();
	private JScrollPane painelScrollTabelaResultados = new JScrollPane();
	private JScrollPane paineScrollTabelaValores = new JScrollPane();

	private JLabel infoCaixaTexto = new JLabel("Digite um valor:");
	private JTextField caixaTexto = new JTextField();
	private JButton botaoLimpar = new JButton("limpar");
	private JButton botaoAdicionar = new JButton("adicionar");

	private JTable tabelaResultados;
	private JTable tabelaValores;

	private TabelaResultados resultados = new TabelaResultados();
	private TabelaValores valores = new TabelaValores();

	public static void main(String[] args) {
		Calculadora frame = new Calculadora();
		frame.setVisible(true);
	}

	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 300);

		setTitle("Calculadora Estatística");
		setContentPane(painel);
		painel.setLayout(null);

		painelEntrada.setBounds(15, 80, 280, 173);
		painelEntrada.setLayout(null);
		painel.add(painelEntrada);

		infoCaixaTexto.setBounds(30, 30, 200, 15);
		painelEntrada.add(infoCaixaTexto);

		caixaTexto.setBounds(30, 50, 200, 20);
		caixaTexto.setColumns(10);
		painelEntrada.add(caixaTexto);

		botaoAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valores.adicionaValor(Integer.parseInt(caixaTexto.getText()));
				resultados.atualizar();
				caixaTexto.setText("");
			}
		});

		botaoAdicionar.setBounds(77, 94, 117, 25);
		painelEntrada.add(botaoAdicionar);

		botaoLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valores.limpar();
				resultados.atualizar();
			}
		});

		botaoLimpar.setBounds(77, 136, 117, 25);
		painelEntrada.add(botaoLimpar);

		painelScrollTabelaResultados.setBounds(10, 10, 880, 50);
		painel.add(painelScrollTabelaResultados);

		tabelaResultados = new JTable(resultados);
		painelScrollTabelaResultados.setViewportView(tabelaResultados);

		paineScrollTabelaValores.setBounds(307, 80, 173, 173);
		painel.add(paineScrollTabelaValores);

		tabelaValores = new JTable(valores);
		paineScrollTabelaValores.setViewportView(tabelaValores);

	}
}