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
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
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

	public void addCollisionBoxesToList(World par1World, int par2, int par3,
			int par4, AxisAlignedBB par5AxisAlignedBB, List par6List,
			Entity par7Entity) {
		this.setBlockBounds(-0.065F, 0.0F, -0.065F, 1.045F, 1.1F, 1.045F);
		super.addCollisionBoxesToList(par1World, par2, par3, par4,
				par5AxisAlignedBB, par6List, par7Entity);
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4) {
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		extract(par1World,par2,par3,par4);
		return false;
	}
	public static void extract(World world, int x, int y, int z){
		ItemStack LightStack = new ItemStack(Items.ItemLightBall, 1);
		EntityItem LightItem = new EntityItem(world, x + 0.5,
				y + 0.5, z - 0.6, LightStack);
		LightItem.motionX = 0;
		LightItem.motionY = 0;
		LightItem.motionZ = -1;
		
		ItemStack DarkStack = new ItemStack(Items.ItemDarkBall, 1);
		EntityItem DarkItem = new EntityItem(world, x + 0.5,
				y + 0.5, z - 0.6, DarkStack);
		DarkItem.motionX = 0;
		DarkItem.motionY = 0;
		DarkItem.motionZ = -1;
		int ID = world.getBlockId(x, y + 1, z);	
		if(!world.isRemote){
		if(ID == IDRef.LIGHT_WOOD_ID){
			world.setBlockToAir(x, y + 1, z);
			world.spawnEntityInWorld(LightItem);
		}
		if(ID == IDRef.DARK_LEAF_ID){
			world.setBlockToAir(x, y + 1, z);
			world.spawnEntityInWorld(DarkItem);
		}
	}
	}
	
}
