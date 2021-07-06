package Bibliotecas.ProjetoFinal.Principal;
import java.nio.file.Path;
import java.nio.file.Paths;
import Bibliotecas.ProjetoFinal.EquipeEsportiva.Equipe;
import Bibliotecas.ProjetoFinal.Esportista.Atleta;
import Bibliotecas.ProjetoFinal.TxtUtils.DiaAtivo;
import Bibliotecas.ProjetoFinal.TxtUtils.DistribuicaoAtividades;
import Bibliotecas.ProjetoFinal.TxtUtils.FormatarPrimeiraTabela;
import Bibliotecas.ProjetoFinal.TxtUtils.FormatarSegundaTabela;
import Bibliotecas.ProjetoFinal.TxtUtils.TotalEsporte;
public class Main {
	public static void main(String[] args) {
		Path arquivo = Paths.get("ListaAtividades.txt");
		
		Equipe equipe = new Equipe("Equipe C125", 2, "Phyll", "28/11/2015");
		equipe.AdicionarAtleta(new Atleta(1, "Igor", 21,
				"estudante de engenharia", "Santa Rita do Sapucaí/MG", "24/01/00."));
		equipe.AdicionarAtleta(new Atleta(2, "Danilo", 21,
				"estudante de engenharia","Pouso Alegre/MG", "12/01/00."));
		
		System.out.print("\n\t\t\t\t    Análise esportiva da " + equipe.getNomeEquipe());
		System.out.println("\n\t\t\t\t    ————————————————————————————————");
		equipe.MostraInfo();
		FormatarPrimeiraTabela.Tabela(arquivo);
		FormatarSegundaTabela.Tabela(arquivo);
		DiaAtivo.DiaMaisAtivo(arquivo);
		DistribuicaoAtividades.Panorama(arquivo);
		TotalEsporte.TotalPorEsporte(arquivo);
	}
}