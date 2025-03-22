package percentualgordura;

import java.util.Scanner;

public class PercentGordura {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Qual o sexo do(a) paciente? (M) Masculino - (F) Feminino");
		char sexo = input.next().charAt(0);
		
		System.out.println("Qual a idade do paciente? ");
		int idade = input.nextInt();
		
		
		String[] nomeDobras7 = {
				"Peitoral", "Abdominal", "Coxa", "Tríceps", "Subescapular", "Suprailíaca", "Axilar média"
				};
		
		//array para armazenar as dobras.
		double[] dobras = new double[nomeDobras7.length];
		
		for (int i = 0 ; i <nomeDobras7.length; i++) {
			
			System.out.println("Digite a espessura da dobra cutânea " + nomeDobras7[i] + " (mm)");
			dobras[i] = input.nextDouble();
		}
		
		//Cálculos
		double somaDobras = 0;
		for (double dobra: dobras) {
			
			somaDobras += dobra;
		}
		
		double densidade;
		if (sexo == 'M' || sexo == 'm') {
			
			densidade = 1.112 - (0.00043499 * somaDobras) + (0.00000055 * Math.pow(somaDobras, 2)) - (0.00028826 * idade);
			
		} else {
			
			densidade = 1.097 - (0.00046971 * somaDobras) + (0.00000056 * Math.pow(somaDobras, 2)) - (0.00012828 * idade);
		}
	
		double perGordura = (495 / densidade) - 450;
		
		System.out.printf("O percentual de gordura é: %.2f%%\n", perGordura);
		
		classificarGordura(perGordura, sexo);
		
		input.close();
	}


	public static void classificarGordura(double perGordura, char sexo) {
		
		
		String categoria, descricao;
		
		if (sexo == 'M' || sexo == 'm') { // Classificação para homens
	        if (perGordura < 6) {
	            categoria = "Essencial";
	            descricao = "Gordura necessária para funções vitais. Abaixo disso é perigoso.";
	        } else if (perGordura >= 6 && perGordura <= 13) {
	            categoria = "Atleta";
	            descricao = "Nível ideal para atletas e pessoas muito ativas.";
	        } else if (perGordura >= 14 && perGordura <= 17) {
	            categoria = "Fitness";
	            descricao = "Nível saudável e adequado para quem pratica exercícios regularmente.";
	        } else if (perGordura >= 18 && perGordura <= 24) {
	            categoria = "Aceitável";
	            descricao = "Nível considerado normal para a população geral.";
	        } else if (perGordura >= 25 && perGordura <= 29) {
	            categoria = "Acima do Peso";
	            descricao = "Risco aumentado de problemas de saúde.";
	        } else {
	            categoria = "Obesidade";
	            descricao = "Risco elevado de doenças cardiovasculares, diabetes e outras condições.";
	        }
	    } else { // Classificação para mulheres
	        if (perGordura < 14) {
	            categoria = "Essencial";
	            descricao = "Gordura necessária para funções vitais. Abaixo disso é perigoso.";
	        } else if (perGordura >= 14 && perGordura <= 20) {
	            categoria = "Atleta";
	            descricao = "Nível ideal para atletas e pessoas muito ativas.";
	        } else if (perGordura >= 21 && perGordura <= 24) {
	            categoria = "Fitness";
	            descricao = "Nível saudável e adequado para quem pratica exercícios regularmente.";
	        } else if (perGordura >= 25 && perGordura <= 31) {
	            categoria = "Aceitável";
	            descricao = "Nível considerado normal para a população geral.";
	        } else if (perGordura >= 32 && perGordura <= 36) {
	            categoria = "Acima do Peso";
	            descricao = "Risco aumentado de problemas de saúde.";
	        } else {
	            categoria = "Obesidade";
	            descricao = "Risco elevado de doenças cardiovasculares, diabetes e outras condições.";
	        }
	    }
	
	    
	    System.out.println("\nCategoria: " + categoria);
	    System.out.println("Descrição: " + descricao);
	}
	
	    
    
}

			
			
			


