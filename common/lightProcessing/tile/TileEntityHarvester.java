package lightProcessing.tile;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityHarvester extends TileEntity{

 
	public void Spawn(Float Light2){
		 ItemStack lightStack  = new ItemStack(lib.Items.ItemLightBall, 1);
   	     ItemStack darkStack  = new ItemStack(lib.Items.ItemDarkBall, 1);
   	     ItemStack stack;
   	     if(Light2 > 0.8F){
   	     stack = lightStack;
   	     }
   	     else{
   	    stack = darkStack;
   	     }
		
		EntityItem entityitem;
		entityitem = new EntityItem(this.worldObj, this.xCoord + 0.5, this.yCoord + 1.5, this.zCoord + 0.5, stack);
	
		 entityitem.motionX = 0;
   	     entityitem.motionY = 0;
   	     entityitem.motionZ = 0;
   	     
   	     
   	     
   	     if(!this.worldObj.isRemote){
   	  this.worldObj.spawnEntityInWorld(entityitem);
   	  System.out.println(Light2);
   	     }
		
	}
}
