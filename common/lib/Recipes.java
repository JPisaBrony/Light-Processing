package LightProcessing.common.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import LightProcessing.common.lib.*;

public class Recipes {

	public static void InitRecipes() {

		GameRegistry.addRecipe(new ItemStack(Items.ItemDarkIngot), "ddd", "ddd", 'd', Items.ItemDarkBall);
		GameRegistry.addRecipe(new ItemStack(Items.ItemLightIngot), "lll", "lll", 'l', Items.ItemLightBall);
		GameRegistry.addRecipe(new ItemStack(Blocks.BlockAbsBlock), "aa", "aa", 'a', Items.ItemAbsIngot);
		GameRegistry.addRecipe(new ItemStack(Items.ItemLightIngot, 4), "L", 'L', Blocks.BlockLightBlock);
		GameRegistry.addRecipe(new ItemStack(Items.ItemDarkIngot, 4), "D", 'D', Blocks.BlockDarkBlock);
		GameRegistry.addRecipe(new ItemStack(Items.ItemAbsIngot, 4), "A", 'A', Blocks.BlockAbsBlock);
		GameRegistry.addRecipe(new ItemStack(Blocks.BlockAbsComp), "SSS", "LSD", "SSS", 'S', Block.stone, 'L', Items.ItemLightIngot, 'D', Items.ItemDarkIngot);
		
		GameRegistry.addRecipe(new ItemStack(Blocks.BlockLightWoodPlanks, 4), "W", 'W', Blocks.BlockLightWood);
	}

}
