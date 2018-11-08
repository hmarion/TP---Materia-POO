package logica;

public class Cartas {

	private String numeroCarta;
	private String paloCarta;
	private int valorCarta;
	
	public Cartas(String numeroCarta, String paloCarta, int valorCarta){
		this.numeroCarta = numeroCarta;
		this.paloCarta = paloCarta;
		this.valorCarta = valorCarta;
	}
	
	public Cartas(){
		
	}
	
	public String getNumeroCarta() {
		return numeroCarta;
	}
	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	public String getPaloCarta() {
		return paloCarta;
	}
	public void setPaloCarta(String paloCarta) {
		this.paloCarta = paloCarta;
	}
	public int getValorCarta() {
		return valorCarta;
	}
	public void setValorCarta(int valorCarta) {
		this.valorCarta = valorCarta;
	}
	
	public String toString(){
		return numeroCarta+ " de " + paloCarta
				+"\nValor: " + valorCarta;
	}
	
}
