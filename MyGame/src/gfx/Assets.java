package gfx;

import java.awt.image.BufferedImage;

public class Assets {
		
	/**
	 * Lo que va a hacer el init es llamar todo en el juego
	 * una sola vez!
	 */
	
	//Estos serian los tipos de imagenes a usar
	public static BufferedImage player, grass, tree, spongebob;
	//Esto es para no hardcodear cada tamaño de imagen 
	//Agarro y digo que todos mis sprites tienen este alto y ancho
	private static final int width = 64, height = 64;
	
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/shit2.jpg"));
		player = sheet.crop(0, 0, width, height);
		tree = sheet.crop(width, 0, width, height);
		grass = sheet.crop(0, height, width, height);
		spongebob = sheet.crop(width, height, width, height);
		
	}
	
	
}
