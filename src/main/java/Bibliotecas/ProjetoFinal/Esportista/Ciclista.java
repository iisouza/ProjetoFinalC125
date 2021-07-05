package Bibliotecas.ProjetoFinal.Esportista;
public class Ciclista extends Atleta {
	private int numAtividades;
	public Ciclista(int id, String nome, int idade) {
		super(id, nome, idade);
	}

	@Override
	public void PraticandoEsporte() {
		System.out.println(this.nome + " pedalando!");
	}
	
	public int getNumAtividades() {
		return numAtividades;
	}
}