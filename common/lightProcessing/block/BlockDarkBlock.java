package lightProcessing.block;

import lib.IDRef;
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
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class BlockDarkBlock extends Block{

	public BlockDarkBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(10);
		this.setResistance(500000);
		this.setLightOpacity(255);
		this.setCreativeTab(lib.BlockTab.blockTab);
		this.setUnlocalizedName("DarkBlock");
	}

	public int power = 0;
	
	/*
	@Override
	public boolean canProvidePower()
	{
		return true;
	}
	*/
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity){
		if(par5Entity instanceof EntityLiving){
			((EntityLiving)par5Entity).addPotionEffect(new PotionEffect(Potion.blindness.getId(),400,50));
		}
		
		/*
		if(lib.Methods.isPowered(par1World, par2, par3, par4)){
			if(par1World.getBlockId(par2, par3 + 1, par4) == IDRef.DARK_BLOCK_ID){
				power = 1;
			}
			if(par5Entity.motionY < 0.08){
				par5Entity.motionY = 0.08;
			}
			par5Entity.motionY = par5Entity.motionY + 0.08;
		}
		else{
			power = 0;
		}
		*/
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
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4){
		power = 0;
	}
	
	 public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		 if(!lib.Methods.isPowered(par1World, par2, par3, par4)){
			 power = 0;
		 }
	 }
	
	 public int isProvidingStrongPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5){
		 
		 if(par5 == 0){
		 return power;
		 }
		 else{
			 return 0;
		 }
	    }
	
	 @Override
	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister iconRegister) {
	        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName2());
	    }
}
