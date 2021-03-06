package LightProcessing.common.worldCrafting;

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
		for(i = 0; i < Array.length; i++) {
			ArrayList<Integer> t = new ArrayList<Integer>(Arrays.asList(Array[i]));
			array.add(t);
		}
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