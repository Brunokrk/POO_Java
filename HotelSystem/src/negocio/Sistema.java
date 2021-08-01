package negocio;

import java.util.ArrayList;
import java.util.List;
import dados.*;
import persistencia.ClienteDAO;
import persistencia.EmpregadoDAO;
import persistencia.EstadiaDAO;
import persistencia.ExtraDAO;
import persistencia.LimpezaDAO;
import persistencia.QuartoDAO;
import persistencia.ReservaDAO;
import persistencia.TipoServicoDAO;


public class Sistema {
	private static Sistema instance =null;
	private ClienteDAO clienteDAO;
	private EmpregadoDAO empregadoDAO;
	private ReservaDAO reservaDAO;
	private LimpezaDAO limpezaDAO;
	private EstadiaDAO estadiaDAO;
	private QuartoDAO quartoDAO;
	private TipoServicoDAO servicoDAO;
	private ExtraDAO extraDAO;
	
	public static Sistema getInstance() {
		if (instance == null) {
			instance = new Sistema();
		}
		return instance;
	}
	
	public void cadastrarCliente(Cliente cliente) {
		clienteDAO.getInstance().insert(cliente);
	}
	
	public void cadastrarLimpeza(Limpeza limpeza) {
		limpezaDAO.getInstance().insert(limpeza);
	}
	
	public void cadastrarEstadia(Estadia estadia){
		estadiaDAO.getInstance().insert(estadia);
	}
	
	public void cadastrarReserva(Reserva reserva) {
		reservaDAO.getInstance().insert(reserva);
	}
	
	public void cadastrarExtra(Extra extra) {
		extraDAO.getInstance().insert(extra);
	}
	
	public List<Empregado> getEmpregados() {	
		return empregadoDAO.getInstance().selectAll();
	}
	
	public List<Reserva> getReservas(){
		return reservaDAO.getInstance().selectAll();
	}
	
	public List<Quarto> getQuartos(){
		List<Quarto> quartos = new ArrayList<Quarto>();
		
		List<Quarto> duplos = quartoDAO.getInstance().selectAllDuplo();
		List<Quarto> casal = quartoDAO.getInstance().selectAllCasal();
		List<Quarto> single = quartoDAO.getInstance().selectAllSingle();
		List<Quarto> suite = quartoDAO.getInstance().selectAllSuite();
		
		quartos.addAll(duplos);
		quartos.addAll(casal);
		quartos.addAll(single);
		quartos.addAll(suite);
		
		return quartos;
	}
	
	public List<tipoServico> getServicos(){
		return servicoDAO.getInstance().selectAll();
	}
	
	
	
	
	
	
	
	
}
