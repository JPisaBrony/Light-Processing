package LightProcessing.common.lib;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;

public class WorldCraftingGrid {
	
	private ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
	private int width;
	private int height;
	
	public WorldCraftingGrid(Integer Array[][]) {
		int i;
		for(i = 0; i < Array.length; i++)
			array.add((ArrayList<Integer>) Arrays.asList(Array[i]));
		if(!checkArray(Array))
			throw new  IllegalArgumentException();
		this.height = Array.length;
		this.width = Array[0].length;
	}
	
	public Integer get(int row, int column) {
		return array.get(row).get(column);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public boolean checkArray(Integer Array[][]) {
		for(int i = 0; i < Array.length; i++) {
			if(Array[i].length != Array[0].length)
				return false;
		}
		return true;
	}
	
}