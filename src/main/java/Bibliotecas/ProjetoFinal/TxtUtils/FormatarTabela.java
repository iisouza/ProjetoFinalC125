package Bibliotecas.ProjetoFinal.TxtUtils;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import Bibliotecas.ProjetoFinal.FuncoesOtimizacao.Funcoes;
public class FormatarTabela {
	private static int total1, total2;
	public static void Tabela(Path arquivo) {
		LinkedHashMap<String, String> AtividadesDia = new LinkedHashMap<>();
		LinkedHashMap<String, String> MapaOrdenado = new LinkedHashMap<>();
		AtividadesDia = AtividadesDiaSemana.AtividadeDia(arquivo);
		total1 = 0;
		total2 = 0;
		
		for (int i = 0; i < 7; i++)
			MapaOrdenado.put(Funcoes.DiaSemana(i), AtividadesDia.get(Funcoes.DiaSemana(i)));

		System.out.println("\n     Número de atividades por dia por atleta");
		System.out.println("     ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
		System.out.println("   ———————————————————————————————————————————");
		System.out.println("   | Dia da semana |  Igor  | Danilo | Total |");
		System.out.println("   ———————————————————————————————————————————");
		MapaOrdenado.forEach((chave, valor) -> {
			chave = chave.substring(0, 1).toUpperCase().concat(chave.substring(1));
			int aux = chave.length();
			System.out.print("   |");
			for (int i = 0; i < (15 - aux) / 2; i++)
				System.out.print(" ");

			System.out.print(chave);
			for (int i = 0; i < (16 - aux) / 2; i++)
				System.out.print(" ");
			
			int total = Integer.parseInt(valor.split("/")[0].strip()) 
					+ Integer.parseInt(valor.split("/")[1].strip());
			
			System.out.println("|   " + valor.split("/")[0].strip() + "   |   " 
							+ valor.split("/")[1].strip() + "   |   " + total + "  |");
			
			total1 += Integer.parseInt(valor.split("/")[0].strip());
			total2 += Integer.parseInt(valor.split("/")[1].strip());
			System.out.println("   ———————————————————————————————————————————");
		});
		System.out.println("   |     Total     |   " + total1 + "  |   " 
		+ total2 + "  |  " + (total1 + total2) + "  |");
		System.out.println("   ———————————————————————————————————————————");
		System.out.println("");
	}
}