package entities;

import java.awt.Graphics;

import tilegame.Game;
import tilegame.Handler;

public abstract class Entity {
	/**
	 * Seria como "Personaje" en el codigo main 
	 * 	que estamos desarrollando en clase
	 * 
	 * XY son flotantes para mejorar la precision
	 * ya que de por si, el movimiento generalmente nunca es perfecto
	 */
	//Posicion!
	protected float x;
	protected float y;
	
	//Tamaño de la entidad!
	protected int width;
	protected int height;
	
	protected Handler handler;
	
	public Entity(Handler handler, float x, float y,int width, int height){
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics gr);

	
	/**
	 * Getters y setters!
	 */
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
