package Bibliotecas.ProjetoFinal.FuncoesOtimizacao;
public class Formato {
	public static String FormatoDuracao(int segundos) {
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