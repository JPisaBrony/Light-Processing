package lightProcessing.tile;

import lightProcessing.block.BlockAbsComp;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAbsComp extends TileEntity
{
	
	
	@Override
	public void updateEntity(){
		if(lib.Methods.isPowered(this.worldObj, this.xCoord, this.yCoord, this.zCoord) && !lightProcessing.block.BlockAbsComp.flag1){
			BlockAbsComp.compress(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}
		else{
			lightProcessing.block.BlockAbsComp.flag1 = false;
		}
	}
	
	
}