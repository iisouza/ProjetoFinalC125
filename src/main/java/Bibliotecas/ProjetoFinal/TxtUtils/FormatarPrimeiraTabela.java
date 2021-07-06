package Bibliotecas.ProjetoFinal.TxtUtils;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import Bibliotecas.ProjetoFinal.FuncoesOtimizacao.Funcoes;
public class FormatarPrimeiraTabela {
	public static void Tabela(Path arquivo) {
		LinkedHashMap<String, String> AtividadesDia = new LinkedHashMap<>();
		LinkedHashMap<String, String> AltimetriaDia = new LinkedHashMap<>();
		LinkedHashMap<String, String> MapaOrdenado = new LinkedHashMap<>();
		StringBuilder atv = new StringBuilder();
		AtividadesDia = AtividadesDiaSemana.AtividadeDia(arquivo);
		AltimetriaDia = AltimetriaDiaSemana.AltimetriaDia(arquivo);
		int total[] = new int[4];
		for (int i = 0; i < 7; i++) {
			atv.append(AtividadesDia.get(Funcoes.DiaSemana(i))).append("/")
			   .append(AltimetriaDia.get(Funcoes.DiaSemana(i)));
			MapaOrdenado.put(Funcoes.DiaSemana(i), atv.toString());
			atv.delete(0, atv.length());
		}
		
		System.out.println("\n     Número de atividades por dia por atleta" + 
				"\t\t    Altimetria por dia por atleta");
		System.out.println("     ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾" +
				"\t\t    ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
		System.out.println("   ———————————————————————————————————————————" + 
				"     ———————————————————————————————————————————————");
		System.out.println("   | Dia da semana |  Igor  | Danilo | Total |" + 
				"     | Dia da semana |  Igor   | Danilo  |  Total  |");
		System.out.println("   ———————————————————————————————————————————" + 
				"     ———————————————————————————————————————————————");
		MapaOrdenado.forEach((chave, valor) -> {
			chave = chave.substring(0, 1).toUpperCase().concat(chave.substring(1));
			int aux = chave.length();
			System.out.print("   |");
			for (int i = 0; i < (15 - aux) / 2; i++)
				System.out.print(" ");

			System.out.print(chave);
			for (int i = 0; i < (16 - aux) / 2; i++)
				System.out.print(" ");
			
			int totalp = Integer.parseInt(valor.split("/")[0].strip()) 
					+ Integer.parseInt(valor.split("/")[1].strip());
			System.out.print("|   " + valor.split("/")[0].strip() + "   |   " 
							+ valor.split("/")[1].strip() + "   |   " + totalp + "  |");
			
			System.out.print("     |");
			for (int i = 0; i < (15 - aux) / 2; i++)
				System.out.print(" ");

			System.out.print(chave);
			for (int i = 0; i < (16 - aux) / 2; i++)
				System.out.print(" ");
			
			totalp = Integer.parseInt(valor.split("/")[2].strip()) 
					+ Integer.parseInt(valor.split("/")[3].strip());
			System.out.println("|  " + valor.split("/")[2].strip() + " m |" + 
			"  " + valor.split("/")[3].strip() + " m |  " + totalp + " m |");
			
			for(int i = 0; i < 4; i++)
				total[i] += Integer.parseInt(valor.split("/")[i].strip());	
		});
		System.out.println("   ———————————————————————————————————————————" + 
				"     ———————————————————————————————————————————————");
		System.out.println("   |     Total     |   " + total[0] + "  |   " 
		+ total[1] + "  |  " + (total[0] + total[1]) + "  |" + "     |     Total     | " 
				+ total[2] + " m | " + total[3] + " m | " + (total[2] + total[3]) + " m |");
		System.out.println("   ———————————————————————————————————————————" + 
				"     ———————————————————————————————————————————————");
		System.out.println("");
	}
}