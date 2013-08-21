package lightProcessing.network;

import lightProcessing.item.ItemAbsCompRenderer;
import lightProcessing.item.ItemDarkGenRenderer;
import lightProcessing.item.ItemHarvesterRenderer;
import lightProcessing.tile.TileEntityAbsComp;
import lightProcessing.tile.TileEntityAbsCompRender;
import lightProcessing.tile.TileEntityDarkGen;
import lightProcessing.tile.TileEntityDarkGenRender;
import lightProcessing.tile.TileEntityHarvester;
import lightProcessing.tile.TileEntityHarvesterRender;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{
	
	  public void registerRenderThings() {
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAbsComp.class, new TileEntityAbsCompRender());
          MinecraftForgeClient.registerItemRenderer(lib.IDRef.ABS_COMP_ID, new ItemAbsCompRenderer());
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHarvester.class, new TileEntityHarvesterRender());
          MinecraftForgeClient.registerItemRenderer(lib.IDRef.HARVESTER_ID, new ItemHarvesterRenderer());
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDarkGen.class, new TileEntityDarkGenRender());
          MinecraftForgeClient.registerItemRenderer(lib.IDRef.DARK_GEN_ID, new ItemDarkGenRenderer());
  }

	
}

