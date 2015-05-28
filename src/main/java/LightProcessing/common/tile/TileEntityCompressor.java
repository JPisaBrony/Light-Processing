package LightProcessing.common.tile;

import LightProcessing.common.block.BlockCompressor;
import LightProcessing.common.lib.*;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCompressor extends TileEntity {

	@Override
	public void updateEntity() {
		if (Methods.isPowered(this.worldObj, this.xCoord, this.yCoord, this.zCoord) && !BlockCompressor.flag1) {
			if (Methods.isPowered(this.worldObj, this.xCoord, this.yCoord, this.zCoord) && !BlockCompressor.flag1) {
				BlockCompressor.compress(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
				BlockCompressor.flag1 = false;
			}
		}
	}
	
}