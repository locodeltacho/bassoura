package tilegame.state;

import gfx.Assets;

import java.awt.Graphics;
import java.io.File;

import tilegame.Game;
import tiles.Tile;
import worlds.World;
import creatures.Player;

public class GameState extends State{
	
	/**
	 *
	 */
	private Player player;
	private World world;

	public GameState(Game game) {
		super(game);
		//valores hardcodeados, que inicie en x=100 y=100
		player = new Player(game,100,100);
        world = new World("world1.txt");
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
