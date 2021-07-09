package Bibliotecas.ProjetoFinal.TestesUnidade;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import Bibliotecas.ProjetoFinal.Atividade.Atividade;
import Bibliotecas.ProjetoFinal.TxtUtils.Leitura;
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
		ListaAtividades = Leitura.LeituraTxt(arquivo);
	}
	
	@Test
	public void TestaLeituraArquivo() {
		assertNotNull(ListaAtividades);
	}
	
	@Test
	public void TestaLeituraCompletaArquivo() {
		int result = ListaAtividades.size();
		assertEquals(389, result);
	}
	
	@Test
	public void TestaNomeArquivo() {
		assertEquals("ListaAtividades.txt", arquivo.getFileName().toString());
	}
	
	@Test
	public void TestaSeNaoFaltaNenhumaAtividade() {
		StringBuilder comp = new StringBuilder();
		boolean ok = true;
		String aux;
		for(int i = 0; i < 389; i++) {
			aux = ListaAtividades.get(i).getId();
			comp.append("Atividade ").append(i + 1);
			if(!aux.equals(comp.toString())) {
				ok = false;
				break;
			}
			comp.delete(0, comp.length());
		}
		assertTrue(ok);
	}
	
	@Test
	public void TestaDiasDaSemana() {
		Set <String> dias = new HashSet <>();
		String dia[] = {"domingo", "segunda-feira", "terca-feira",
				"quarta-feira", "quinta-feira", "sexta-feira", "sabado"};
		
		for(Atividade atividade:ListaAtividades)
			dias.add(atividade.getDiaSemana());
		assertEquals(7, dias.size());
		
		boolean ok = true;
		for(int i = 0; i < 7; i++) 
			if(!dias.contains(dia[i])) {
				ok = false;
				break;
			}
			else
				dias.remove(dia[i]);
		
		assertTrue(ok);
		assertEquals(0, dias.size());
	}
	
	@Test
	public void TestaAtletasEquipe() {
		Set <String> atletas = new HashSet <>();
		for(Atividade atividade:ListaAtividades)
			atletas.add(atividade.getNomeAtleta());
		assertEquals(2, atletas.size());
	}
	
	@Test
	public void TestaEstiloAtividades() {
		Set <String> estilos = new HashSet <>();
		for(Atividade atividade:ListaAtividades)
			estilos.add(atividade.getEstilo());
		assertEquals(4, estilos.size());
	}
	
	@Test
	public void TestaValoresPositivos() {
		boolean ok = true;
		for(Atividade atividade:ListaAtividades)
			if(atividade.getDuracao().length() > 8 || atividade.getDuracao().length() < 5 ||
			   atividade.getDistancia() < 0 || atividade.getCalorias() < 0 || 
			   atividade.getAltimetria() < 0) {
				ok = false;
				break;
			}
		assertTrue(ok);
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
	
	@Test
	public void TestaTempoTotal() {
		String aux;
		int total = 0;
		for (Atividade atividade:ListaAtividades) {
			aux = atividade.getDuracao();
			String duracao[] = aux.split("-");
			total += Integer.parseInt(duracao[0])*3600 + 
					Integer.parseInt(duracao[1])*60 + Integer.parseInt(duracao[2]);
		}
		assertEquals(997343, total);
	}
}