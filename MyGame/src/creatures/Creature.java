package creatures;

import entities.Entity;

public abstract class Creature extends Entity {

		/**
		 * VARIABLES DEFAULT para cada mierda que cree en el juego
		 * obviamente despues se pueden cambiar si no queda bien
		 */
		public static final int DEFAULT_HEALTH= 10; //vida standar de cualquier bicho
		public static final float DEFAULT_SPEED = 3.0f; //mira vos, sin la f no compilaba
		public static final int DEFAULT_CREATURE_WIDTH = 64;
		public static final int DEFAULT_CREATURE_HEIGHT = 64;
		/**
		 * A medida que cambie el width y height, puedo agrandar
		 * o achicar al personaje en pantalla
		 */
		
		protected int health;
		protected float speed;
		
		
		protected float xMove;
		protected float yMove;
		
		
		public Creature(float x, float y,int width, int height) {
		super(x,y,width,height);
		this.health = DEFAULT_HEALTH;
		this.speed = DEFAULT_SPEED;
		
		this.xMove = 0;
		this.yMove = 0;
		
	}
		/**
		 * A partir de crear esto, tengo que modificar
		 * la manera en la que se mueve "Player"
		 */
		public void move(){
			x += xMove;
			y += yMove;
		}
		

		/**
		 * Getter and setters!
		 * @return
		 */
		public int getHealth() {
			return health;
		}


		public float getSpeed() {
			return speed;
		}


		public void setHealth(int health) {
			this.health = health;
		}


		public void setSpeed(float speed) {
			this.speed = speed;
		}

		public float getxMove() {
			return xMove;
		}

		public float getyMove() {
			return yMove;
		}

		public void setxMove(float xMove) {
			this.xMove = xMove;
		}

		public void setyMove(float yMove) {
			this.yMove = yMove;
		}


}
