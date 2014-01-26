package LightProcessing.common.lightProcessing.block;

import java.util.List;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import LightProcessing.common.lib.*;
import LightProcessing.common.lightProcessing.tile.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockExtractor extends Block {

	public BlockExtractor(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(10);
		this.setCreativeTab(BlockTab.blockTab);
		this.setUnlocalizedName("Extractor");
	}

	@Override
	public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side) {
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
		if (entity == null) {
			return;
		}

		TileEntityExtractor tile = (TileEntityExtractor) world.getBlockTileEntity(x, y, z);
		if (!world.isRemote) {
			world.setBlockMetadataWithNotify(x, y, z, MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3, 3);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return new TileEntityExtractor();
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {

		if (par5EntityPlayer.getCurrentEquippedItem() == null) {
			if (!par1World.isRemote) {
				int meta = par1World.getBlockMetadata(par2, par3, par4);
				if (meta < 4) {
					meta += 4;
				}
				else {
					meta -= 4;
				}
				par1World.setBlockMetadataWithNotify(par2, par3, par4, meta, 3);
			}
		}
		return false;
	}

	public static void extract(World world, int x, int y, int z) {
		int stack = ExtractionList.getEssence(world, x, y + 1, z);
		double posx = 0;
		double posz = 0;
		double velx = 0;
		double velz = 0;

		switch (world.getBlockMetadata(x, y, z))
			{
			case 0:
			case 4: {
				posx = x + 0.5;
				posz = z - 0.6;
				velz = -1;
				velx = 0;
			}
				;
				break;
			case 1:
			case 5: {
				posx = x + 1.5;
				posz = z + 0.5;
				velx = 1;
				velz = 0;
			}
				;
				break;
			case 2:
			case 6: {
				posx = x + 0.5;
				posz = z + 1.5;
				velz = 1;
				velx = 0;
			}
				break;
			case 3:
			case 7: {
				posx = x - 0.6;
				posz = z + 0.5;
				velx = -1;
				velz = 0;
			}
				break;

			}

		EntityItem OutputItem = null;
		ItemStack Output = null;
		if (stack > 0) {
			System.out.println(stack);
			Output = new ItemStack(Items.ItemLightBall, stack);
		}
		else if (stack < 0) {
			Output = new ItemStack(Items.ItemDarkBall, stack);
		}
		OutputItem = new EntityItem(world, posx, y + 0.5, posz, Output);
		OutputItem.motionX = velx;
		OutputItem.motionY = 0;
		OutputItem.motionZ = velz;
		world.setBlockToAir(x, y + 1, z);
		if (!world.isRemote) {
			world.spawnEntityInWorld(OutputItem);
			world.spawnEntityInWorld(OutputItem);
		}
	}

}
