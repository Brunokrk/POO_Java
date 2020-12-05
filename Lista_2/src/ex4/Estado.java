package ex4;


public class Estado {
		private String nome;
		private Cidade[] cidades = new Cidade[20];
		private int num_cidades = 0;
		
		public void adicionaCidade(Cidade cidade) {
			this.cidades[num_cidades] = cidade;
			num_cidades++;
		}
		
		public Cidade[] filtrarRendaPerCapta(float x) {
			int tam =0;
			int cont = 0;
			for(int i =0; i<num_cidades; i++) {
				if (cidades[i].rendaPerCapta()>x) {
					tam++;
				}
			}
			Cidade [] aux = new Cidade[tam];
			
			for(int i =0; i<num_cidades; i++) {
				if (cidades[i].rendaPerCapta()>x) {
					aux[cont] = cidades[i];
					cont++;
				}
			}
			return aux;
		}
		
		public String toString() {
			return "     Estado:"+this.nome;
					
		}
		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		
}
