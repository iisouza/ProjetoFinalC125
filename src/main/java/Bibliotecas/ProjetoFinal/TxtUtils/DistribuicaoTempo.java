package Bibliotecas.ProjetoFinal.TxtUtils;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import Bibliotecas.ProjetoFinal.Atividade.Atividade;
import Bibliotecas.ProjetoFinal.FuncoesOtimizacao.Funcoes;
public class DistribuicaoTempo {
	public static void Panorama(Path arquivo) {
		List<Atividade> ListaAtividades = new ArrayList<>();
		ListaAtividades = TxtUtils.LeituraTxt(arquivo);
		LinkedHashMap<String, String> TemposDia = new LinkedHashMap<>();
		TemposDia = TempoDiaSemana.TempoDia(arquivo);
		NumberFormat form = DecimalFormat.getNumberInstance();
		form.setMaximumFractionDigits(2);
		int tempo[] = new int[6];
		int hora, minuto, segundo;
		
		for(Atividade atividade:ListaAtividades) {
			hora = Integer.parseInt(atividade.getDuracao().split("-")[0].strip());
			minuto = Integer.parseInt(atividade.getDuracao().split("-")[1].strip());
			segundo = Integer.parseInt(atividade.getDuracao().split("-")[2].strip());
			
			if(atividade.getNomeAtleta().equals("Igor"))
				if(atividade.getEstilo().equals("Caminhada")) 
					tempo[1] += (hora*3600 + minuto*60 + segundo);
				else if(atividade.getEstilo().equals("Pedal")) 
					tempo[2] += (hora*3600 + minuto*60 + segundo);
				else
					tempo[0] += (hora*3600 + minuto*60 + segundo);
			
			else if(atividade.getNomeAtleta().equals("Danilo"))
				if(atividade.getEstilo().equals("Caminhada"))
					tempo[4] += (hora*3600 + minuto*60 + segundo);
				else if(atividade.getEstilo().equals("Pedal"))
					tempo[5] += (hora*3600 + minuto*60 + segundo);
				else
					tempo[3] += (hora*3600 + minuto*60 + segundo);
		}
			
		System.out.println("   Os atletas correram por " + 
				Funcoes.HoraFormat(tempo[0] + tempo[3]) + 
				":\t\t   ————————————————————————————————————————————————————————————————————");
		System.out.println("\t- Danilo correu por " + Funcoes.HoraFormat(tempo[3]) + " - " 
				+ form.format((tempo[3] * 100.0)/(tempo[0] + tempo[3])) + "%\t   |     Total     | " + 
				TemposDia.get("Total").split("/")[0] + " | " + TemposDia.get("Total")
				.split("/")[1] + " | " + TemposDia.get("Total").split("/")[2] + " |");
		
		System.out.println("\t- Igor correu por " + Funcoes.HoraFormat(tempo[0]) + 
				" - " + form.format((tempo[0] * 100.0)/(tempo[0] + tempo[3])) + "%" + 
				"\t   ————————————————————————————————————————————————————————————————————\n");
		
		System.out.println("   Os atletas caminharam por " + 
				Funcoes.HoraFormat(tempo[1] + tempo[4]) + ":");
		System.out.println("\t- Danilo correu por " + Funcoes.HoraFormat(tempo[4]) + 
				" - " + form.format((tempo[4] * 100.0)/(tempo[1] + tempo[4])) + "%");
		System.out.println("\t- Igor correu por " + Funcoes.HoraFormat(tempo[1]) + 
				" - " + form.format((tempo[1] * 100.0)/(tempo[1] + tempo[4])) + "%\n");
		
		System.out.println("   Os atletas pedalaram por " + 
				Funcoes.HoraFormat(tempo[2] + tempo[5]) + ":");
		System.out.println("\t- Danilo correu por " + Funcoes.HoraFormat(tempo[5]) + 
				" - " + form.format((tempo[5] * 100.0)/(tempo[2] + tempo[5])) + "%");
		System.out.println("\t- Igor correu por " + Funcoes.HoraFormat(tempo[2]) + 
				" - " + form.format((tempo[2] * 100.0)/(tempo[2] + tempo[5])) + "%\n");
	}
}