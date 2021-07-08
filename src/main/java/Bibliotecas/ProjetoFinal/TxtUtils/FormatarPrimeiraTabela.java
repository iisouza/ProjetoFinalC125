package Bibliotecas.ProjetoFinal.TxtUtils;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import Bibliotecas.ProjetoFinal.FuncoesOtimizacao.Dias;
public class FormatarPrimeiraTabela {
	public static void Tabela(Path arquivo) {
		LinkedHashMap<String, String> AtividadesDia = new LinkedHashMap<>();
		LinkedHashMap<String, String> AltimetriaDia = new LinkedHashMap<>();
		LinkedHashMap<String, String> MapaOrdenado = new LinkedHashMap<>();
		
		AtividadesDia = AtividadesDiaSemana.AtividadeDia(arquivo);
		AltimetriaDia = AltimetriaDiaSemana.AltimetriaDia(arquivo);
		StringBuilder atv = new StringBuilder();
		
		int total[] = new int[4];
		NumberFormat form = DecimalFormat.getNumberInstance();
		form.setMaximumFractionDigits(0);
		
		for (int i = 0; i < 7; i++) {
			atv.append(AtividadesDia.get(Dias.DiaSemana(i))).append("/")
			   .append(AltimetriaDia.get(Dias.DiaSemana(i)));
			MapaOrdenado.put(Dias.DiaSemana(i), atv.toString());
			atv.delete(0, atv.length());
		}
		
		System.out.println("\n\tNúmero de atividades por dia por atleta"
			+ "\t\t\t    Altimetria por dia por atleta");
		
		System.out.println("\t‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾"
			+ "\t\t\t    ‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
		
		System.out.println("   ——————————————————————————————————————————————————" 
			+ "     ——————————————————————————————————————————————————");
		
		System.out.println("   | Dia da semana |   Igor   |  Danilo  |  Totais  |"
			+ "     | Dia da semana |   Igor   |  Danilo  |  Totais  |");
		
		System.out.println("   ——————————————————————————————————————————————————"
			+ "     ——————————————————————————————————————————————————");
		
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
			
			System.out.print("|  " + valor.split("/")[0].strip() + " atv. |  " 
				+ valor.split("/")[1].strip() + " atv. |  " + totalp + " atv. |     |");
			
			for (int i = 0; i < (15 - aux) / 2; i++)
				System.out.print(" ");

			System.out.print(chave);
			for (int i = 0; i < (16 - aux) / 2; i++)
				System.out.print(" ");
			
			totalp = Integer.parseInt(valor.split("/")[2].strip()) 
					+ Integer.parseInt(valor.split("/")[3].strip());
			
			System.out.println("|  " + form.format(Integer.parseInt(valor.split("/")[2]
					.strip())) + " m |  " + form.format(Integer.parseInt(valor.split("/")[3]
					.strip()))  + " m |  " + form.format(totalp)  + " m |");
			
			for(int i = 0; i < 4; i++)
				total[i] += Integer.parseInt(valor.split("/")[i].strip());	
		});
		
		System.out.println(
			"   ——————————————————————————————————————————————————" 
			+ "     ——————————————————————————————————————————————————");
		
		System.out.println("   |     Total     | " + total[0] + " atv. | " + total[1] 
			+ " atv. | " + (total[0] + total[1]) + " atv. |" + "     |     Total     | " 
			+ form.format(total[2]) + " m | " + form.format(total[3]) + " m | " + 
			form.format(total[2] + total[3]) + " m |");
		
		System.out.println("   ——————————————————————————————————————————————————"
			+ "     ——————————————————————————————————————————————————\n");
	}
}