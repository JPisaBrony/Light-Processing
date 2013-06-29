package lib;

import cpw.mods.fml.common.registry.GameRegistry;

public class Tiles {
public static void registerTiles(){
	GameRegistry.registerTileEntity(lightProcessing.tile.TileEntityHarvester.class, "Harvester");
	GameRegistry.registerTileEntity(lightProcessing.tile.TileEntityAbsComp.class, "Abs Comp");
}
}
