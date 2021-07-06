package Bibliotecas.ProjetoFinal.TxtUtils;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import Bibliotecas.ProjetoFinal.FuncoesOtimizacao.Funcoes;
public class FormatarSegundaTabela {
	public static void Tabela(Path arquivo) {
		LinkedHashMap<String, String> DistanciaDia = new LinkedHashMap<>();
		LinkedHashMap<String, String> CaloriaDia = new LinkedHashMap<>();
		LinkedHashMap<String, String> MapaOrdenado = new LinkedHashMap<>();
		StringBuilder atv = new StringBuilder();
		DistanciaDia = DistanciaDiaSemana.DistanciaDia(arquivo);
		CaloriaDia = CaloriaDiaSemana.CaloriaDia(arquivo);
		NumberFormat form = DecimalFormat.getNumberInstance();
		form.setMaximumFractionDigits(1);
		double total[] = new double[4];
		
		for (int i = 0; i < 7; i++) {
			atv.append(DistanciaDia.get(Funcoes.DiaSemana(i))).append("/")
			   .append(CaloriaDia.get(Funcoes.DiaSemana(i)));
			MapaOrdenado.put(Funcoes.DiaSemana(i), atv.toString());
			atv.delete(0, atv.length());
		}
		
		System.out.println("\t Distância das atividades por dia por atleta" + 
				"\t\t\t\tCalorias por dia por atleta");
		System.out.println("\t ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾" +
				"\t\t\t\t‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
		System.out.println("   ————————————————————————————————————————————————————————" + 
				"     —————————————————————————————————————————————————————————");
		System.out.println("   | Dia da semana |    Igor    |   Danilo   |    Total   |" + 
				"     | Dia da semana |    Igor    |   Danilo   |    Total    |");
		System.out.println("   ————————————————————————————————————————————————————————" + 
				"     —————————————————————————————————————————————————————————");
		MapaOrdenado.forEach((chave, valor) -> {
			chave = chave.substring(0, 1).toUpperCase().concat(chave.substring(1));
			int aux = chave.length();
			System.out.print("   |");
			for (int i = 0; i < (15 - aux) / 2; i++)
				System.out.print(" ");

			System.out.print(chave);
			for (int i = 0; i < (16 - aux) / 2; i++)
				System.out.print(" ");
			
			double totalp = (Double.parseDouble(valor.split("/")[0].strip()) 
					+ Double.parseDouble(valor.split("/")[1].strip()));
			atv.append(totalp);
			System.out.print("|   " + valor.split("/")[0].strip().replace(".", ",") + " km |   " 
							+ valor.split("/")[1].strip().replace(".", ",") + " km |   " 
							+ atv.toString().replace(".", ",") + " km |");
			atv.delete(0, atv.length());
			
			System.out.print("     |");
			for (int i = 0; i < (15 - aux) / 2; i++)
				System.out.print(" ");

			System.out.print(chave);
			for (int i = 0; i < (16 - aux) / 2; i++)
				System.out.print(" ");
			
			totalp = Integer.parseInt(valor.split("/")[2].strip()) 
					+ Integer.parseInt(valor.split("/")[3].strip());
			System.out.println("| " + valor.split("/")[2].strip() + " cal. |" + 
			" " + valor.split("/")[3].strip() + " cal. |  " + (int)totalp + " cal. |");
			
			total[0] += Double.parseDouble(valor.split("/")[0].strip());
			total[1] += Double.parseDouble(valor.split("/")[1].strip());
			total[2] += Integer.parseInt(valor.split("/")[2].strip());
			total[3] += Integer.parseInt(valor.split("/")[3].strip());
		});
		System.out.println("   ————————————————————————————————————————————————————————" + 
				"     —————————————————————————————————————————————————————————");
		System.out.println("   |     Total     | " + form.format(total[0]) + " km | " 
		+ form.format(total[1]) + " km | " + form.format((total[0] + total[1])) + " km |" + "     |     Total     | " 
				+ (int)total[2] + " cal. | " + (int)total[3] + " cal. | " + (int)(total[2] + total[3]) + " cal. |");
		System.out.println("   ————————————————————————————————————————————————————————" + 
				"     —————————————————————————————————————————————————————————");
		System.out.println("");
	}
}