package Bibliotecas.ProjetoFinal.Esportista;
public class Atleta {
	private String nome, profissao;
	private String naturalidade, dataNascimento;
	private int idade, id;
	
	public Atleta(int id, String nome, int idade, String profissao,
			String naturalidade, String dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.profissao = profissao;
		this.naturalidade = naturalidade;
		this.dataNascimento = dataNascimento;
	}
	
	public void MostraInfo() {
		System.out.println("\t- Atleta " + this.id + ": " 
			+ this.nome + ", " + this.idade + " anos, " + this.profissao +
			". Nascido em "  + this.naturalidade + " em " + this.dataNascimento);
	}
}