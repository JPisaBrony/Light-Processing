package lightProcessing.network;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {
	public void registerServerTickHandler()
	{
	 TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
	}
}