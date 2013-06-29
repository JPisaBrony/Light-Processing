package lightProcessing;

import net.minecraftforge.common.Configuration;
import lib.BlockTab;
import lib.IDRef;
import lib.ItemTab;
import lib.Reference;
import lightProcessing.network.CommonProxy;
import lightProcessing.tile.TileEntityAbsComp;
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

@Mod(
		modid = Reference.MOD_ID,
		name = Reference.NAME, 
		version = Reference.VERSION)

@NetworkMod(clientSideRequired = true, serverSideRequired = false)



public class LightProcessing {

	@Instance("LightProcessing")
	public static LightProcessing instance;
	
	@SidedProxy(clientSide="lightProcessing.network.ClientProxy", serverSide="lightProcessing.network.CommonProxy")
	public static CommonProxy proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event){
		
		ItemTab.InitTab();
		BlockTab.InitTab();
		lib.Blocks.InitBlocks();
		lib.Items.InitItems();
		lib.Recipes.InitRecipes();
		lib.Tiles.registerTiles();
		
		 proxy.registerRenderThings();
         GameRegistry.registerTileEntity(TileEntityAbsComp.class, "tileEntityAbsComp");
         
		
		
		
	}
	
	@Init
	public void load(FMLInitializationEvent event){
		
	}
	
	@PostInit
	public void PostInit(FMLInitializationEvent event){
		
	}
	
	
}
