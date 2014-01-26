package LightProcessing.common.lib;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Methods {

	private static int offsetX = 0;
	private static int offsetY = 0;
	private static int offsetZ = 0;

	public static boolean isPowered(World world, int x, int y, int z) {
		if (world.getBlockPowerInput(x, y, z) > 0) {
			return true;
		}
		else if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
			return true;
		}
		else if (world.isBlockIndirectlyGettingPowered(x + 1, y, z)) {
			return true;
		}
		else if (world.isBlockIndirectlyGettingPowered(x - 1, y, z)) {
			return true;
		}
		else if (world.isBlockIndirectlyGettingPowered(x, y, z + 1)) {
			return true;
		}
		else if (world.isBlockIndirectlyGettingPowered(x, y, z - 1)) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Checks the metadata of a block neighboring x, y, z.
	 * 0 = +x, 1 = -x, 2 = +y, 3 = -y, 4 = +z, 5 = -z
	 */
	public static int getMeta(World world, int x, int y, int z, int dir) {
		switch (dir) {
		case 0: {
			return world.getBlockMetadata(x + 1, y, z);
		}
		case 1: {
			return world.getBlockMetadata(x - 1, y, z);
		}
		case 2: {
			return world.getBlockMetadata(x, y + 1, z);
		}
		case 3: {
			return world.getBlockMetadata(x, y - 1, z);
		}
		case 4: {
			return world.getBlockMetadata(x, y, z + 1);
		}
		case 5: {
			return world.getBlockMetadata(x, y, z - 1);
		}
		default:
			return 0;
		}
	}

	/**
	 * Checks the ID of a block neighboring x, y, z.
	 * 0 = +x, 1 = -x, 2 = +y, 3 = -y, 4 = +z, 5 = -z
	 */
	public static int getID(World world, int x, int y, int z, int dir) {
		switch (dir) {
		case 0: {
			return world.getBlockId(x + 1, y, z);
		}
		case 1: {
			return world.getBlockId(x - 1, y, z);
		}
		case 2: {
			return world.getBlockId(x, y + 1, z);
		}
		case 3: {
			return world.getBlockId(x, y - 1, z);
		}
		case 4: {
			return world.getBlockId(x, y, z + 1);
		}
		case 5: {
			return world.getBlockId(x, y, z - 1);
		}
		}
		return 0;
	}

	/**
	 * Sets the metadata of a block neighboring x, y, z to "meta."
	 * 0 = +x, 1 = -x, 2 = +y, 3 = -y, 4 = +z, 5 = -z
	 */
	public static void metaSet(World world, int x, int y, int z, int meta, int dir) {
		switch (dir) {
		case 0: {
			world.setBlockMetadataWithNotify(x + 1, y, z, meta, 3);
		}
		case 1: {
			world.setBlockMetadataWithNotify(x + 1, y, z, meta, 3);
		}
		case 2: {
			world.setBlockMetadataWithNotify(x, y + 1, z, meta, 3);
		}
		case 3: {
			world.setBlockMetadataWithNotify(x, y - 1, z, meta, 3);
		}
		case 4: {
			world.setBlockMetadataWithNotify(x, y, z + 1, meta, 3);
		}
		case 5: {
			world.setBlockMetadataWithNotify(x, y, z - 1, meta, 3);
		}
		}
	}

	public static boolean isPoweredDirect(World world, int x, int y, int z) {
		if (world.getBlockPowerInput(x, y, z) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isPoweredIndirect(World world, int x, int y, int z) {
		if (world.getBlockPowerInput(x, y, z) > 0) {
			return true;
		}
		else if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
			return true;
		}
		else {
			return false;
		}
	}

	public static String textureName(String unLocNam) {
		return Reference.MOD_ID.toLowerCase() + ":" + (unLocNam.substring(5));
	}

	/**
	 * This Method accepts a world location, x, y, z, a 2 dimensional Array, and a block which will be offset (block clicked)
	 * it will check the 2 dimensional Array in a flat plane with the block's world location
	 * at the center of the checking and if successful, returns true. -1 is the "skip" location sentinel
	 * if -1 is passed as the block for the offset block, it will skip the offset check (for quicker code runtime)
	 */
	public static boolean checkArea(World world, int x, int y, int z, int Array[][], int block) {
		int num = 0, i, j;
		int valX = Array[0].length / 2;
		int valY = Array.length / 2;

		offsetCheck: {
			if (block == -1)
				break offsetCheck;
			for (i = -1 * valY; i <= valY; i++) {
				for (j = -1 * valX; j <= valX; j++) {
					if (Array[i + valY][j + valX] == block) {
						if (i < 0 || j < 0) {
							offsetX = -1 * i;
							offsetY = -1 * j;
							break offsetCheck;
						}
						else {
							offsetX = i;
							offsetY = j;
							break offsetCheck;
						}
					}
				}
			}
		}

		for (i = -1 * valY; i <= valY; i++) {
			for (j = -1 * valX; j <= valX; j++) {
				if (world.getBlockId(x + i + offsetX, y, z + j + offsetY) == Array[i + valY][j + valX] || Array[i + valY][j + valX] == -1)
					num++;
			}
		}

		if (Array.length * Array[0].length == num)
			return true;
		else
			return false;
	}

	/**
	 * This Method accepts a world location, x, y, z, a 2 dimensional Array, a block id to be set too, and a block which will be offset (block clicked)
	 * it will first check with the checkArea method to make sure it is a valid array
	 * then set the area to the block id. -1 is the "skip" location sentinel
	 * if -1 is passed as the block for the offset block, it will skip the offset check (for quicker code runtime)
	 */
	public static boolean setArea(World world, int x, int y, int z, int Array[][], int block, int offsetBlock) {
		int i, j;
		int valX = Array[0].length / 2;
		int valY = Array.length / 2;
		if (checkArea(world, x, y, z, Array, offsetBlock)) {
			for (i = -1 * valY; i <= valY; i++) {
				for (j = -1 * valX; j <= valX; j++) {
					if (Array[i + valY][j + valX] == -1)
						continue;
					else
						// if(world.getBlockId(x + i + offsetX, y, z + j + offsetY) == Array[i+valY][j+valX])
						world.setBlock(x + i + offsetX, y, z + j + offsetY, block);
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * This Method accepts a world location, x, y, z, a 3 dimensional Array, and a block which will be offset (block clicked)
	 * it will check the 2 dimensional Array in a flat plane with the block's world location
	 * at the center of the checking and if successful, returns true. -1 is the "skip" location sentinel.
	 * if -1 is passed as the block for the offset block, it will skip the offset check (for quicker code runtime)
	 */
	public static boolean checkArea(World world, int x, int y, int z, int Array[][][], int block) {
		int num = 0, i, j, k;
		int valX = Array[0][0].length / 2;
		int valY = Array[0].length / 2;
		int valZ = Array.length / 2;

		offsetCheck: {
			if (block == -1)
				break offsetCheck;
			for (i = -1 * valZ; i <= valZ; i++) {
				for (j = -1 * valY; j <= valY; j++) {
					for (k = -1 * valX; k <= valX; k++) {
						if (Array[i + valZ][j + valY][k + valX] == block) {
							if (i < 0 || j < 0 || k < 0) {
								offsetX = -1 * i;
								offsetY = -1 * j;
								offsetZ = -1 * k;
								break offsetCheck;
							}
							else {
								offsetX = i;
								offsetY = j;
								offsetZ = k;
								break offsetCheck;
							}
						}
					}
				}
			}
		}

		for (i = -1 * valZ; i <= valZ; i++) {
			for (j = -1 * valY; j <= valY; j++) {
				for (k = -1 * valX; k <= valX; k++) {
					if (world.getBlockId(x + j + offsetY, y + i + offsetX, z + k + offsetZ) == Array[i + valZ][j + valY][k + valX] || Array[i + valZ][j + valY][k + valX] == -1)
						num++;
				}
			}
		}

		if (Array[0][0].length * Array[0].length * Array.length == num)
			return true;
		else
			return false;
	}

	/**
	 * This Method accepts a world location, x, y, z, a 3 dimensional Array, a block id to be set too, and a block which will be offset (block clicked)
	 * it will first check with the checkArea method to make sure it is a valid array
	 * then set the area to the block id. -1 is the "skip" location sentinel
	 * if -1 is passed as the block for the offset block, it will skip the offset check (for quicker code runtime)
	 */
	public static boolean setArea(World world, int x, int y, int z, int Array[][][], int block, int offsetBlock) {
		int i, j, k;
		int valX = Array[0][0].length / 2;
		int valY = Array[0].length / 2;
		int valZ = Array.length / 2;
		if (checkArea(world, x, y, z, Array, offsetBlock)) {
			for (i = -1 * valZ; i <= valZ; i++) {
				for (j = -1 * valY; j <= valY; j++) {
					for (k = -1 * valX; k <= valX; k++) {
						if (Array[i + valZ][j + valY][k + valX] == -1)
							continue;
						else if (world.getBlockId(x + j + offsetY, y + i + offsetX, z + k + offsetZ) == Array[i + valZ][j + valY][k + valX])
							world.setBlock(x + j + offsetY, y + i + offsetX, z + k + offsetZ, block);
					}
				}
			}
			return true;
		}
		return false;
	}

	/**	This Method accepts a world location, x, y, z, and a 3 dimensional Array
	 * 	it will check the 2 dimensional Array in a flat plane with the block's world location
	 * 	at the center of the checking and if successful, returns true. -1 is the "skip" location sentinel
	 */
	public static boolean checkArea(World world, int x, int y, int z, int Array[][][]) {
		int num = 0, i, j, k;
		int valX = Array[0][0].length / 2;
		int valY = Array[0].length / 2;
		int valZ = Array.length / 2;
		for(i = -1*valZ; i <= valZ; i++) {
			for(j = -1*valY; j <= valY; j++) {
				for(k = -1*valX; k <= valX; k++) {
					if(world.getBlockId(x + j, y + i, z + k) == Array[i+valZ][j+valY][k+valX]  || Array[i+valZ][j+valY][k+valX] == -1)
						num++;
				}
			}
		}
		
		if(Array[0][0].length * Array[0].length * Array.length == num)
			return true;
		else
			return false;
	}
	
	/**	This Method accepts a world location, x, y, z, a 3 dimensional Array and a block id
	 * 	it will first check with the checkArea method to make sure it is a valid array
	 * 	then set the area to the block id. -1 is the "skip" location sentinel
	 */
	public static boolean setArea(World world, int x, int y, int z, int Array[][][], int block) {
		int i, j, k;
		int valX = Array[0][0].length / 2;
		int valY = Array[0].length / 2;
		int valZ = Array.length / 2;
		if(checkArea(world, x, y, z, Array)) {
			for(i = -1*valZ; i <= valZ; i++) {
				for(j = -1*valY; j <= valY; j++) {
					for(k = -1*valX; k <= valX; k++) {
						if(Array[i+valZ][j+valY][k+valX] == -1)
							continue;
						else if(world.getBlockId(x + j, y + i, z + k) == Array[i+valZ][j+valY][k+valX])
							world.setBlock(x + j, y + i, z + k, block);
					}
				}
			}
			return true;
		}
		return false;
	}
	
	
	
	public static boolean testArea(World world, int x, int y, int z, int ox, int oy, int oz, int Array[][][]) {
		int num = 0, i, j, k;
		int valX = Array[0][0].length;
		int valY = Array[0].length;
		int valZ = Array.length;
		for(i = 0; i <= valZ; i++) {
			for(j = 0; j <= valY; j++) {
				for(k = 0; k <= valX; k++) {
					if(world.getBlockId(x + j - ox, y + i - oy, z + k - oz) == Array[i+valZ][j+valY][k+valX]  || Array[i+valZ][j+valY][k+valX] == -1)
						num++;
					
					System.out.println(world.getBlockId(x + j - ox, y + i - oy, z + k - oz));
				}
				
			}
		}
		
		if(Array[0][0].length * Array[0].length * Array.length == num)
			return true;
		else
			return false;
	}
	
	
	
}
