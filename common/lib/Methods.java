package LightProcessing.common.lib;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Methods {

	public static boolean isPowered(World world, int x, int y, int z) {
		if (world.getBlockPowerInput(x, y, z) > 0) {
			return true;
		} else if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
			return true;
		} else if (world.isBlockIndirectlyGettingPowered(x + 1, y, z)) {
			return true;
		} else if (world.isBlockIndirectlyGettingPowered(x - 1, y, z)) {
			return true;
		} else if (world.isBlockIndirectlyGettingPowered(x, y, z + 1)) {
			return true;
		} else if (world.isBlockIndirectlyGettingPowered(x, y, z - 1)) {
			return true;
		} else {
			return false;
		}
	}

	/**Checks the metadata of a block neighboring x, y, z.
	 * 0 = +x, 1 = -x, 2 = +y, 3 = -y, 4 = +z, 5 = -z 
	 */
	public static int getMeta(World world, int x, int y, int z, int dir){
		switch(dir){
		case 0:
		{
			return world.getBlockMetadata(x + 1, y, z);
		}
		case 1:
		{
			return world.getBlockMetadata(x - 1, y, z);
		}
		case 2:
		{
			return world.getBlockMetadata(x, y + 1, z);
		}
		case 3:
		{
			return world.getBlockMetadata(x, y - 1, z);
		}
		case 4:
		{
			return world.getBlockMetadata(x, y, z + 1);
		}
		case 5:
		{
			return world.getBlockMetadata(x, y, z - 1);
		}
		default:
		return 0;
		}
	}
	
	/**Checks the ID of a block neighboring x, y, z.
	 * 0 = +x, 1 = -x, 2 = +y, 3 = -y, 4 = +z, 5 = -z 
	 */
	public static int getID(World world, int x, int y, int z, int dir){
	switch(dir){
	case 0:
	{
		return world.getBlockId(x + 1, y, z);
	}
	case 1:
	{
		return world.getBlockId(x - 1, y, z);
	}
	case 2:
	{
		return world.getBlockId(x, y + 1, z);
	}
	case 3:
	{
		return world.getBlockId(x, y - 1, z);
	}
	case 4:
	{
		return world.getBlockId(x, y, z + 1);
	}
	case 5:
	{
		return world.getBlockId(x, y, z - 1);
	}
	}
	return 0;
	}

	/**Sets the metadata of a block neighboring x, y, z to "meta."
	 * 0 = +x, 1 = -x, 2 = +y, 3 = -y, 4 = +z, 5 = -z 
	 */
	public static void metaSet(World world, int x, int y, int z, int meta, int dir){
		switch(dir){
			case 0:
			{
				world.setBlockMetadataWithNotify(x + 1, y, z, meta, 3);
			}
			case 1:
			{
				world.setBlockMetadataWithNotify(x + 1, y, z, meta, 3);				
			}
			case 2:
			{	
				world.setBlockMetadataWithNotify(x, y + 1, z, meta, 3);
			}
			case 3:
			{	
				world.setBlockMetadataWithNotify(x, y - 1, z, meta, 3);
			}
			case 4:
			{	
				world.setBlockMetadataWithNotify(x, y, z + 1, meta, 3);
			}
			case 5:
			{	
				world.setBlockMetadataWithNotify(x, y, z - 1, meta, 3);
			}
		}
	}
	
	public static boolean isPoweredDirect(World world, int x, int y, int z) {
		if (world.getBlockPowerInput(x, y, z) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isPoweredIndirect(World world, int x, int y, int z) {
		if (world.getBlockPowerInput(x, y, z) > 0) {
			return true;
		} else if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
			return true;
		} else {
			return false;
		}
	}

	public static String textureName(String unLocNam) {
		return Reference.MOD_ID.toLowerCase() + ":" + (unLocNam.substring(5));
	}
	
	/**	This Method accepts a world location, x, y, z, and a 2 dimensional Array
	 * 	it will check the 2 dimensional Array in a flat plane with the block's world location
	 * 	at the center of the checking and if successful, returns true
	 */
	public static boolean checkArea(World world, int x, int y, int z, int Array[][]) {
		int num = 0, i, j;
		for(i = -1*(Array[0].length / 2); i <= Array[0].length / 2; i++) {
			for(j = -1*(Array[1].length / 2); j <= Array[1].length / 2; j++) {
				if(world.getBlockId(x + j, y, z + i) == Array[i+2][j+2])
					num++;
			}
		}
		
		if(Array[0].length * Array[1].length == num)
			return true;
		else
			return false;
	}
	
	/**	This Method accepts a world location, x, y, z, a 2 dimensional Array and a block id
	 * 	it will first check with the checkArea method to make sure it is a valid array
	 * 	then set the area to the block id
	 */
	public static boolean setArea(World world, int x, int y, int z, int Array[][], int block) {
		int i, j;
		if(checkArea(world, x, y, z, Array)){
			for(i = -1*(Array[0].length / 2); i <= Array[0].length / 2; i++) {
				for(j = -1*(Array[1].length / 2); j <= Array[1].length / 2; j++) {
					if(world.getBlockId(x + j, y, z + i) == Array[i+2][j+2])
						world.setBlock(x + j, y, z + i, block);
				}
			}
			return true;
		}
		return false;
	}
}
