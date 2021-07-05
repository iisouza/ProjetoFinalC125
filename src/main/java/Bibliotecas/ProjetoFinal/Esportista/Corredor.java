package Bibliotecas.ProjetoFinal.Esportista;
public class Corredor extends Atleta {
	private int numAtividades;
	public Corredor(int id, String nome, int idade) {
		super(id, nome, idade);
	}

	@Override
	public void PraticandoEsporte() {
		System.out.println(this.nome + "correndo!");
	}
	
	public int getNumAtividades() {
		return numAtividades;
	}
}