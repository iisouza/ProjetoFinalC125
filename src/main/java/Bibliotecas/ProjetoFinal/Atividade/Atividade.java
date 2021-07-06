package Bibliotecas.ProjetoFinal.Atividade;
public class Atividade {
	private int altimetria, calorias;
	private String id, diaSemana, duracao, nomeAtleta, Estilo;
	private double distancia;
	public Atividade(String id, String diaSemana, double distancia,
			String duracao, int altimetria, int calorias, 
			String nomeAtleta, String estilo) {
		this.id = id;
		this.diaSemana = diaSemana;
		this.distancia = distancia;
		this.duracao = duracao;
		this.altimetria = altimetria;
		this.calorias = calorias;
		this.nomeAtleta = nomeAtleta;
		this.Estilo = estilo;
	}

	public String getId() {
		return id;
	}

	public String getDuracao() {
		return duracao;
	}

	public int getAltimetria() {
		return altimetria;
	}

	public int getCalorias() {
		return calorias;
	}

	public String getDiaSemana() {
		return diaSemana;
	}

	public String getNomeAtleta() {
		return nomeAtleta;
	}

	public String getEstilo() {
		return Estilo;
	}

	public double getDistancia() {
		return distancia;
	}
}