package LightProcessing.common.network;

import java.util.EnumSet;

import LightProcessing.common.render.ModelEssenceExtractor;
import LightProcessing.common.render.ModelMachineCore;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ServerTickHandler implements ITickHandler {

	public static boolean twilight = false;
	public static int DS = 0;
	public static int LS = 0;
	
	@SideOnly(Side.CLIENT)
	private void onPlayerTick(EntityPlayer player) {
		//ModelMachineCore.rotate();
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		//if (type.equals(EnumSet.of(TickType.PLAYER))) {
		//	onPlayerTick((EntityPlayer) tickData[0]);
		//}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
