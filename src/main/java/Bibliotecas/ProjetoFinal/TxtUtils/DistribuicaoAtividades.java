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
		
		System.out.println("   A equipe realizou " + soma + " atividades, sendo:");
		System.out.println("      - " + (atividades[0] + 
				atividades[3]) + " corridas");
		System.out.println("      - " + (atividades[1] + 
				atividades[4]) + " caminhadas");
		System.out.println("      - " + (atividades[2] + 
				atividades[5]) + " pedais\n");
		
		System.out.println("      -> Igor realizou " +
			(atividades[0] + atividades[1] + atividades[2]) + " atividades, sendo:");
		System.out.println("         - " + 
						atividades[0] + " corridas");
		System.out.println("         - " + 
						atividades[1] + " caminhadas");
		System.out.println("         - " + 
						atividades[2] + " pedais\n");
		
		System.out.println("      -> Danilo realizou as outras " + 
				(atividades[3] + atividades[4] + 
						atividades[5]) + " atividades, sendo:");
		System.out.println("         - " + atividades[3] + " corridas");
		System.out.println("         - " + atividades[4] + " caminhadas");
		System.out.println("         - " + atividades[5] + " pedais\n");
	}
}