package tilegame.state;

import gfx.Assets;

import java.awt.Graphics;

import tilegame.Game;
import tilegame.Handler;
import tiles.Tile;
import worlds.World;
import creatures.Player;

public class GameState extends State{
	
	/**
	 *
	 */
	private Player player;
	private World world;

	public GameState(Handler handler) {
		super(handler);
		//valores hardcodeados, que inicie en x=100 y=100
		world = new World(handler,"MyGame/resources/worlds/world2.txt");
		handler.setWorld(world);
		player = new Player(handler,64,64);
		

	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics gr) {
		
		//Tile.tiles[1].render(gr, 0, 0);;
		world.render(gr);
		player.render(gr);

	}
	
	/**
	 * Por las dudas
	 * File fichero = new File("datos.txt"); 
        System.out.println(fichero.getAbsolutePath());  
	 * 
	 */
		
}
