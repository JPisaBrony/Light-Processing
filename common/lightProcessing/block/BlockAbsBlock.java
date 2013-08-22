package LightProcessing.common.lightProcessing.block;

import LightProcessing.common.lib.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAbsBlock extends Block{

	public BlockAbsBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setLightValue(0.5F);
		this.setHardness(10);
		this.setResistance(500000);
		this.setCreativeTab(BlockTab.blockTab);
		this.setUnlocalizedName("AbsBlock");
	}
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity){
		if(par5Entity instanceof EntityLiving){
			((EntityLiving)par5Entity).curePotionEffects(new ItemStack(Item.bucketMilk));
			if(par5Entity.isBurning()){
				par5Entity.extinguish();
			}
			par5Entity.fallDistance = 0.0F;
		}
	}

	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
    	if(par1IBlockAccess.isAirBlock(par2, par3, par4)){
    		return true;
    		}
    	if(par1IBlockAccess.getBlockId(par2, par3, par4) == IDRef.ABS_BLOCK_ID){
    		return false;
    	}
    	if(!par1IBlockAccess.doesBlockHaveSolidTopSurface(par2, par3, par4)){
    	return true;
    	}
    	if(par5 == 0 && par1IBlockAccess.getBlockId(par2, par3, par4) != IDRef.ABS_BLOCK_ID){
    		return true;
    	}
    		return false;
    }
	
	public boolean isOpaqueCube()
	{
	    return false;
	}
	
	@SideOnly(Side.CLIENT)	
	public int getRenderBlockPass()
    {
        return 1;
    }
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	{
	    return null;
	}
	public boolean renderAsNormalBlock()
	{
	    return false;
	}
	
	 @Override
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IconRegister iconRegister) {
	        blockIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	 }
}
