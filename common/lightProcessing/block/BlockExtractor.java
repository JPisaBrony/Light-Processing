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

public class BlockExtractor extends Block {

	public BlockExtractor(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(10);
		this.setCreativeTab(BlockTab.blockTab);
		this.setUnlocalizedName("Extractor");
	}

	public static boolean flag1;

	@Override
	public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z,
			int side) {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Methods.textureName(this
				.getUnlocalizedName()));
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

	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {

		if (par5EntityPlayer.getCurrentItemOrArmor(0) == null) {
		}
		return false;
	}
}
