package LightProcessing.common.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import LightProcessing.common.lib.BlockTab;
import LightProcessing.common.lib.LPBlocks;
import LightProcessing.common.lib.IDRef;
import LightProcessing.common.lib.LPItems;
import LightProcessing.common.lib.Methods;
import LightProcessing.common.worldCrafting.WorldCrafting;
import LightProcessing.common.worldCrafting.WorldCraftingRecipe;
import LightProcessing.common.worldCrafting.WorldCraftingRecipeCollection;

public class BlockLightWoodPlanks extends Block{
	public BlockLightWoodPlanks(Material material) {
		super(material);
		this.setBlockName("LightWoodPlanks");
		this.setCreativeTab(BlockTab.blockTab);
		this.setHardness(2.0F);
		this.setLightLevel(1.0F);
	}
	
	public int idDropped(int par1, Random par2Random, int par3) {
		return IDRef.LIGHT_WOOD_PLANKS_ID;
	}

	public int quantityDropped(Random par1Random) {
		return 1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		WorldCrafting harvester = new WorldCrafting();
		if (par5EntityPlayer.getCurrentEquippedItem() == null) {
			WorldCraftingRecipeCollection recipe = harvester.dictionary.get(IDRef.LIGHT_WOOD_PLANKS_ID);
			for(int i = 0; i < recipe.getCount(); i++) {
				if(Methods.checkRecipe(world, x, y, z, recipe.get(i))) {
					Methods.spawnItemInWorld(world, x, y, z, LPItems.ItemAbsRod);
					return true;
				}
			}
		}
		return false;
	}
	
}