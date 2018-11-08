package jugadores;
import java.util.ArrayList;
import logica.Cartas;

public abstract class Usuario {

	private String nombre;
	private int puntaje;
	private int cantidadCartasA;
	private int puntajeMaximo; 
	private int puntajeMinimo;
	ArrayList cartasJugador;

	
	public Usuario(String nombre){
		this.nombre = nombre;
	}
	
	public int getPuntajeMaximo() {
		return puntajeMaximo;
	}

	public void setPuntajeMaximo(int valor) {
		this.puntajeMaximo = valor;
	}

	public int getPuntajeMinimo() {
		return puntajeMinimo;
	}

	public void setPuntajeMinimo(int puntajeMinimo) {
		this.puntajeMinimo = puntajeMinimo;
	}

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public int getCantidadCartasA() {
		return cantidadCartasA;
	}

	public void setCantidadCartasA(int cantidadCartasA) {
		this.cantidadCartasA = cantidadCartasA;
	}
	
	public String toString(){
		return "Nombre: " + nombre;
	}
	
	public void inicilizarCartas(){	
		cartasJugador = new ArrayList(5);
		this.puntaje = 0;
		this.puntajeMaximo = 0;
		this.puntajeMinimo = 0;
		this.cantidadCartasA = 0;
	}
	
	public void agregarCarta(Object carta){
		cartasJugador.add(carta);
	}
	
	public void mostrarCartas(){
		for(int i=0; i<cartasJugador.size(); i++){
			System.out.println(cartasJugador.get(i));
		}
	}
	
	public int valorCartasJugador(int i){
		return ((Cartas) cartasJugador.get(i)).getValorCarta();
	}
	
	public void sumaValorMaximo(int i){
		if(i==1){
			if(getCantidadCartasA()==1){
				this.puntajeMaximo += 11;
			}else if(getCantidadCartasA()==2){
				this.puntajeMaximo += i;
			}else{
				this.puntajeMaximo = 22;				
			}
		}else{
			this.puntajeMaximo += i;
		}
	}
	
	public void sumaValorMinimo(int i){
		if(i==1){
			if(getCantidadCartasA()==1){
				this.puntajeMinimo += i;							
			}else if(getCantidadCartasA()==2){
				this.puntajeMinimo += 11;
			}else{
				this.puntajeMinimo = 22;
			}
		}else{
			this.puntajeMinimo += i;
		}
	}
	
	public void cargarValor(){
		if(puntajeMaximo<=21){
			setPuntaje(getPuntajeMaximo());
		}else if(puntajeMinimo<=21){
			setPuntaje(getPuntajeMinimo());
		}else{
			setPuntaje(22);
		}
	}
	
	public void sumarCantidadCartasA(int valor){
		if(valor==1){			
			this.cantidadCartasA++;
		}
	}
	
}
