package worlds;

import java.awt.Graphics;

import tilegame.Game;
import tilegame.Handler;
import tiles.Tile;
import utils.Utils;

public class World {
		private int width;
		private int height;
		private int[][] tiles;
		
		private int spawnX;
		private int spawnY;
		
		private Handler handler;
		
		public World(Handler handler,String path){
			this.handler = handler;
			loadWorld(path);
		}
		
		public void tick(){
			
		}
		public void render(Graphics gr){
			/**
			 * Añado control de render con estas 
			 * 4 variables, que tienen la posicion de los extremos
			 * de la pantalla visible
			*/
			/**
			 * Math.max elige entre dos variables la mayor. El 0 es para el caso de tiles negativas,
			 * es decir, que se escapan de nuestro mapa, y no nos interesan
			 */
			int xStart = (int)Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILEWIDTH);
			//Para xEnd es lo mismo, me dice EXACTAMENTE EN QUE TILE DEJA DE RENDERIZAR
			int xEnd = (int) Math.min(width,  ( handler.getGameCamera().getxOffset()  + handler.getWidth())/ Tile.TILEWIDTH +1);
			int yStart = (int)Math.max(0, handler.getGameCamera().getyOffset()/Tile.TILEHEIGHT);
			int yEnd = (int) Math.min(height,  ( handler.getGameCamera().getyOffset()  + handler.getHeight())/ Tile.TILEHEIGHT +1);
			
			/// ojoo con el height y width, height es alto y width es ancho!
			for (int y = yStart; y < yEnd; y++) {
				for (int x = xStart; x < xEnd; x++) {
					//negreando con cast, despues lo paso todo a int y a la mierda
					getTile(x,y).render(gr, (int)(x*Tile.TILEWIDTH -handler.getGameCamera().getxOffset()), 
							(int)(y*Tile.TILEWIDTH - handler.getGameCamera().getyOffset()));
				}
			}
		}
		
		public Tile getTile(int x, int y){
			/**
			 * Tile.tiles[] seria el array de la clase Tiles
			 * y tiles[][] el de nuestra clase world
			 */
			//Este if es para que no se bugee saliendo del mapa.
			if (x<0 || y<0 || x>= width || y >=height)
				return Tile.grassTile;
			
			Tile tl = Tile.tiles[tiles[x][y]];
			//Esto esta rancio, es si no encuentra el iD
			//que meta verdura
			if(tl == null)
				return Tile.rockTile;
			
			return tl;
		}
		
		private void loadWorld(String path){
			String file = Utils.loadFileAsString(path);
			String[] tokens = file.split("\\s+");
			width = Utils.parseInt(tokens[0]);
			height = Utils.parseInt(tokens[1]);
			spawnX = Utils.parseInt(tokens[2]);
			spawnY = Utils.parseInt(tokens[3]);
			
			tiles = new int[width][height];
			
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					tiles[x][y]= Utils.parseInt(tokens[((x+y*width) +4)]);
				}
			}
			
		}

		public int getWidth() {
			return width;
		}

		public int getHeight() {
			return height;
		}


		
}
