package LightProcessing.common.tile;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import LightProcessing.common.lib.ExtractionList;
import LightProcessing.common.lib.LPItems;

public class TileEntityEssenceExtractor extends TileEntity {

	public long animationOffset;
	public boolean flag;

	public TileEntityEssenceExtractor() {
		animationOffset = System.nanoTime() % 400000;
		flag = true;
	}

}