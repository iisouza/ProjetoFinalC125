package Bibliotecas.ProjetoFinal.TxtUtils;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import Bibliotecas.ProjetoFinal.Atividade.Atividade;
import Bibliotecas.ProjetoFinal.FuncoesOtimizacao.Dias;
import Bibliotecas.ProjetoFinal.FuncoesOtimizacao.Formato;
public class TempoDiaSemana {
	public static LinkedHashMap<String, String> TempoDia(Path arquivo) {
		LinkedHashMap<String, String> TemposDia = new LinkedHashMap<>();
		List<Atividade> ListaAtividades = TxtUtils.LeituraTxt(arquivo);
		StringBuilder func = new StringBuilder();
		String aux;
		
		int DiasContador1[] = {0, 0, 0, 0, 0, 0, 0};
		int DiasContador2[] = {0, 0, 0, 0, 0, 0, 0};
		int total;
		
		for (Atividade atividade:ListaAtividades) {
			if (atividade.getNomeAtleta().equals("Igor")) {
				aux = atividade.getDuracao();
				String duracao[] = aux.split("-");
				total = Integer.parseInt(duracao[0])*3600 + 
					Integer.parseInt(duracao[1])*60 + Integer.parseInt(duracao[2]);
				DiasContador1[Dias.PosicaoElemento(atividade.getDiaSemana())] += total;
			}

			if (atividade.getNomeAtleta().equals("Danilo")) {
				aux = atividade.getDuracao();
				String duracao[] = aux.split("-");
				total = Integer.parseInt(duracao[0])*3600 + 
					Integer.parseInt(duracao[1])*60 + Integer.parseInt(duracao[2]);
				DiasContador2[Dias.PosicaoElemento(atividade.getDiaSemana())] += total;
			}
		}
		
		for(int i = 0; i < 7; i++) {
			func.delete(0, func.length());
			total = (DiasContador1[i] + DiasContador2[i]);
			func.append(Formato.FormatoDuracao(DiasContador1[i]))
			    .append("/").append(Formato.FormatoDuracao(DiasContador2[i]))
			    .append("/").append(Formato.FormatoDuracao(total));
			TemposDia.put(Dias.DiaSemana(i), func.toString());
		}
		
		int totalp = 0;
		func.delete(0, func.length());
		for(int i = 0; i < 7; i++) 
			totalp += DiasContador1[i];
		total = totalp;
		func.append(Formato.FormatoDuracao(totalp)).append("/");
		
		totalp = 0;
		for(int i = 0; i < 7; i++) 
			totalp += DiasContador2[i];
		total += totalp;
		func.append(Formato.FormatoDuracao(totalp))
			.append("/").append(Formato.FormatoDuracao(total));
		TemposDia.put("Total", func.toString());
		
		return TemposDia;
	}
}