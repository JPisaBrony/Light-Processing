package LightProcessing.common.lib;

import net.minecraft.block.Block;

public class WorldCrafting {
	static int I = Block.blockIron.blockID;
	static int D = Block.blockDiamond.blockID;
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
	static int CM = IDRef.COMPRESSOR_ID;
	public WorldCraftingRecipeDictionary dictionary = new WorldCraftingRecipeDictionary();
	
	public WorldCrafting() {
		WorldCraftingRecipeCollection ironBlockRecipes = new WorldCraftingRecipeCollection(I);
		WorldCraftingRecipeCollection machineCoreRecipes = new WorldCraftingRecipeCollection(MC);
		WorldCraftingRecipeCollection toolRecipes = new WorldCraftingRecipeCollection(D);
		WorldCraftingRecipeCollection lightPlanks = new WorldCraftingRecipeCollection(LP);
		ironBlockRecipes.add(new WorldCraftingRecipe(MachineCore, MC, Block.blockIron.blockID));
		machineCoreRecipes.add(new WorldCraftingRecipe(LightBlock, LB, MC));
		machineCoreRecipes.add(new WorldCraftingRecipe(DarkBlock, DB, MC));
		machineCoreRecipes.add(new WorldCraftingRecipe(Harvester, H, MC));
		machineCoreRecipes.add(new WorldCraftingRecipe(Extractor, EX, MC));
		machineCoreRecipes.add(new WorldCraftingRecipe(Compressor, CM, MC));
		toolRecipes.add(new WorldCraftingRecipe(LightPickaxe, 0, D));
		toolRecipes.add(new WorldCraftingRecipe(LightAxe, 0, D));
		toolRecipes.add(new WorldCraftingRecipe(LightHoe, 0, D));
		toolRecipes.add(new WorldCraftingRecipe(LightShovel, 0, D));
		toolRecipes.add(new WorldCraftingRecipe(LightSword, 0, D));
		toolRecipes.add(new WorldCraftingRecipe(DarkPickaxe, 0, D));
		toolRecipes.add(new WorldCraftingRecipe(DarkAxe, 0, D));
		toolRecipes.add(new WorldCraftingRecipe(DarkHoe, 0, D));
		toolRecipes.add(new WorldCraftingRecipe(DarkShovel, 0, D));
		toolRecipes.add(new WorldCraftingRecipe(DarkSword, 0, D));
		lightPlanks.add(new WorldCraftingRecipe(AbsRod, 0, LP));
		dictionary.add(ironBlockRecipes);
		dictionary.add(machineCoreRecipes);
		dictionary.add(toolRecipes);
		dictionary.add(lightPlanks);
	}
	
	public static Integer MachineCore[][][] = {
		{
			{LP,DL,LP},
			{DL,I,DL},
			{LP,DL,LP}
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
			{0,D,0},
			{0,D,0}
		}
	};
	
	public static Integer LightAxe[][][] = {
		{
			{LB,LB},
			{LB,D},
			{0,D}
		}
	};
	
	public static Integer LightHoe[][][] = {
		{
			{LB,LB},
			{0,D},
			{0,D}
		}
	};
	
	public static Integer LightShovel[][][] = {
		{
			{LB},
			{D},
			{D}
		}
	};
	
	public static Integer LightSword[][][] = {
		{
			{LB},
			{LB},
			{D}
		}
	};
	
	public static Integer DarkPickaxe[][][] = {
		{
			{DB,DB,DB},
			{0,D,0},
			{0,D,0}
		}
	};
	
	public static Integer DarkAxe[][][] = {
		{
			{DB,DB},
			{DB,D},
			{0,D}
		}
	};
	
	public static Integer DarkHoe[][][] = {
		{
			{DB,DB},
			{0,D},
			{0,D}
		}
	};
	
	public static Integer DarkShovel[][][] = {
		{
			{DB},
			{D},
			{D}
		}
	};
	
	public static Integer DarkSword[][][] = {
		{
			{DB},
			{DB},
			{D}
		}
	};
	
	public static Integer DarkBlock[][][] = {
		{
			{DL,DL,DL},
			{DL,MC,DL},
			{DL,DL,DL}
		}
	};
	
	public static Integer LightBlock[][][] = {
		{
			{LP,LP,LP},
			{LP,MC,LP},
			{LP,LP,LP}
		}
	};
	
	public static Integer AbsRod[][][] = {
		{
			{DL,LP},
			{DL,LP},
			{DL,LP},
			{DL,LP},
			{DL,LP}
		}
	};
	
	public static Integer Extractor[][][] = {
		{
			{LB,LP,LP,LP,DB},
			{DL,0,0,0,DL},
			{DL,0,MC,0,DL},
			{DL,0,0,0,DL},
			{DB,LP,LP,LP,LB}
		}
	};
	
	public static Integer Compressor[][][] = {
		{
			{LB,LB,LB,DB,DB},
			{LB,0,0,0,DB},
			{DB,0,MC,0,DB},
			{DB,0,0,0,LB},
			{DB,DB,LB,LB,LB}
		}
	};
	
}