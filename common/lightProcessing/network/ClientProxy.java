package lightProcessing.network;

import lightProcessing.tiles.TileEntityAbsComp;
import lightProcessing.tiles.TileEntityAbsCompRender;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{
	
	  public void registerRenderThings() {
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAbsComp.class, new TileEntityAbsCompRender());
  }

	
}

