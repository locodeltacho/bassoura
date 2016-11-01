package tilegame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	/**
	 * Maneja todo lo referido al teclado
	 */
	/**
	 * Se crea esta variable de booleandos para representar todas
	 * las id de las teclas del teclado
	 */
	private boolean[] keys;
	protected boolean up;
	protected boolean down;
	protected boolean left;
	protected boolean right;
	
	
	public KeyManager(){
		keys = new boolean[256];
	}
	/**
	 * Para updatear a cada rato el estado del personaje 
	 * en la pantalla
	 * el valor va a estar dado por el valor en el array de booleanos
	 * y este valor cambia cuando presionamos una tecla
	 */
	public void tick(){
		
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		
	}
	
	//Cuando presionas las teclas..
	@Override
	public void keyPressed(KeyEvent id) {
		//keycode me da el codigo de la tecla ingresada
			keys[id.getKeyCode()] = true;
	}
	
	//Cuando las soltas...
	@Override
	public void keyReleased(KeyEvent id) {
		keys[id.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		///
	}
	public boolean[] getKeys() {
		return keys;
	}
	public boolean isUp() {
		return up;
	}
	public boolean isDown() {
		return down;
	}
	public boolean isLeft() {
		return left;
	}
	public boolean isRight() {
		return right;
	}

}
