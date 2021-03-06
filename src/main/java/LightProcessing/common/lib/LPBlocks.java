package LightProcessing.common.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import LightProcessing.common.block.*;

public class LPBlocks {

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
	public static Block BlockLightOre;
	public static Block BlockLightOreStone;
	public static Block BlockStabilizer;

	public static void InitBlocks() {
		// LIGHT BLOCK
		BlockLightBlock = new BlockLightBlock(Material.rock);
		GameRegistry.registerBlock(BlockLightBlock, "LightBlock");
		LanguageRegistry.addName(BlockLightBlock, "Block of Light");

		// LIGHT WOOD
		BlockLightWood = new BlockLightWood(Material.wood);
		GameRegistry.registerBlock(BlockLightWood, "LightWood");
		LanguageRegistry.addName(BlockLightWood, "Light Wood");
		
		// DARK LEAF
		BlockDarkLeaf = new BlockDarkLeaf();
		GameRegistry.registerBlock(BlockDarkLeaf, "DarkLeaf");
		LanguageRegistry.addName(BlockDarkLeaf, "Dark Leaf");
		
		// LIGHT SAPLING
		BlockLightTreeSapling = new BlockLightTreeSapling(IDRef.LIGHT_SAPLING_ID);
		GameRegistry.registerBlock(BlockLightTreeSapling, "LightTreeSapling");
		LanguageRegistry.addName(BlockLightTreeSapling, "Light Tree Sapling");
		
		// LIGHT PLANKS
		BlockLightWoodPlanks = new BlockLightWoodPlanks(Material.wood);
		GameRegistry.registerBlock(BlockLightWoodPlanks, "LightWoodPlanks");
		LanguageRegistry.addName(BlockLightWoodPlanks, "Light Wood Planks");

		// DARK BLOCK
		BlockDarkBlock = new BlockDarkBlock(Material.rock);
		GameRegistry.registerBlock(BlockDarkBlock, "DarkBlock");
		LanguageRegistry.addName(BlockDarkBlock, "Block of Darkness");

		// ABSOLUTION BLOCK
		BlockAbsBlock = new BlockAbsBlock(Material.rock);
		GameRegistry.registerBlock(BlockAbsBlock, "AbsBlock");
		LanguageRegistry.addName(BlockAbsBlock, "Block of Absolution");

		// HARVESTER
		BlockHarvester = new BlockHarvester(Material.rock);
		GameRegistry.registerBlock(BlockHarvester, "Harvester");
		LanguageRegistry.addName(BlockHarvester, "Harvester");

		// ABSOLUTION COMPRESSOR
		BlockAbsComp = new BlockCompressor(Material.rock);
		GameRegistry.registerBlock(BlockAbsComp, "AbsComp");
		LanguageRegistry.addName(BlockAbsComp, "Compressor");

		// DARKNESS GENERATOR
		BlockDarkGen = new BlockDarkGen(Material.rock);
		GameRegistry.registerBlock(BlockDarkGen, "DarkGen");
		LanguageRegistry.addName(BlockDarkGen, "Darkness Generator");

		// MACHINE CORE
		BlockMachineCore = new BlockMachineCore(Material.rock);
		GameRegistry.registerBlock(BlockMachineCore, "MachineCore");
		LanguageRegistry.addName(BlockMachineCore, "Machine Core");

		// Essence Extractor
		BlockEssenceExtractor = new BlockEssenceExtractor(Material.rock);
		GameRegistry.registerBlock(BlockEssenceExtractor, "EssenceExtractor");
		LanguageRegistry.addName(BlockEssenceExtractor, "Essence Extractor");
	
		// Light Ore
		BlockLightOre = new BlockLightOre(Material.rock);
		GameRegistry.registerBlock(BlockLightOre, "LightOre");
		LanguageRegistry.addName(BlockLightOre, "Light Ore");
		
		// Light Ore Stone
		BlockLightOreStone = new BlockLightOreStone(Material.rock);
		GameRegistry.registerBlock(BlockLightOreStone, "LightOreStone");
		LanguageRegistry.addName(BlockLightOreStone, "Light Ore Stone");
	
		// Stabilizer
		BlockStabilizer = new BlockStabilizer(Material.rock);
		GameRegistry.registerBlock(BlockStabilizer, "Stabilizer");
		LanguageRegistry.addName(BlockStabilizer, "Stabilizer");
	}

}
