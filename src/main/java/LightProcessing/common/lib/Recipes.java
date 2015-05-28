package LightProcessing.common.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import LightProcessing.common.lib.*;

public class Recipes {

	public static void InitRecipes() {
		//Temporary
		GameRegistry.addRecipe(new ItemStack(LPItems.ItemDarkIngot), "ddd", "ddd", 'd', LPItems.ItemDarkBall);
		GameRegistry.addRecipe(new ItemStack(LPItems.ItemLightIngot), "lll", "lll", 'l', LPItems.ItemLightBall);
		GameRegistry.addRecipe(new ItemStack(LPBlocks.BlockAbsBlock), "aa", "aa", 'a', LPItems.ItemAbsIngot);
		GameRegistry.addRecipe(new ItemStack(LPItems.ItemLightIngot, 4), "L", 'L', LPBlocks.BlockLightBlock);
		GameRegistry.addRecipe(new ItemStack(LPItems.ItemDarkIngot, 4), "D", 'D', LPBlocks.BlockDarkBlock);
		GameRegistry.addRecipe(new ItemStack(LPItems.ItemAbsIngot, 4), "A", 'A', LPBlocks.BlockAbsBlock);
		
		GameRegistry.addRecipe(new ItemStack(LPBlocks.BlockLightWoodPlanks, 4), "W", 'W', LPBlocks.BlockLightWood);
		GameRegistry.addRecipe(new ItemStack(Items.stick, 2), "P", "P", 'P', LPBlocks.BlockLightWoodPlanks);
	}

}