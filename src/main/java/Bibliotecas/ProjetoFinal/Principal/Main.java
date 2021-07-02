package Bibliotecas.ProjetoFinal.Principal;
import java.nio.file.Path;
import java.nio.file.Paths;
import Bibliotecas.ProjetoFinal.TxtUtils.AtividadesDiaSemana;
import Bibliotecas.ProjetoFinal.TxtUtils.DiaAtivo;
import Bibliotecas.ProjetoFinal.TxtUtils.FormatarTabela;
import Bibliotecas.ProjetoFinal.TxtUtils.TotalEsporte;
public class Main {
	public static void main(String[] args) {
		Path arquivo = Paths.get("ListaAtividades.txt");
		AtividadesDiaSemana.AtividadeDia(arquivo);
		FormatarTabela.Tabela(arquivo);
		DiaAtivo.DiaMaisAtivo(arquivo);
		TotalEsporte.TotalPorEsporte(arquivo);
	}
}