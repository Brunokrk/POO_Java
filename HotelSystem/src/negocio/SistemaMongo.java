package negocio;

import java.util.ArrayList;
import java.util.List;
import dados.*;
import mongoPersistence.ClienteMongoDAO;
import mongoPersistence.EmpregadoMongoDAO;
import mongoPersistence.EstadiaMongoDAO;
import mongoPersistence.ExtraMongoDAO;
import mongoPersistence.LimpezaMongoDAO;
import mongoPersistence.QuartoMongoDAO;
import mongoPersistence.TipoServicoMongoDAO;
import persistencia.ClienteDAO;
import persistencia.EmpregadoDAO;
import persistencia.EstadiaDAO;
import persistencia.ExtraDAO;
import persistencia.LimpezaDAO;
import persistencia.QuartoDAO;
import persistencia.ReservaDAO;
import persistencia.TipoServicoDAO;


public class SistemaMongo {
	private static SistemaMongo instance =null;
	private ClienteMongoDAO clienteMongoDAO;
	private EmpregadoMongoDAO empregadoMongoDAO;
	private EstadiaMongoDAO estadiaMongoDAO;
	private LimpezaMongoDAO limpezaMongoDAO;
	private TipoServicoMongoDAO servicoMongoDAO;
	private ExtraMongoDAO extraMongoDAO;
	private QuartoMongoDAO quartoMongoDAO;
	/*
	private ReservaDAO reservaDAO;
	*/
	
	public static SistemaMongo getInstance() {
		if (instance == null) {
			instance = new SistemaMongo();
		}
		return instance;
	}
	
	public void cadastrarCliente(Cliente cliente) {
		clienteMongoDAO.getInstance().insert(cliente);
	}
	
	public List<Cliente> getClientes(){
		return clienteMongoDAO.getInstance().selectAll();
	}
	
	public List<Empregado> getEmpregados() {	
		return empregadoMongoDAO.getInstance().selectAll();
	}
	
	public void cadastrarEstadia(Estadia estadia){
		estadiaMongoDAO.getInstance().insert(estadia);
	}
	
	public List<Estadia> getEstadias(){
		return estadiaMongoDAO.getInstance().selectAll();
	}
	
	public void cadastrarLimpeza(Limpeza limpeza) {
		limpezaMongoDAO.getInstance().insert(limpeza);
	}
	
	
	public List<tipoServico> getServicos(){
		return servicoMongoDAO.getInstance().selectAll();
	}
	
	public void cadastrarExtra(Extra extra) {
		extraMongoDAO.getInstance().insert(extra);
	}
	
	public List<QuartoMongo> getQuartos(){
		List<QuartoMongo> quartos = new ArrayList<QuartoMongo>();
		quartos = quartoMongoDAO.getInstance().selectAll();
		
		return quartos;
	}
	
	
	
	/*
	
	
	public void cadastrarReserva(Reserva reserva) {
		reservaDAO.getInstance().insert(reserva);
	}
	
	
	public void calcularExtra(int cod) {
		extraDAO.getInstance().calculaExtra(cod);
	}
	
	
	public List<Reserva> getReservas(){
		return reservaDAO.getInstance().selectAll();
	}
	
	
	
	
	
	
	
*/	
}
