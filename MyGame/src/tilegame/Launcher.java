package tilegame;


public class Launcher {
	/**
	 * Lo unico que va a hacer es iniciar el juego
	 * @param args
	 */
	public static void main(String[] args) {
		//Primero guardo todo en una variable juego
		//para despues hacer el start, que llame a init y muestre la ventana
		Game juego =  new Game("Mundo del tacho",768,640);
		juego.start();
		
	}
	
	
}
