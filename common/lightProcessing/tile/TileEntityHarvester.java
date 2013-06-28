package lightProcessing.tile;

import lightProcessing.block.BlockHarvester;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityHarvester extends TileEntity{

	private java.util.Random r = new java.util.Random();
	
	@Override
	public void updateEntity(){
		 if(r.nextInt(500) == 0)
	        {
	        BlockHarvester.Essence(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
	        }
	}
	
	
	public void Spawn(Float Light2){
		 ItemStack lightStack  = new ItemStack(lib.Items.ItemLightBall, 1);
   	     ItemStack darkStack  = new ItemStack(lib.Items.ItemDarkBall, 1);
   	     ItemStack stack;
   	     if(Light2 > 0.7F){
   	     stack = lightStack;
   	     }
   	     else{
   	    stack = darkStack;
   	     }
		
		EntityItem entityitem;
		entityitem = new EntityItem(this.worldObj, this.xCoord + 0.5, this.yCoord + 0.2, this.zCoord + 0.5, stack);
	
		 entityitem.motionX = 0;
   	     entityitem.motionY = 0;
   	     entityitem.motionZ = 0;
   	     
   	     
   	     
   	     if(!this.worldObj.isRemote){
   	  this.worldObj.spawnEntityInWorld(entityitem);
   	  System.out.println(Light2);
   	     }
		
	}
}

