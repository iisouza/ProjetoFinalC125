package Bibliotecas.ProjetoFinal.TxtUtils;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import Bibliotecas.ProjetoFinal.Atividade.Atividade;
public class TotalEsporte {
	public static double[] TotalPorEsporte(Path arquivo) {
		List<Atividade> ListaAtividades = TxtUtils.LeituraTxt(arquivo);
		NumberFormat total = DecimalFormat.getNumberInstance();
		total.setMaximumFractionDigits(2);
		double totalEsporte[] = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };

		for (Atividade atividade : ListaAtividades) {
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
				total.format(totalEsporte[0]) + "km.");
		if (totalEsporte[1] > totalEsporte[2]) {
			System.out.println("\t- Igor correu " + total
				.format(totalEsporte[1]) + "km - " + total
				.format(totalEsporte[1] * 100 / totalEsporte[0]) + "%");
			System.out.println("\t- Danilo correu " + total
				.format(totalEsporte[2]) + "km - " + total
				.format(totalEsporte[2] * 100 / totalEsporte[0]) + "%\n");
		}

		else {
			System.out.println("        - Danilo correu " + total
				.format(totalEsporte[2]) + "km - " + total
				.format(totalEsporte[2] * 100 / totalEsporte[0]) + "%");
			System.out.println("        - Igor correu " + total
				.format(totalEsporte[1]) + "km - "+ total
				.format(totalEsporte[1] * 100 / totalEsporte[0]) + "%\n");
		}

		System.out.println("   Os atletas caminharam um total de " + 
				total.format(totalEsporte[3]) + "km.");
		if (totalEsporte[4] > totalEsporte[5]) {
			System.out.println("\t- Igor caminhou " + total
				.format(totalEsporte[4]) + "km - " + total
				.format(totalEsporte[4] * 100 / totalEsporte[3]) + "%");
			System.out.println("\t- Danilo caminhou " + total
				.format(totalEsporte[5]) + "km - " + total
				.format(totalEsporte[5] * 100 / totalEsporte[3]) + "%\n");
		}

		else {
			System.out.println("\t- Danilo caminhou " + total
				.format(totalEsporte[5]) + "km - " + total
				.format(totalEsporte[5] * 100 / totalEsporte[3]) + "%");
			System.out.println("\t- Danilo caminhou " + total
				.format(totalEsporte[4]) + "km - " + total
				.format(totalEsporte[4] * 100 / totalEsporte[3]) + "%\n");
		}

		System.out.println("   Os atletas pedalaram um total de " + total
			.format(totalEsporte[6]) + "km.");
		if (totalEsporte[6] > totalEsporte[7]) {
			System.out.println("\t- Igor pedalou " + total
				.format(totalEsporte[7]) + "km - " + total
				.format(totalEsporte[7] * 100 / totalEsporte[6]) + "%");
			System.out.println("\t- Danilo pedalou " + total
				.format(totalEsporte[8]) + "km - " + total
				.format(totalEsporte[8] * 100 / totalEsporte[6]) + "%\n");
		}

		else {
			System.out.println("\t- Danilo pedalou " + total
				.format(totalEsporte[8]) + "km - " + total
				.format(totalEsporte[8] * 100 / totalEsporte[6]) + "%");
			System.out.println("\t- Igor pedalou " + total
				.format(totalEsporte[7]) + "km - " + total
				.format(totalEsporte[7] * 100 / totalEsporte[6]) + "%\n");
		}
		
		return totalEsporte;
	}
}