package Bibliotecas.ProjetoFinal.TxtUtils;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import Bibliotecas.ProjetoFinal.Atividade.Atividade;
import Bibliotecas.ProjetoFinal.FuncoesOtimizacao.Dias;
public class CaloriaDiaSemana {
	public static LinkedHashMap<String, String> CaloriaDia(Path arquivo) {
		LinkedHashMap<String, String> CaloriasDia = new LinkedHashMap<>();
		List<Atividade> ListaAtividades = TxtUtils.LeituraTxt(arquivo);
		int DiasContador1[] = {0, 0, 0, 0, 0, 0, 0};
		int DiasContador2[] = {0, 0, 0, 0, 0, 0, 0};

		for (Atividade atividade : ListaAtividades) {
			if (atividade.getNomeAtleta().equals("Igor"))
				DiasContador1[Dias.PosicaoElemento(atividade.getDiaSemana())] 
						+= atividade.getCalorias();

			if (atividade.getNomeAtleta().equals("Danilo"))
				DiasContador2[Dias.PosicaoElemento(atividade.getDiaSemana())] 
						+= atividade.getCalorias();
		}

		for (int i = 0; i < 7; i++)
			CaloriasDia.put(Dias.DiaSemana(i), 
				DiasContador1[i] + "/" + DiasContador2[i]);
		
		return CaloriasDia;
	}
}