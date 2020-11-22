package extra_quest;

import java.util.Scanner;

public class QuestaoExtra {
	private static Scanner leitor = new Scanner(System.in);
	
	private static int retornaMdc(int a, int b){
        if(b == 0) return a;
        return retornaMdc(b, a % b);
    }
	
	private static void fazReducao(int var_a, int var_b, int mdc) {
		if(mdc==1) {
			//Não há mais reduções para se fazer
			System.out.println("A fração simplificada é: "+ var_a+"/"+var_b);
		}else {
			int aux_a = (var_a / mdc);
			int aux_b = (var_b / mdc);
			fazReducao(aux_a, aux_b, retornaMdc(aux_a, aux_b));
		}
	}
	public static void main(String[] args) {
		
		System.out.println("Informe o numerador");
		int varA = Integer.parseInt(leitor.nextLine());
		System.out.println("Informe o denominador");
		int varB = Integer.parseInt(leitor.nextLine());
		if (varB != 0) {
			fazReducao(varA, varB, retornaMdc(varA, varB));			
		}else {
			System.out.println("Não existe divisão por zero, por favor execute novamente");
		}
	}
}
