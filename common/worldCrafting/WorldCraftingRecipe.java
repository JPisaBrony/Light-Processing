package LightProcessing.common.worldCrafting;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldCraftingRecipe {
	
	private WorldCraftingGrid3d grid;
	private int resultBlockID;
	private int controlBlockID;
	
	private class Point3D {
		public int x;
		public int y;
		public int z;
		
		public Point3D(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public Point3D() {
			
		}
		
		public Point3D subtract(Point3D point) {
			Point3D P = new Point3D();
			P.x = x - point.x;
			P.y = y - point.y;
			P.z = z - point.z;
			return P;
		}
		
		public Point3D add(Point3D point) {
			Point3D P = new Point3D();
			P.x = x + point.x;
			P.y = y + point.y;
			P.z = z + point.z;
			return P;
		}
	}
	
	public WorldCraftingRecipe(Integer[][][] array, int resultBlockID, int controlBlockID) {
		grid = new WorldCraftingGrid3d();
		for(int i = 0; i < array.length; i++) {
			grid.add(array[i]);
		}
		this.resultBlockID = resultBlockID;
		this.controlBlockID = controlBlockID;
	}
	
	public WorldCraftingRecipe(WorldCraftingGrid3d array, int resultBlockID, int controlBlockID) {
		grid = array;
		this.resultBlockID = resultBlockID;
		this.controlBlockID = controlBlockID;
	}
	
	public int getResultBlockID() {
		return resultBlockID;
	}
	
	public boolean checkRecipe(int x, int y, int z, World world) {
		Point3D controlBlockCoordsArray = getControlBlockCoords();
		Point3D controlBlockCoordsWorld = new Point3D(x, y, z);
		boolean isTrue = true;
		int depth, row, column;
		for(depth = 0; depth < grid.getDepth(); depth++) {
			WorldCraftingGrid layer = grid.getLayer(depth);
			for(row = 0; row < layer.getHeight(); row++) {
				for(column = 0; column < layer.getWidth(); column++) {
					Point3D arrayCoords = new Point3D(column, depth, row);
					Point3D worldCoords = getBlockWorldCoords(arrayCoords, controlBlockCoordsWorld, controlBlockCoordsArray);
					System.out.println(arrayCoords.x + ":" + arrayCoords.y + ":" + arrayCoords.z + " " + worldCoords.x + ":" + worldCoords.y + ":" + worldCoords.z);
					if(!checkBlock(worldCoords, grid.get(row, column, depth), world) && (grid.get(row,column,depth) != 0))
						isTrue = false;
					
				}
			}
		}
		return isTrue;
	}
	
	public Point3D getControlBlockCoords() {
		int depth, row, column;
		for(depth = 0; depth < grid.getDepth(); depth++) {
			WorldCraftingGrid layer = grid.getLayer(depth);
			for(row = 0; row < layer.getHeight(); row++) {
				for(column = 0; column < layer.getWidth(); column++) {
					if(grid.get(row, column, depth) == controlBlockID) {
						Point3D P = new Point3D();
						P.x = column;
						P.z = row;
						P.y = depth;
						return P;
					}
				}
			}
		}
		return null;
	}
	
	public Point3D getRelativeCords(Point3D arrayCoordsBlock, Point3D worldCordsControl, Point3D arrayCoordsControl) {
		Point3D relativeCoords = arrayCoordsBlock.subtract(arrayCoordsControl);
		return relativeCoords;
	}
	
	public Point3D getBlockWorldCoords(Point3D arrayCoordsBlock, Point3D worldCordsControl, Point3D arrayCoordsControl) {
		Point3D relativeCoords = getRelativeCords(arrayCoordsBlock, worldCordsControl, arrayCoordsControl);
		Point3D worldCoords = worldCordsControl.add(relativeCoords);
		return worldCoords;
	}
	
	public boolean checkBlock(Point3D worldCoords, Integer blockID, World world) {
		Integer blockId = world.getBlockId(worldCoords.x, worldCoords.y, worldCoords.z);
		boolean temp = world.getBlockId(worldCoords.x, worldCoords.y, worldCoords.z) == blockID;
		//world.setBlock(worldCoords.x, worldCoords.y, worldCoords.z, Block.blockLapis.blockID);
		System.out.println(world.getBlockId(worldCoords.x, worldCoords.y, worldCoords.z) + " " + blockID);
		return temp;
	}
	
	public void clearGrid(int x, int y, int z, World world) {
		Point3D controlBlockCoordsArray = getControlBlockCoords();
		Point3D controlBlockCoordsWorld = new Point3D(x, y, z);
		boolean isTrue = true;
		int depth, row, column;
		for(depth = 0; depth < grid.getDepth(); depth++) {
			WorldCraftingGrid layer = grid.getLayer(depth);
			for(row = 0; row < layer.getHeight(); row++) {
				for(column = 0; column < layer.getWidth(); column++) {
					Point3D arrayCoords = new Point3D(column, depth, row);
					Point3D worldCoords = getBlockWorldCoords(arrayCoords, controlBlockCoordsWorld, controlBlockCoordsArray);
					if(grid.get(row, column, depth) != 0)
						world.setBlock(worldCoords.x, worldCoords.y, worldCoords.z, 0);
				}
			}
		}
	}
	
}