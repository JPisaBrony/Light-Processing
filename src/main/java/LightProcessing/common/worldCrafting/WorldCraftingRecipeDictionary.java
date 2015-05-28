package LightProcessing.common.worldCrafting;

import java.util.HashMap;

public class WorldCraftingRecipeDictionary {
	
	HashMap<Integer, WorldCraftingRecipeCollection> map;
	
	public WorldCraftingRecipeDictionary() {
		map = new HashMap<Integer, WorldCraftingRecipeCollection>();
	}
	
	public void add(WorldCraftingRecipeCollection collection) {
		map.put(collection.controlBlockId, collection);
	}
	
	public int getCount() {
		return map.size();
	}
	
	public WorldCraftingRecipeCollection get(int controlBlockId) {
		return map.get(controlBlockId);
	}
	
}
