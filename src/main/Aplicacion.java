package main;
import java.util.Scanner;
import java.util.ArrayList;

import logica.*;
import jugadores.*;

public class Aplicacion {

	public static void main(String [] args){
		
		System.out.println("Bienvenido a los Juegos de Cartas");
		
		Scanner teclado = new Scanner(System.in);

		System.out.print("Ingrese su Nombre: ");
		String nombreJugador = teclado.nextLine();
		Jugador jugador = new Jugador(nombreJugador);
		

		
		int opcion;
	
		do{
			System.out.println("\n\n");
			System.out.println("***********************************************************************");
			System.out.println("*                                                                     *");
			System.out.println("*                                                                     *");
			System.out.println("*                   Seleccion de Juegos de Cartas                     *");
			System.out.println("*                                                                     *");
			System.out.println("*                                                                     *");
			System.out.println("*                                                                     *");
			System.out.println("***********************************************************************");
			System.out.println("\n\n");
			//Menu de Seleccion de Juego
			System.out.println("Seleccione un juego");
			System.out.println("1 - BlackJack");
			System.out.println("2 - Poker");
			System.out.println("3 - Salir");
			System.out.print("Elija una opcion: ");
			opcion = teclado.nextInt();
			teclado.nextLine();
			
			switch(opcion){
				case 1:
					JuegosDeCartas juegoActual = new BlackJack();
					juegoActual.iniciarListadoDeJugadores();
					juegoActual.agregarJugador(jugador);
					String opcionSalida; //Se utiliza para salir del BlackJack
					boolean salir;
					System.out.println("\n\nBienvenido al BlackJack");
					
					do{
						if(((BlackJack) juegoActual).dineroActual()){
							do{							
								juegoActual.armarBaraja();
								((BlackJack) juegoActual).inicializarCartasJugador();
								((BlackJack) juegoActual).mostrarDineroJugador();
								juegoActual.realizarApuesta();
								((BlackJack) juegoActual).repartirCartasInicial();
								((BlackJack) juegoActual).repartirCartas();
								((BlackJack) juegoActual).mostrarPuntajeJugador();
								((BlackJack) juegoActual).verificarGanador();
								System.out.print("Desea seguir jugando? (Ingrese 'S' para continuar o cualquier tecla para salir ): ");
								opcionSalida = teclado.nextLine();
								if(opcionSalida.equalsIgnoreCase("S")){
									salir = true;
								}else{
									salir = false;
								}
								if(((BlackJack) juegoActual).dineroActual()){
									
								}else{
									System.out.println("Usted no posee dinero para seguir jugando");
									salir = false;
								}
							}while(salir!=false);
						}else{
							System.out.println("Usted no posee dinero para seguir jugando");
							salir = false;
						}
					}while(salir!=false);
					break;
				
				case 2:
					System.out.println("Juego en Mantenimiento");
					break;
				
				case 3:
					System.out.println("Muchas gracias por utilizar los Juegos de Cartas");
					break;
					
				default:
					System.out.println("La opcion ingresada es incorrecta");
			
			}
			
		
		}while(opcion!=3);
		
		
	}

}
