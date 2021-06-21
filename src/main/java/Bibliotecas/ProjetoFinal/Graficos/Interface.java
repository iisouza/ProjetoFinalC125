package Bibliotecas.ProjetoFinal.Graficos;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.nio.file.Path;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
public class Interface extends JFrame {
	private JPanel contentPane;
	public static void PlotaGrafico(Path arquivo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.add(new GraficoBarras());
					frame.add(new TabelaAtividades(arquivo));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Interface() {
		setFont(new Font("Courier New", Font.BOLD, 14));
		setForeground(Color.BLACK);
		setTitle("Anállise esportiva da equipe C125");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		
		JPanel jpnGrafico = new JPanel();
		getContentPane().add(jpnGrafico, BorderLayout.NORTH);
	}
}