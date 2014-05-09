package LightProcessing.common.lightProcessing.block;

import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import LightProcessing.common.lib.*;
import LightProcessing.common.lightProcessing.tile.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCompressor extends Block {

	public static boolean flag1;

	public BlockCompressor(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(10);
		this.setCreativeTab(BlockTab.blockTab);
		this.setUnlocalizedName("AbsComp");
	}

	@Override
	public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side) {
		return true;
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
		return new TileEntityCompressor();
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	public static void particles(World world, int x, int y, int z) {

		Random random = new Random();
		float f1 = (float) x + 0.5F;
		float f2 = (float) y + 1.1F;
		float f3 = (float) z + 0.5F;
		float f4 = random.nextFloat() * 0.6F - 0.3F;
		float f5 = random.nextFloat() * -0.6F - -0.3F;

		world.playSoundEffect((double) f1, (double) f2, (double) f3, "mob.irongolem.death", 1.0F, world.rand.nextFloat() * 0.1F + 0.9F);

		world.spawnParticle("largeexplode", (double) (f1), (double) f2, (double) (f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f1), (double) f2, (double) (f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f1), (double) f2, (double) (f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f1), (double) f2, (double) (f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f1), (double) f2, (double) (f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f1), (double) f2, (double) (f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f1), (double) f2, (double) (f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f1), (double) f2, (double) (f3), 0.0D, 0.0D, 0.0D);
	}

	public static void compress(World par1World, int par2, int par3, int par4) {
		int id = par1World.getBlockId(par2 - 1, par3, par4);
		int met = par1World.getBlockMetadata(par2 - 1, par3, par4);
		int id2 = par1World.getBlockId(par2 + 1, par3, par4);
		int met2 = par1World.getBlockMetadata(par2 + 1, par3, par4);
		int id3 = par1World.getBlockId(par2, par3, par4 - 1);
		int met3 = par1World.getBlockMetadata(par2, par3, par4 - 1);
		int id4 = par1World.getBlockId(par2, par3, par4 + 1);
		int met4 = par1World.getBlockMetadata(par2, par3, par4 + 1);
		int id5 = par1World.getBlockId(par2, par3 + 1, par4);
		int light = IDRef.LIGHT_BLOCK_ID;
		int dark = IDRef.DARK_BLOCK_ID;

		ItemStack unAbStack = new ItemStack(Items.ItemUnstableAbs, 1);
		EntityItem UnAbsItem = new EntityItem(par1World, par2 + 0.5, par3 + 1.15, par4 + 0.5, unAbStack);
		UnAbsItem.motionX = 0;
		UnAbsItem.motionY = 0;
		UnAbsItem.motionZ = 0;

		if (id == light && id2 == dark && met2 != 2) {
			if (id5 == 0) {
				par1World.setBlock(par2 - 1, par3, par4, 0);
				par1World.setBlock(par2 + 1, par3, par4, 0);
				particles(par1World, par2, par3, par4);
				if (!par1World.isRemote) {
					par1World.spawnEntityInWorld(UnAbsItem);
					flag1 = true;
				}
			}
		}
		else if (id == dark && id2 == light && met != 2) {
			if (id5 == 0) {
				par1World.setBlock(par2 - 1, par3, par4, 0);
				par1World.setBlock(par2 + 1, par3, par4, 0);
				particles(par1World, par2, par3, par4);
				if (!par1World.isRemote) {
					par1World.spawnEntityInWorld(UnAbsItem);
					flag1 = true;
				}
			}
		}
		else if (id3 == light && id4 == dark && met4 != 2) {
			if (id5 == 0) {
				par1World.setBlock(par2, par3, par4 - 1, 0);
				par1World.setBlock(par2, par3, par4 + 1, 0);
				particles(par1World, par2, par3, par4);
				if (!par1World.isRemote) {
					par1World.spawnEntityInWorld(UnAbsItem);
					flag1 = true;
				}
			}
		}
		else if (id3 == dark && id4 == light && met3 != 2) {
			if (id5 == 0) {
				par1World.setBlock(par2, par3, par4 - 1, 0);
				par1World.setBlock(par2, par3, par4 + 1, 0);
				particles(par1World, par2, par3, par4);
				if (!par1World.isRemote) {
					par1World.spawnEntityInWorld(UnAbsItem);
					flag1 = true;
				}
			}
		}
	}

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {

		if (par5EntityPlayer.getCurrentItemOrArmor(0) == null) {
			compress(par1World, par2, par3, par4);
		}
		return false;
	}
}
