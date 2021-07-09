package Bibliotecas.ProjetoFinal.TxtUtils;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import Bibliotecas.ProjetoFinal.Atividade.Atividade;
import Bibliotecas.ProjetoFinal.FuncoesOtimizacao.Dias;
public class AltimetriaDiaSemana {
	public static LinkedHashMap<String, String> AltimetriaDia(Path arquivo) {
		LinkedHashMap<String, String> AltimetriaDiaSemana = new LinkedHashMap<>();
		List<Atividade> ListaAtividades = Leitura.LeituraTxt(arquivo);
		int altimetriaSomador1[] = {0, 0, 0, 0, 0, 0, 0};
		int altimetriaSomador2[] = {0, 0, 0, 0, 0, 0, 0};

		for (Atividade atividade:ListaAtividades) {
			if (atividade.getNomeAtleta().equals("Igor"))
				altimetriaSomador1[Dias.PosicaoElemento(atividade.getDiaSemana())] 
					+= atividade.getAltimetria();

			if (atividade.getNomeAtleta().equals("Danilo"))
				altimetriaSomador2[Dias.PosicaoElemento(atividade.getDiaSemana())] 
					+= atividade.getAltimetria();
		}

		for (int i = 0; i < 7; i++)
			AltimetriaDiaSemana.put(Dias.DiaSemana(i), 
				altimetriaSomador1[i] + "/" + altimetriaSomador2[i]);
		
		return AltimetriaDiaSemana;
	}
}