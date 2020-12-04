package negocio;

import dados.*;

public class Sistema {
	private Animal[] animais = new Animal[20];
	private Viveiro[] viveiros = new Viveiro[5];
	private int num_animais;
	private int num_viveiros;
	
	public void cadastrarViveiro(Viveiro viveiro) {
		this.viveiros[num_viveiros] = viveiro;
		this.num_viveiros ++;
	}
	
	public void cadastrarAnimais(Animal animal) {
		this.animais[num_animais] = animal;
		this.num_animais ++;
	}
	
	public boolean alocarAnimal(Animal animal, Viveiro viveiro) {
		if(animal instanceof Peixe && viveiro instanceof Aquario) {
			//Peixe e Aquário
			Peixe aux = (Peixe)(animal);
			Aquario auxx = (Aquario)(viveiro);
			if(auxx.getTemperatura() <= aux.getTemperaturaIdeal()) {				
				return viveiro.adicionarAnimal(animal);
			}else {
				return false;
			}
		}else if(animal instanceof Peixe && (viveiro instanceof Aquario)==false){
			return false;
		}else if ((animal instanceof Peixe)==false && viveiro instanceof Aquario) {
			return false;
		}else {
			//Não Peixe e Não Aquario
			return viveiro.adicionarAnimal(animal);
		}
	}
	
	public Aquario[] getSoAquarios() {
		int max =0;
		for(int i=0; i<num_viveiros; i++) {
			if(viveiros[i] instanceof Aquario) {
				max++;
			}
		}
		
		Aquario[] aquarios = new Aquario[max];
		
		int qnt = 0;
		for(int i=0; i<num_viveiros; i++) {
			if(viveiros[i] instanceof Aquario) {
				aquarios[qnt] = (Aquario)(viveiros[i]);
				qnt++;
			}
		}
		return aquarios;
	}
	
	public Viveiro[] getSoViveiros() {
		int max =0;
		for(int i=0; i<num_viveiros; i++) {
			if(viveiros[i] instanceof Viveiro) {
				max++;
			}
		}
		
		Viveiro[] soviveiros = new Viveiro[max];
		
		int qnt = 0;
		for(int i=0; i<num_viveiros; i++) {
			if(viveiros[i] instanceof Viveiro) {
				soviveiros[qnt] = (Viveiro)(viveiros[i]);
				qnt++;
			}
		}
		return soviveiros;
	}
	
	public int getNumViveiros() {
		return this.num_viveiros;
	}
	
	public int getNumAnimais() {
		return this.num_animais;
	}
	
	public Viveiro[] getViveiros() {
		return this.viveiros;
	}
	
	public Animal[] getAnimais() {
		return this.animais;
	}
}
