package worlds;

import java.awt.Graphics;

import tiles.Tile;

public class World {
		private int width;
		private int height;
		private int[][] tiles;
		
		public World(String path){
			loadWorld(path);
		}
		
		public void tick(){
			
		}
		public void render(Graphics gr){
			for (int y = 0; y < width; y++) {
				for (int x = 0; x < height; x++) {
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
			//testeando
			width = 5;
			height = 5;
			tiles = new int [width][height];
			
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					tiles[i][j] = 0;
				}
			}
			
		}
		
}
