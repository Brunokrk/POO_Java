package apresentacao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dados.*;
import negocio.Sistema;

public class PainelUm extends JPanel{

	
	public PainelUm() {
		Sistema sistema = Sistema.getInstance();
		
		JComboBox<Reserva> boxReservas = new JComboBox<Reserva>();
		JComboBox<Empregado> boxEmpregados = new JComboBox<Empregado>();
		JComboBox<Quarto> boxQuartos = new JComboBox<Quarto>();
		JComboBox<tipoServico> boxTipos = new JComboBox<tipoServico>();
		
		JTextField nomeField = new JTextField();
		JTextField regField = new JTextField();
		JTextField telField = new JTextField();
		JTextField estadoField = new JTextField();
		JTextField cidadeField = new JTextField();
		JTextField bairroField = new JTextField();
		JTextField ruaField = new JTextField();
		JTextField codLimpezaField = new JTextField();
		JTextField codReservaField = new JTextField();
		JTextField nRegEmpField = new JTextField();
		JTextField tempoField = new JTextField();
		JTextField checkInField = new JTextField();
		JTextField checkOutField = new JTextField();
		JTextField codClienteField = new JTextField();
		JTextField codEstadiaField = new JTextField();
		JTextField diaReservaField = new JTextField();
		JTextField diaEntradaField = new JTextField();
		JTextField codEstadiaEx = new JTextField();
		JTextField diaEx = new JTextField();
		JTextField horaEx = new JTextField();
		
		JLabel tituloCli = new JLabel ("Cadastro de Cliente");
		JLabel infoNomeField = new JLabel("Nome: ");
		JLabel infoRegField = new JLabel("CPF: ");//registro
		JLabel infoTelField = new JLabel("Telefone: ");
		JLabel infoEstadoField = new JLabel("Estado: ");
		JLabel infoCidadeField = new JLabel("Cidade: ");
		JLabel infoBairroField = new JLabel("Bairro: ");
		JLabel infoRuaField = new JLabel("Rua: ");
		JLabel tituloLimpeza =  new JLabel ("Cadastro de Limpeza");
		JLabel infoRegEmpField = new JLabel("Selecione o Empregado");
		JLabel infoTempoField = new JLabel("Informe o tempo do serviço");
		JLabel infoReservaFiedl = new JLabel("Selecione a Reserva ");
		JLabel tituloCheckIn = new JLabel("Cadastro de Estadia");
		JLabel infoCheckInField = new JLabel("Informe data do check-in");
		JLabel infoCheckOutField = new JLabel("Informe data do check-out");
		JLabel tituloCdstReserva = new JLabel("Cadastro de Reserva");
		JLabel infoCodCliente = new JLabel("Código do cliente");
		JLabel infoCodEstadia = new JLabel("Código da estadia");
		JLabel infoDiaReserva = new JLabel("Dia da reserva");
		JLabel infoDiaEntrada = new JLabel("Dia do pagamento");
		JLabel infoBoxQuartos = new JLabel("Selecione o quarto");
		JLabel tituloExtra = new JLabel("Adicionando um Extra");
		JLabel tituloBoxTipo = new JLabel("Selecione o serviço");
		JLabel infoCodEstadiaEx = new JLabel("Código da estadia");
		JLabel infodiaEx = new JLabel("Dia do serviço");
		JLabel infohoraEx = new JLabel("Horário do serviço");
		
		
		JButton btnCdstCli =  new JButton("Cadastrar");
		JButton btnCdstLim =  new JButton("Cadastrar");
		JButton btnCdstEst =  new JButton("Cadastrar");
		JButton btnCdstRes =  new JButton("Cadastrar");
		JButton btnCdstEx = new JButton("Cadastrar");
		
		setLayout(null);
		
		tituloCli.setBounds(25, 5, 200, 15);
		add(tituloCli);
		
		//NOME
		infoNomeField.setBounds(25, 30, 200, 15);
		add(infoNomeField);
		nomeField.setColumns(15);
		nomeField.setBounds(25, 55, 200, 20);
		nomeField.setBackground(Color.LIGHT_GRAY);
		add(nomeField);
		
		//REGISTRO
		infoRegField.setBounds(25, 80, 200, 15);
		add(infoRegField);
		regField.setColumns(15);
		regField.setBounds(25, 105, 200, 20);
		regField.setBackground(Color.LIGHT_GRAY);
		add(regField);
		
		//TELEFONE
		infoTelField.setBounds(25, 130, 200, 15);
		add(infoTelField);
		telField.setColumns(15);
		telField.setBounds(25, 155, 200, 20);
		telField.setBackground(Color.LIGHT_GRAY);
		add(telField);
		
		//ESTADO
		infoEstadoField.setBounds(25, 180, 200, 15);
		add(infoEstadoField);
		estadoField.setColumns(15);
		estadoField.setBounds(25, 205, 200, 20);
		estadoField.setBackground(Color.LIGHT_GRAY);
		add(estadoField);
		
		//CIDADE
		infoCidadeField.setBounds(25, 230, 200, 15);
		add(infoCidadeField);
		cidadeField.setColumns(15);
		cidadeField.setBounds(25, 255, 200, 20);
		cidadeField.setBackground(Color.LIGHT_GRAY);
		add(cidadeField);
		
		//BAIRRO
		infoBairroField.setBounds(25, 280, 200, 15);
		add(infoBairroField);
		bairroField.setColumns(15);
		bairroField.setBounds(25, 305, 200, 20);
		bairroField.setBackground(Color.LIGHT_GRAY);
		add(bairroField);
		
		//RUA
		infoRuaField.setBounds(25, 330, 200, 15);
		add(infoRuaField);
		ruaField.setColumns(15);
		ruaField.setBounds(25, 355, 200, 20);
		ruaField.setBackground(Color.LIGHT_GRAY);
		add(ruaField);
		
		//Botão Cadastrar Cliente
		btnCdstCli.setBounds(25, 380, 200, 40);
		btnCdstCli.setBackground(Color.white);
		btnCdstCli.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Funcionalidade do botão cadastrar cliente
				Cliente cliente = new Cliente();
				cliente.setNome(nomeField.getText());
				cliente.setnRegistro(Integer.parseInt(regField.getText()));
				cliente.setTelefone(Integer.parseInt(telField.getText()));
				cliente.setEstado(estadoField.getText());
				cliente.setCidade(cidadeField.getText());
				cliente.setBairro(bairroField.getText());
				cliente.setRua(ruaField.getText());
				sistema.cadastrarCliente(cliente);
			}
			
		});
		add(btnCdstCli);
		
		//---------------------------LIMPEZA------------------------------
		tituloLimpeza.setBounds(250, 5, 200, 15);
		add(tituloLimpeza);
		
		//EMPREGADO
		infoRegEmpField.setBounds(250, 30, 200, 15);
		add(infoRegEmpField);
		for(Empregado e : sistema.getEmpregados()) {
			boxEmpregados.addItem(e);
		}
		boxEmpregados.setBounds(250, 55, 200, 20);
		boxEmpregados.setBackground(Color.LIGHT_GRAY);
		add(boxEmpregados);
	
		//TEMPO
		infoTempoField.setBounds(250, 80, 200, 15);
		add(infoTempoField);
		tempoField.setBounds(250, 105, 200, 20);
		tempoField.setBackground(Color.LIGHT_GRAY);
		add(tempoField);
		
		//RESERVA
		infoReservaFiedl.setBounds(250, 130, 200, 15);
		add(infoReservaFiedl);
		for(Reserva r : sistema.getReservas()) {
			boxReservas.addItem(r);
		}
		boxReservas.setBounds(250, 155, 200, 20);
		boxReservas.setBackground(Color.LIGHT_GRAY);
		add(boxReservas);
	
		btnCdstLim.setBounds(250, 180, 200, 40);
		btnCdstLim.setBackground(Color.white);
		btnCdstLim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Funcionalidade do botão cadastrar Limpeza
				Limpeza limpeza = new Limpeza();
				Reserva reserva = (Reserva) boxReservas.getSelectedItem();
				Empregado empregado = (Empregado) boxEmpregados.getSelectedItem();
				limpeza.setCodReseva(reserva.getCodreserva());
				limpeza.setnRegEmp(empregado.getnRegistro());
				limpeza.setTempo(tempoField.getText()); //formato correto
				sistema.cadastrarLimpeza(limpeza);
			}
		});
		add(btnCdstLim);
		
		
		//---------------------------ESTADIA------------------------------
		tituloCheckIn.setBounds(475, 5, 200, 15);
		add(tituloCheckIn);
		
		infoCheckInField.setBounds(475, 30, 200, 15);
		add(infoCheckInField);
		
		checkInField.setBounds(475, 55, 200, 20);
		checkInField.setBackground(Color.LIGHT_GRAY);
		add(checkInField);
		
		infoCheckOutField.setBounds(475, 80, 200, 20);
		add(infoCheckOutField);
		checkOutField.setBounds(475, 105, 200, 20);
		checkOutField.setBackground(Color.LIGHT_GRAY);
		add(checkOutField);
		
		btnCdstEst.setBounds(475, 130, 200, 40);
		btnCdstEst.setBackground(Color.white);
		btnCdstEst.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Funcionalidade do botão cadastrar Estadia
				Estadia estadia = new Estadia();
				estadia.setCheckin(checkInField.getText());
				estadia.setCheckout(checkOutField.getText());
				sistema.cadastrarEstadia(estadia);
			}
			
		});
		add(btnCdstEst);		
		
		//---------------------------RESERVA------------------------------
		tituloCdstReserva.setBounds(700, 5, 200, 15);
		add(tituloCdstReserva);
		
		infoCodCliente.setBounds(700, 30, 200, 15);
		add(infoCodCliente);
		
		codClienteField.setBounds(700, 55, 200, 20);
		codClienteField.setBackground(Color.LIGHT_GRAY);
		add(codClienteField);
		
		infoCodEstadia.setBounds(700, 80, 200, 15);
		add(infoCodEstadia);
		
		codEstadiaField.setBounds(700, 105, 200, 20);
		codEstadiaField.setBackground(Color.LIGHT_GRAY);
		add(codEstadiaField);
		
		infoDiaReserva.setBounds(700, 130, 200, 15);
		add(infoDiaReserva);
		
		diaReservaField.setBounds(700, 155, 200, 20);
		diaReservaField.setBackground(Color.LIGHT_GRAY);
		add(diaReservaField);
		
		infoDiaEntrada.setBounds(700, 180, 200, 15);
		add(infoDiaEntrada);
		
		diaEntradaField.setBounds(700, 205, 200, 20);
		diaEntradaField.setBackground(Color.LIGHT_GRAY);
		add(diaEntradaField);
		
		infoBoxQuartos.setBounds(700, 230, 200, 20);
		add(infoBoxQuartos);
		
		for(Quarto q : sistema.getQuartos()) {
			boxQuartos.addItem(q);
		}
		boxQuartos.setBounds(700, 255, 200, 20);
		boxQuartos.setBackground(Color.LIGHT_GRAY);
		add(boxQuartos);
		
		btnCdstRes.setBounds(700, 280, 200, 40);
		btnCdstRes.setBackground(Color.white);
		btnCdstRes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Reserva reserva = new Reserva();
				Quarto quarto = new Quarto();
				
				quarto = (Quarto)boxQuartos.getSelectedItem();
				reserva.setCodcliente(Integer.parseInt(codClienteField.getText()));
				reserva.setCodestadia(Integer.parseInt(codEstadiaField.getText()));
				reserva.setDiaentrada(diaEntradaField.getText());
				reserva.setDiareserva(diaReservaField.getText());
				reserva.setNroa(quarto.getNroa());
				sistema.cadastrarReserva(reserva);
			}
		});
		add(btnCdstRes);
		
		//---------------------------EXTRA------------------------------
		tituloExtra.setBounds(925, 5, 200, 15);
		add(tituloExtra);
		
		tituloBoxTipo.setBounds(925, 30, 200, 15);
		add(tituloBoxTipo);
		
		//criar BOX DE TIPOS
		for(tipoServico t : sistema.getServicos()) {
			boxTipos.addItem(t);
		}
		boxTipos.setBounds(925, 55, 200, 20);
		boxTipos.setBackground(Color.LIGHT_GRAY);
		add(boxTipos);
		
		infoCodEstadiaEx.setBounds(925, 80, 200, 15);
		add(infoCodEstadiaEx);
		
		codEstadiaEx.setBounds(925, 105, 200, 20);
		codEstadiaEx.setBackground(Color.LIGHT_GRAY);
		add(codEstadiaEx);
		
		infodiaEx.setBounds(925, 130, 200, 15);
		add(infodiaEx);
		
		diaEx.setBounds(925, 155, 200, 20);
		diaEx.setBackground(Color.LIGHT_GRAY);
		add(diaEx);
		
		infohoraEx.setBounds(925, 180, 200, 15);
		add(infohoraEx);
		
		horaEx.setBounds(925, 205, 200, 20);
		horaEx.setBackground(Color.LIGHT_GRAY);
		add(horaEx);
		
		btnCdstEx.setBounds(925, 230, 200, 40);
		btnCdstEx.setBackground(Color.white);
		btnCdstEx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Extra extra = new Extra();
				tipoServico tipo = new tipoServico();
				
				tipo = (tipoServico)boxTipos.getSelectedItem();
				extra.setCodEstadia(Integer.parseInt(codEstadiaEx.getText()));
				extra.setCodTipo(tipo.getCodTipo());
				extra.setDia(diaEx.getText());
				extra.setHora(horaEx.getText());
				sistema.cadastrarExtra(extra);
			}
		});
		add(btnCdstEx);
		
		
	}
	
	
}









