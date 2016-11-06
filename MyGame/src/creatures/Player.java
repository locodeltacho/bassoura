package creatures;

import gfx.Assets;

import java.awt.Graphics;

import tilegame.Game;

public class Player extends Creature {
	
	
	//Player debe tener acceso al juego...

	public Player(Game game,float x, float y) {
		super(game,x, y, 
				Creature.DEFAULT_CREATURE_WIDTH,
				Creature.DEFAULT_CREATURE_WIDTH
				);
		

	}
	
	
	@Override
	public void tick() {
	
		getInput();
		move();
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(game.getKeyManager().isUp())
			yMove = -speed; //Esto es porque la Y esta invertida
		
		if(game.getKeyManager().isDown())
			yMove = speed;
			
		if(game.getKeyManager().isLeft())
			xMove = -speed;
		
		if(game.getKeyManager().isRight())
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
		gr.drawImage(Assets.player, (int)x, (int)y,width,height, null);
		
		
	}
		
}
