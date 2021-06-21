package Bibliotecas.ProjetoFinal.Utils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import Bibliotecas.ProjetoFinal.Atividade.Atividade;
import Bibliotecas.ProjetoFinal.FuncoesOtimizacao.Funcoes;
public class TxtUtils {
	public static List <Atividade> LeituraTxt(Path arquivo) {
		List <Atividade> ListaAtividades = new ArrayList <>();
		NumberFormat total = DecimalFormat.getNumberInstance();
		total.setMaximumFractionDigits(2);
		try {
			List <String> atividades = Files.readAllLines(arquivo);
			atividades.remove(0);
			atividades.forEach((descricao) -> {
				String[] dados = descricao.split(";");
				StringBuilder hora = new StringBuilder();
				hora.append(dados[3]).append("h");
				
				if(Integer.parseInt(dados[4]) < 10)
					hora.append("0");
				hora.append(Integer.parseInt(dados[4])).append("min");
				
				if(Integer.parseInt(dados[5]) < 10)
					hora.append("0");
				hora.append(Integer.parseInt(dados[5])).append("seg");
				
				ListaAtividades.add(new Atividade(dados[0], dados[1], 
						Double.parseDouble(dados[2].replace(",", ".")), hora.toString(), 
						Integer.parseInt(dados[6]), Integer.parseInt(dados[7]), dados[8], dados[9]));
			});
		} catch (IOException erro) {
			System.out.println("Erro no arquivo!\n");
		}
		return ListaAtividades;
	}
	
	public static LinkedHashMap <String, String> AtividadeDiaSemana(Path arquivo) {
		LinkedHashMap <String, String> AtividadesDia = new LinkedHashMap <>();
		List <Atividade> ListaAtividades = LeituraTxt(arquivo);
		int DiasContador1[] = {0, 0, 0, 0, 0, 0, 0};
		int DiasContador2[] = {0, 0, 0, 0, 0, 0, 0};
		
		for(Atividade atividade:ListaAtividades) {
			if(atividade.getNomeAtleta().equals("Igor")) 
				DiasContador1[Funcoes.PosicaoElemento(atividade.getDiaSemana())]++;
			
			if(atividade.getNomeAtleta().equals("Danilo")) 
				DiasContador2[Funcoes.PosicaoElemento(atividade.getDiaSemana())]++;
		}
		
		for (int i = 0; i < 7; i++)
			AtividadesDia.put(Funcoes.DiaSemana(i), DiasContador1[i] + "/" + DiasContador2[i]);
		
//		saida de teste do mapamento das atividades por dia
//		System.out.println("Atividades Igor:");
//		AtividadesDia.forEach((dia, numAtividades) -> {
//			System.out.println(numAtividades + " atividades " + dia);
//		});
		return AtividadesDia;
	}
	
	public static double[] TotalPorEsporte(Path arquivo) {
		List <Atividade> ListaAtividades = LeituraTxt(arquivo);
		NumberFormat total = DecimalFormat.getNumberInstance();
		total.setMaximumFractionDigits(2);
		double totalEsporte[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		
		for(Atividade atividade:ListaAtividades) {
			if(atividade.getEstilo().equals("Corrida") ||
					atividade.getEstilo().equals("Esteira"))
			{
				totalEsporte[0] += atividade.getDistancia();
				if(atividade.getNomeAtleta().equals("Igor"))
					totalEsporte[1] += atividade.getDistancia();
				else
					totalEsporte[2] += atividade.getDistancia();
			}
			
			if(atividade.getEstilo().equals("Caminhada"))
			{
				totalEsporte[3] += atividade.getDistancia();
				if(atividade.getNomeAtleta().equals("Igor"))
					totalEsporte[4] += atividade.getDistancia();
				else
					totalEsporte[5] += atividade.getDistancia();
			}
			
			if(atividade.getEstilo().equals("Pedal"))
			{
				totalEsporte[6] += atividade.getDistancia();
				if(atividade.getNomeAtleta().equals("Igor"))
					totalEsporte[7] += atividade.getDistancia();
				else
					totalEsporte[8] += atividade.getDistancia();
			}
		}
		
//		saida de teste do mapamento da distancia total por atividade
		System.out.println("Os atletas correram um total de " + total.format(totalEsporte[0]) + "km.");
		System.out.println("   Desse total:");
		if(totalEsporte[1] > totalEsporte[2]) {
			System.out.println("     - Igor correu mais: " + total.format(totalEsporte[1]) + "km - " +
					total.format(totalEsporte[1]*100/totalEsporte[0]) + "%");
			System.out.println("     - Danilo correu menos: " + total.format(totalEsporte[2]) + "km - " +
					total.format(totalEsporte[2]*100/totalEsporte[0]) + "%\n");
		}
		
		else {
			System.out.println("     - Danilo correu mais: " + total.format(totalEsporte[2]) + "km - " +
					total.format(totalEsporte[2]*100/totalEsporte[0]) + "%");
			System.out.println("     - Igor correu menos: " + total.format(totalEsporte[1]) + "km - " +
					total.format(totalEsporte[1]*100/totalEsporte[0]) + "%\n");
		}
		
		System.out.println("Os atletas caminharam um total de " + total.format(totalEsporte[3]) + "km.");
		System.out.println("   Desse total:");
		if(totalEsporte[4] > totalEsporte[5]) {
			System.out.println("     - Igor caminhou mais: " + total.format(totalEsporte[4]) + "km - " +
					total.format(totalEsporte[4]*100/totalEsporte[3]) + "%");
			System.out.println("     - Danilo caminhou menos: " + total.format(totalEsporte[5]) + "km - " +
					total.format(totalEsporte[5]*100/totalEsporte[3]) + "%\n");
		}
		
		else {
			System.out.println("     - Danilo caminhou mais: " + total.format(totalEsporte[5]) + "km - " +
					total.format(totalEsporte[5]*100/totalEsporte[3]) + "%");
			System.out.println("     - Danilo correu menos: " + total.format(totalEsporte[4]) + "km - " +
					total.format(totalEsporte[4]*100/totalEsporte[3]) + "%\n");
		}
		
		System.out.println("Os atletas pedalaram um total de " + total.format(totalEsporte[6]) + "km.");
		System.out.println("   Desse total:");
		if(totalEsporte[6] > totalEsporte[7]) {
			System.out.println("     - Igor pedalou mais: " + total.format(totalEsporte[7]) + "km - " +
					total.format(totalEsporte[7]*100/totalEsporte[6]) + "%");
			System.out.println("     - Danilo pedalou menos: " + total.format(totalEsporte[8]) + "km - " +
					total.format(totalEsporte[8]*100/totalEsporte[6]) + "%\n");
		}
		
		else {
			System.out.println("     - Danilo pedalou mais: " + total.format(totalEsporte[8]) + "km - " +
					total.format(totalEsporte[8]*100/totalEsporte[6]) + "%");
			System.out.println("     - Igor pedalou menos: " + total.format(totalEsporte[7]) + "km - " +
					total.format(totalEsporte[7]*100/totalEsporte[6]) + "%\n");
		}
		return totalEsporte;
	}
}