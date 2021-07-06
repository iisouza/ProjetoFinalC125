package Bibliotecas.ProjetoFinal.FuncoesOtimizacao;
public class Funcoes {
	private static String dias[] = {"domingo", "segunda-feira", "terca-feira", "quarta-feira",
			"quinta-feira", "sexta-feira", "sabado"};
	public static int PosicaoElemento(String elemento) {
		int posicao = -1;
		for(int i = 0; i < 7; i++) 
			if(dias[i].equals(elemento)) {
				posicao = i;
				break;
			}
		return posicao;
	}
	
	public static String DiaSemana(int dia) {
		return dias[dia];
	}
}