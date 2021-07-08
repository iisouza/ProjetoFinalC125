package Bibliotecas.ProjetoFinal.TxtUtils;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.List;
import Bibliotecas.ProjetoFinal.Atividade.Atividade;
public class TotalEsporte {
	public static double[] TotalPorEsporte(Path arquivo) {
		List<Atividade> ListaAtividades = TxtUtils.LeituraTxt(arquivo);
		LinkedHashMap<String, String> TemposDia = new LinkedHashMap<>();
		TemposDia = TempoDiaSemana.TempoDia(arquivo);
		NumberFormat total = DecimalFormat.getNumberInstance();
		total.setMaximumFractionDigits(2);
		double totalEsporte[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		
		for (Atividade atividade:ListaAtividades) {
			if (atividade.getEstilo().equals("Corrida") || 
					atividade.getEstilo().equals("Esteira")) {
				totalEsporte[0] += atividade.getDistancia();
				if (atividade.getNomeAtleta().equals("Igor"))
					totalEsporte[1] += atividade.getDistancia();
				else
					totalEsporte[2] += atividade.getDistancia();
			}

			if (atividade.getEstilo().equals("Caminhada")) {
				totalEsporte[3] += atividade.getDistancia();
				if (atividade.getNomeAtleta().equals("Igor"))
					totalEsporte[4] += atividade.getDistancia();
				else
					totalEsporte[5] += atividade.getDistancia();
			}

			if (atividade.getEstilo().equals("Pedal")) {
				totalEsporte[6] += atividade.getDistancia();
				if (atividade.getNomeAtleta().equals("Igor"))
					totalEsporte[7] += atividade.getDistancia();
				else
					totalEsporte[8] += atividade.getDistancia();
			}
		}

		System.out.println("   Os atletas correram um total de " + 
				total.format(totalEsporte[0]) + "km:\t\t        "
					+ "\t Tempo total por dia da semana por atleta");
		System.out.println("        - Danilo correu " + total
			.format(totalEsporte[2]) + "km - " + total
			.format(totalEsporte[2] * 100 / totalEsporte[0]) + "%"
					+ "\t\t\t\t ————————————————————————————————————————");
		System.out.println("        - Igor correu " + total
			.format(totalEsporte[1]) + "km - "+ total
			.format(totalEsporte[1] * 100 / totalEsporte[0]) + "%"
				+ "\t\t   ————————————————————————————————————————————————————————————————————");
					
		System.out.println("\t\t\t\t\t\t\t   | Dia da semana |"
				+ "      Igor      |     Danilo     |     Totais     |" 
				+ "\n   Os atletas caminharam um total de " + total.format(totalEsporte[3]) + "km:"
				+ "\t\t   ————————————————————————————————————————————————————————————————————");
		
		System.out.println("\t- Danilo caminhou " + total
			.format(totalEsporte[5]) + "km - " + total
			.format(totalEsporte[5] * 100 / totalEsporte[3]) + "%\t\t   |    Domingo    |  " + 
			TemposDia.get("domingo").split("/")[0] + " |  " + TemposDia.get("domingo")
			.split("/")[1] + " |  " + TemposDia.get("domingo").split("/")[2] + " |");
		
		System.out.println("\t- Igor caminhou " + total
			.format(totalEsporte[4]) + "km - " + total
			.format(totalEsporte[4] * 100 / totalEsporte[3]) + "%\t\t   | Segunda-feira |  " +
			TemposDia.get("segunda-feira").split("/")[0] + " |  " + TemposDia.get("segunda-feira")
			.split("/")[1] + " |  " + TemposDia.get("segunda-feira").split("/")[2] + " |");
		
		System.out.println("\t\t\t\t\t\t\t   |  Terca-feira  |  " + 
			TemposDia.get("terca-feira").split("/")[0] + " |  " + TemposDia.get("terca-feira")
			.split("/")[1] + " |  " + TemposDia.get("terca-feira").split("/")[2] + " |");

		System.out.println("   Os atletas pedalaram um total de " + total
			.format(totalEsporte[6]) + "km:\t\t   | Quarta-feira  |  " + 
			TemposDia.get("quarta-feira").split("/")[0] + " |  " + TemposDia.get("quarta-feira")
			.split("/")[1] + " |  " + TemposDia.get("quarta-feira").split("/")[2] + " |");
		
		System.out.println("\t- Danilo pedalou " + total
			.format(totalEsporte[8]) + "km - " + total
			.format(totalEsporte[8] * 100 / totalEsporte[6]) + "%\t\t   | Quinta-feira  |  " + 
			TemposDia.get("quinta-feira").split("/")[0] + " |  " + TemposDia.get("quinta-feira")
			.split("/")[1] + " |  " + TemposDia.get("quinta-feira").split("/")[2] + " |");
		
		System.out.println("\t- Igor pedalou " + total
			.format(totalEsporte[7]) + "km - " + total
			.format(totalEsporte[7] * 100 / totalEsporte[6]) + "%\t\t   |  Sexta-feira  |  " + 
			TemposDia.get("sexta-feira").split("/")[0] + " |  " + TemposDia.get("sexta-feira")
			.split("/")[1] + " |  " + TemposDia.get("sexta-feira").split("/")[2] + " |");
		
		System.out.println("\t\t\t\t\t\t\t   |    Sabado     |  " + 
			TemposDia.get("sabado").split("/")[0] + " |  " + TemposDia.get("sabado")
			.split("/")[1] + " |  " + TemposDia.get("sabado").split("/")[2] + " |");
		
		return totalEsporte;
	}
}