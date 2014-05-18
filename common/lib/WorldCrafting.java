package LightProcessing.common.lib;

public class WorldCrafting {
	
	static int DL = IDRef.DARK_LEAF_ID;
	static int LW = IDRef.LIGHT_WOOD_ID;
	static int HV = IDRef.HARVESTER_ID;
	static int MC = IDRef.MACHINE_CORE_ID;
	static int DB = IDRef.DARK_BLOCK_ID;
	static int EX = IDRef.ESSENCE_EXTRACTOR_ID;
	static int H = IDRef.HARVESTER_ID;
	static int SK = -1;
	public WorldCraftingRecipeDictionary dictionary = new WorldCraftingRecipeDictionary();
	
	public WorldCrafting() {
		WorldCraftingRecipeCollection harvesterRecipes = new WorldCraftingRecipeCollection(MC);
		harvesterRecipes.add(new WorldCraftingRecipe(harvester2, H, MC));
		harvesterRecipes.add(new WorldCraftingRecipe(harvester3, H, MC));
		dictionary.add(harvesterRecipes);
	}
	
	public static int harvester[][] = {
		{LW,DL,DL,DL,LW},
		{DL,-1 ,-1 ,-1 ,DL},
		{DL,-1 ,MC ,-1 ,DL},
		{DL,-1 ,-1 ,-1 ,DL},
		{LW,DL,DL,DL,LW}
	};
	
	public static Integer harvester2[][][] = {
	{
		{LW,DL,DL,DL,LW},
		{DL,0 ,0 ,0 ,DL},
		{DL,0 ,MC ,0 ,DL},
		{DL,0 ,0 ,0 ,DL},
		{LW,DL,DL,DL,LW}
	},
	{
		{LW,DL,DL,DL,LW},
		{DL,0 ,0 ,0 ,DL},
		{DL,0 ,0 ,0 ,DL},
		{DL,0 ,0 ,0 ,DL},
		{LW,DL,DL,DL,LW}
	}
	};
	
	public static Integer harvester3[][][] = {
		{
			{LW,DL,DL,DL,LW},
			{DL,0 ,0 ,0 ,DL},
			{DL,0 ,MC ,0 ,DL},
			{DL,0 ,0 ,0 ,DL},
			{LW,DL,DL,DL,LW}
		}
	};
	
}