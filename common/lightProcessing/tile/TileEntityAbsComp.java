package lightProcessing.tile;

import lightProcessing.block.BlockAbsComp;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAbsComp extends TileEntity
{
	
	
	@Override
	public void updateEntity(){
		if(lib.Methods.isPowered(this.worldObj, this.xCoord, this.yCoord, this.zCoord)){
			BlockAbsComp.compress(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}
	}
	
	
}