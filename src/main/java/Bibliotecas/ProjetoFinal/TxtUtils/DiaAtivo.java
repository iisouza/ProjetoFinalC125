package Bibliotecas.ProjetoFinal.TxtUtils;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
public class DiaAtivo {
	public static void DiaMaisAtivo(Path arquivo) {
		LinkedHashMap<String, String> AtividadesDia = new LinkedHashMap<>();
		AtividadesDia = AtividadesDiaSemana.AtividadeDia(arquivo);
		
		List<Integer> DiaAtivo1 = new ArrayList <>();
		List<String> DiasAtivos1 = new ArrayList <>();
		List<Integer> DiaAtivo2 = new ArrayList <>();
		List<String> DiasAtivos2 = new ArrayList <>();
		
		AtividadesDia.forEach((chave, valor) -> {
			DiaAtivo1.add(Integer.parseInt(valor.split("/")[0]));
			DiaAtivo2.add(Integer.parseInt(valor.split("/")[1]));
		});
	
		DiaAtivo1.sort(null);
		DiaAtivo2.sort(null);
	
		AtividadesDia.forEach((chave, valor) -> {
			if(Integer.parseInt(valor.split("/")[0]) == DiaAtivo1.get(6))
				DiasAtivos1.add(chave);
		
			if(Integer.parseInt(valor.split("/")[1]) == DiaAtivo2.get(6))
				DiasAtivos2.add(chave);
		});
	
		System.out.println("   Resultados obtidos a partir da ánalise das informações:");
		if(DiasAtivos2.size() == 1) {
			System.out.print("\t- O dia preferido de Danilo para as atividades é: ");
			System.out.println(DiasAtivos2.get(0) + ".");
		}
		else {
			System.out.print("\t- Os dias preferidos de Danilo para as atividades são: ");
			for(int i = 0; i < DiasAtivos2.size(); i++) {
				System.out.print(DiasAtivos2.get(i));
			
				if(i != DiasAtivos2.size() - 1)
					if(i != DiasAtivos2.size() - 2)
						System.out.print(", ");
					else
						System.out.print(" e ");
				else
					System.out.println(".\n");
			}
		}
	
		if(DiasAtivos1.size() == 1) {
			System.out.print("\t- O dia preferido de Igor para as atividades é: ");
			System.out.println(DiasAtivos1.get(0) + ".");
		}
		else {
			System.out.print("\t- Os dias preferidos de Igor para as atividades são: ");
			for(int i = 0; i < DiasAtivos1.size(); i++) {
				System.out.print(DiasAtivos1.get(i));
			
				if(i != DiasAtivos1.size() - 1)
					if(i != DiasAtivos1.size() - 2)
						System.out.print(", ");
					else
						System.out.print(" e ");
				else
					System.out.println(".\n");
			}
		}
	}
}