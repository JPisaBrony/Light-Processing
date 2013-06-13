package lib;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Blocks {

	//vars
	public static Block BlockLightBlock;
	public static Block BlockDarkBlock;
	public static Block BlockAbsBlock;
	public static Block BlockHarvester;
	
	public static void InitBlocks(){
		
		//LIGHT BLOCK
		BlockLightBlock = (new lightProcessing.block.BlockLightBlock(3000, Material.rock));
		GameRegistry.registerBlock(BlockLightBlock, "LightBlock");
		LanguageRegistry.addName(BlockLightBlock, "Block of Light");
		/////////////
		
		//DARK BLOCK
		BlockDarkBlock = (new lightProcessing.block.BlockDarkBlock(3008, Material.rock));
		GameRegistry.registerBlock(BlockDarkBlock, "DarkBlock");
		LanguageRegistry.addName(BlockDarkBlock, "Block of Darkness");
		/////////////
		
		//DARK BLOCK
		BlockAbsBlock = (new lightProcessing.block.BlockAbsBlock(3009, Material.rock));
		GameRegistry.registerBlock(BlockAbsBlock, "AbsBlock");
		LanguageRegistry.addName(BlockAbsBlock, "Block of Absolution");
		/////////////
		
		//DARK BLOCK
		BlockHarvester = (new lightProcessing.block.BlockHarvester(3010, Material.rock));
		GameRegistry.registerBlock(BlockHarvester, "Harvester");
		LanguageRegistry.addName(BlockHarvester, "Harvester");
		/////////////
	}
	
}
