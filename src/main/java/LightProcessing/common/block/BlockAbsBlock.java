package LightProcessing.common.block;

import java.util.Random;

import LightProcessing.common.lib.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
//import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockAbsBlock extends Block {

	public BlockAbsBlock(Material material) {
		super(material);
		this.setLightLevel(0.5F);
		this.setHardness(10);
		this.setResistance(500000);
		this.setCreativeTab(BlockTab.blockTab);
		this.setBlockName("AbsBlock");
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int x, int y, int z) {
		if (!par1IBlockAccess.isAirBlock(x, y - 1, z) && par1IBlockAccess.getBlock(x, y - 1, z) != LPBlocks.BlockAbsBlock) {
			this.setBlockBounds(0.0F, 0.0001F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		if (par5Entity instanceof EntityPlayer) {
			((EntityPlayer) par5Entity).curePotionEffects(new ItemStack(Items.milk_bucket));
			if (par5Entity.isBurning()) {
				par5Entity.extinguish();
			}
			par5Entity.fallDistance = 0F;
		}
		if (par5Entity instanceof EntityLiving) {
			((EntityLiving) par5Entity).curePotionEffects(new ItemStack(Items.milk_bucket));
			if (par5Entity.isBurning()) {
				par5Entity.extinguish();
			}
			par5Entity.fallDistance = 0.0F;
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		if (par1IBlockAccess.isAirBlock(par2, par3, par4)) {
			return true;
		}
		if (par1IBlockAccess.getBlock(par2, par3, par4) == LPBlocks.BlockAbsBlock) {
			return false;
		}
		if (par1IBlockAccess.isSideSolid(par2, par3, par4, ForgeDirection.UP, true)) {
			return true;
		}
		if (par5 == 0 && par1IBlockAccess.getBlock(par2, par3, par4) != LPBlocks.BlockAbsBlock) {
			return true;
		}
		return false;
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
