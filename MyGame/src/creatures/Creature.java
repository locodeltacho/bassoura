package creatures;

import tilegame.Game;
import tilegame.Handler;
import tiles.Tile;
import entities.Entity;

public abstract class Creature extends Entity {

	/**
	 * VARIABLES DEFAULT para cada mierda que cree en el juego obviamente
	 * despues se pueden cambiar si no queda bien
	 */
	public static final int DEFAULT_HEALTH = 10; // vida standar de cualquier
													// bicho
	public static final float DEFAULT_SPEED = 3.0f; // mira vos, sin la f no
													// compilaba
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;
	/**
	 * A medida que cambie el width y height, puedo agrandar o achicar al
	 * personaje en pantalla
	 */

	protected int health;
	protected float speed;

	protected float xMove;
	protected float yMove;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		this.health = DEFAULT_HEALTH;
		this.speed = DEFAULT_SPEED;

		this.xMove = 0;
		this.yMove = 0;

	}

	/**
	 * A partir de crear esto, tengo que modificar la manera en la que se mueve
	 * "Player"
	 */
	public void move() {
		moveX();
		moveY();
	}
	
	/**
	 * En las lineas de abajo el flaco tiro alta magia, asi que voy a tener que hacer algunos calculos
	 * para ver que concha hizo.
	 * Resumiendo agarra cada esquina del rectangulo de colisiones y se fija si tiene una tile cerca
	 */

	public void moveX() {
		if (xMove > 0) { // derecha
			// Esta linea magica nos dice a donde nos vamos a mover
			int tx = (int) ((x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH);

			// Si hay una colision en la parte superior o inferior de la derecha
			// esto va a dar true, y no vamos a poder cruzarla
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx,
							(int) (y + bounds.y + bounds.height)
									/ Tile.TILEHEIGHT)) {
				x += xMove;
			} else { //fix para los espacios en blanco de las colisiones
					x = tx*Tile.TILEWIDTH -bounds.x - bounds.width -1;
					//el -1 magico es porque sino se quedaba trabado en el borde... wrong!
			}
		} else if (xMove < 0) {// izquierda
			int tx = (int) ((x + xMove + bounds.x) / Tile.TILEWIDTH);
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT)
					&& !collisionWithTile(tx,
							(int) (y + bounds.y + bounds.height)
									/ Tile.TILEHEIGHT)) {
				x += xMove;
			}else {
				
				x = tx*Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
				 	
			}
		}
	}

	public void moveY() {
		if (yMove < 0) { // arriba
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width)
							/ Tile.TILEWIDTH, ty)) {
				y += yMove;
			}else {
				y = ty*Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}

		} else if (yMove > 0) {// abajo

			int ty = (int) (y + yMove + bounds.y + bounds.height)
					/ Tile.TILEHEIGHT;
			if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width)
							/ Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty*Tile.TILEHEIGHT - bounds.y - bounds.height -1;
			}
		}
	}

	/**
	 * Al fin empezamos con colisiones! Esto me dice si en x,y hay una tile
	 * solida
	 * 
	 */
	protected boolean collisionWithTile(int x, int y) {

		return handler.getWorld().getTile(x, y).isSolid();
	}

	/**
	 * Getter and setters!
	 * 
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
