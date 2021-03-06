package LightProcessing.common.main;

//import java.util.logging.Level;
import LightProcessing.common.generation.WorldGeneration;
import LightProcessing.common.lib.*;
import LightProcessing.common.network.CommonProxy;
//import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
//import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
//import cpw.mods.fml.common.Mod.PreInit;
//import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
//import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class LightProcessing {

	@Instance("LightProcessing")
	public static LightProcessing instance;

	@SidedProxy(clientSide = "LightProcessing.common.network.ClientProxy", serverSide = "LightProcessing.common.network.CommonProxy")
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
		IDRef.ESSENCE_EXTRACTOR_ID = config.get(config.CATEGORY_BLOCK, "Essence Extractor", IDRef.ESSENCE_EXTRACTOR_IDD).getInt();
		IDRef.LIGHT_SAPLING_ID = config.get(config.CATEGORY_BLOCK, "LightTreeSapling", IDRef.LIGHT_SAPLING_IDD).getInt();
		IDRef.LIGHT_WOOD_PLANKS_ID = config.get(config.CATEGORY_BLOCK, "LightWoodPlanks", IDRef.LIGHT_WOOD_PLANKS_IDD).getInt();
		IDRef.LIGHT_ORE_ID = config.get(config.CATEGORY_BLOCK, "Light Ore", IDRef.LIGHT_ORE_IDD).getInt();
		IDRef.LIGHT_ORE_STONE_ID = config.get(config.CATEGORY_BLOCK, "Light Ore Stone", IDRef.LIGHT_ORE_STONE_IDD).getInt();
		IDRef.STABILIZER_ID = config.get(config.CATEGORY_BLOCK, "Stabilizer", IDRef.STABILIZER_IDD).getInt();
		
		
		// items
		IDRef.ABS_INGOT_ID = config.get(config.CATEGORY_ITEM, "AbsIngot", IDRef.ABS_INGOT_IDD).getInt();
		IDRef.ABS_ROD_ID = config.get(config.CATEGORY_ITEM, "AbsRod", IDRef.ABS_ROD_IDD).getInt();
		IDRef.DARK_BALL_ID = config.get(config.CATEGORY_ITEM, "DarkBall", IDRef.DARK_BALL_IDD).getInt();
		IDRef.DARK_INGOT_ID = config.get(config.CATEGORY_ITEM, "DarkIngot", IDRef.DARK_INGOT_IDD).getInt();
		IDRef.LIGHT_BALL_ID = config.get(config.CATEGORY_ITEM, "LightBall", IDRef.LIGHT_BALL_IDD).getInt();
		IDRef.LIGHT_INGOT_ID = config.get(config.CATEGORY_ITEM, "LightIngot", IDRef.LIGHT_INGOT_IDD).getInt();
		IDRef.UNSTABLE_ABS_ID = config.get(config.CATEGORY_ITEM, "UnstableAbs", IDRef.UNSTABLE_ABS_IDD).getInt();
		IDRef.LIGHT_SWORD_ID = config.get(config.CATEGORY_ITEM, "LightSword", IDRef.LIGHT_SWORD_IDD).getInt();
		IDRef.LIGHT_PICKAXE_ID = config.get(config.CATEGORY_ITEM, "LightPickaxe", IDRef.LIGHT_PICKAXE_IDD).getInt();
		IDRef.LIGHT_SHOVEL_ID = config.get(config.CATEGORY_ITEM, "LightShovel", IDRef.LIGHT_SHOVEL_IDD).getInt();
		IDRef.LIGHT_AXE_ID = config.get(config.CATEGORY_ITEM, "LightAxe", IDRef.LIGHT_AXE_IDD).getInt();
		IDRef.LIGHT_HOE_ID = config.get(config.CATEGORY_ITEM, "LightHoe", IDRef.LIGHT_HOE_IDD).getInt();
		IDRef.DARK_SWORD_ID = config.get(config.CATEGORY_ITEM, "DarkSword", IDRef.DARK_SWORD_IDD).getInt();
		IDRef.DARK_PICKAXE_ID = config.get(config.CATEGORY_ITEM, "DarkPickaxe", IDRef.DARK_PICKAXE_IDD).getInt();
		IDRef.DARK_SHOVEL_ID = config.get(config.CATEGORY_ITEM, "DarkShovel", IDRef.DARK_SHOVEL_IDD).getInt();
		IDRef.DARK_AXE_ID = config.get(config.CATEGORY_ITEM, "DarkAxe", IDRef.DARK_AXE_IDD).getInt();
		IDRef.DARK_HOE_ID = config.get(config.CATEGORY_ITEM, "DarkHoe", IDRef.DARK_HOE_IDD).getInt();
		config.save();

		proxy.registerRenderThings();
		proxy.registerServerTickHandler();
		GameRegistry.registerWorldGenerator(new WorldGeneration());
		MinecraftForge.EVENT_BUS.register(new Events());
		ItemTab.InitTab();
		BlockTab.InitTab();
		LPBlocks.InitBlocks();
		LPItems.InitItems();
		Recipes.InitRecipes();
		Tiles.registerTiles();
		ExtractionList.setList();
	}

}
