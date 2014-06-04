package LightProcessing.common.lib;

import net.minecraft.world.World;

public class ExtractionList {

	public static int[] list = new int[4096];
	public static int[][] list2 = new int[4096][16];

	public static void setList() {
		list[0] = 0;
		list[1] = -3;
		list[2] = 3;
		list[3] = -1;
		list[4] = -2;
		list[12] = 1;
		list[13] = -1;
		list[14] = 5;
		list[15] = 4;
		list[16] = -3;
		list[18] = 1;
		list[19] = 0;
		list[20] = 2;
		list[21] = -6;
		list[22] = 5;
		list[23] = -10;
		list[25] = 4;
		list[29] = -5;
		list[30] = 3;
		list[33] = 4;
		list[41] = 45;
		list[42] = 36;
		list[43] = -2;
		list[44] = -1;
		list[45] = -10;
		list[46] = -15;
		list[47] = 15;
		list[48] = -10;
		list[49] = -5;
		list[53] = 10;
		list[54] = 5;
		list[56] = 8;
		list[57] = 64;
		list[58] = 4;
		list[60] = 2;
		list[61] = -8;
		list[62] = -7;
		list[67] = -5;
		list[73] = -10;
		list[74] = -9;
		list[79] = 4;
		list[80] = 3;
		list[82] = -3;
		list[84] = 16;
		list[85] = 4;
		list[86] = -5;
		list[87] = -2;
		list[88] = -5;
		list[89] = 10;
		list[91] = 5;
		list[92] = 5;
		list[98] = -2;
		list[99] = -5;
		list[100] = -5;
		list[101] = -7;
		list[102] = 7;
		list[103] = 8;
		list[107] = 5;
		list[108] = -7;
		list[109] = -5;
		list[110] = -4;
		list[112] = -3;
		list[113] = -3;
		list[114] = -7;
		list[116] = 24;
		list[117] = -8;
		list[118] = -15;
		list[121] = 2;
		list[122] = -64;
		list[123] = -8;
		list[124] = 8;
		list[125] = 2;
		list[126] = 1;
		list[128] = -7;
		list[129] = 15;
		list[130] = -20;
		list[133] = 64;
		list[134] = 7;
		list[135] = 7;
		list[136] = 7;
		list[138] = 32;
		list[139] = -4;
		list[140] = -2;
		list[144] = -10;
		list[145] = 32;
		list[146] = 16;
		list[151] = 15;
		list[152] = -32;
		list[153] = -4;
		list[154] = -8;
		list[155] = 5;
		list[156] = 8;
		list[158] = -10;
		list[159] = 5;
		list[170] = 8;
		list[171] = 1;
		list[172] = -1;
		list[173] = -48;
		list[IDRef.DARK_BLOCK_ID] = -54;
		list[IDRef.LIGHT_BLOCK_ID] = 54;
		list[IDRef.ABS_BLOCK_ID] = -64;
		list[IDRef.DARK_LEAF_ID] = -15;
		list[IDRef.LIGHT_WOOD_ID] = 20;
		list[IDRef.LIGHT_WOOD_PLANKS_ID] = 5;

		int[] planks = { 1, -2, 2, -1, 1, -2, 2, -1, 1, -2, 2, -1};
		int[] logs = { 2, -4, 4, -2 };
		int[] sandstone = { -2, -2, -2 };
		int[] wool = { 2, 2, 2, 2, 2, 2, 2, -2, -2, 2, -2, -2, -2, -2, 2, -2 };
		int[] dslabs = { -2, -3, 2, 2, 6, 4, -6, 6 };
		int[] slabs = { -1, -2, 2, -1, 3, -2, -3, 3 };
		int[] sbricks = { -2, -3, -3, -5 };
		int[] wdslabs = { 2, -4, 4, -2 };
		int[] wslabs = { 1, -2, 2, -1 };
		int[] quartz = { 5, 6, 6, 6 };
		int[] sclay = { 5, 5, 5, 5, 5, 5, 5, -5, -5, 5, -5, -5, -5, -5, 5, -5 };
		int[] carpet = { 1, 1, 1, 1, 1, 1, 1, -1, -1, 1, -1, -1, -1, -1, 1, -1 };

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
	}

	public static int getEssence(World world, int x, int y, int z) {
		int ID = world.getBlockId(x, y, z);
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
