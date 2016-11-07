package gfx;

import entities.Entity;
import tilegame.Game;
import tilegame.Handler;
import tiles.Tile;

public class GameCamera {
	
	private Handler handler;
	private float xOffset;
	private float yOffset;
	
	public GameCamera(Handler handler,float xOffset, float yOffset){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;

	}
	/**
	 * Este metodo va a ser para limitar hasta donde se mueve la camara
	 */
	public void checkBlackSpace(){
		if (xOffset <0){
			xOffset = 0;
		}else if(xOffset > ( handler.getWorld().getWidth()*Tile.TILEWIDTH - 
				handler.getWidth())){
			xOffset = handler.getWorld().getWidth()*Tile.TILEWIDTH - handler.getWidth();
		}
		
		if (yOffset <0){
			yOffset = 0;
		} else if ( yOffset > handler.getWorld().getHeight()*Tile.TILEHEIGHT 
				-handler.getHeight()){
			yOffset = handler.getWorld().getHeight()*Tile.TILEHEIGHT -handler.getHeight();
		}
	}
	
	/**
	 * Esta es la magia de la camara :D
	 */
	public void centerOnEntity(Entity e){
		// Va moviendo la camara con el personaje
		//El Game/2 es para que el personaje este JUSTO en la mitad de la pantalla, y no al borde
		xOffset = e.getX() - ( handler.getWidth() /2 ) + ( e.getWidth() /2 );
		yOffset = e.getY() - ( handler.getHeight() /2 ) + ( e.getHeight() /2 );
		
		checkBlackSpace();
		//System.out.println("xoff"+xOffset+"yoff"+yOffset);
	}
	
	
	public void move(float xAmt, float yAmt){//amount
		xOffset+=xAmt;
		yOffset+=yAmt;
		checkBlackSpace();
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
