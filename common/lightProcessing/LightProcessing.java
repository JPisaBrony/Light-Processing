package LightProcessing.common.lightProcessing;

import java.util.logging.Level;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import LightProcessing.common.lib.*;
import LightProcessing.common.lightProcessing.network.*;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class LightProcessing {

	@Instance("LightProcessing")
	public static LightProcessing instance;

	@SidedProxy(clientSide = "LightProcessing.common.lightProcessing.network.ClientProxy", serverSide = "LightProcessing.common.lightProcessing.network.CommonProxy")
	public static CommonProxy proxy;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		// CONFIG
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();

		// blocks
		IDRef.ABS_BLOCK_ID = config.get(config.CATEGORY_BLOCK, "AbsBlock", IDRef.ABS_BLOCK_IDD).getInt();
		IDRef.DARK_BLOCK_ID = config.get(config.CATEGORY_BLOCK, "DarkBlock", IDRef.DARK_BLOCK_IDD).getInt();
		IDRef.DARK_GEN_ID = config.get(config.CATEGORY_BLOCK, "DarkGen", IDRef.DARK_GEN_IDD).getInt();
		IDRef.LIGHT_BLOCK_ID = config.get(config.CATEGORY_BLOCK, "LightBlock", IDRef.LIGHT_BLOCK_IDD).getInt();
		IDRef.LIGHT_WOOD_ID = config.get(config.CATEGORY_BLOCK, "LightWood", IDRef.LIGHT_WOOD_IDD).getInt();
		IDRef.HARVESTER_ID = config.get(config.CATEGORY_BLOCK, "Harvester", IDRef.HARVESTER_IDD).getInt();
		IDRef.COMPRESSOR_ID = config.get(config.CATEGORY_BLOCK, "AbsComp", IDRef.COMPRESSOR_IDD).getInt();
		IDRef.DARK_LEAF_ID = config.get(config.CATEGORY_BLOCK, "DarkLeaf", IDRef.DARK_LEAF_IDD).getInt();
		IDRef.MACHINE_CORE_ID = config.get(config.CATEGORY_BLOCK, "MachineCore", IDRef.MACHINE_CORE_IDD).getInt();
		IDRef.EssenceExtractor_ID = config.get(config.CATEGORY_BLOCK, "Essence Extractor", IDRef.EssenceExtractor_IDD).getInt();

		// items
		IDRef.ABS_INGOT_ID = config.get(config.CATEGORY_ITEM, "AbsIngot", IDRef.ABS_INGOT_IDD).getInt();
		IDRef.ABS_ROD_ID = config.get(config.CATEGORY_ITEM, "AbsRod", IDRef.ABS_ROD_IDD).getInt();
		IDRef.DARK_BALL_ID = config.get(config.CATEGORY_ITEM, "DarkBall", IDRef.DARK_BALL_IDD).getInt();
		IDRef.DARK_INGOT_ID = config.get(config.CATEGORY_ITEM, "DarkIngot", IDRef.DARK_INGOT_IDD).getInt();
		IDRef.LIGHT_BALL_ID = config.get(config.CATEGORY_ITEM, "LightBall", IDRef.LIGHT_BALL_IDD).getInt();
		IDRef.LIGHT_INGOT_ID = config.get(config.CATEGORY_ITEM, "LightIngot", IDRef.LIGHT_INGOT_IDD).getInt();
		IDRef.UNSTABLE_ABS_ID = config.get(config.CATEGORY_ITEM, "UnstableAbs", IDRef.UNSTABLE_ABS_IDD).getInt();
		config.save();

		proxy.registerRenderThings();
		proxy.registerServerTickHandler();
		ItemTab.InitTab();
		BlockTab.InitTab();
		Blocks.InitBlocks();
		Items.InitItems();
		Recipes.InitRecipes();
		Tiles.registerTiles();
		ExtractionList.setList();

	}

	@Init
	public void load(FMLInitializationEvent event) {

	}

	@PostInit
	public void PostInit(FMLInitializationEvent event) {

	}

}
