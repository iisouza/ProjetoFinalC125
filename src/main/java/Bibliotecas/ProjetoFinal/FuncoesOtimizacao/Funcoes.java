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
	
	public static String HoraFormat(int segundos) {
		int hora, minuto;
		StringBuilder duracao = new StringBuilder();
		
		hora = segundos/3600;
		segundos -= hora*3600;
		minuto = segundos/60;
		segundos -= minuto*60;
		
		duracao.append(hora).append("h");
		if(minuto < 10)
			duracao.append("0");
		duracao.append(minuto).append("min");
		
		if(segundos < 10)
			duracao.append("0");
		duracao.append(segundos).append("seg");
		return duracao.toString();
	}
}