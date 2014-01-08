package LightProcessing.common.lightProcessing.tile;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import LightProcessing.common.lib.ExtractionList;
import LightProcessing.common.lib.Items;
import LightProcessing.resources.mods.ltp.models.ModelExtractor.*;

public class TileEntityExtractor extends TileEntity{
	
	public TileEntityExtractor(){
		animationOffset = System.nanoTime() % 400000;
		flag = true;
	}

	public long animationOffset;
	public boolean flag;
}