package jugadores;

public class Jugador extends Usuario{
	
	private int dinero;
	private int dineroApostado;
	
	public Jugador(String nombre){
		super(nombre);
		setDinero(100);
	}
	
	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getDineroApostado() {
		return dineroApostado;
	}

	public void setDineroApostado(int dineroApostado) {
		this.dineroApostado = dineroApostado;
	}

	public void apuesta(int dineroApostado){
		if(dineroApostado <= this.dinero){
			this.dinero -= dineroApostado;
			this.dineroApostado = dineroApostado;			
		}else{
			System.out.println("Usted no posee saldo para realizar la siguiente apuesta");
		}
			
	}
	
	public void sumarDineroGanado(int apuesta){
		this.dinero += (apuesta*2);
	}

}
