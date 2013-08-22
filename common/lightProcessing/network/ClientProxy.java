package LightProcessing.common.lightProcessing.network;

import LightProcessing.common.lib.*;
import LightProcessing.common.lightProcessing.item.*;
import LightProcessing.common.lightProcessing.tile.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{
	
	  public void registerRenderThings() {
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAbsComp.class, new TileEntityAbsCompRender());
          MinecraftForgeClient.registerItemRenderer(IDRef.ABS_COMP_ID, new ItemAbsCompRenderer());
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHarvester.class, new TileEntityHarvesterRender());
          MinecraftForgeClient.registerItemRenderer(IDRef.HARVESTER_ID, new ItemHarvesterRenderer());
  }

	
}

