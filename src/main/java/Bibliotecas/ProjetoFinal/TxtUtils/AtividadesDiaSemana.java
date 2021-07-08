package Bibliotecas.ProjetoFinal.TxtUtils;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import Bibliotecas.ProjetoFinal.Atividade.Atividade;
import Bibliotecas.ProjetoFinal.FuncoesOtimizacao.Dias;
public class AtividadesDiaSemana {
	public static LinkedHashMap<String, String> AtividadeDia(Path arquivo) {
		LinkedHashMap<String, String> AtividadesDia = new LinkedHashMap<>();
		List<Atividade> ListaAtividades = TxtUtils.LeituraTxt(arquivo);
		int DiasContador1[] = {0, 0, 0, 0, 0, 0, 0};
		int DiasContador2[] = {0, 0, 0, 0, 0, 0, 0};

		for (Atividade atividade : ListaAtividades) {
			if (atividade.getNomeAtleta().equals("Igor"))
				DiasContador1[Dias.PosicaoElemento(atividade.getDiaSemana())]++;

			if (atividade.getNomeAtleta().equals("Danilo"))
				DiasContador2[Dias.PosicaoElemento(atividade.getDiaSemana())]++;
		}

		for (int i = 0; i < 7; i++)
			AtividadesDia.put(Dias.DiaSemana(i), 
				DiasContador1[i] + "/" + DiasContador2[i]);
		
		return AtividadesDia;
	}
}