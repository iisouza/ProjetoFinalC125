package Bibliotecas.ProjetoFinal.TxtUtils;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import Bibliotecas.ProjetoFinal.Atividade.Atividade;
public class DistribuicaoAtividades {
	public static void Panorama(Path arquivo) {
		List<Atividade> ListaAtividades = new ArrayList<>();
		ListaAtividades = TxtUtils.LeituraTxt(arquivo);
		int atividades[] = new int[6];
		
		for(Atividade atividade:ListaAtividades) {
			if(atividade.getNomeAtleta().equals("Igor")) {
				if(atividade.getEstilo().equals("Caminhada"))
					atividades[1]++;
				else if(atividade.getEstilo().equals("Pedal"))
					atividades[2]++;
				else
					atividades[0]++;
			}
			
			else if(atividade.getNomeAtleta().equals("Danilo")) {
				if(atividade.getEstilo().equals("Caminhada"))
					atividades[4]++;
				else if(atividade.getEstilo().equals("Pedal"))
					atividades[5]++;
				else
					atividades[3]++;
			}
		}
		
		int soma = 0;
		for(int i = 0; i < 6; i++)
			soma += atividades[i];
		
		System.out.println("   A equipe realizou " + soma + " atividades, sendo " 
			+ (atividades[0] + atividades[3]) + " corridas, "
			+ (atividades[1] + atividades[4]) + " caminhadas e "
			+ (atividades[2] + atividades[5]) + " pedais.");
		
		System.out.println("\t- Danilo realizou " + (atividades[3] + atividades[4] 
			+ atividades[5]) + " atividades, sendo " +  atividades[3] 
			+ " corridas, " + atividades[4] + " caminhadas e "
			+ atividades[5] + " pedais.");
		
		System.out.println("\t- Igor realizou " + (atividades[0] + atividades[1]
			+ atividades[2]) + " atividades, sendo " + atividades[0]
			+ " corridas, " + atividades[1] + " caminhadas e "
			+ atividades[2] + " pedais.");
	}
}