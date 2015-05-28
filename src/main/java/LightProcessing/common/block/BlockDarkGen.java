package LightProcessing.common.block;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Random;

import org.objectweb.asm.*;

import LightProcessing.common.lib.*;
import LightProcessing.common.tile.TileEntityDarkGen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.world.ChunkWatchEvent;
import net.minecraftforge.event.world.ChunkWatchEvent.UnWatch;
import LightProcessing.common.lib.BlockTab;
import LightProcessing.common.lib.IDRef;
import LightProcessing.common.lib.Methods;
import cpw.mods.fml.common.asm.transformers.AccessTransformer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDarkGen extends Block {

	public BlockDarkGen(Material material) {
		super(material);
		this.setHardness(10);
		this.setCreativeTab(BlockTab.blockTab);
		this.setBlockName("DarkGen");
	}

	@Override
	public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side) {
		return true;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	}

	public int getMobilityFlag() {
		return 0;
	}

	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		return par9;
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		super.randomDisplayTick(world, x, y, z, random);
		float f1 = (float) x + 0.5F;
		float f2 = (float) y + 0.5F;
		float f3 = (float) z + 0.5F;
		float f4 = random.nextFloat() * 0.6F - 0.3F;
		float f5 = random.nextFloat() * -0.6F - -0.3F;
		world.spawnParticle("smoke", (double) f1, (double) f2, (double) f3, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("smoke", (double) f1, (double) f2, (double) f3, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("smoke", (double) f1, (double) f2, (double) f3, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("smoke", (double) f1, (double) f2, (double) f3, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("smoke", (double) f1, (double) f2, (double) f3, 0.0D, 0.0D, 0.0D);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9) {
		for (int i = -10; i < 10; i++) {
			for (int j = -10; j < 10; j++) {
				for (int k = -10; k < 10; k++) {
					if(world.getLightBrightness(x+i, y+j, z+k) == 0) {
						world.setLightValue(EnumSkyBlock.Block, x+i, y+j, z+k, 1);
						world.setLightValue(EnumSkyBlock.Sky, x+i, y+j, z+k, 1);
						continue;
					}
					world.setLightValue(EnumSkyBlock.Block, x+i, y+j, z+k, 0);
					world.setLightValue(EnumSkyBlock.Sky, x+i, y+j, z+k, 0);
				}
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