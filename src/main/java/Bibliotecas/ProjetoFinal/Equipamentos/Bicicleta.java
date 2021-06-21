package Bibliotecas.ProjetoFinal.Equipamentos;
public class Bicicleta {
	private String marca;
	private int aro;
	
	public Bicicleta(String marca, int aro) {
		this.marca = marca;
		this.aro = aro;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public int getAro() {
		return aro;
	}
}