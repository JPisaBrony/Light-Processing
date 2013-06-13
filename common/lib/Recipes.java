package lib;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Recipes {
	
	
public static void InitRecipes(){
	GameRegistry.addRecipe(new ItemStack(lib.Items.ItemDarkIngot), "   ", "ddd", "ddd", 'd', lib.Items.ItemDarkBall);
	GameRegistry.addRecipe(new ItemStack(lib.Items.ItemDarkIngot), "ddd", "ddd", "   ", 'd', lib.Items.ItemDarkBall);
	GameRegistry.addRecipe(new ItemStack(lib.Items.ItemLightIngot), "   ", "lll", "lll", 'l', lib.Items.ItemLightBall);
	GameRegistry.addRecipe(new ItemStack(lib.Items.ItemLightIngot), "lll", "lll", "   ", 'l', lib.Items.ItemLightBall);
	GameRegistry.addRecipe(new ItemStack(lib.Blocks.BlockLightBlock), "lll", "lll", "lll", 'l', lib.Items.ItemLightIngot);
	GameRegistry.addRecipe(new ItemStack(lib.Blocks.BlockAbsBlock), "aaa", "aaa", "aaa", 'a', lib.Items.ItemAbsIngot);
//TEMPORARY
	GameRegistry.addShapelessRecipe(new ItemStack(lib.Items.ItemUnstableAbs), new ItemStack(lib.Items.ItemLightIngot), new ItemStack(lib.Items.ItemDarkIngot));
	GameRegistry.addRecipe(new ItemStack(lib.Items.ItemAbsIngot), "DLD", "LUL", "DLD", 'D', lib.Items.ItemDarkIngot, 'L', lib.Items.ItemLightIngot, 'U', lib.Items.ItemUnstableAbs);
	GameRegistry.addRecipe(new ItemStack(lib.Items.ItemAbsIngot), "LDL", "DUD", "LDL", 'D', lib.Items.ItemDarkIngot, 'L', lib.Items.ItemLightIngot, 'U', lib.Items.ItemUnstableAbs);
	GameRegistry.addRecipe(new ItemStack(lib.Items.ItemDarkBall), "OOO", "OEO", "OOO", 'O', Block.obsidian, 'E', Item.enderPearl);
	GameRegistry.addRecipe(new ItemStack(lib.Items.ItemLightBall), "GGG", "GEG", "GGG", 'G', Block.glowStone, 'E', Item.enderPearl);
	GameRegistry.addRecipe(new ItemStack(lib.Items.ItemAbsRod), "ASA", "ASA", "ASA", 'A', lib.Items.ItemAbsIngot, 'S', Item.stick);
}
}
