package Bibliotecas.ProjetoFinal.Esportista;
public abstract class Atleta {
	protected String nome;
	protected int idade, id;
	
	public Atleta(int id, String nome, int idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}
	
	public void MostraInfo() {
		System.out.println("      Atleta " + this.id + ": " 
							+ this.nome + ", " + this.idade + " anos.");
	}
	
	public abstract void PraticandoEsporte();
	
	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
}