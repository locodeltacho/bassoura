package entities;

import java.awt.Graphics;
import java.awt.Rectangle;

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
	
	//Handler
	protected Handler handler;
	
	//Rectangulo para colisiones, wipiii
	protected Rectangle bounds;
	
	public Entity(Handler handler, float x, float y,int width, int height){
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		bounds = new Rectangle(0,0,width,height); //para empezar
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
