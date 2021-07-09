package Bibliotecas.ProjetoFinal.TxtUtils;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;
import Bibliotecas.ProjetoFinal.Atividade.Atividade;
import Bibliotecas.ProjetoFinal.FuncoesOtimizacao.Dias;
public class DistanciaDiaSemana {
	public static LinkedHashMap<String, String> DistanciaDia(Path arquivo) {
		LinkedHashMap<String, String> DistanciaDia = new LinkedHashMap<>();
		List<Atividade> ListaAtividades = Leitura.LeituraTxt(arquivo);
		
		double distanciaSomador1[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		double distanciaSomador2[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		NumberFormat total = DecimalFormat.getNumberInstance();
		total.setMaximumFractionDigits(1);
		
		for (Atividade atividade:ListaAtividades) {
			if (atividade.getNomeAtleta().equals("Igor"))
				distanciaSomador1[Dias.PosicaoElemento(atividade.getDiaSemana())] 
						+= atividade.getDistancia();

			if (atividade.getNomeAtleta().equals("Danilo"))
				distanciaSomador2[Dias.PosicaoElemento(atividade.getDiaSemana())] 
						+= atividade.getDistancia();
		}

		for (int i = 0; i < 7; i++)
			DistanciaDia.put(Dias.DiaSemana(i), 
				total.format(distanciaSomador1[i]).replace(",", ".")
				+ "/" + total.format(distanciaSomador2[i]).replace(",", "."));
		
		return DistanciaDia;
	}
}