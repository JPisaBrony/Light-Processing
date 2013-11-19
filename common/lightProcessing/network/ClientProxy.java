package LightProcessing.common.lightProcessing.network;

import LightProcessing.common.lib.*;
import LightProcessing.common.lightProcessing.item.*;
import LightProcessing.common.lightProcessing.tile.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{
	
	  public void registerRenderThings() {
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCompressor.class, new TileEntityCompressorRender());
          MinecraftForgeClient.registerItemRenderer(IDRef.COMPRESSOR_ID, new ItemAbsCompRenderer());
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHarvester.class, new TileEntityHarvesterRender());
          MinecraftForgeClient.registerItemRenderer(IDRef.HARVESTER_ID, new ItemHarvesterRenderer());
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDarkGen.class, new TileEntityDarkGenRender());
          MinecraftForgeClient.registerItemRenderer(IDRef.DARK_GEN_ID, new ItemDarkGenRenderer());
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMachineCore.class, new TileEntityMachineCoreRender());
          MinecraftForgeClient.registerItemRenderer(IDRef.MACHINE_CORE_ID, new ItemMachineCoreRenderer());
          ClientRegistry.bindTileEntitySpecialRenderer(TileEntityExtractor.class, new TileEntityExtractorRender());
          MinecraftForgeClient.registerItemRenderer(IDRef.EXTRACTOR_ID, new ItemExtractorRenderer());
  }

	
}

