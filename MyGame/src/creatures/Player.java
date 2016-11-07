package creatures;

import gfx.Assets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import tilegame.Game;
import tilegame.Handler;

public class Player extends Creature {
	
	
	//Player debe tener acceso al juego...

	public Player(Handler handler,float x, float y) {
		super(handler,x, y, 
				Creature.DEFAULT_CREATURE_WIDTH,
				Creature.DEFAULT_CREATURE_WIDTH
				);
		//coordenadas del rectangulo, le digo
		//desde donde y hasta donde empiezan las colisiones
		bounds.x = 12; 
		bounds.y = 18;
		bounds.width = 38;
		bounds.height = 34;

	}
	
	
	@Override
	public void tick() {
		
		getInput();
		move();
		//para que la camara se centre en el pj
		handler.getGameCamera().centerOnEntity(this);
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().isUp())
			yMove = -speed; //Esto es porque la Y esta invertida
		
		if(handler.getKeyManager().isDown())
			yMove = speed;
			
		if(handler.getKeyManager().isLeft())
			xMove = -speed;
		
		if(handler.getKeyManager().isRight())
			xMove = speed;
	}	
	
	/**
	 * old Tick
		if(game.getKeyManager().isUp())
			y-=3;
		if(game.getKeyManager().isDown())
			y+=3;
		if(game.getKeyManager().isLeft())
			x-=3;
		if(game.getKeyManager().isRight())
			x+=3;
	 */

	@Override
	public void render(Graphics gr) {
		//DE PRUEBA, DESPUES SE CAMBIA
		//Drawimage recibe enteros... por eso el cast
		//Ademas puede recibir ancho y alto porque hereda de Creature
		gr.drawImage(Assets.parrot, (int)(x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()),width,height, null);
		
		gr.setColor(Color.red);
//		gr.fillRect((int)(x+bounds.x - handler.getGameCamera().getxOffset()), 
//				(int)(y+bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}
		
}
