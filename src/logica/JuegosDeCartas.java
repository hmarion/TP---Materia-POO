package logica;
import java.util.ArrayList;

import jugadores.*;

import java.util.Scanner;

public abstract class JuegosDeCartas {

	ArrayList listadoJugadores;
	Scanner teclado;
	Baraja baraja;
	
	public void armarBaraja(){
		baraja = new Baraja();
		baraja.armarBaraja();
	}
	
	public void iniciarListadoDeJugadores(){
		listadoJugadores = new ArrayList<>(5);
		Croupier maquina = new Croupier("Maquina");
		listadoJugadores.add(maquina);
	}
	
	public void agregarJugador(Jugador jugador){
		listadoJugadores.add(jugador);
	}
	
	public int mostrarCantidadJugadores(){
		return listadoJugadores.size();
	}
	
	public abstract void repartirCartas();
	
	public void realizarApuesta(){
		for(int i=1; i<(listadoJugadores.size()); i++){
			teclado = new Scanner(System.in);
			System.out.print("Ingrese su apuesta: ");
			int dineroApostado = teclado.nextInt();
			((Jugador) listadoJugadores.get(i)).apuesta(dineroApostado);
		}
	}

	public void mostrarCartas(){
		for(int i=0; i<listadoJugadores.size(); i++){
			((Usuario) listadoJugadores.get(i)).mostrarCartas();
		}
	}
	

}
