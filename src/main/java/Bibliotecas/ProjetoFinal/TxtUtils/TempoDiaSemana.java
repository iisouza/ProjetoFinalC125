package Bibliotecas.ProjetoFinal.TxtUtils;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import Bibliotecas.ProjetoFinal.Atividade.Atividade;
import Bibliotecas.ProjetoFinal.FuncoesOtimizacao.Funcoes;
public class TempoDiaSemana {
	public static LinkedHashMap<String, String> TempoDia(Path arquivo) {
		LinkedHashMap<String, String> TemposDia = new LinkedHashMap<>();
		List<Atividade> ListaAtividades = TxtUtils.LeituraTxt(arquivo);
		int DiasContador1[] = {0, 0, 0, 0, 0, 0, 0};
		int DiasContador2[] = {0, 0, 0, 0, 0, 0, 0};
		StringBuilder func = new StringBuilder();
		int total;
		String aux;
		
		for (Atividade atividade:ListaAtividades) {
			if (atividade.getNomeAtleta().equals("Igor")) {
				aux = atividade.getDuracao();
				String duracao[] = aux.split("-");
				total = Integer.parseInt(duracao[0])*3600 + 
					Integer.parseInt(duracao[1])*60 + Integer.parseInt(duracao[2]);
				DiasContador1[Funcoes.PosicaoElemento(atividade.getDiaSemana())] += total;
			}

			if (atividade.getNomeAtleta().equals("Danilo")) {
				aux = atividade.getDuracao();
				String duracao[] = aux.split("-");
				total = Integer.parseInt(duracao[0])*3600 + 
					Integer.parseInt(duracao[1])*60 + Integer.parseInt(duracao[2]);
				DiasContador2[Funcoes.PosicaoElemento(atividade.getDiaSemana())] += total;
			}
		}
		
		for(int i = 0; i < 7; i++) {
			func.delete(0, func.length());
			total = (DiasContador1[i] + DiasContador2[i]);
			func.append(Funcoes.HoraFormat(DiasContador1[i]))
			    .append("/").append(Funcoes.HoraFormat(DiasContador2[i]))
			    .append("/").append(Funcoes.HoraFormat(total));
			TemposDia.put(Funcoes.DiaSemana(i), func.toString());
		}
		
		int totalp = 0;
		func.delete(0, func.length());
		for(int i = 0; i < 7; i++) 
			totalp += DiasContador1[i];
		total = totalp;
		func.append(Funcoes.HoraFormat(totalp)).append("/");
		
		totalp = 0;
		for(int i = 0; i < 7; i++) 
			totalp += DiasContador2[i];
		total += totalp;
		func.append(Funcoes.HoraFormat(totalp))
			.append("/").append(Funcoes.HoraFormat(total));
		TemposDia.put("Total", func.toString());
		return TemposDia;
	}
}