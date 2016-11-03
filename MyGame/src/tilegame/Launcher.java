package tilegame;


public class Launcher {
	/**
	 * Lo unico que va a hacer es iniciar el juego
	 * @param args
	 */
	public static void main(String[] args) {
		Game juego =  new Game("Mundo del tacho",768,640);
		juego.start();
		
	}
	
	
}
