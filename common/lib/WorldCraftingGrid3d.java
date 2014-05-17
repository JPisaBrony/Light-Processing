package LightProcessing.common.lib;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.block.Block;

public class WorldCraftingGrid3d {
	
	private ArrayList<WorldCraftingGrid> array = new ArrayList<WorldCraftingGrid>();
	private int depth;
	
	public WorldCraftingGrid3d(WorldCraftingGrid Array[]) {
		array = (ArrayList<WorldCraftingGrid>) Arrays.asList(Array);
		this.depth = Array.length;
	}
	
	public WorldCraftingGrid3d() {
		this.depth = 0;
	}
	
	public Integer get(int row, int column, int height) {
		return array.get(height).get(row, column);
	}
	
	public void add(Integer twoDarray[][]) {
		array.add(new WorldCraftingGrid(twoDarray));
		depth++;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public WorldCraftingGrid getLayer(int i) {
		return array.get(i);
	}
	
}
