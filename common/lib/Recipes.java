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
	GameRegistry.addRecipe(new ItemStack(lib.Blocks.BlockLightBlock), "ll", "ll", 'l', lib.Items.ItemLightIngot);
	GameRegistry.addRecipe(new ItemStack(lib.Blocks.BlockAbsBlock), "aa", "aa", 'a', lib.Items.ItemAbsIngot);
	GameRegistry.addRecipe(new ItemStack(lib.Blocks.BlockDarkBlock), "dd", "dd", 'd', lib.Items.ItemDarkIngot);
	GameRegistry.addRecipe(new ItemStack(lib.Items.ItemLightIngot, 4), "L", 'L', lib.Blocks.BlockLightBlock);
	GameRegistry.addRecipe(new ItemStack(lib.Blocks.BlockAbsComp), "SSS", "LSD", "SSS", 'S', Block.stone, 'L', lib.Items.ItemLightIngot, 'D', lib.Items.ItemDarkIngot);
//TEMPORARY
	GameRegistry.addRecipe(new ItemStack(lib.Items.ItemAbsIngot), "DLD", "LUL", "DLD", 'D', lib.Items.ItemDarkIngot, 'L', lib.Items.ItemLightIngot, 'U', lib.Items.ItemUnstableAbs);
	GameRegistry.addRecipe(new ItemStack(lib.Items.ItemAbsIngot), "LDL", "DUD", "LDL", 'D', lib.Items.ItemDarkIngot, 'L', lib.Items.ItemLightIngot, 'U', lib.Items.ItemUnstableAbs);
	GameRegistry.addRecipe(new ItemStack(lib.Items.ItemDarkBall, 3), "OOO", "OEO", "OOO", 'O', Block.obsidian, 'E', Item.enderPearl);
	GameRegistry.addRecipe(new ItemStack(lib.Items.ItemLightBall, 3), "GGG", "GEG", "GGG", 'G', Block.glowStone, 'E', Item.enderPearl);
	GameRegistry.addRecipe(new ItemStack(lib.Items.ItemAbsRod), "ASA", "ASA", "ASA", 'A', lib.Items.ItemAbsIngot, 'S', Item.stick);
	GameRegistry.addRecipe(new ItemStack(lib.Blocks.BlockHarvester), "SGS", "LSO", "SSS", 'S', Block.stone, 'G', Block.glass, 'L', Block.glowStone, 'O', Block.obsidian);
}
}
