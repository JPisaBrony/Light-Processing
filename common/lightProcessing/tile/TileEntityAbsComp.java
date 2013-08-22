package LightProcessing.common.lightProcessing.tile;

import LightProcessing.common.lib.*;
import LightProcessing.common.lightProcessing.block.BlockAbsComp;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAbsComp extends TileEntity
{
	
	
	@Override
	public void updateEntity(){
		if(Methods.isPowered(this.worldObj, this.xCoord, this.yCoord, this.zCoord) && !BlockAbsComp.flag1){
			BlockAbsComp.compress(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}
		else{
			BlockAbsComp.flag1 = false;
		}
	}
	
	
}