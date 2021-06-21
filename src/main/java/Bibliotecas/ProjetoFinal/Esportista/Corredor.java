package Bibliotecas.ProjetoFinal.Esportista;
import java.util.ArrayList;
import java.util.List;
import Bibliotecas.ProjetoFinal.Equipamentos.Tenis;
public class Corredor extends Atleta {
	List <Tenis> ListaTenis = new ArrayList <Tenis>();
	private int numAtividades;
	
	public Corredor(String nome, int idade) {
		super(nome, idade);
	}

	@Override
	public void PraticandoEsporte() {
		System.out.println(this.nome + "correndo!");
	}
	
	public int getNumAtividades() {
		return numAtividades;
	}
}