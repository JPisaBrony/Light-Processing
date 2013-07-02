package lightProcessing.block;

import java.util.Random;

import lib.Reference;
import lib.IDRef;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDarkGen extends Block{

	public BlockDarkGen(int par1, Material par2Material) {
		super(par1, Material.grass);
		this.setHardness(10);
		this.setResistance(500000);
		this.setTickRandomly(true);
		this.setCreativeTab(lib.BlockTab.blockTab);
		this.setUnlocalizedName("BlockDarkGen");
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
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4){
		darkgenID theid = new darkgenID();
			if(theid.getID() > 0){
				this.onNeighborBlockChange(par1World, par2, par3, par4, 3001);
				System.out.println("block changed!");
			}
		}
	
	
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName2());
    }
    
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    if (!par1World.isRemote){

    	int ID = 1;
    	int ID2 = 3001;
    	for(int i = -10; i < 10; i++) {
    		for(int j = -10; j < 10; j++) {
    			for(int k = -10; k < 10; k++){
    				if(par1World.isAirBlock(par2+k, par3+j, par4+i)){
    					par1World.setBlock(par2+k, par3+j, par4+i, ID2);
    				}
    			}
    		}
    	}
    	System.out.println("active");
        }
	return false;
    }
    
}

class darkgenID {
	private int id;
	
	public darkgenID() {
		id = 1;
	}
	
	public int getID() {
		return id;
	}
	
}