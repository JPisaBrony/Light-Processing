package LightProcessing.common.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Blocks {

	//vars
	public static Block BlockLightBlock;
	public static Block BlockLightWood;
	public static Block BlockDarkBlock;
	public static Block BlockAbsBlock;
	public static Block BlockHarvester;
	public static Block BlockAbsComp;
	
	public static void InitBlocks(){
		
		//LIGHT BLOCK
		BlockLightBlock = (new LightProcessing.common.lightProcessing.block.BlockLightBlock(IDRef.LIGHT_BLOCK_ID, Material.rock));
		GameRegistry.registerBlock(BlockLightBlock, "LightBlock");
		LanguageRegistry.addName(BlockLightBlock, "Block of Light");
		/////////////
		
		//LIGHT WOOD
		BlockLightWood = (new LightProcessing.common.lightProcessing.block.BlockLightWood(IDRef.LIGHT_WOOD_ID, Material.wood));
		GameRegistry.registerBlock(BlockLightWood, "LightWood");
		LanguageRegistry.addName(BlockLightWood,  "Light Wood");
		/////////////
		
		//DARK BLOCK
		BlockDarkBlock = (new LightProcessing.common.lightProcessing.block.BlockDarkBlock(IDRef.DARK_BLOCK_ID, Material.rock));
		GameRegistry.registerBlock(BlockDarkBlock, "DarkBlock");
		LanguageRegistry.addName(BlockDarkBlock, "Block of Darkness");
		////////////
		
		//ABSOLUTION BLOCK
		BlockAbsBlock = (new LightProcessing.common.lightProcessing.block.BlockAbsBlock(IDRef.ABS_BLOCK_ID, Material.rock));
		GameRegistry.registerBlock(BlockAbsBlock, "AbsBlock");
		LanguageRegistry.addName(BlockAbsBlock, "Block of Absolution");
		/////////////
		
		//HARVESTER
		BlockHarvester = (new LightProcessing.common.lightProcessing.block.BlockHarvester(IDRef.HARVESTER_ID, Material.rock));
		GameRegistry.registerBlock(BlockHarvester, "Harvester");
		LanguageRegistry.addName(BlockHarvester, "Harvester");
		/////////////
		
		//ABSOLUTION COMPRESSOR
		BlockAbsComp = (new LightProcessing.common.lightProcessing.block.BlockAbsComp(IDRef.ABS_COMP_ID, Material.rock));
		GameRegistry.registerBlock(BlockAbsComp, "AbsComp");
		LanguageRegistry.addName(BlockAbsComp, "Absolution Compressor");
		/////////////
	}
	
}
