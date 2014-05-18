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
		GameRegistry.addRecipe(new ItemStack(Blocks.BlockLightBlock), "ll", "ll", 'l', Items.ItemLightIngot);
		GameRegistry.addRecipe(new ItemStack(Blocks.BlockAbsBlock), "aa", "aa", 'a', Items.ItemAbsIngot);
		GameRegistry.addRecipe(new ItemStack(Blocks.BlockDarkBlock), "dd", "dd", 'd', Items.ItemDarkIngot);
		GameRegistry.addRecipe(new ItemStack(Items.ItemLightIngot, 4), "L", 'L', Blocks.BlockLightBlock);
		GameRegistry.addRecipe(new ItemStack(Items.ItemDarkIngot, 4), "D", 'D', Blocks.BlockDarkBlock);
		GameRegistry.addRecipe(new ItemStack(Items.ItemAbsIngot, 4), "A", 'A', Blocks.BlockAbsBlock);
		GameRegistry.addRecipe(new ItemStack(Blocks.BlockAbsComp), "SSS", "LSD", "SSS", 'S', Block.stone, 'L', Items.ItemLightIngot, 'D', Items.ItemDarkIngot);
		GameRegistry.addRecipe(new ItemStack(Blocks.BlockHarvester), "SGS", "LDO", "SSS", 'S', Block.stone, 'G', Block.glass, 'L', Block.glowStone, 'O', Block.obsidian, 'D', Item.diamond);
		GameRegistry.addRecipe(new ItemStack(Items.ItemDarkBall, 3), "D", 'D', Blocks.BlockDarkLeaf);
		GameRegistry.addRecipe(new ItemStack(Blocks.BlockLightWoodPlanks, 4), "W", 'W', Blocks.BlockLightWood);
		// TEMPORARY
		GameRegistry.addRecipe(new ItemStack(Items.ItemAbsIngot), "DLD", "LUL", "DLD", 'D', Items.ItemDarkIngot, 'L', Items.ItemLightIngot, 'U', Items.ItemUnstableAbs);
		GameRegistry.addRecipe(new ItemStack(Items.ItemAbsIngot), "LDL", "DUD", "LDL", 'D', Items.ItemDarkIngot, 'L', Items.ItemLightIngot, 'U', Items.ItemUnstableAbs);
		GameRegistry.addRecipe(new ItemStack(Items.ItemAbsRod), "ASA", "ASA", "ASA", 'A', Items.ItemAbsIngot, 'S', Item.stick);
		GameRegistry.addRecipe(new ItemStack(Items.ItemDarkBucketEmpty), "X X", " X ", 'X', Item.netherrackBrick);
		
		// CODE FOR CUSTOM MODPACK
		// Cow
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 92), "XXX", "XGX", "XXX", 'X', Item.leather, 'G', Item.swordGold);
		// Pig
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 90), "XXX", "XGX", "XXX", 'X', Item.rottenFlesh, 'G', Item.swordGold);
		// Sheep
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 91), "XXX", "XGX", "XXX", 'X', Block.cloth, 'G', Item.swordGold);
		// Chicken
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 93), "XXX", "XGX", "XXX", 'X', Item.silk, 'G', Item.swordGold);
		// Wolf
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 95), "XXX", "XGX", "XXX", 'X', Item.bone, 'G', Item.swordGold);
		// Squid
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 94), "XXX", "XGX", "XXX", 'X', Item.fishingRod, 'G', Item.swordGold);
		// Ocelot
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 98), "XXX", "XGX", "XXX", 'X', Item.fishRaw, 'G', Item.swordGold);
		// Skeleton
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 51), "XXX", "XGX", "XXX", 'X', Item.arrow, 'G', Item.swordGold);
		// Zombie Head
		GameRegistry.addRecipe(new ItemStack(Item.skull, 1, 2), "XXX", "XXX", "XXX", 'X', Item.rottenFlesh);
		// Zombie
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 54), "XXX", "XSX", "XXX", 'X', Item.rottenFlesh, 'S', new ItemStack(Item.skull, 1, 2));
		// Spider
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 59), "XXX", "XSX", "XXX", 'X', Item.silk, 'S', new ItemStack(Item.skull, 1, 2));
		// Creeper
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 50), "XXX", "XSX", "XXX", 'X', Item.gunpowder, 'S', new ItemStack(Item.skull, 1, 2));
		// Enderman
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 58), "XXX", "XSX", "XXX", 'X', Block.obsidian, 'S', new ItemStack(Item.skull, 1, 2));
		// Blaze
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 61), "XXX", "XSX", "XXX", 'X', Item.blazeRod, 'S', new ItemStack(Item.skull, 1, 2));
		// Slime
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 55), "XXX", "XSX", "XXX", 'X', Item.magmaCream, 'S', new ItemStack(Item.skull, 1, 2));
		// Village
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 120), "FCO", "SZH", "GWP", 'F', Item.fermentedSpiderEye, 'C', new ItemStack(Item.skull, 1, 4), 'O', Item.gunpowder, 'S', Item.skull, 'Z', Item.blazeRod, 'H', new ItemStack(Item.skull, 1, 2), 'G', Item.ghastTear, 'W', new ItemStack(Item.skull, 1, 1), 'P', Item.enderPearl);
		// Bat
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 65), "XGX", 'X', Item.leather, 'G', Item.swordGold);
		// Magma Cube
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 62), "XXX", "XGX", "XXX", 'X', Item.slimeBall, 'G', new ItemStack(Item.skull, 1, 2));
		// Horse
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 100), " X ", "XGX", " X ", 'X', Item.leather, 'G', Item.swordGold);
		// Witch
		GameRegistry.addRecipe(new ItemStack(Item.monsterPlacer, 1, 66), "XZX", "GOM", "XPX", 'X', Item.potion, 'Z', Item.blazePowder, 'G', Item.ghastTear, 'O', new ItemStack(Item.skull, 1, 2), 'M', Item.magmaCream, 'P', Item.gunpowder);
	}

}
