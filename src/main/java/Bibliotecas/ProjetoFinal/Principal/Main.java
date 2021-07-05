package Bibliotecas.ProjetoFinal.Principal;
import java.nio.file.Path;
import java.nio.file.Paths;
import Bibliotecas.ProjetoFinal.EquipeEsportiva.Equipe;
import Bibliotecas.ProjetoFinal.Esportista.Corredor;
import Bibliotecas.ProjetoFinal.TxtUtils.DiaAtivo;
import Bibliotecas.ProjetoFinal.TxtUtils.DistribuicaoAtividades;
import Bibliotecas.ProjetoFinal.TxtUtils.FormatarTabela;
import Bibliotecas.ProjetoFinal.TxtUtils.TotalEsporte;
public class Main {
	public static void main(String[] args) {
		Path arquivo = Paths.get("ListaAtividades.txt");
		
		Equipe equipe = new Equipe("Equipe C125", 2);
		equipe.AdicionarAtleta(new Corredor(1, "Igor", 21));
		equipe.AdicionarAtleta(new Corredor(2, "Danilo", 21));
		
		System.out.println("\n   Análise esportiva da " + equipe.getNome());
		System.out.println("   ————————————————————————————————");
		equipe.MostraInfo();
		FormatarTabela.Tabela(arquivo);
		DiaAtivo.DiaMaisAtivo(arquivo);
		DistribuicaoAtividades.Panorama(arquivo);
		TotalEsporte.TotalPorEsporte(arquivo);
	}
}