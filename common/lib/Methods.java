package LightProcessing.common.lib;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet15Place;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Methods {

	public static boolean isPowered(World world, int x, int y, int z) {
		if (world.getBlockPowerInput(x, y, z) > 0)
			return true;
		else if (world.isBlockIndirectlyGettingPowered(x, y, z))
			return true;
		else if (world.isBlockIndirectlyGettingPowered(x + 1, y, z))
			return true;
		else if (world.isBlockIndirectlyGettingPowered(x - 1, y, z))
			return true;
		else if (world.isBlockIndirectlyGettingPowered(x, y, z + 1))
			return true;
		else if (world.isBlockIndirectlyGettingPowered(x, y, z - 1))
			return true;
		else
			return false;
	}

	/**
	 * Checks the metadata of a block neighboring x, y, z.
	 * 0 = +x, 1 = -x, 2 = +y, 3 = -y, 4 = +z, 5 = -z
	 */
	public static int getMeta(World world, int x, int y, int z, int dir) {
		int id = 0;
		switch (dir) {
			case 0:
				id = world.getBlockMetadata(x + 1, y, z);
				break;
			case 1:
				id = world.getBlockMetadata(x - 1, y, z);
				break;
			case 2:
				id = world.getBlockMetadata(x, y + 1, z);
				break;
			case 3:
				id = world.getBlockMetadata(x, y - 1, z);
				break;
			case 4:
				id = world.getBlockMetadata(x, y, z + 1);
				break;
			case 5:
				id = world.getBlockMetadata(x, y, z - 1);
				break;
		}
		return id;
	}

	/**
	 * Checks the ID of a block neighboring x, y, z.
	 * 0 = +x, 1 = -x, 2 = +y, 3 = -y, 4 = +z, 5 = -z
	 */
	public static int getID(World world, int x, int y, int z, int dir) {
		int id = 0;
		switch (dir) {
			case 0:
				id = world.getBlockId(x + 1, y, z);
				break;
			case 1:
				id = world.getBlockId(x - 1, y, z);
				break;
			case 2:
				id = world.getBlockId(x, y + 1, z);
				break;
			case 3:
				id = world.getBlockId(x, y - 1, z);
				break;
			case 4:
				id = world.getBlockId(x, y, z + 1);
				break;
			case 5:
				id = world.getBlockId(x, y, z - 1);
				break;
		}
		return id;
	}

	/**
	 * Sets the metadata of a block neighboring x, y, z to "meta."
	 * 0 = +x, 1 = -x, 2 = +y, 3 = -y, 4 = +z, 5 = -z
	 */
	public static void metaSet(World world, int x, int y, int z, int meta, int dir) {
		switch (dir) {
			case 0:
				world.setBlockMetadataWithNotify(x + 1, y, z, meta, 3);
				break;
			case 1:
				world.setBlockMetadataWithNotify(x + 1, y, z, meta, 3);
				break;
			case 2:
				world.setBlockMetadataWithNotify(x, y + 1, z, meta, 3);
				break;
			case 3:
				world.setBlockMetadataWithNotify(x, y - 1, z, meta, 3);
				break;
			case 4:
				world.setBlockMetadataWithNotify(x, y, z + 1, meta, 3);
				break;
			case 5:
				world.setBlockMetadataWithNotify(x, y, z - 1, meta, 3);
				break;
		}
	}

	public static boolean isPoweredDirect(World world, int x, int y, int z) {
		if (world.getBlockPowerInput(x, y, z) > 0)
			return true;
		return false;
	}

	public static boolean isPoweredIndirect(World world, int x, int y, int z) {
		if (world.getBlockPowerInput(x, y, z) > 0)
			return true;
		else if (world.isBlockIndirectlyGettingPowered(x, y, z))
			return true;
		else
			return false;
	}
	
	public static boolean lightCheck(World world, int x, int y, int z, int minimum){
		boolean val = false;
		if(world.getFullBlockLightValue(x - 1, y, z) > minimum)
			val = true;
		else if(world.getFullBlockLightValue(x + 1, y, z) > minimum)
			val = true;
		else if(world.getFullBlockLightValue(x, y - 1, z) > minimum)
			val = true;
		else if(world.getFullBlockLightValue(x, y + 1, z) > minimum)
			val = true;
		else if(world.getFullBlockLightValue(x, y, z - 1) > minimum)
			val = true;
		else if(world.getFullBlockLightValue(x, y, z + 1) > minimum)
			val = true;
		return val;
	}
	
	public static boolean hasItem(EntityPlayer player, int item) {
		int i;
		IInventory inv = player.inventory;
		for(i = 0; i < inv.getSizeInventory(); i++) {
			if (inv.getStackInSlot(i) == null)
				continue;
			if (inv.getStackInSlot(i).getItem().itemID == item + 256)
				return true;
		}
		return false;
	}
	
	public static boolean useItem(EntityPlayer player, int item) {
		if(hasItem(player, item)) {
			int i;
			IInventory inv = player.inventory;
			for(i = 0; i < inv.getSizeInventory(); i++) {
				if (inv.getStackInSlot(i) == null)
					continue;
				if (inv.getStackInSlot(i).getItem().itemID == item + 256) {
					player.inventory.decrStackSize(i, 1);
					return true;
				}
			}
		}
		return false;
	}
	
	public static String textureName(String unLocNam) {
		return Reference.MOD_ID.toLowerCase() + ":" + unLocNam.substring(5);
	}
	
}
