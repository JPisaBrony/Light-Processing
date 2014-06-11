package LightProcessing.common.lightProcessing.block;

import java.util.ArrayList;
import java.util.Random;

import LightProcessing.common.lib.Blocks;
import LightProcessing.common.lib.IDRef;
import LightProcessing.common.lib.Methods;
import LightProcessing.common.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class BlockLightOreStone extends Block {
	
	private boolean flag;
	
	public BlockLightOreStone(int par1, Material material) {
		super(par1, material);
		this.setCreativeTab(LightProcessing.common.lib.BlockTab.blockTab);
		this.setStepSound(soundStoneFootstep);
		this.setHardness(1.0F);
		this.setUnlocalizedName("LightOreStone");
		flag = true;
	}
	
	public int idDropped(int par1, Random par2Random, int par3) {
		if(flag)
			return 4;
		return IDRef.LIGHT_BALL_ID + 256;
	}

	public int quantityDropped(Random par1Random) {
		return 1;
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		super.randomDisplayTick(world, x, y, z, random);
		if(Methods.lightCheck(world, x, y, z, 5) && !world.canBlockSeeTheSky(x, y, z)) {
			world.setBlock(x, y, z, IDRef.LIGHT_ORE_ID);
			flag = false;
		}
		else
			flag = true;
	}
	
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = Block.stone.getIcon(1, 0);
	}
	
}