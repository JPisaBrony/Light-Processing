package LightProcessing.common.lib;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class ExtractionList {

	public static int[] list = new int[4096];
	public static int[][] list2 = new int[4096][16];

	public static void setList() {
		list[0] = 0;
		list[1] = -1;
		list[2] = 1;
		list[3] = -1;
		//list[4] = -1;
		list[12] = 1;
		list[13] = -1;
		list[14] = 2;
		list[15] = 1;
		list[16] = -1;
		list[18] = 1;
		//list[19] = 0;
		list[20] = 1;
		list[21] = -1;
		list[22] = 1;
		list[23] = -1;
		list[25] = 1;
		list[29] = -1;
		list[30] = 1;
		list[33] = 1;
		list[41] = 4;
		list[42] = 2;
		//list[43] = -2;
		list[44] = -1;
		list[45] = -1;
		list[46] = -2;
		list[47] = 1;
		list[48] = -1;
		list[49] = -1;
		list[53] = 1;
		list[54] = 1;
		//list[56] = 4;
		list[57] = 36;
		//list[58] = 1;
		//list[60] = 2;
		list[61] = -1;
		//list[62] = -7;
		//list[67] = -5;
		list[73] = -2;
		//list[74] = -9;
		list[79] = 1;
		//list[80] = 3;
		//list[82] = -3;
		list[84] = 1;
		//list[85] = 4;
		list[86] = -1;
		//list[87] = -2;
		list[88] = -1;
		list[89] = 2;
		list[91] = 2;
		list[92] = 1;
		list[98] = -1;
		list[99] = -1;
		list[100] = -1;
		list[101] = -1;
		list[102] = 1;
		list[103] = 1;
		list[107] = 1;
		list[108] = -1;
		list[109] = -1;
		list[110] = -1;
		list[112] = -1;
		list[113] = -1;
		list[114] = -1;
		list[116] = 8;
		list[117] = -1;
		list[118] = -1;
		//list[121] = 2;
		list[122] = -64;
		list[123] = -1;
		list[124] = 1;
		//list[125] = 2;
		//list[126] = 1;
		list[128] = -1;
		//list[129] = 15;
		list[130] = -2;
		list[133] = 32;
		//list[134] = 7;
		//list[135] = 7;
		//list[136] = 7;
		list[138] = 32;
		//list[139] = -4;
		//list[140] = -2;
		list[144] = -1;
		list[145] = 13;
		//list[146] = 16;
		list[151] = 1;
		list[152] = -1;
		list[153] = -1;
		list[154] = -1;
		list[155] = 1;
		list[156] = 1;
		list[158] = -1;
		//list[159] = 1;
		list[170] = 1;
		list[171] = 1;
		list[172] = -1;
		list[173] = -2;
		list[IDRef.DARK_BLOCK_ID] = -2;
		list[IDRef.LIGHT_BLOCK_ID] = 2;
		list[IDRef.ABS_BLOCK_ID] = -4;
		list[IDRef.DARK_LEAF_ID] = -1;
		list[IDRef.LIGHT_WOOD_ID] = 1;
		//list[IDRef.LIGHT_WOOD_PLANKS_ID] = 5;

		//int[] planks = { 1, -2, 2, -1, 1, -2, 2, -1, 1, -2, 2, -1};
		//int[] logs = { 1, -1, 1, -1 };
		//int[] sandstone = { -2, -2, -2 };
		//int[] wool = { 2, 2, 2, 2, 2, 2, 2, -2, -2, 2, -2, -2, -2, -2, 2, -2 };
		//int[] dslabs = { -2, -3, 2, 2, 6, 4, -6, 6 };
		//int[] slabs = { -1, -2, 2, -1, 3, -2, -3, 3 };
		//int[] sbricks = { -2, -3, -3, -5 };
		//int[] wdslabs = { 2, -4, 4, -2 };
		//int[] wslabs = { 1, -2, 2, -1 };
		//int[] quartz = { 5, 6, 6, 6 };
		//int[] sclay = { 5, 5, 5, 5, 5, 5, 5, -5, -5, 5, -5, -5, -5, -5, 5, -5 };
		//int[] carpet = { 1, 1, 1, 1, 1, 1, 1, -1, -1, 1, -1, -1, -1, -1, 1, -1 };
		/*
		list2[5] = planks;
		list2[17] = logs;
		list2[24] = sandstone;
		list2[35] = wool;
		list2[43] = dslabs;
		list2[44] = slabs;
		list2[98] = sbricks;
		list2[125] = wdslabs;
		list2[126] = wslabs;
		list2[155] = quartz;
		list2[159] = sclay;
		list2[171] = carpet;
		*/
	}

	public static int getEssence(World world, int x, int y, int z) {
		Block ID = world.getBlock(x, y, z);
		int meta = world.getBlockMetadata(x, y, z);
		try{
		if (meta == 0)
			return list[ID];
		else if (list2[ID][meta] == 0)
			return list[ID];
		else
			return list2[ID][meta];
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e){
			return list[ID];
		}
	}

}
