package LightProcessing.common.lib;

import java.util.ArrayList;

public class WorldCraftingRecipeCollection {
	
	ArrayList<WorldCraftingRecipe> recipes;
	int controlBlockId;
	
	public WorldCraftingRecipeCollection(int controlBlockId) {
		recipes = new ArrayList<WorldCraftingRecipe>();
		this.controlBlockId = controlBlockId;
	}
	
	public void add(WorldCraftingRecipe recipe) {
		recipes.add(recipe);
	}
	
	public WorldCraftingRecipe get(int ID) {
		return recipes.get(ID);
	}
	
	public int getCount() {
		return recipes.size();
	}
	
}
