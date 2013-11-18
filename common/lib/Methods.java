package LightProcessing.common.lib;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
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
		return false;
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
		return false;
	}

	public static String textureName(String unLocNam) {
		return Reference.MOD_ID.toLowerCase() + ":" + (unLocNam.substring(5));
	}
}
