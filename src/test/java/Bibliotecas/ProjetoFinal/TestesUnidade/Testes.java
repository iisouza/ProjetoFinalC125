package Bibliotecas.ProjetoFinal.TestesUnidade;
import static org.junit.Assert.assertEquals;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import Bibliotecas.ProjetoFinal.Atividade.Atividade;
import Bibliotecas.ProjetoFinal.TxtUtils.TxtUtils;
import Bibliotecas.ProjetoFinal.TxtUtils.AltimetriaDiaSemana;
import Bibliotecas.ProjetoFinal.TxtUtils.CaloriaDiaSemana;
import Bibliotecas.ProjetoFinal.TxtUtils.DistanciaDiaSemana;
public class Testes {
	private List<Atividade> ListaAtividades;
	private int total1 = 0;
	private double total2 = 0;
	Path arquivo = Paths.get("ListaAtividades.txt");
	
	@Before
	public void Init() {
		ListaAtividades = TxtUtils.LeituraTxt(arquivo);
	}
	
	@Test
	public void TestaLeituraCompletaArquivo() {
		int result = ListaAtividades.size();
		assertEquals(389, result);
	}
	
	@Test
	public void TestaAtletasEquipe() {
		Set <String> atletas = new HashSet <>();
		for(Atividade atividade:ListaAtividades)
			atletas.add(atividade.getNomeAtleta());
		assertEquals(true, atletas.size() == 2);
	}
	
	@Test
	public void TestaEstiloAtividades() {
		Set <String> estilos = new HashSet <>();
		for(Atividade atividade:ListaAtividades)
			estilos.add(atividade.getEstilo());
		assertEquals(true, estilos.size() == 4);
	}
	
	@Test
	public void TestaValoresPositivos() {
		boolean ok = true;
		for(Atividade atividade:ListaAtividades)
			if(atividade.getDuracao().length() != 13 || atividade.getDistancia() < 0
				|| atividade.getCalorias() < 0 || atividade.getAltimetria() < 0) {
				ok = false;
				break;
			}
		assertEquals(true, ok);
	}
	
	@Test
	public void TestaAltimetriaTotal() {
		LinkedHashMap<String, String> AltimetriaDia = new LinkedHashMap<>();
		AltimetriaDia = AltimetriaDiaSemana.AltimetriaDia(arquivo);
		
		AltimetriaDia.forEach((chave, valor) -> {
			total1 += Integer.parseInt(valor.split("/")[0]);
			total1 += Integer.parseInt(valor.split("/")[1]);
		});
		assertEquals(32427, total1);
	}
	
	@Test
	public void TestaDistanciaTotal() {
		LinkedHashMap<String, String> DistanciaDia = new LinkedHashMap<>();
		DistanciaDia = DistanciaDiaSemana.DistanciaDia(arquivo);
		
		DistanciaDia.forEach((chave, valor) -> {
			total2 += Double.parseDouble(valor.split("/")[0].strip().replace(",", "."));
			total2 += Double.parseDouble(valor.split("/")[1].strip().replace(",", "."));
		});
		assertEquals(3022.4, total2, 0.01);
	}
	
	@Test
	public void TestaCaloriaTotal() {
		LinkedHashMap<String, String> CaloriaDia = new LinkedHashMap<>();
		CaloriaDia = CaloriaDiaSemana.CaloriaDia(arquivo);
		
		CaloriaDia.forEach((chave, valor) -> {
			total1 += Integer.parseInt(valor.split("/")[0].strip());
			total1 += Integer.parseInt(valor.split("/")[1].strip());
		});
		assertEquals(186493, total1);
	}
}