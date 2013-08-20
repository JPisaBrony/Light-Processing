package lightProcessing.block;

import java.util.Random;

import lib.IDRef;
import lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLightWood extends Block {

	public BlockLightWood(int par1, Material par2Material) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
		this.setUnlocalizedName("LightWood");
		this.setCreativeTab(lib.BlockTab.blockTab);
		this.setHardness(2.0F);
		this.setStepSound(soundWoodFootstep);
		this.setLightValue(1.0F);
	}
	public Icon blockIcon2;
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
		 int j1 = par9 & 3;
	        byte b0 = 0;

	        switch (par5)
	        {
	            case 0:
	            case 1:
	                b0 = 0;
	                break;
	            case 2:
	            case 3:
	                b0 = 8;
	                break;
	            case 4:
	            case 5:
	                b0 = 4;
	        }

	        return j1 | b0;
    }
	 @Override
	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister iconRegister) {
	        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName2());
	        blockIcon2 = iconRegister.registerIcon("tree_top");
	 }

	 public Icon getIcon(int par1, int par2)
	    {
	        int k = par2 & 12;
	        int l = par2 & 3;
	        return k == 0 && (par1 == 1 || par1 == 0) ? blockIcon2 : (k == 4 && (par1 == 5 || par1 == 4) ? blockIcon2 : (k == 8 && (par1 == 2 || par1 == 3) ? blockIcon2 : this.blockIcon));
	    }

	 
	 /*
	  public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	    {
	 if(par5 == 0 || par5 == 1){
		 return blockIcon2;
	 }
	 else{
		 return blockIcon;
	 }	 
	    }
	    */
	 public int idDropped(int par1, Random par2Random, int par3)
	    {
		 return IDRef.LIGHT_BALL_ID + 256;
	    }
	 
	 public int quantityDropped(Random par1Random)
	    {
		 return par1Random.nextInt(2) + 1;
	    }
	 
	 @Override
	    public boolean canSustainLeaves(World world, int x, int y, int z)
	    {
	        return true;
	    }
	
}
