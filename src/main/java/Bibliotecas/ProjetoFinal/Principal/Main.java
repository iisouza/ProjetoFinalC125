package Bibliotecas.ProjetoFinal.Principal;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFrame;
import Bibliotecas.ProjetoFinal.Graficos.Interface;
import Bibliotecas.ProjetoFinal.Graficos.PlotaGrafico3D;
import Bibliotecas.ProjetoFinal.Utils.TxtUtils;
public class Main {
	public static void main(String[] args) {
		Path arquivo = Paths.get("ListaAtividades.txt");
		TxtUtils.AtividadeDiaSemana(arquivo);
		System.out.println("");
		
		TxtUtils.TotalPorEsporte(arquivo);
		Interface.PlotaGrafico(arquivo);
	}
}