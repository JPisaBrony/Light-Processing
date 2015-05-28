package LightProcessing.common.block;

import java.util.Random;

import javax.swing.Icon;

import LightProcessing.common.lib.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLightWood extends Block {
	
	public BlockLightWood(Material material) {
		super(material);
		this.setBlockName("LightWood");
		this.setCreativeTab(BlockTab.blockTab);
		this.setHardness(2.0F);
		this.setStepSound(soundTypeWood);
		this.setLightLevel(1.0F);
	}
	
	public Icon blockIcon2;
	
	@Override
	public boolean isWood(World world, int x, int y, int z) {
		return true;
	}
	
	public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9) {
		int j1 = par9 & 3;
		byte b0 = 0;

		switch (par5) {
		case 0:
		case 1:
			b0 = 0;
			break;
		case 2:
		case 3:
			b0 = 8;
			break;
		case 4:
		case 5:
			b0 = 4;
		}

		return j1 | b0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
		blockIcon2 = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()) + "Top");
	}

	public Icon getIcon(int par1, int par2) {
		int k = par2 & 12;
		int l = par2 & 3;
		return k == 0 && (par1 == 1 || par1 == 0) ? blockIcon2 : (k == 4 && (par1 == 5 || par1 == 4) ? blockIcon2 : (k == 8 && (par1 == 2 || par1 == 3) ? blockIcon2 : this.blockIcon));
	}
	
	public int idDropped(int par1, Random par2Random, int par3) {
		return IDRef.LIGHT_WOOD_ID;
	}

	public int quantityDropped(Random par1Random) {
		return 1;
	}

	@Override
	public boolean canSustainLeaves(World world, int x, int y, int z) {
		return true;
	}

}
