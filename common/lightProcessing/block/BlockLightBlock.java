package LightProcessing.common.lightProcessing.block;

import java.util.Random;

import LightProcessing.common.lib.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLightBlock extends Block{

	public BlockLightBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setLightValue(1.0F);
		this.setHardness(10);
		this.setResistance(500000);
		this.setCreativeTab(BlockTab.blockTab);
		this.setUnlocalizedName("LightBlock");
	}
	
	private java.util.Random r = new java.util.Random();
	
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
		if(par1World.getBlockId(par2, par3 - 1, par4) == 3){
			par1World.setBlock(par2, par3 - 1, par4, 2);
		}
		
        return par9;
    }
	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
    	if(par1IBlockAccess.isAirBlock(par2, par3, par4)){
    		return true;
    		}
    	if(par1IBlockAccess.getBlockId(par2, par3, par4) == IDRef.LIGHT_BLOCK_ID){
    		return false;
    	}
    	if(!par1IBlockAccess.doesBlockHaveSolidTopSurface(par2, par3, par4)){
    	return true;
    	}
    	if(par5 == 0 && par1IBlockAccess.getBlockId(par2, par3, par4) != IDRef.LIGHT_BLOCK_ID){
    		return true;
    	}
    		return false;
    }
	
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		
		int randgrass = 0;
		if(par1World.getBlockId(par2, par3 - 1, par4) == 3){
			par1World.setBlock(par2, par3 - 1, par4, 2);
		}
		  if (!par1World.isRemote)
	        {
	        	randgrass = r.nextInt(8);
	        }
		  switch(randgrass){
		  case 0:	
      	{
      		if(par1World.getBlockId(par2 - 1, par3 - 1, par4) == 3){
    			par1World.setBlock(par2 - 1, par3 - 1, par4, 2);
    			break;
      		}
      	}
      	 case 1:	
       	{
       		if(par1World.getBlockId(par2 + 1, par3 - 1, par4) == 3){
     			par1World.setBlock(par2 + 1, par3 - 1, par4, 2);
     			break;
     		}
      	}
      	 case 2:	
        	{
        		if(par1World.getBlockId(par2, par3 - 1, par4 - 1) == 3){
      			par1World.setBlock(par2, par3 - 1, par4 - 1, 2);
      			break;
      		}
       	}
      	case 3:	
    	{
    		if(par1World.getBlockId(par2, par3 - 1, par4 + 1) == 3){
  			par1World.setBlock(par2, par3 - 1, par4 + 1, 2);
  			break;
  		}
   	}
      	case 4:	
    	{
    		if(par1World.getBlockId(par2 - 1, par3 - 1, par4 - 1) == 3){
  			par1World.setBlock(par2 - 1, par3 - 1, par4 - 1, 2);
  			break;
  		}
   	}
      	case 5:	
    	{
    		if(par1World.getBlockId(par2 - 1, par3 - 1, par4 + 1) == 3){
  			par1World.setBlock(par2 - 1, par3 - 1, par4 + 1, 2);
  			break;
  		}
   	}
      	case 6:	
    	{
    		if(par1World.getBlockId(par2 + 1, par3 - 1, par4 - 1) == 3){
  			par1World.setBlock(par2 + 1, par3 - 1, par4 - 1, 2);
  			break;
  		}
    	}
    	case 7:	
    	{
    		if(par1World.getBlockId(par2 + 1, par3 - 1, par4 + 1) == 3){
  			par1World.setBlock(par2 + 1, par3 - 1, par4 + 1, 2);
  			break;
  		}
   	}
   	}
		  }
			
		
	

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity){
		
		
		//gives night vision
		
		if(par5Entity instanceof EntityLiving){
			((EntityLiving)par5Entity).addPotionEffect(new PotionEffect(Potion.nightVision.getId(),400,50));
		}
		
		
		//cures zombie villagers
		
		if(par5Entity instanceof EntityZombie && ((EntityZombie) par5Entity).isVillager()){
			 EntityVillager entityvillager = new EntityVillager(par5Entity.worldObj);
		        entityvillager.func_85031_j(par5Entity);
		        entityvillager.func_82187_q();

		        if (((EntityZombie) par5Entity).isChild())
		        {
		            entityvillager.setGrowingAge(-24000);
		        }

		        par5Entity.worldObj.removeEntity(par5Entity);
		        if(!par1World.isRemote){
		        par5Entity.worldObj.spawnEntityInWorld(entityvillager);
		        }
		        entityvillager.addPotionEffect(new PotionEffect(Potion.confusion.id, 200, 0));
		        par5Entity.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1017, (int)par5Entity.posX, (int)par5Entity.posY, (int)par5Entity.posZ, 0);
		}
		
		//sets hostile mobs on fire
		
		if(par5Entity.isCreatureType(EnumCreatureType.monster, true)){
		par5Entity.setFire(5);
		}
		
		//Light Motion (Horizontal)
		
		if(Methods.isPowered(par1World, par2, par3, par4)){
			
			if(par5Entity.motionX > 1.0 && par5Entity instanceof net.minecraft.entity.item.EntityItem){
				par5Entity.motionX = 1.0;
			}
			if(par5Entity.motionX < -1.0 && par5Entity instanceof net.minecraft.entity.item.EntityItem){
				par5Entity.motionX = -1.0;
			}
			if(par5Entity.motionZ > 1.0 && par5Entity instanceof net.minecraft.entity.item.EntityItem){
				par5Entity.motionZ = 1.0;
			}
			if(par5Entity.motionZ < -1.0 && par5Entity instanceof net.minecraft.entity.item.EntityItem){
				par5Entity.motionZ = -1.0;
			}
			
			boolean xpos = (par1World.doesBlockHaveSolidTopSurface(par2 + 1, par3, par4));
			boolean xneg = (par1World.doesBlockHaveSolidTopSurface(par2 - 1, par3, par4));
			boolean zpos = (par1World.doesBlockHaveSolidTopSurface(par2, par3, par4 + 1));
			boolean zneg = (par1World.doesBlockHaveSolidTopSurface(par2, par3, par4 - 1));
			double speed = 0.2;
			double cSpeed = 0.25;
			
			if(xpos && zpos && zneg && !xneg){
				par5Entity.motionX = -speed;
			}
			else if(xneg && zpos && zneg && !xpos){
				par5Entity.motionX = speed;
			}
			else if(zpos && xpos && xneg && !zneg){
				par5Entity.motionZ = -speed;
			}
			
			else if(zneg && xpos && xneg && !zpos){
				par5Entity.motionZ = speed;
			}
			
			else if(xpos && zpos){
				if(par5Entity instanceof net.minecraft.entity.item.EntityItem){
					par5Entity.motionY = 0;
				}
				
				if(Math.abs(par5Entity.motionX) > Math.abs(par5Entity.motionZ) && par5Entity.motionX > 0){
					par5Entity.motionX = cSpeed;
					par5Entity.motionZ = -speed;
				}
				else if(Math.abs(par5Entity.motionZ) > Math.abs(par5Entity.motionX) && par5Entity.motionZ > 0){
					par5Entity.motionX = -speed;
					par5Entity.motionZ = cSpeed;
				}
				
			}
			else if(xneg && zneg){
				if(par5Entity instanceof net.minecraft.entity.item.EntityItem){
					par5Entity.motionY = 0;
				}
				if(Math.abs(par5Entity.motionX) > Math.abs(par5Entity.motionZ) && par5Entity.motionX < 0){
					par5Entity.motionX = -cSpeed;
					par5Entity.motionZ = speed;
				}
				else if(Math.abs(par5Entity.motionZ) > Math.abs(par5Entity.motionX) && par5Entity.motionZ < 0){
					par5Entity.motionX = speed;
					par5Entity.motionZ = -cSpeed;
				}
			}
			else if(xpos && zneg){
				if(par5Entity instanceof net.minecraft.entity.item.EntityItem){
					par5Entity.motionY = 0;
				}
				if(Math.abs(par5Entity.motionX) > Math.abs(par5Entity.motionZ) && par5Entity.motionX > 0){
					par5Entity.motionX = cSpeed;
					par5Entity.motionZ = speed;
				}
				else if(Math.abs(par5Entity.motionZ) > Math.abs(par5Entity.motionX) && par5Entity.motionZ < 0){
					par5Entity.motionX = -speed;
					par5Entity.motionZ = -cSpeed;
				}
			}
			else if(xneg && zpos){
				if(par5Entity instanceof net.minecraft.entity.item.EntityItem){
					par5Entity.motionY = 0;
				}
				if(Math.abs(par5Entity.motionX) > Math.abs(par5Entity.motionZ) && par5Entity.motionX < 0){
					par5Entity.motionX = -cSpeed;
					par5Entity.motionZ = -speed;
				}
				else if(Math.abs(par5Entity.motionZ) > Math.abs(par5Entity.motionX) && par5Entity.motionZ > 0){
					par5Entity.motionX = speed;
					par5Entity.motionZ = cSpeed;
				}
			}
			
			else if(Math.abs(par5Entity.motionX) > Math.abs(par5Entity.motionZ) && par5Entity.motionX > 0){
				par5Entity.motionX = par5Entity.motionX + speed;
			}
			else if(Math.abs(par5Entity.motionX) > Math.abs(par5Entity.motionZ) && par5Entity.motionX < 0){
				par5Entity.motionX = par5Entity.motionX - speed;
			}
			else if(Math.abs(par5Entity.motionX) < Math.abs(par5Entity.motionZ) && par5Entity.motionZ > 0){
				par5Entity.motionZ = par5Entity.motionZ + speed;
			}
			else if(Math.abs(par5Entity.motionX) < Math.abs(par5Entity.motionZ) && par5Entity.motionZ < 0){
				par5Entity.motionZ = par5Entity.motionZ - speed;
			}
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
		blockIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}
	
}
