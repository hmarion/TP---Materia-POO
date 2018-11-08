package logica;
import java.math.*;

public class Baraja {

	Cartas [] baraja;

	public void armarBaraja(){
		baraja = new Cartas[52];
		for(int j=1; j<5; j++){
			for(int i=1; i<13; i++){
				
				int numeroCarta = (i-1)+(j-1)*12; //Valor para cargar en la matriz principal
	
				String numero; //IF utilizado para cargar el numero/letra de la carta
				if(i==1){
					numero = "A";
				}else if(i<11){
					numero = Integer.toString(i);
				}else if(i==11){
					numero = "J";
				}else if(i==12){
					numero = "Q";
				}else{
					numero = "K";
				}
				
				String palo;
				if(j==1){ //If utilizado para cargar el palo de la carta
					palo = "Corazon";
				}else if(j==2){
					palo = "Diamante";
				}else if(j==3){
					palo = "Trebol";
				}else{
					palo = "Pica";
				}
				
				int valor;
				if(i<11){
					valor = i;
				}else{
					valor = 10;
				}

				baraja[numeroCarta] = new Cartas(numero, palo, valor);
			}
		}
	}
	
	
	public String mostrarBaraja(int i){
		return baraja[i].toString();
	}
	
	public Cartas repartirCarta(){
		int random;
		do{
			random = (int)(Math.random()*(51-1+1)+1);
		}while(baraja[random-1]==null);
		return baraja[random-1];
	}
	

}
