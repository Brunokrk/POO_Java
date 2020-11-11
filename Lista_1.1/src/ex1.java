import java.util.Random;
import java.util.Arrays;

public class ex1 {
	public static void main(String [] args) {
		int[] array = new int[10];
		//Instanciando um objeto da classe Random
		Random gerador = new Random();
		boolean flag = true;
		int cont = 0;
		int total=0;
		//gerando array aleatório
		for(int i=0; i<10; i++) {
			array[i] = gerador.nextInt(); 
			//System.out.println(array[i]);
			total += array[i];
		}
		Arrays.sort(array); //Ordena o array
		
		for(int i=0; i<10; i++) {
			System.out.println(array[i]);//printa o array
		}
		System.out.println("Maior valor: " + array[9]); //maior valor
		
		//Calculando quantidade de primos
		for(int i=0; i<10;i++) {
			for(int j=2; j<array[i]; j++) {
				if(array[i]%j ==0) {
					flag = false;
				}
			}
			if (flag == true) {
				System.out.println(array[i]+" é numero primo");
				cont++;
			}
			flag = true;
		}
		
		System.out.println("Quantidade de primos: "+ cont);
		System.out.println("Media dos valores é: "+(total/10));
	}
}
