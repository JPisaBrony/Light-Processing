package LightProcessing.common.lightProcessing.block;
import java.util.Random;


import LightProcessing.common.lib.Methods.*;
import LightProcessing.common.lib.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityWitch;
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
		this.setCreativeTab(LightProcessing.common.lib.BlockTab.blockTab);
		this.setUnlocalizedName("LightBlock");
	}
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4) {
		if(!par1IBlockAccess.isAirBlock(par2, par3 - 1, par4) && par1IBlockAccess.getBlockId(par2, par3 - 1, par4) != IDRef.LIGHT_BLOCK_ID){
			this.setBlockBounds(0.0F, 0.0001F, 0.0F, 1.0F, 1.0F, 1.0F);
			}
	}
	
	public void metaTestSet(World world, int x, int y, int z, int test, int set){
		if(Methods.getMeta(world,x,y,z,0) == test && Methods.getID(world,x,y,z,0) == IDRef.LIGHT_BLOCK_ID){
			Methods.metaSet(world,x,y,z,set,0);
		}
		if(Methods.getMeta(world,x,y,z,1) == test && Methods.getID(world,x,y,z,1) == IDRef.LIGHT_BLOCK_ID){
			Methods.metaSet(world,x,y,z,set,1);
		}
		if(Methods.getMeta(world,x,y,z,4) == test && Methods.getID(world,x,y,z,4) == IDRef.LIGHT_BLOCK_ID){
			Methods.metaSet(world,x,y,z,set,4);
		}
		if(Methods.getMeta(world,x,y,z,5) == test && Methods.getID(world,x,y,z,5) == IDRef.LIGHT_BLOCK_ID){
			Methods.metaSet(world,x,y,z,set,5);
		}
	}
	public boolean metaTest(World world, int x, int y, int z, int test){
		if(Methods.getMeta(world,x,y,z,0) == test && Methods.getID(world,x,y,z,0) == IDRef.LIGHT_BLOCK_ID){
			return true;
		}
		if(Methods.getMeta(world,x,y,z,1) == test && Methods.getID(world,x,y,z,1) == IDRef.LIGHT_BLOCK_ID){
			return true;
		}
		if(Methods.getMeta(world,x,y,z,4) == test && Methods.getID(world,x,y,z,4) == IDRef.LIGHT_BLOCK_ID){
			return true;
		}
		if(Methods.getMeta(world,x,y,z,5) == test && Methods.getID(world,x,y,z,5) == IDRef.LIGHT_BLOCK_ID){
			return true;
		}
		return false;
	}
	@SideOnly(Side.CLIENT)
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
		if(par1World.getBlockId(par2, par3 - 1, par4) == 3){
			par1World.setBlock(par2, par3 - 1, par4, 2);
		}
		par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
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
		super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
       	float f1 = (float)par2 + 0.5F;
		float f2 = (float)par3 + 1.1F;
		float f3 = (float)par4 + 0.5F; 
		float f4 = par5Random.nextFloat() * 0.6F -0.3F;
		float f5 = par5Random.nextFloat() * -0.6F - -0.3F;
	spread(par1World,par2,par3,par4);
	if(par1World.getBlockMetadata(par2, par3, par4) > 0 && par1World.isAirBlock(par2, par3 + 1, par4)){
		par1World.spawnParticle("instantSpell", (double)f1 +  f4, (double)f2, (double)f3 + f5, 0.0D, 0.0D, 0.0D);
	}
		}
			
		
	

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity){
		
		
		//gives night vision
		
		if(par5Entity instanceof EntityLiving){
			((EntityLiving)par5Entity).addPotionEffect(new PotionEffect(Potion.nightVision.getId(),400,50));
			//((EntityLiving)par5Entity).addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(),400,50));
		}
		if(par5Entity instanceof EntityPlayer){
			((EntityPlayer)par5Entity).addPotionEffect(new PotionEffect(Potion.nightVision.getId(),400,50));
		}
		
		
		//cures zombie villagers
		
		if(par5Entity instanceof EntityZombie && ((EntityZombie) par5Entity).isVillager()){
			EntityVillager entityvillager = new EntityVillager(par5Entity.worldObj);
	        entityvillager.copyLocationAndAnglesFrom(par5Entity);
	        entityvillager.func_110161_a((EntityLivingData)null);
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
			par5Entity.attackEntityFrom(DamageSource.magic, 5);
			par5Entity.setFire(5);
		}
		
		//Light Motion (Horizontal)
		
		if(par1World.getBlockMetadata(par2, par3, par4) > 0){
			
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
	@SideOnly(Side.CLIENT)
	public void spread(World world, int x, int y, int z){
		 int thisMeta = world.getBlockMetadata(x, y, z);
		 if(Methods.isPowered(world, x, y, z) && thisMeta == 0){
				world.setBlockMetadataWithNotify(x, y, z, 1, 3);
				metaTestSet(world,x,y,z,0,2);
				
			}
			if(!Methods.isPowered(world, x, y, z) && thisMeta == 1)
			{
				world.setBlockMetadataWithNotify(x, y, z, 0, 3);	
			}
			if(thisMeta == 2){
				metaTestSet(world,x,y,z,0,3);
				if(!metaTest(world,x,y,z,1)){
					metaTestSet(world,x,y,z,3,4);
					world.setBlockMetadataWithNotify(x, y, z, 0, 3);
				}
			}
			if(thisMeta == 3){
				metaTestSet(world,x,y,z,0,3);
			}
			if(thisMeta == 4){
				if(!metaTest(world,x,y,z,1)){
					metaTestSet(world,x,y,z,3,4);
					world.setBlockMetadataWithNotify(x, y, z, 0, 3);
				}
			}
	}
	
	@SideOnly(Side.CLIENT)
	 public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		 spread(par1World,par2,par3,par4);
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
