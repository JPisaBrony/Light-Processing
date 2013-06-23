package lightProcessing.network;

import lightProcessing.item.ItemAbsCompRenderer;
import lightProcessing.tiles.TileEntityAbsComp;
import lightProcessing.tiles.TileEntityAbsCompRender;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{
	
	  public void registerRenderThings() {
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAbsComp.class, new TileEntityAbsCompRender());
          MinecraftForgeClient.registerItemRenderer(lib.IDRef.ABS_COMP_ID, new ItemAbsCompRenderer());
  }

	
}

