package Bibliotecas.ProjetoFinal.Graficos;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Color;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import Bibliotecas.ProjetoFinal.Utils.TxtUtils;
import java.awt.Font;
public class TabelaAtividades extends JPanel {
	private JTable TabelaAtividades;
	public TabelaAtividades(Path arquivo) {
		LinkedHashMap<String, String> Atv = TxtUtils.AtividadeDiaSemana(arquivo);
		TabelaAtividades = new JTable();
		TabelaAtividades.setEnabled(false);
		TabelaAtividades.setFont(new Font("Courier New", Font.BOLD, 14));
		TabelaAtividades.setForeground(Color.BLACK);
		TabelaAtividades.setModel(new DefaultTableModel(
			new Object[][] {
				{"Dia da Semana", "NumAtividades Igor", "NumAtividade Danilo"},
				{"Domingo", Atv.get("domingo").split("/")[0], Atv.get("domingo").split("/")[1]},
				{"Segunda-feira", Atv.get("segunda-feira").split("/")[0], Atv.get("segunda-feira").split("/")[1]},
				{"Terça-feira", Atv.get("terca-feira").split("/")[0], Atv.get("terca-feira").split("/")[1]},
				{"Quarta-feira", Atv.get("quarta-feira").split("/")[0], Atv.get("quarta-feira").split("/")[1]},
				{"Quinta-feira", Atv.get("quinta-feira").split("/")[0], Atv.get("quinta-feira").split("/")[1]},
				{"Sexta-feira", Atv.get("sexta-feira").split("/")[0], Atv.get("sexta-feira").split("/")[1]},
				{"Sábado", Atv.get("sabado").split("/")[0], Atv.get("sabado").split("/")[1]},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		TabelaAtividades.setBackground(Color.WHITE);
		add(TabelaAtividades);
		
	}
	
}