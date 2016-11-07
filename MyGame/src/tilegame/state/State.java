package tilegame.state;

import java.awt.Graphics;

import tilegame.Game;
import tilegame.Handler;

public abstract class State {
		/**
		 * Un estado es basicamente una condicion relativa de las variables
		 * y atributos de un programa segun sus valores actuales
		 */
	
		/////------------------//////
		/**
		 * Esto podria ir en una clase llamada "StateManager", capaz a futuro, pero paja
		 */
		//Este atributo estatico nos dira cual es el estado que queremos cargar
		//Y renderizar actualmente
		private static State currentState = null;
		
		
		protected Handler handler;
		
		//Fuera el game, ahora es un handler bitch
		
		public State(Handler handler){
			this.handler = handler;
		}
		
		
		
		//Los get y set para acceder a esta clase
		public static void setState(State state){
			currentState = state;
		}
		
		public static State getState(){
			return currentState;
		}
		
		/////------------------//////
		//Esto se refiere a la clase abstracta, lo de arriba podria ir en otra clase aparte
		//Por el momento, nuestra clase estado puede refrescar y dibujar
		public abstract void tick();
		public abstract void render(Graphics gr);
		
		
		
		
		
}
