package Bibliotecas.ProjetoFinal.EquipeEsportiva;
import Bibliotecas.ProjetoFinal.Esportista.Atleta;
public class Equipe {
	private String nome;
	private Atleta[] ListaAtletas = new Atleta[5];
	
	public Equipe(String nome, int qtdAtletas) {
		this.nome = nome;
		this.ListaAtletas = new Atleta[qtdAtletas];
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
		System.out.println("   Nome: " + this.nome);
		System.out.println("   Atletas representantes: " + this.ListaAtletas.length);
		for(Atleta atleta : ListaAtletas)
			atleta.MostraInfo();
	}
	
	public String getNome() {
		return nome;
	}
}