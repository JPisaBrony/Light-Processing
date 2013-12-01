package LightProcessing.common.lib;

public class WorldCrafting {
	static int DL = IDRef.DARK_LEAF_ID;
	static int LW = IDRef.LIGHT_WOOD_ID;
	static int HV = IDRef.HARVESTER_ID;
	static int MC = IDRef.MACHINE_CORE_ID;
	static int DB = IDRef.DARK_BLOCK_ID;
	public static int harvester[][] = {
			{LW,DL,DL,DL,LW},
			{DL,0 ,0 ,0 ,DL},
			{DL,0 ,MC,0 ,DL},
			{DL,0 ,0 ,0 ,DL},
			{LW,DL,DL,DL,LW}
		};
	public static int darkGen[][] = {
		{0 ,0 ,DB,0 ,0 },
		{0 ,DB,0 ,DB,0 },
		{DB,0 ,MC,0 ,DB},
		{0 ,DB,0 ,DB,0 },
		{0 ,0 ,DB,0 ,0 }
	};
	public static int darkGen2[][] = {
		{0 ,0 ,0 ,0 ,0 },
		{0 ,0 ,0 ,0 ,0 },
		{0 ,0 ,DB,0 ,0 },
		{0 ,0 ,0 ,0 ,0 },
		{0 ,0 ,0 ,0 ,0 }
	};
}
