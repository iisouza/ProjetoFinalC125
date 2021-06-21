package Bibliotecas.ProjetoFinal.Esportista;
public abstract class Atleta {
	protected String nome;
	protected int idade;
	
	public Atleta(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public abstract void PraticandoEsporte();
	
	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
}