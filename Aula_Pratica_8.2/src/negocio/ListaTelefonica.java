package negocio;

import dados.Contato;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ListaTelefonica {
	
	private List<Contato> contatos = new ArrayList<Contato>();
	
	public void adicionarContato(Contato contato) {
		contatos.add(contato);
	}
	
	public void removerContato(Contato contato) {
		int i =0;
		for(Contato item : contatos) {
			if(item.equals(contato)) {
				contatos.remove(i);
			}
			i++;
		}
	}
	
	public List<Contato> buscarContatosPorLetra(char letra){
		Map<Character, List<Contato>> map_consulta = this.buscarContatos();
		
		if (map_consulta.containsKey(letra)) {
			return map_consulta.get(letra);
		}else {
			return null;
		}
	}
	
	
	public Map<Character, List<Contato>> buscarContatos(){
		Map<Character, List<Contato>> map_letra = new HashMap<Character, List<Contato>>();
		Set<Character> iniciais = new HashSet<Character>();
		List<Contato> aux = new ArrayList<Contato>();
		
		for(Contato item : contatos) {
			iniciais.add(item.getNome().charAt(0));
		}
		
		for(char c : iniciais) {
			for(Contato item : contatos) {
				char comp = item.getNome().charAt(0);
				if(comp == c) {
					aux.add(item);
				}
			}
			map_letra.put(c, aux);
			aux.clear();
		}
		
		return map_letra;
	}
	
	
}
