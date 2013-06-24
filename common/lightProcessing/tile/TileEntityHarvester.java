package lightProcessing.tile;

import net.minecraft.tileentity.TileEntity;

public class TileEntityHarvester extends TileEntity{
	
	public static Float Light;
	
	@Override
    public void updateEntity() {
	
		Light = this.getWorldObj().getLightBrightness(this.xCoord, this.yCoord + 1, this.zCoord);
		
	}
	
	
	

}
