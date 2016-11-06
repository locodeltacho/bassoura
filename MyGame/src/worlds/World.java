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
			/// ojoo con el height y width, height es alto y width es ancho!
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					getTile(x,y).render(gr, x*Tile.TILEWIDTH, y*Tile.TILEWIDTH);
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
