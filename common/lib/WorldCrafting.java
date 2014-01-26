package LightProcessing.common.lib;

public class WorldCrafting {
	
	static int DL = IDRef.DARK_LEAF_ID;
	static int LW = IDRef.LIGHT_WOOD_ID;
	static int HV = IDRef.HARVESTER_ID;
	static int MC = IDRef.MACHINE_CORE_ID;
	static int DB = IDRef.DARK_BLOCK_ID;
	static int EX = IDRef.EXTRACTOR_ID;
	static int SK = -1;
	
	public static int harvester[][] = {
		{LW,DL,DL,DL,LW},
		{DL,-1 ,-1 ,-1 ,DL},
		{DL,-1 ,MC ,-1 ,DL},
		{DL,-1 ,-1 ,-1 ,DL},
		{LW,DL,DL,DL,LW}
	};
	
	public static int darkGen[][] = {
		{SK,SK,DB,SK,SK},
		{SK,DB,0 ,DB,SK},
		{DB,0 ,MC,0 ,DB},
		{SK,DB,0 ,DB,SK},
		{SK,SK,DB,SK,SK}
	};
	
	public static int darkGen2[][] = {
		{SK,SK,SK,SK,SK},
		{SK,SK,SK,SK,SK},
		{SK,SK,DB,SK,SK},
		{SK,SK,SK,SK,SK},
		{SK,SK,SK,SK,SK}
	};
	
}