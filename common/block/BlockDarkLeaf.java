package LightProcessing.common.block;

import java.util.ArrayList;
import java.util.Random;

import LightProcessing.common.entities.EntityMoveBlock;
import LightProcessing.common.lib.IDRef;
import LightProcessing.common.lib.Items;
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
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityFallingSand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockDarkLeaf extends BlockLeavesBase implements IShearable{

	public BlockDarkLeaf(int par1) {
		super(par1, Material.leaves, false);
		this.setCreativeTab(LightProcessing.common.lib.BlockTab.blockTab);
		this.setStepSound(soundGrassFootstep);
		this.setHardness(0.2F);
		this.setUnlocalizedName("DarkLeaf");
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
		return par1Random.nextInt(50) == 0 ? 1 : 0;
	}

/*
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		if (!par1World.isRemote && par5EntityPlayer.getCurrentItemOrArmor(0) == null) {
			EntityMoveBlock entityfallingsand = new EntityMoveBlock(par1World, (double) ((float) par2 + 0.5F), (double) ((float) par3 + 0.5F), (double) ((float) par4 + 0.5F), IDRef.DARK_LEAF_ID, par1World.getBlockMetadata(par2, par3, par4));
			entityfallingsand.motionX = 0;
			entityfallingsand.motionY = 0.5;
			entityfallingsand.motionZ = 0;
			par1World.spawnEntityInWorld(entityfallingsand);
		}
		return false;
	}
*/
	
	public void onFinishFalling(World par1World, int par2, int par3, int par4, int par5) {
		par1World.setBlockToAir(par2, par3 - 1, par4);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + (this.getUnlocalizedName().substring(5)));
	}

    @Override
    public ArrayList<ItemStack> onSheared(ItemStack item, World world, int x, int y, int z, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
        return ret;
    }
    
    @Override
    public boolean isShearable(ItemStack item, World world, int x, int y, int z)
    {
        return true;
    }
    
}