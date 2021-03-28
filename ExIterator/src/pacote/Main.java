package pacote;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matriz<Integer> matriz = new Matriz<Integer>(3,3);
		
		int cont = 0;
		for(int i = 0; i<3; i++) {
			for(int j=0; j<3; j++) {
				matriz.set(i, j, cont++);
			}
		}
		
		while(matriz.getIteradorLinha().hasNext()) {
			System.out.println(matriz.getIteradorLinha().next());
		}
		System.out.println();
	}

}
