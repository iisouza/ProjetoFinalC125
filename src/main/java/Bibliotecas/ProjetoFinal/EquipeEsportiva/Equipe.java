package Bibliotecas.ProjetoFinal.EquipeEsportiva;
import Bibliotecas.ProjetoFinal.Esportista.Atleta;
public class Equipe {
	private String nomeEquipe, nomeTreinador, dataFundacao;
	private Atleta[] ListaAtletas = new Atleta[5];
	
	public Equipe(String nomeEquipe, int qtdAtletas, String nomeTreinador, String dataFundacao) {
		this.nomeEquipe = nomeEquipe;
		this.ListaAtletas = new Atleta[qtdAtletas];
		this.nomeTreinador = nomeTreinador;
		this.dataFundacao = dataFundacao;
	}
	
	public void AdicionarAtleta(Atleta atleta) {
		for(int i = 0; i < ListaAtletas.length; i++) 
			if(ListaAtletas[i] == null) {
				ListaAtletas[i] = atleta;
				break;
			}
		
		return;
	}
	
	public void MostraInfo() {
		System.out.println("   A " + this.nomeEquipe + " comandada pelo treinador " + 
				this.nomeTreinador + " foi fundada em " + this.dataFundacao + ".");
		System.out.println("   Atletas representantes: " + this.ListaAtletas.length);
		for(Atleta atleta : ListaAtletas)
			atleta.MostraInfo();
	}

	public String getNomeEquipe() {
		return nomeEquipe;
	}

	public String getNomeTreinador() {
		return nomeTreinador;
	}

	public String getDataFundacao() {
		return dataFundacao;
	}

	public Atleta[] getListaAtletas() {
		return ListaAtletas;
	}
}