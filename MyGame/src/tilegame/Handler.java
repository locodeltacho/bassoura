package tilegame;

import gfx.GameCamera;
import worlds.World;

public class Handler {
	/**
	 * Basicamente el handler es para manejar todo desde esta
	 * clase, ya sea el juego o el mundo (mapa)
	 */

	private Game game;
	private World world;
	
	public Handler(Game game) {
		super();
		this.game = game;
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	
	///Getters y setters de la clase

	public Game getGame() {
		return game;
	}

	public World getWorld() {
		return world;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
}
