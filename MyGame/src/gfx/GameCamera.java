package gfx;

import entities.Entity;
import tilegame.Game;

public class GameCamera {
	
	private Game game;
	private float xOffset;
	private float yOffset;
	
	public GameCamera(Game game,float xOffset, float yOffset){
		this.game = game;
		this.xOffset = xOffset;
		this.yOffset = yOffset;

	}
	
	/**
	 * Esta es la magia de la camara :D
	 */
	public void centerOnEntity(Entity e){
		// Va moviendo la camara con el personaje
		//El Game/2 es para que el personaje este JUSTO en la mitad de la pantalla, y no al borde
		xOffset = e.getX() - ( game.getWidth() /2 ) + ( e.getWidth() /2 );
		yOffset = e.getY() - ( game.getHeight() /2 ) + ( e.getHeight() /2 );
		
		//System.out.println("xoff"+xOffset+"yoff"+yOffset);
	}
	
	
	public void move(float xAmt, float yAmt){//amount
		xOffset+=xAmt;
		yOffset+=yAmt;
	}

	public float getxOffset() {
		return xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
}
