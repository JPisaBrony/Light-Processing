package LightProcessing.common.lightProcessing.tile;

import LightProcessing.common.lib.*;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDarkGen extends TileEntity {

	public void updateEntity() {
		if (this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) == 1) {
			for (int i = -10; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					for (int k = -10; k < 10; k++) {
						if (this.worldObj.isAirBlock(this.xCoord + k, this.yCoord + j, this.zCoord + i)) {
							this.worldObj.setBlock(this.xCoord + k, this.yCoord + j, this.zCoord + i, IDRef.DARK_BLOCK_ID, 2, 2);

						}
					}
				}
			}
		}
	}
	
}