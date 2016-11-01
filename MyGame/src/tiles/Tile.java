package tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	//STATIC
	/**
	 * En el vector de tiles guardo tooodas las tile segun 
	 * su ID numerico, que representa la posicion en ese vector
	 */
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0); //Id 0 arbitraria
	public static Tile rockTile = new RockTile(1); //Id 0 arbitraria
	
	
	
	//CLASS
	/**
	 * Basicamente en Tile tenemos todo lo que va a aparecer en la pantalla
	 * Y ademas con esta, podemos saber si cada Tile es solida o no
	 * es decir, si podemos pasar a traves de una textura o no
	 */
	
	protected BufferedImage texture;
	protected final int id;	
	public static final int TILEWIDTH = 64;
	public static final int TILEHEIGHT = 64;
	
	/**
	 * 	La id de cada textura es UNICA en el juego, para saber diferenciarlas
	 * al renderizar todo, es final porque nunca se va a cambiar
	 * en el transcurso del juego
	 * @param id
	 */
	public Tile(BufferedImage texture, int id){
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics gr, int x, int y){
		gr.drawImage(texture, x, y,TILEWIDTH,TILEHEIGHT, null);
	}
	
	public boolean isSolid(){
		return false;
	}
	
	public int getId(){
		return id;
	}
	
	
	
}
