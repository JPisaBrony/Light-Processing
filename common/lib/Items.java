package lib;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

public class Items {

	
	
	public static Item ItemDarkBall;
	public static Item ItemLightBall;
	public static Item ItemDarkIngot;
	public static Item ItemLightIngot;
	public static Item ItemAbsIngot;
	public static Item ItemUnstableAbs;
	public static Item ItemAbsRod;
	
	public static void InitItems(){
		ItemDarkBall = (new lightProcessing.item.ItemDarkBall(3001));
		ItemLightBall = (new lightProcessing.item.ItemLightBall(3002));
		ItemDarkIngot = (new lightProcessing.item.ItemDarkIngot(3003));
		ItemLightIngot = (new lightProcessing.item.ItemLightIngot(3004));
		ItemUnstableAbs = (new lightProcessing.item.ItemUnstableAbs(3005));
		ItemAbsIngot = (new lightProcessing.item.ItemAbsIngot(3006));
		ItemAbsRod = (new lightProcessing.item.ItemAbsRod(3007));
	
		LanguageRegistry.addName(ItemDarkBall,  "Darkness Essence");
		LanguageRegistry.addName(ItemLightBall, "Light Essence");
		LanguageRegistry.addName(ItemDarkIngot, "Darkness Ingot");
		LanguageRegistry.addName(ItemLightIngot, "Light Ingot");
		LanguageRegistry.addName(ItemAbsIngot, "Stabilized Absolution");
		LanguageRegistry.addName(ItemUnstableAbs, "Unstable Absolution");
		LanguageRegistry.addName(ItemAbsRod, "Absolution Rod");
	
	}
	
}
