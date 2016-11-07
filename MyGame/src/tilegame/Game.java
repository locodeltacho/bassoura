package tilegame;

import gfx.Assets;
import gfx.GameCamera;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import tilegame.state.GameState;
import tilegame.state.MenuState;
import tilegame.state.State;
import display.Display;


public class Game implements Runnable {
	/**
	 * La base de todo el codigo
	 * Abre, corre y cierra todo en el juego
	 */
	private Display display;
	protected int width;
	protected int height;
	protected String title;
	
	//Necesito un thread para correr el juego, seria algo asi como un "mini-programa"
	//Es para que el juego corra separado del resto del codigo en ejecucion
	private Thread thread;
	private boolean running = false; //para controlar el run del juego

	//Para el render
	//

	private BufferStrategy bs;
	private Graphics gr;
	
	//states
	private State gameState;
	private State menuState;
	
	//Input
	private KeyManager keyManager;
	
	//Camara
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height){
		//Cada vez que creo una instancia de juego, se crea
		//automaticamente el display
		this.width = width;
		this.height = height;
		this.title = title;
		this.keyManager = new KeyManager();
		
	}
	
	private void init(){
		//Este metodo seria el que va a inicializar
		//todos los graficos del juego
		
		display = new Display(title,width,height);
		//Para poder acceder al teclado
		display.getFrame().addKeyListener(keyManager);
		
		//Inicializando la camara
		gameCamera = new GameCamera(this,0,0);
		handler = new Handler(this);
		
		Assets.init();
		//Esto lo puedo hacer porque GameState hereda de State, que es abstracta
		//Inicializo todos los es tados
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		State.setState(gameState);
	}
	
	
	/**
	 * Some people just call it "tick" because 
	 * physics engine update frame is too long 
	 * for casual players to remember/understand.
	 * basicamente seria un update de algo
	 */

	
	private void tick(){
		//Antes que nada, updateo el teclado
		keyManager.tick();
		
		//Si no habia un state, hace el tick. copio el mismo codigo en render
		if(State.getState()!= null)
			State.getState().tick();
	}
	
	//render lo que hace es dibujar cosas en la pantalla, for dummies
	//Siempre va a hacer lo mismo
	private void render(){
		/**For dummies, un buffer Strategy le dice a la computadora
		 * que cosas va a dibujar en la pantalla
		 * Como todo buffer, va guardando todo en memoria antes de hacerlo
		 * Es mas que nada para evitar flickering (parpadeo de la pantalla)
		 */
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			//Si no habia un buffer, creo uno. el 3 es magico
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		//Ahora necesito el Graphic para empezar a dibujar en el canvas...
		/**
		 * Con el objeto Graphics se puede dibujar 
		 * lo que se te cante la chota en el canvas
		 */
		/**
		 * Nota de los graficos en java:
		 * En java, las Y positivas son decrecientes 
		 * Las X crecen hacia la derecha
		 */
		gr = bs.getDrawGraphics();
		//Limpiar pantalla
		gr.clearRect(0, 0, width, height);
		

		if(State.getState()!= null)
			State.getState().render(gr);
		
		bs.show();
		gr.dispose();
	}
	
	//Necesito si o si el Run cuando le meto el implements Runnable
	//Basicamente aca va a ir casi todo el codigo del juego
	public void run(){
		init();

		int fps = 60;//frames per second son las veces que quiero llamar a tick y a render
		
		//time per tick -> 1 billon / 60, serian 1 billon de nanosegundos
		//en un segundo. Medimos el tiempo en nanosegundos
		//Para ser mas especificos
		double timePerTick = 1000000000/fps; 
		//Delta es la variacion del tiempo entre que es llamado el metodo y el tiempo actual
		double delta = 0;
		// now se inicia al principio del loop, me dice cuando empiezo a contar
		long now;
		//LastTime retorna el tiempo de nuestra compu en nanosegundos
		long lastTime = System.nanoTime(); //Sería el tiempo actual en nanosegundos
		
		
		while(running){
			//Esto es magia
			now = System.nanoTime();
			//Basicamente el delta, segun un tiempo, le dice
			//si necesitamos llamar a tick y a render
			delta += (now - lastTime)/timePerTick;
			lastTime = now;
			
			
			if(delta >=1){ //Si el delta llega a 1, refresh
			tick();
			render();
			delta--;
			}
			//Esto es para saber si nuestro juego corre a 60 fps

		}
		
		stop();
		
	}
	/**
	 * basicamente el init haria esto..
	 * Game loop!
	 * loop: update variables, positions, objects
	 * render (draw) everything 
	 * goto loop;
	 */
	

		public KeyManager getKeyManager(){
			return keyManager;
		}
		
		public GameCamera getGameCamera(){
			return gameCamera;
		}
	
	//Start y stop inician y paran el hilo 
	public synchronized void start(){
		//Si ya esta corriendo, no hace nada
		if(running)
			return;
		running = true;
		//le mando el this, o sea clase Game, que es lo que quiero correr
		thread = new Thread(this); 
		thread.start(); //llama al run()
	}
	
	public synchronized void stop(){
		
		if(!running)
			return;
		
		running = false;
		try {
			//es para cerrar el metodo de forma segura
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	/**Aclaracion del Synchronized (uff, como cuesta escribirlo)
	 * Declarar un metodo synchronized es lo mismo que hacer todo el codigo del metodo synchronized
	 * es decir, es lo mismo que hacer
	 metodoblabla
	 synchronized(this) {
      // codigo del metodo aca
   	 }
	 * El bloque synchronized lleva entre paréntesis la referencia a un objeto. Cada vez que un thread intenta acceder 
	  a un bloque sincronizado le pregunta a ese objeto si no hay algún otro thread que ya tenga el lock(bloqueo) para ese objecto. 
	 * En otras palabras, le pregunta si no hay otro thread ejecutando algun bloque sincronizado con ese objeto 
	  (y recalco que es ese objeto porque en eso radica la clave para entender el funcionamiento)
	 *Si el lock está tomado por otro thread, entonces el thread actual es suspendido 
	 y puesto en espera hasta que el lock se libere. Si el lock está libre, entonces el 
	 thread actual toma el lock del objeto y entra a ejecutar el bloque. 
	 *Al tomar el lock, cuando venga el proximo thread a intentar ejecutar 
	 un bloque sincronizado con ese objeto, será puesto en espera.
	 https://epere4.blogspot.com.ar/2008/04/cmo-funciona-synchronized-en-java.html
	 **/
	
	
	


	
}
