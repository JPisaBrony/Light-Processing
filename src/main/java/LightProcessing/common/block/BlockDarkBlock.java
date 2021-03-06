package LightProcessing.common.block;

import java.util.Random;

import LightProcessing.common.lib.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockDarkBlock extends Block {

	public boolean coll = true;

	public BlockDarkBlock(Material material) {
		super(material);
		this.setHardness(10);
		this.setResistance(500000);
		this.setLightOpacity(255);
		this.setCreativeTab(BlockTab.blockTab);
		this.setBlockName("DarkBlock");
	}

	public boolean canProvidePower() {
		return true;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		if (!par1IBlockAccess.isAirBlock(par2, par3 - 1, par4) && par1IBlockAccess.getBlock(par2, par3 - 1, par4) != LPBlocks.BlockDarkBlock) {
			this.setBlockBounds(0.0F, 0.0001F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	public boolean isCollidable() {
		return coll;
	}

	public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		if (par1IBlockAccess.getBlockMetadata(par2, par3, par4) == 1) {

			switch (par5) {
			case 0: {
				return 15;
			}
			default:
				return 0;
			}
		}
		else {
			return 0;
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		if (par1IBlockAccess.isAirBlock(par2, par3, par4)) {
			return true;
		}
		if (par1IBlockAccess.getBlock(par2, par3, par4) == LPBlocks.BlockDarkBlock) {
			return false;
		}
		if (par1IBlockAccess.isSideSolid(par2, par3, par4, ForgeDirection.UP, true)) {
			return true;
		}
		if (par5 == 0 && par1IBlockAccess.getBlock(par2, par3, par4) != LPBlocks.BlockDarkBlock) {
			return true;
		}
		return false;
	}

	public boolean isBlockReplaceable(World world, int x, int y, int z) {
		if (world.getBlockMetadata(x, y, z) == 2) {
			return true;
		}
		return false;
	}

	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		if (par1World.getBlockMetadata(par2, par3, par4) == 2) {
			coll = false;
		}
		else {
			coll = true;
		}
		if (par1World.getBlock(par2, par3 - 1, par4) == Blocks.grass) {
			par1World.setBlock(par2, par3 - 1, par4, Blocks.dirt);
		}

		return par9;
	}

	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {

		if (par1World.getBlockMetadata(par2, par3, par4) == 2) {
			coll = false;
		}
		else {
			coll = true;
		}

		if (par1World.getBlock(par2, par3 - 1, par4) == Blocks.grass) {
			par1World.setBlock(par2, par3 - 1, par4, Blocks.dirt);
		}
		if (Methods.isPowered(par1World, par2, par3, par4) && par1World.getBlockMetadata(par2, par3, par4) == 0) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 3);
		}
		if (!Methods.isPowered(par1World, par2, par3, par4) && par1World.getBlockMetadata(par2, par3, par4) == 1) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
		}
	}

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		
		if (par5Entity instanceof net.minecraft.entity.item.EntityItem && par1World.getBlockMetadata(par2, par3, par4) < 2){
			if(((net.minecraft.entity.item.EntityItem) par5Entity).getEntityItem().getItem() == Items.bucket && !par1World.isRemote){
				ItemStack DarkBucket = new ItemStack(LPItems.ItemDarkBucketEmpty);
				EntityItem DBucketI = new EntityItem(par1World,par5Entity.posX, par5Entity.posY, par5Entity.posZ, DarkBucket);
				DBucketI.motionX = par5Entity.motionX;
				DBucketI.motionY = par5Entity.motionY;
				DBucketI.motionZ = par5Entity.motionZ;
				par1World.removeEntity(par5Entity);
				DBucketI.delayBeforeCanPickup = 25;
				par1World.spawnEntityInWorld(DBucketI);
				par1World.setBlockToAir(par2, par3, par4);
			}
		}
		
		if (par5Entity instanceof EntityPlayer && par1World.getBlockMetadata(par2, par3, par4) < 2) {
			((EntityPlayer) par5Entity).addPotionEffect(new PotionEffect(Potion.blindness.getId(), 400, 50));
		}
		if (par5Entity instanceof EntityLiving && par1World.getBlockMetadata(par2, par3, par4) < 2) {
			((EntityLiving) par5Entity).addPotionEffect(new PotionEffect(Potion.blindness.getId(), 400, 50));
		}
		if (par1World.getBlockMetadata(par2, par3, par4) == 1) {
			if (par5Entity.motionY > 1.0 && par5Entity instanceof net.minecraft.entity.item.EntityItem) {
				par5Entity.motionY = 1.0;
			}
			if (par5Entity.motionY < 0.1) {
				par5Entity.motionY = par5Entity.motionY + 0.1;
			}
			else {
				par5Entity.motionY = par5Entity.motionY + 0.05;
			}
		}
	}

	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {

		if (par1World.getBlockMetadata(par2, par3, par4) == 2) {
			coll = false;
		}
		else {
			coll = true;
		}

		if (Methods.isPowered(par1World, par2, par3, par4) && par1World.getBlockMetadata(par2, par3, par4) == 0) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 3);
		}
		if (!Methods.isPowered(par1World, par2, par3, par4) && par1World.getBlockMetadata(par2, par3, par4) == 1) {
			par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 3);
		}
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		return null;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}
}
