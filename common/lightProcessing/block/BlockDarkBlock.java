package lightProcessing.block;

import lib.Methods;
import lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockDarkBlock extends Block{

	public BlockDarkBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(10);
		this.setResistance(500000);
		this.setLightOpacity(255);
		this.setCreativeTab(lib.BlockTab.blockTab);
		this.setUnlocalizedName("DarkBlock");
	}

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity){
		if(par5Entity instanceof EntityLiving){
			((EntityLiving)par5Entity).addPotionEffect(new PotionEffect(Potion.blindness.getId(),400,50));
		}
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
	        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName2());
	    }
}
