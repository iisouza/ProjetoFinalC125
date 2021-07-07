package Bibliotecas.ProjetoFinal.TxtUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import Bibliotecas.ProjetoFinal.Atividade.Atividade;
public class TxtUtils {
	public static List<Atividade> LeituraTxt(Path arquivo) {
		List<Atividade> ListaAtividades = new ArrayList<>();
		
		try {
			List<String> atividades = Files.readAllLines(arquivo);
			atividades.remove(0);
			atividades.forEach((descricao) -> {
				String[] dados = descricao.split(";");
				StringBuilder hora = new StringBuilder();
				hora.append(dados[3]).append("-")
					.append(dados[4]).append("-")
					.append(dados[5]).append("-");
				ListaAtividades.add(new Atividade(dados[0], dados[1], 
					Double.parseDouble(dados[2].replace(",", ".")),
					hora.toString(), Integer.parseInt(dados[6]), 
					Integer.parseInt(dados[7]), dados[8], dados[9]));
			});
		} catch (IOException erro) {
			System.out.println("Erro no arquivo!\n");
		}
		return ListaAtividades;
	}
}