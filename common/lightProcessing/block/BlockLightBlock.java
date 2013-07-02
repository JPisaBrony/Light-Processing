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
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockLightBlock extends Block{

	public BlockLightBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setLightValue(1.0F);
		this.setHardness(10);
		this.setResistance(500000);
		this.setCreativeTab(lib.BlockTab.blockTab);
		this.setUnlocalizedName("LightBlock");
	}

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity){
		
		
		//gives night vision
		
		if(par5Entity instanceof EntityLiving){
			((EntityLiving)par5Entity).addPotionEffect(new PotionEffect(Potion.nightVision.getId(),400,50));
		}
		
		
		//cures zombie villagers
		
		if(par5Entity instanceof EntityZombie && ((EntityZombie) par5Entity).isVillager()){
			 EntityVillager entityvillager = new EntityVillager(par5Entity.worldObj);
		        entityvillager.func_82149_j(par5Entity);
		        entityvillager.initCreature();
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
		
		if(lib.Methods.isPowered(par1World, par2, par3, par4)){
			if(Math.abs(par5Entity.motionX) > Math.abs(par5Entity.motionZ) && par5Entity.motionX > 0){
				par5Entity.motionX = par5Entity.motionX + 0.1;
			}
			else if(Math.abs(par5Entity.motionX) > Math.abs(par5Entity.motionZ) && par5Entity.motionX < 0){
				par5Entity.motionX = par5Entity.motionX - 0.1;
			}
			else if(Math.abs(par5Entity.motionX) < Math.abs(par5Entity.motionZ) && par5Entity.motionZ > 0){
				par5Entity.motionZ = par5Entity.motionZ + 0.1;
			}
			else{
				par5Entity.motionZ = par5Entity.motionZ - 0.1;
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
	        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName2());
	    }
}
