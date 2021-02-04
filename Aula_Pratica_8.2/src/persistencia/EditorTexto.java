package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

public class EditorTexto {
	public List<String> leTexto(String caminho){
		
		//Faz a leitura de todas as linhas do arquivo, e retorna uma List de String
		//Cada posição da List, representa uma linha do arquivo
		
		List<String> dados =  new LinkedList<String>();
		FileReader arq;
		BufferedReader lerArq;
		
		try {
			arq = new FileReader(caminho);
			lerArq = new BufferedReader(arq);
			String s = lerArq.readLine();
			
			while (s != null) {
				dados.add(s);
				s = lerArq.readLine();
			}
			arq.close();
		}catch (Exception e) {
			System.err.println("Erro ao manipular o arquivo");
			System.exit(0);
		}
		return dados;
	}
	
	public void gravaTexto(String caminho, List<String> dados) {
		
		//Recebe uma lista de Strings, e salvará cada posição em cada linha respectivamente
		
		FileWriter arq;
		try {
			arq = new FileWriter(caminho);
			for (int i = 0; i< dados.size(); i++) {
				arq.write(dados.get(i) + "\n");
			}
			arq.close();
		}catch (Exception e) {
			System.err.println("Erro ao manipular o arquivo");
			System.exit(0);
		}
	}
	
	public void gravaTexto(String caminho, String linha) {
		FileWriter arq;
		
		try {
			arq = new FileWriter(caminho, true);
			arq.write(linha);
			arq.close();
		}catch (Exception e) {
			System.err.println("Erro ao manipular o arquivo");
			System.exit(0);
		}
	}
}
