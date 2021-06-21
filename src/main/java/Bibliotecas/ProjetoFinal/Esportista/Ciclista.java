package Bibliotecas.ProjetoFinal.Esportista;
import java.util.ArrayList;
import java.util.List;
import Bibliotecas.ProjetoFinal.Equipamentos.Bicicleta;
public class Ciclista extends Atleta {
	List <Bicicleta> ListaBicicletas = new ArrayList <>();
	private int numAtividades;
	
	public Ciclista(String nome, int idade) {
		super(nome, idade);
	}

	@Override
	public void PraticandoEsporte() {
		System.out.println(this.nome + " pedalando!");
	}
	
	public int getNumAtividades() {
		return numAtividades;
	}
}