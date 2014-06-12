package LightProcessing.common.lightProcessing.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import LightProcessing.common.lib.BlockTab;
import LightProcessing.common.lib.IDRef;
import LightProcessing.common.lib.Items;
import LightProcessing.common.lib.Methods;
import LightProcessing.common.lib.WorldCrafting;
import LightProcessing.common.lib.WorldCraftingRecipe;
import LightProcessing.common.lib.WorldCraftingRecipeCollection;

public class BlockLightWoodPlanks extends Block{
	public BlockLightWoodPlanks(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setUnlocalizedName("LightWoodPlanks");
		this.setCreativeTab(BlockTab.blockTab);
		this.setHardness(2.0F);
		this.setLightValue(1.0F);
	}
	
	public int idDropped(int par1, Random par2Random, int par3) {
		return IDRef.LIGHT_WOOD_PLANKS_ID;
	}

	public int quantityDropped(Random par1Random) {
		return 1;
	}
	
	public boolean onBlockActivated(World world, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		WorldCrafting lightitems = new WorldCrafting();
		if (par5EntityPlayer.getCurrentItemOrArmor(0) == null) {
			WorldCraftingRecipeCollection recipe = lightitems.dictionary.get(IDRef.LIGHT_WOOD_PLANKS_ID);
			for(int i = 0; i < recipe.getCount(); i++)
				if(Methods.checkRecipe(world, par2, par3, par4, recipe.get(i))) {
					switch(i) {
						case 0:
							Methods.spawnItemInWorld(world, par2, par3, par4, Items.ItemLightPickaxe);
							break;
						case 1:
							Methods.spawnItemInWorld(world, par2, par3, par4, Items.ItemLightAxe);
							break;
						case 2:
							Methods.spawnItemInWorld(world, par2, par3, par4, Items.ItemLightHoe);
							break;
						case 3:
							Methods.spawnItemInWorld(world, par2, par3, par4, Items.ItemLightShovel);
							break;
						case 4:
							Methods.spawnItemInWorld(world, par2, par3, par4, Items.ItemLightSword);
							break;
						default:
							break;
					}
					return true;
				}
		}
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}
	
}
