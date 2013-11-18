package LightProcessing.common.lightProcessing.block;
import java.util.ArrayList;
import java.util.Random;

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
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
public class BlockDarkLeaf extends Block
{
public BlockDarkLeaf(int par1, Material material)
{
super(par1, material);
this.setCreativeTab(LightProcessing.common.lib.BlockTab.blockTab);
this.setStepSound(soundGrassFootstep);
this.setHardness(0.2F);
this.setUnlocalizedName("DarkLeaf");
}

@Override
	public void randomDisplayTick(World world, int x, int y, int z,
			Random random) {
		super.randomDisplayTick(world, x, y, z, random);
		float f1 = (float) x + 0.5F;
		float f2 = (float) y + 0.5F;
		float f3 = (float) z + 0.5F;
		float f4 = random.nextFloat() * 1.5F - 0.7F;
		float f5 = random.nextFloat() * -1.5F - -0.7F;
		float f6 = y - 0.2F;
		world.spawnParticle("portal", (double) f1 + f4, (double) f2, (double) f3 + f5, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("portal", (double) f1 + f4, (double) f2, (double) f3 + f5, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("portal", (double) f1 + f4, (double) f2, (double) f3 + f5, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("portal", (double) f1 + f4, (double) f2, (double) f3 + f5, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("portal", (double) f1 + f4, (double) f2, (double) f3 + f5, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("portal", (double) f1 + f4, (double) f2, (double) f3 + f5, 0.0D, 0.0D, 0.0D);
		world.spawnParticle("portal", (double) f1 + f4, (double) f6, (double) f3 + f5, 0.0D, 0.0D, 0.0D);
	}
	
	public int idDropped(int par1, Random par2Random, int par3) {
		return IDRef.DARK_LEAF_ID;
	}

	public int quantityDropped(Random par1Random) {
		return par1Random.nextInt(2);
	}
	
	 @Override
	 @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister iconRegister) {
		 blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().substring(5)));
	    }
}