package LightProcessing.common.tile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import LightProcessing.common.block.*;
import LightProcessing.common.lib.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class TileEntityHarvester extends TileEntity {

	private java.util.Random r = new java.util.Random();
	private int chance;

	@Override
	public void updateEntity() {
		chance = 2000;
		if (this.worldObj.getBlockId(this.xCoord, this.yCoord + 1, this.zCoord) == IDRef.LIGHT_BLOCK_ID || this.worldObj.getBlockId(this.xCoord, this.yCoord + 1, this.zCoord) == IDRef.DARK_BLOCK_ID) {
			chance /= 2;
		}
		if (r.nextInt(chance) == 0) {
			BlockHarvester.Essence(this.worldObj, this.xCoord, this.yCoord, this.zCoord);
		}
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		AxisAlignedBB bb = INFINITE_EXTENT_AABB;
		bb = AxisAlignedBB.getAABBPool().getAABB(xCoord - 1, yCoord, zCoord - 1, xCoord + 2, yCoord + 2, zCoord + 2);
		return bb;
	}

	public void Spawn(Float LightValue, boolean isAbove) {
		ItemStack stack;
		
		if (LightValue > 0.7F) {
			stack = new ItemStack(Items.ItemLightBall, 1);
		}
		else {
			stack = new ItemStack(Items.ItemDarkBall, 1);
		}
		EntityItem entityitem;
		
		if(isAbove)
			entityitem = new EntityItem(this.worldObj, this.xCoord + 0.5, this.yCoord + 1.0, this.zCoord + 0.5, stack);
		else
			entityitem = new EntityItem(this.worldObj, this.xCoord + 0.5, this.yCoord + 0.2, this.zCoord + 0.5, stack);
		
		entityitem.motionX = 0;
		entityitem.motionY = 0;
		entityitem.motionZ = 0;

		if (!this.worldObj.isRemote) {
			if (!Methods.isPoweredIndirect(this.worldObj, this.xCoord, this.yCoord, this.zCoord)) {
				this.worldObj.spawnEntityInWorld(entityitem);
			}
		}

	}
	
}
