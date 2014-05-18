package LightProcessing.common.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import LightProcessing.common.lightProcessing.block.*;

public class Blocks {

	// vars
	public static Block BlockLightBlock;
	public static Block BlockLightWood;
	public static Block BlockLightTreeSapling;
	public static Block BlockLightWoodPlanks;
	public static Block BlockDarkBlock;
	public static Block BlockAbsBlock;
	public static Block BlockHarvester;
	public static Block BlockAbsComp;
	public static Block BlockDarkGen;
	public static Block BlockDarkLeaf;
	public static Block BlockMachineCore;
	public static Block BlockEssenceExtractor;

	public static void InitBlocks() {
		// LIGHT BLOCK
		BlockLightBlock = (new BlockLightBlock(IDRef.LIGHT_BLOCK_ID, Material.rock));
		GameRegistry.registerBlock(BlockLightBlock, "LightBlock");
		LanguageRegistry.addName(BlockLightBlock, "Block of Light");

		// LIGHT WOOD
		BlockLightWood = (new BlockLightWood(IDRef.LIGHT_WOOD_ID, Material.wood));
		GameRegistry.registerBlock(BlockLightWood, "LightWood");
		LanguageRegistry.addName(BlockLightWood, "Light Wood");
		
		// DARK LEAF
		BlockDarkLeaf = (new BlockDarkLeaf(IDRef.DARK_LEAF_ID));
		GameRegistry.registerBlock(BlockDarkLeaf, "DarkLeaf");
		LanguageRegistry.addName(BlockDarkLeaf, "Dark Leaf");
		
		// LIGHT SAPLING
		BlockLightTreeSapling = (new BlockLightTreeSapling(IDRef.LIGHT_SAPLING_ID));
		GameRegistry.registerBlock(BlockLightTreeSapling, "LightTreeSapling");
		LanguageRegistry.addName(BlockLightTreeSapling, "Light Tree Sapling");
		
		// LIGHT PLANKS
		BlockLightWoodPlanks = new BlockLightWoodPlanks(IDRef.LIGHT_WOOD_PLANKS_ID, Material.wood);
		GameRegistry.registerBlock(BlockLightWoodPlanks, "LightWoodPlanks");
		LanguageRegistry.addName(BlockLightWoodPlanks, "Light Wood Planks");

		// DARK BLOCK
		BlockDarkBlock = (new BlockDarkBlock(IDRef.DARK_BLOCK_ID, Material.rock));
		GameRegistry.registerBlock(BlockDarkBlock, "DarkBlock");
		LanguageRegistry.addName(BlockDarkBlock, "Block of Darkness");

		// ABSOLUTION BLOCK
		BlockAbsBlock = (new BlockAbsBlock(IDRef.ABS_BLOCK_ID, Material.rock));
		GameRegistry.registerBlock(BlockAbsBlock, "AbsBlock");
		LanguageRegistry.addName(BlockAbsBlock, "Block of Absolution");

		// HARVESTER
		BlockHarvester = (new BlockHarvester(IDRef.HARVESTER_ID, Material.rock));
		GameRegistry.registerBlock(BlockHarvester, "Harvester");
		LanguageRegistry.addName(BlockHarvester, "Harvester");

		// ABSOLUTION COMPRESSOR
		BlockAbsComp = (new BlockCompressor(IDRef.COMPRESSOR_ID, Material.rock));
		GameRegistry.registerBlock(BlockAbsComp, "AbsComp");
		LanguageRegistry.addName(BlockAbsComp, "Compressor");

		// DARKNESS GENERATOR
		BlockDarkGen = (new BlockDarkGen(IDRef.DARK_GEN_ID, Material.rock));
		GameRegistry.registerBlock(BlockDarkGen, "DarkGen");
		LanguageRegistry.addName(BlockDarkGen, "Darkness Generator");

		// MACHINE CORE
		BlockMachineCore = (new BlockMachineCore(IDRef.MACHINE_CORE_ID, Material.rock));
		GameRegistry.registerBlock(BlockMachineCore, "MachineCore");
		LanguageRegistry.addName(BlockMachineCore, "Machine Core");

		// Essence Extractor
		BlockEssenceExtractor = (new BlockEssenceExtractor(IDRef.ESSENCE_EXTRACTOR_ID, Material.rock));
		GameRegistry.registerBlock(BlockEssenceExtractor, "EssenceExtractor");
		LanguageRegistry.addName(BlockEssenceExtractor, "Essence Extractor");
	}

}
