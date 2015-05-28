package LightProcessing.common.block;

import java.util.ArrayList;
import java.util.Random;

import LightProcessing.common.entities.EntityMoveBlock;
import LightProcessing.common.lib.IDRef;
import LightProcessing.common.lib.LPItems;
import LightProcessing.common.lib.Methods;
import LightProcessing.common.lib.Reference;
import LightProcessing.common.worldCrafting.WorldCrafting;
import LightProcessing.common.worldCrafting.WorldCraftingRecipeCollection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockDarkLeaf extends BlockLeavesBase implements IShearable{

	public BlockDarkLeaf() {
		super(Material.leaves, false);
		this.setCreativeTab(LightProcessing.common.lib.BlockTab.blockTab);
		this.setStepSound(soundTypeGrass);
		this.setHardness(0.2F);
		this.setBlockName("DarkLeft");
	}
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
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
		return IDRef.LIGHT_SAPLING_ID;
	}

	public int quantityDropped(Random par1Random) {
		return par1Random.nextInt(40) == 0 ? 1 : 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().substring(5)));
	}
    
    @Override
    public void beginLeavesDecay(World world, int x, int y, int z) {
    	world.setBlockMetadataWithNotify(x, y, z, 0, 4);
    }

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, 0));
        return ret;
	}
    
}