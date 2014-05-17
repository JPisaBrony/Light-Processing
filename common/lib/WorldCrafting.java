package LightProcessing.common.lib;

public class WorldCrafting {
	
	static int DL = IDRef.DARK_LEAF_ID;
	static int LW = IDRef.LIGHT_WOOD_ID;
	static int HV = IDRef.HARVESTER_ID;
	static int MC = IDRef.MACHINE_CORE_ID;
	static int DB = IDRef.DARK_BLOCK_ID;
	static int EX = IDRef.ESSENCE_EXTRACTOR_ID;
	static int SK = -1;
	
	public static int harvester[][] = {
		{LW,DL,DL,DL,LW},
		{DL,-1 ,-1 ,-1 ,DL},
		{DL,-1 ,MC ,-1 ,DL},
		{DL,-1 ,-1 ,-1 ,DL},
		{LW,DL,DL,DL,LW}
	};
	
	public static Integer harvester2[][] = {
		{0,0,0,0,0,0,0,0,0,0},
		{DL,-1 ,-1 ,-1 ,DL},
		{DL,-1 ,MC ,-1 ,DL},
		{DL,-1 ,-1 ,-1 ,DL},
		{LW,DL,DL,DL,LW}
	};
	
	public WorldCraftingGrid3d mine = new WorldCraftingGrid3d();
	
	public WorldCrafting() {
		mine.add(harvester2);
	}
	
}