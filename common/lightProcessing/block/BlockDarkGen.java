package lightProcessing.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lib.IDRef;
import lib.Reference;
import lightProcessing.tile.TileEntityAbsComp;
import lightProcessing.tile.TileEntityDarkGen;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDarkGen extends Block {

	public BlockDarkGen(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(10);
		this.setCreativeTab(lib.BlockTab.blockTab);
		this.setUnlocalizedName("DarkGen");
	}

	@Override
	public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z,
			int side) {
		return true;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}

	public int getMobilityFlag() {
		return 0;
	}

	public int onBlockPlaced(World par1World, int par2, int par3, int par4,
			int par5, float par6, float par7, float par8, int par9) {
		return par9;
	}

	public void breakBlock(World par1World, int par2, int par3, int par4,
			int par5, int par6) {
		int ID2 = IDRef.DARK_BLOCK_ID;
		for (int i = -10; i < 10; i++) {
			for (int j = -10; j < 10; j++) {
				for (int k = -10; k < 10; k++) {
					if (par1World.getBlockId(par2 + k, par3 + j, par4 + i) == ID2
							&& par1World.getBlockMetadata(par2 + k, par3 + j,
									par4 + i) == 2) {
						par1World.setBlock(par2 + k, par3 + j, par4 + i, 0);

					}
				}
			}
		}
		par1World.removeBlockTileEntity(par2, par3, par4);
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z,
			Random random) {
		super.randomDisplayTick(world, x, y, z, random);
		float f1 = (float) x + 0.5F;
		float f2 = (float) y + 0.5F;
		float f3 = (float) z + 0.5F;
		float f4 = random.nextFloat() * 0.6F - 0.3F;
		float f5 = random.nextFloat() * -0.6F - -0.3F;
		world.spawnParticle("smoke", (double) f1, (double) f2, (double) f3,
				0.0D, 0.0D, 0.0D);
		world.spawnParticle("smoke", (double) f1, (double) f2, (double) f3,
				0.0D, 0.0D, 0.0D);
		world.spawnParticle("smoke", (double) f1, (double) f2, (double) f3,
				0.0D, 0.0D, 0.0D);
		world.spawnParticle("smoke", (double) f1, (double) f2, (double) f3,
				0.0D, 0.0D, 0.0D);
		world.spawnParticle("smoke", (double) f1, (double) f2, (double) f3,
				0.0D, 0.0D, 0.0D);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
				+ ":HarvesterTop");
	}

	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		if (!par1World.isRemote
				&& par5EntityPlayer.getCurrentItemOrArmor(0) == null) {

			int ID = 1;
			int ID2 = IDRef.DARK_BLOCK_ID;
			if (par1World.getBlockMetadata(par2, par3, par4) == 0) {
				for (int i = -10; i < 10; i++) {
					for (int j = -10; j < 10; j++) {
						for (int k = -10; k < 10; k++) {
							if (par1World.isAirBlock(par2 + k, par3 + j, par4
									+ i)) {
								par1World.setBlock(par2 + k, par3 + j,
										par4 + i, ID2, 2, 2);

							}
						}
					}
				}
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
			} else if (par1World.getBlockMetadata(par2, par3, par4) == 1) {
				for (int i = -10; i < 10; i++) {
					for (int j = -10; j < 10; j++) {
						for (int k = -10; k < 10; k++) {
							if (par1World.getBlockId(par2 + k, par3 + j, par4
									+ i) == ID2
									&& par1World.getBlockMetadata(par2 + k,
											par3 + j, par4 + i) == 2) {
								par1World.setBlock(par2 + k, par3 + j,
										par4 + i, 0);
							}
						}
					}
				}
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
			}
		}
		return false;
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
		return new TileEntityDarkGen();
	}

	@Override
	public int getRenderType() {
		return -1;
	}
}