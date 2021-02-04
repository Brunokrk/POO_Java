package persistencia;

import java.util.LinkedList;
import java.util.List;

import dados.Contato;


public class ArquivoContatoDAO {
	private final String caminho = "files/contatos.csv";
	private static EditorTexto arquivo = new EditorTexto();
	
	private String toCSV(Contato c) {
		//Transforma o contato em uma String para ser salva no CSV
		String aux ="";
		aux += c.getNome() + ",";
		aux += c.getTelefone();
		
		return aux;
	}
	
	public Contato fromCSV(String s) {
		//Transforma a informação salva no CSV em um objeto Contato
		String[] att = s.split(",");
		
		Contato contato = new Contato();
		contato.setNome(att[0]);
		contato.setTelefone(Integer.parseInt(att[1]));
		
		return contato;
	}
	
	public List<String> listaContatoToString(List <Contato> contatos){
		List<String> arquivo = new LinkedList<String>();
		for(Contato contato : contatos) {
			arquivo.add(toCSV(contato));
		}
		return arquivo;
	}
	
	public List<Contato> stringToListaContato(List<String> arquivo){
		List<Contato> contatos = new LinkedList<Contato>();
		for(String linha : arquivo) {
			contatos.add(fromCSV(linha));
		}
		return contatos;
	}
	
	public List<Contato> leContatos(){
		return stringToListaContato(arquivo.leTexto(caminho));
	}
	
	public void salvaContatos(List<Contato> contatos) {
		arquivo.gravaTexto(caminho, listaContatoToString(contatos));
	}
	
	public void salvaContato(Contato contato) {
		arquivo.gravaTexto(caminho, toCSV(contato));
	}
}
