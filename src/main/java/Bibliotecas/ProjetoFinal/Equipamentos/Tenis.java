package Bibliotecas.ProjetoFinal.Equipamentos;
public class Tenis {
	private String marca;
	private int tamanho;
	
	public Tenis(String marca, int tamanho) {
		this.marca = marca;
		this.tamanho = tamanho;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public int getTamanho() {
		return tamanho;
	}
}