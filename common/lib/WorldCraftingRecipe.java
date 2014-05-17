package LightProcessing.common.lib;

public class WorldCraftingRecipe {
	
	private WorldCraftingGrid3d grid;
	private int resultBlockID;
	private int controlBlockID;
	
	private class Point3D {
		public int x;
		public int y;
		public int z;
	}
	
	public WorldCraftingRecipe(Integer[][][] array, int resultBlockID, int controlBlockID) {
		grid = new WorldCraftingGrid3d();
		for(int i = 0; i < array.length; i++) {
			grid.add(array[i]);
		}
		this.resultBlockID = resultBlockID;
		this.controlBlockID = controlBlockID;
	}
	
	public int getResultBlockID() {
		return resultBlockID;
	}
	
	public void checkRecipe(int x, int y, int z) {
		int depth, row, column;
		for(depth = 0; depth < grid.getDepth(); depth++) {
			WorldCraftingGrid layer = grid.getLayer(depth);
			for(row = 0; row < layer.getHeight(); row++) {
				for(column = 0; column < layer.getWidth(); column++) {
					
				}
			}
		}
	}
	
	public Point3D getControlBlockCords() {
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
	
	public void getRelativeCords(Point3D arrayCords, Point3D worldCords, Point3D controlBlockCords) {
		int depth, row, column;
		for(depth = 0; depth < grid.getDepth(); depth++) {
			WorldCraftingGrid layer = grid.getLayer(depth);
			for(row = 0; row < layer.getHeight(); row++) {
				for(column = 0; column < layer.getWidth(); column++) {
					
				}
			}
		}
	}
	
}