package LightProcessing.common.lightProcessing.tile;

import net.minecraft.tileentity.TileEntity;
import LightProcessing.resources.mods.ltp.models.ModelExtractor.*;

public class TileEntityExtractor extends TileEntity{
	
	public TileEntityExtractor(){
		animationOffset = System.nanoTime() % 400000;
	}

	long animationOffset;
}