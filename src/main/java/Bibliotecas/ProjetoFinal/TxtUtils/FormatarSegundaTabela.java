package Bibliotecas.ProjetoFinal.TxtUtils;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import Bibliotecas.ProjetoFinal.FuncoesOtimizacao.Dias;
public class FormatarSegundaTabela {
	public static void Tabela(Path arquivo) {
		LinkedHashMap<String, String> DistanciaDia = new LinkedHashMap<>();
		LinkedHashMap<String, String> CaloriaDia = new LinkedHashMap<>();
		LinkedHashMap<String, String> MapaOrdenado = new LinkedHashMap<>();
		
		StringBuilder atv = new StringBuilder();
		DistanciaDia = DistanciaDiaSemana.DistanciaDia(arquivo);
		CaloriaDia = CaloriaDiaSemana.CaloriaDia(arquivo);
		
		double total[] = new double[4];
		NumberFormat form1 = DecimalFormat.getNumberInstance();
		NumberFormat form2 = DecimalFormat.getNumberInstance();
		form1.setMaximumFractionDigits(1);
		form2.setMaximumFractionDigits(0);
		
		for (int i = 0; i < 7; i++) {
			atv.append(DistanciaDia.get(Dias.DiaSemana(i))).append("/")
			   .append(CaloriaDia.get(Dias.DiaSemana(i)));
			MapaOrdenado.put(Dias.DiaSemana(i), atv.toString());
			atv.delete(0, atv.length());
		}
		
		System.out.println("\t Distância das atividades por dia por atleta" + 
				"\t\t\t\t  Calorias por dia por atleta");
		
		System.out.println("\t ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾" +
				"\t\t\t\t  ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
		
		System.out.println("   ————————————————————————————————————————————————————————" + 
				"     ———————————————————————————————————————————————————————————————");
		
		System.out.println("   | Dia da semana |    Igor    |   Danilo   |   Totais   |" + 
				"     | Dia da semana |     Igor     |    Danilo    |    Totais     |");
		
		System.out.println("   ————————————————————————————————————————————————————————" + 
				"     ———————————————————————————————————————————————————————————————");
		
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
			
			System.out.print("|   " + valor.split("/")[0].strip().replace(".", ",") 
				+ " km |   " + valor.split("/")[1].strip().replace(".", ",") + 
				" km |   " + atv.toString().replace(".", ",") + " km |");
			atv.delete(0, atv.length());
			
			System.out.print("     |");
			for (int i = 0; i < (15 - aux) / 2; i++)
				System.out.print(" ");

			System.out.print(chave);
			for (int i = 0; i < (16 - aux) / 2; i++)
				System.out.print(" ");
			
			totalp = Integer.parseInt(valor.split("/")[2].strip()) 
					+ Integer.parseInt(valor.split("/")[3].strip());
			
			System.out.println("| " + form2.format(Integer.parseInt(valor.split("/")[2].
				strip())) + " kcal. | " + form2.format(Integer.parseInt(valor.split("/")[3].
				strip())) + " kcal. |  " + form2.format(totalp) + " kcal. |");
			
			total[0] += Double.parseDouble(valor.split("/")[0].strip());
			total[1] += Double.parseDouble(valor.split("/")[1].strip());
			total[2] += Integer.parseInt(valor.split("/")[2].strip());
			total[3] += Integer.parseInt(valor.split("/")[3].strip());
		});
		
		System.out.println("   ————————————————————————————————————————————————————————" + 
				"     ———————————————————————————————————————————————————————————————");
		
		System.out.println("   |     Total     | " + form1.format(total[0]) + " km | " 
				+ form1.format(total[1]) + " km | " + form1.format((total[0] + total[1])) + 
				" km |" + "     |     Total     | " + form2.format(total[2]) + " kcal. | " 
				+ form2.format(total[3]) + " kcal. | " + form2.format(total[2] +total[3]) + " kcal. |");
		
		System.out.println("   ————————————————————————————————————————————————————————" + 
				"     ———————————————————————————————————————————————————————————————\n");
	}
}