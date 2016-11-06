package worlds;

import java.awt.Graphics;

import tilegame.Game;
import tiles.Tile;
import utils.Utils;

public class World {
		private int width;
		private int height;
		private int[][] tiles;
		
		private int spawnX;
		private int spawnY;
		
		private Game game;
		
		public World(Game game,String path){
			this.game = game;
			loadWorld(path);
		}
		
		public void tick(){
			
		}
		public void render(Graphics gr){
			/**
			 * A�ado control de render con estas 
			 * 4 variables, que tienen la posicion de los extremos
			 * de la pantalla visible
			*/
			/**
			 * Math.max elige entre dos variables la mayor. El 0 es para el caso de tiles negativas,
			 * es decir, que se escapan de nuestro mapa, y no nos interesan
			 */
			int xStart = (int)Math.max(0, game.getGameCamera().getxOffset()/Tile.TILEWIDTH);
			//Para xEnd es lo mismo, me dice EXACTAMENTE EN QUE TILE DEJA DE RENDERIZAR
			int xEnd = (int) Math.min(width,  ( game.getGameCamera().getxOffset()  + game.getWidth())/ Tile.TILEWIDTH +1);
			int yStart = (int)Math.max(0, game.getGameCamera().getyOffset()/Tile.TILEHEIGHT);
			int yEnd = (int) Math.min(height,  ( game.getGameCamera().getyOffset()  + game.getHeight())/ Tile.TILEHEIGHT +1);
			
			/// ojoo con el height y width, height es alto y width es ancho!
			for (int y = yStart; y < yEnd; y++) {
				for (int x = xStart; x < xEnd; x++) {
					//negreando con cast, despues lo paso todo a int y a la mierda
					getTile(x,y).render(gr, (int)(x*Tile.TILEWIDTH -game.getGameCamera().getxOffset()), 
							(int)(y*Tile.TILEWIDTH - game.getGameCamera().getyOffset()));
				}
			}
		}
		
		public Tile getTile(int x, int y){
			/**
			 * Tile.tiles[] seria el array de la clase Tiles
			 * y tiles[][] el de nuestra clase world
			 */
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
		
}
