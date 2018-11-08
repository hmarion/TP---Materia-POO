package logica;
import java.util.Scanner;

import jugadores.*;
import logica.Cartas;

public class BlackJack extends JuegosDeCartas{

	Scanner teclado1;
	
	public void inicializarCartasJugador(){
		for(int i=0; i<listadoJugadores.size(); i++){
			((Usuario) listadoJugadores.get(i)).inicilizarCartas();
		}
	}
	
	public void repartirCartasInicial(){
		for(int j=0; j<2; j++){			
			for(int i=1; i<(listadoJugadores.size()+1); i++){
				if(i==listadoJugadores.size()){
					Cartas carta = new Cartas("A", "Corazon", 1);
					carta = baraja.repartirCarta();
					((Usuario) listadoJugadores.get(0)).agregarCarta(carta);
					System.out.println("Maquina");
					((Usuario) listadoJugadores.get(0)).mostrarCartas();
					((Usuario) listadoJugadores.get(0)).sumarCantidadCartasA(((Usuario) listadoJugadores.get(0)).valorCartasJugador(j));
					((Usuario) listadoJugadores.get(0)).sumaValorMaximo(((Usuario) listadoJugadores.get(0)).valorCartasJugador(j));
					((Usuario) listadoJugadores.get(0)).sumaValorMinimo(((Usuario) listadoJugadores.get(0)).valorCartasJugador(j));
					((Usuario) listadoJugadores.get(0)).cargarValor();
					System.out.println("Puntaje: " + ((Usuario) listadoJugadores.get(0)).getPuntaje());
					System.out.println();
				}else{
					Cartas carta1 = new Cartas("A", "Corazon", 1);
					carta1 = baraja.repartirCarta();
					((Usuario) listadoJugadores.get(i)).agregarCarta(carta1);
					System.out.println("Jugador " + i);
					((Usuario) listadoJugadores.get(i)).mostrarCartas();
					((Usuario) listadoJugadores.get(i)).sumarCantidadCartasA(((Usuario) listadoJugadores.get(i)).valorCartasJugador(j));
					((Usuario) listadoJugadores.get(i)).sumaValorMaximo(((Usuario) listadoJugadores.get(i)).valorCartasJugador(j));
					((Usuario) listadoJugadores.get(i)).sumaValorMinimo(((Usuario) listadoJugadores.get(i)).valorCartasJugador(j));
					((Usuario) listadoJugadores.get(i)).cargarValor();
					System.out.println(" Puntaje: " + ((Usuario) listadoJugadores.get(i)).getPuntaje());
					System.out.println();
				}
			}
		}
	}
	
	public void verificarGanador(){
		for(int i=1; i<listadoJugadores.size(); i++){
			if((((Usuario) listadoJugadores.get(i)).getPuntaje() > ((Usuario) listadoJugadores.get(0)).getPuntaje()) || (((Usuario) listadoJugadores.get(0)).getPuntaje() > 21)){
				if(((Usuario) listadoJugadores.get(i)).getPuntaje() > 21){
					System.out.println("La maquina gana\n");
				}else{					
					int apuesta = obtenerMontoApostado(i);
					((Jugador) listadoJugadores.get(i)).sumarDineroGanado(apuesta);
					System.out.println("El jugador gana!!!\n");
				}
			}else{
				System.out.println("La maquina gana\n");
			}
		}
	}
	
	public int obtenerMontoApostado(int i){
			int apuesta = ((Jugador) listadoJugadores.get(i)).getDineroApostado();
			return apuesta;
		}
	
	public void repartirCartas(){
		teclado1 = new Scanner(System.in);
		for(int i=1; i<(listadoJugadores.size()+1); i++){
			if(i==listadoJugadores.size()){
				int numeroDeCarta = 2;
				while((((Usuario) listadoJugadores.get(0)).getPuntaje()<17)){
					Cartas carta = new Cartas("A", "Corazon", 1);
					((Usuario) listadoJugadores.get(0)).agregarCarta(carta);
					System.out.println("Maquina");
					((Usuario) listadoJugadores.get(0)).mostrarCartas();
					int valor = ((Usuario) listadoJugadores.get(0)).valorCartasJugador(numeroDeCarta);
					((Usuario) listadoJugadores.get(0)).sumarCantidadCartasA(valor);
					((Usuario) listadoJugadores.get(0)).sumaValorMaximo(valor);
					((Usuario) listadoJugadores.get(0)).sumaValorMinimo(valor);
					((Usuario) listadoJugadores.get(0)).cargarValor();
					System.out.println("Puntaje: " + ((Usuario) listadoJugadores.get(0)).getPuntaje());
					System.out.println();
					numeroDeCarta++;
				}
			}else{
				int numedoDeCarta = 2;
				String opcionPedirCartas; 
				System.out.print("Desea recibir otra carta?: (Ingrese 'S' para continuar o cualquier tecla para salir )");
				opcionPedirCartas = teclado1.nextLine();
				boolean salida;
				if(opcionPedirCartas.equalsIgnoreCase("S")){
					salida = true;
				}else{
					salida = false;
				}
				while(salida){
					Cartas carta1 = new Cartas("A", "Corazon", 1);
					carta1 = baraja.repartirCarta();
					((Usuario) listadoJugadores.get(i)).agregarCarta(carta1);
					System.out.println("Jugador " + i);
					((Usuario) listadoJugadores.get(i)).mostrarCartas();
					int valor = ((Usuario) listadoJugadores.get(i)).valorCartasJugador(numedoDeCarta);
					((Usuario) listadoJugadores.get(i)).sumarCantidadCartasA(valor);
					((Usuario) listadoJugadores.get(i)).sumaValorMaximo(valor);
					((Usuario) listadoJugadores.get(i)).sumaValorMinimo(valor);
					((Usuario) listadoJugadores.get(i)).cargarValor();
					System.out.println(" Puntaje: " + ((Usuario) listadoJugadores.get(i)).getPuntaje());
					System.out.println();
					if(((Jugador) listadoJugadores.get(i)).getPuntaje()>21){
						System.out.println("Estas fuera!");
						salida = false;
					}else{
						System.out.print("Desea recibir otra carta?: (Ingrese 'S' para continuar o cualquier tecla para salir )");
						opcionPedirCartas = teclado1.nextLine();
						if(opcionPedirCartas.equalsIgnoreCase("S")){
							salida = true;
						}else{
							salida = false;
						}
					}
				}
			}
		}
	}
	
	public void mostrarDineroJugador(){
		for(int i=1; i<listadoJugadores.size(); i++){			
			int dinero = ((Jugador) listadoJugadores.get(i)).getDinero();
			System.out.println("Dinero: " + dinero);
		}
	}
	
	public boolean dineroActual(){
		for(int i=1; i<listadoJugadores.size(); i++){
			if(((Jugador) listadoJugadores.get(i)).getDinero()==0){
				return false;
			}
		}
		return true;
	}
	
	public void mostrarPuntajeJugador(){
		System.out.println("\n\nPuntajes de la Partida\n");
		int puntaje;
		for(int i=1; i<listadoJugadores.size()+1; i++){			
			if(i==listadoJugadores.size()){
				System.out.println("Maquina: " + ((Usuario) listadoJugadores.get(0)).getPuntaje());
			}else{
				puntaje = ((Jugador) listadoJugadores.get(i)).getPuntaje();
				System.out.println("Jugador "+ i + ": " + puntaje);				
			}
		}
	}
	
}
