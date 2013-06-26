package lightProcessing.tile;

import lightProcessing.block.BlockAbsComp;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAbsComp extends TileEntity
{
	@Override
	public void updateEntity(){
		
if(this.worldObj.getBlockPowerInput(this.xCoord, this.yCoord, this.zCoord) > 0){
BlockAbsComp.compress(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
}
	}
}