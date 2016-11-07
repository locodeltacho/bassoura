package gfx;

import java.awt.image.BufferedImage;

public class Assets {
		
	/**
	 * Lo que va a hacer el init es llamar todo en el juego
	 * una sola vez!
	 */
	
	//Estos serian los tipos de imagenes a usar
	public static BufferedImage player, grass, tree, spongebob,sand,water,lava,rock, parrot;
	//Esto es para no hardcodear cada tamaño de imagen 
	//Agarro y digo que todos mis sprites tienen este alto y ancho
	private static final int width = 64, height = 64;
	
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/23.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/poop.png"));
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/24.jpg"));
		SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage("/textures/parrot.png"));
		
		//player = sheet.crop(0, 0, width, height);
		player = sheet2.crop(0, 0, width, height);
		tree = sheet.crop(width, 0, width, height);
		grass = sheet.crop(0, height, width, height);
		spongebob = sheet.crop(width, height, width, height);
		
		sand = sheet3.crop(0, 0, width, height);
		water = sheet.crop(width, height, width, height);
		//water = sheet3.crop(width, 0, width, height);
		lava = sheet3.crop(0, height, width, height);
		rock = sheet3.crop(width, height, width, height);
		parrot = sheet4.crop(0, 0, width, height);
	}
	
	
}
