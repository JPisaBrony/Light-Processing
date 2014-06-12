package LightProcessing.common.lib;

import net.minecraft.block.Block;

public class WorldCrafting {
	static int I = Block.blockIron.blockID;
	static int S = Block.stone.blockID;
	static int DL = IDRef.DARK_LEAF_ID;
	static int LW = IDRef.LIGHT_WOOD_ID;
	static int HV = IDRef.HARVESTER_ID;
	static int MC = IDRef.MACHINE_CORE_ID;
	static int DB = IDRef.DARK_BLOCK_ID;
	static int EX = IDRef.ESSENCE_EXTRACTOR_ID;
	static int H = IDRef.HARVESTER_ID;
	static int LP = IDRef.LIGHT_WOOD_PLANKS_ID;
	static int LB = IDRef.LIGHT_BLOCK_ID;
	public WorldCraftingRecipeDictionary dictionary = new WorldCraftingRecipeDictionary();
	
	public WorldCrafting() {
		WorldCraftingRecipeCollection machineCoreRecipes = new WorldCraftingRecipeCollection(Block.blockIron.blockID);
		WorldCraftingRecipeCollection harvesterRecipes = new WorldCraftingRecipeCollection(MC);
		WorldCraftingRecipeCollection LightToolRecipes = new WorldCraftingRecipeCollection(LP);
		WorldCraftingRecipeCollection DarkToolRecipes = new WorldCraftingRecipeCollection(DL);
		machineCoreRecipes.add(new WorldCraftingRecipe(MachineCore, MC, Block.blockIron.blockID));
		harvesterRecipes.add(new WorldCraftingRecipe(Harvester, H, MC));
		LightToolRecipes.add(new WorldCraftingRecipe(LightPickaxe, 0, LP));
		LightToolRecipes.add(new WorldCraftingRecipe(LightAxe, 0, LP));
		LightToolRecipes.add(new WorldCraftingRecipe(LightHoe, 0, LP));
		LightToolRecipes.add(new WorldCraftingRecipe(LightShovel, 0, LP));
		LightToolRecipes.add(new WorldCraftingRecipe(LightSword, 0, LP));
		LightToolRecipes.add(new WorldCraftingRecipe(LightBlock, LB, LP));
		DarkToolRecipes.add(new WorldCraftingRecipe(DarkPickaxe, 0, DL));
		DarkToolRecipes.add(new WorldCraftingRecipe(DarkAxe, 0, DL));
		DarkToolRecipes.add(new WorldCraftingRecipe(DarkHoe, 0, DL));
		DarkToolRecipes.add(new WorldCraftingRecipe(DarkShovel, 0, DL));
		DarkToolRecipes.add(new WorldCraftingRecipe(DarkSword, 0, DL));
		DarkToolRecipes.add(new WorldCraftingRecipe(DarkBlock, DB, DL));
		dictionary.add(machineCoreRecipes);
		dictionary.add(harvesterRecipes);
		dictionary.add(LightToolRecipes);
		dictionary.add(DarkToolRecipes);
	}
	
	public static Integer MachineCore[][][] = {
		{
			{S,S,S},
			{S,I,S},
			{S,S,S}
		}
	};
	
	public static Integer Harvester[][][] = {
		{
			{LW,DL,DL,DL,LW},
			{DL,0,0,0,DL},
			{DL,0,MC,0,DL},
			{DL,0,0,0,DL},
			{LW,DL,DL,DL,LW}
		}
	};
	
	public static Integer LightPickaxe[][][] = {
		{
			{LB,LB,LB},
			{0,LP,0},
			{0,LP,0}
		}
	};
	
	public static Integer LightAxe[][][] = {
		{
			{LB,LB},
			{LB,LP},
			{0,LP}
		}
	};
	
	public static Integer LightHoe[][][] = {
		{
			{LB,LB},
			{0,LP},
			{0,LP}
		}
	};
	
	public static Integer LightShovel[][][] = {
		{
			{LB},
			{LP},
			{LP}
		}
	};
	
	public static Integer LightSword[][][] = {
		{
			{LB},
			{LB},
			{LP}
		}
	};
	
	public static Integer DarkPickaxe[][][] = {
		{
			{DB,DB,DB},
			{0,DL,0},
			{0,DL,0}
		}
	};
	
	public static Integer DarkAxe[][][] = {
		{
			{DB,DB},
			{DB,DL},
			{0,DL}
		}
	};
	
	public static Integer DarkHoe[][][] = {
		{
			{DB,DB},
			{0,DL},
			{0,DL}
		}
	};
	
	public static Integer DarkShovel[][][] = {
		{
			{DB},
			{DL},
			{DL}
		}
	};
	
	public static Integer DarkSword[][][] = {
		{
			{DB},
			{DB},
			{DL}
		}
	};
	
	public static Integer DarkBlock[][][] = {
		{
			{S,S,S},
			{S,DL,S},
			{S,S,S}
		}
	};
	
	public static Integer LightBlock[][][] = {
		{
			{S,S,S},
			{S,LP,S},
			{S,S,S}
		}
	};
	
}