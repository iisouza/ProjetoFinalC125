package Bibliotecas.ProjetoFinal.Graficos;
import java.awt.Dimension;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import Bibliotecas.ProjetoFinal.Utils.TxtUtils;
public class PlotaGrafico3D {
	public CategoryDataset createDataset(LinkedHashMap<String, String> linkedHashMap) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		linkedHashMap.forEach((chave, valor) -> {;
			dataset.addValue(Integer.parseInt(valor.split("/")[0]), chave, "");
		});
		return dataset;
	}
	
	public JFreeChart createBarChart(CategoryDataset dataset) {
		JFreeChart GraficoBarras = ChartFactory.createBarChart3D("Atividades por dia da semana",
				"Dia da semana", "Número de atividades", dataset, 
				PlotOrientation.HORIZONTAL, true, false, false);
		
		return GraficoBarras;
	}
	
	public ChartPanel createGrafico(Path arquivo) {
		CategoryDataset dataset = this.createDataset(TxtUtils.AtividadeDiaSemana(arquivo));
		JFreeChart grafico = this.createBarChart(dataset);
		ChartPanel PainelGrafico = new ChartPanel(grafico);
		
		PainelGrafico.setPreferredSize(new Dimension(400, 400));
		return PainelGrafico;
	}
}