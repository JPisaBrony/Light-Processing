package lightProcessing.block;

import java.util.Random;

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
public boolean coll = true;
	
	 public boolean canProvidePower()
	 	{
	        return true;
	    }
	 
	 public boolean isCollidable()
	    {
	        return coll;
	    }

	    public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	    {
	    	if(par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 1){
	    
	    	switch(par5){
	    	case 0:
	    	{
	    		return 15;
	    	}
	    	default: return 0;
	    	}
	    	}
	    	else{
	    		return 0;
	    	}
	    }
	

	    @SideOnly(Side.CLIENT)
	    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	    {
	    	if(par1IBlockAccess.isAirBlock(par2, par3, par4)){
	    		return true;
	    		}
	    	if(par1IBlockAccess.getBlockId(par2, par3, par4) == IDRef.DARK_BLOCK_ID){
	    		return false;
	    	}
	    	if(!par1IBlockAccess.doesBlockHaveSolidTopSurface(par2, par3, par4)){
	    	return true;
	    	}
	    	if(par5 == 0 && par1IBlockAccess.getBlockId(par2, par3, par4) != IDRef.DARK_BLOCK_ID){
	    		return true;
	    	}
	    		return false;
	    }
	    
	    
	    public boolean isBlockReplaceable(World world, int x, int y, int z)
	    {
	    	if(world.getBlockMetadata(x, y, z) == 2){
	    		return true;
	    	}
	    	return false;
	    }
	    
	    
	    
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
		if(par1World.getBlockMetadata(par2, par3, par4) == 2){
			coll = false;
		}
		else{
			coll = true;
		}
		
		if(par1World.getBlockId(par2, par3 - 1, par4) == 2){
			
			par1World.setBlock(par2, par3 - 1, par4, 3);
		}
		
        return par9;
    }
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		
		if(par1World.getBlockMetadata(par2, par3, par4) == 2){
			coll = false;
		}
		else{
			coll = true;
		}
		
		if(par1World.getBlockId(par2, par3 - 1, par4) == 2){
			par1World.setBlock(par2, par3 - 1, par4, 3);
		}
		if(lib.Methods.isPowered(par1World, par2, par3, par4) && par1World.getBlockMetadata(par2, par3, par4) == 0){
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 3);
		}
		if(!lib.Methods.isPowered(par1World, par2, par3, par4) && par1World.getBlockMetadata(par2, par3, par4) == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
		}
	}
	
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity){
		if(par5Entity instanceof EntityLiving && par1World.getBlockMetadata(par2, par3, par4) != 2){
			((EntityLiving)par5Entity).addPotionEffect(new PotionEffect(Potion.blindness.getId(),400,50));
		}
		if(par1World.getBlockMetadata(par2, par3, par4) == 1){
		if(par5Entity.motionY > 1.0 && par5Entity instanceof net.minecraft.entity.item.EntityItem){
			par5Entity.motionY = 1.0;
		}
		if(par5Entity.motionY < 0.1){
			par5Entity.motionY = par5Entity.motionY + 0.1;
		}
		else{
		par5Entity.motionY = par5Entity.motionY + 0.05;
		}
		}
	}
	
	 public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		 
		 if(par1World.getBlockMetadata(par2, par3, par4) == 2){
				coll = false;
			}
			else{
				coll = true;
			}
		 
		 if(lib.Methods.isPowered(par1World, par2, par3, par4) && par1World.getBlockMetadata(par2, par3, par4) == 0){
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 3);
		}
		if(!lib.Methods.isPowered(par1World, par2, par3, par4) && par1World.getBlockMetadata(par2, par3, par4) == 1)
		{
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
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
