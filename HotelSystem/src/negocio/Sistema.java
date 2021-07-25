package negocio;

import java.util.ArrayList;
import java.util.List;
import dados.*;


public class Sistema {
	private static Sistema instance =null;
	private List<Reserva> reservas;
	private List<Cliente> clientes;
	private List<Empregado> empregados;
	
	
	public static Sistema getInstance() {
		if (instance == null) {
			instance = new Sistema();
		}
		return instance;
	}
	
	
	
}
