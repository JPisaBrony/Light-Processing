package LightProcessing.common.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import LightProcessing.common.lightProcessing.tile.*;

public class Tiles {
public static void registerTiles(){
	GameRegistry.registerTileEntity(TileEntityHarvester.class, "Harvester");
	GameRegistry.registerTileEntity(TileEntityAbsComp.class, "Abs Comp");
	GameRegistry.registerTileEntity(lightProcessing.tile.TileEntityDarkGen.class, "Dark Gen");
	}
}