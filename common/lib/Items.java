package lib;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
		ItemDarkBall = (new lightProcessing.item.ItemDarkBall(IDRef.DARK_BALL_ID));
		ItemLightBall = (new lightProcessing.item.ItemLightBall(IDRef.LIGHT_BALL_ID));
		ItemDarkIngot = (new lightProcessing.item.ItemDarkIngot(IDRef.DARK_INGOT_ID));
		ItemLightIngot = (new lightProcessing.item.ItemLightIngot(IDRef.LIGHT_INGOT_ID));
		ItemUnstableAbs = (new lightProcessing.item.ItemUnstableAbs(IDRef.UNSTABLE_ABS_ID));
		ItemAbsIngot = (new lightProcessing.item.ItemAbsIngot(IDRef.ABS_INGOT_ID));
		ItemAbsRod = (new lightProcessing.item.ItemAbsRod(IDRef.ABS_ROD_ID));
	
		LanguageRegistry.addName(ItemDarkBall,  "Darkness Essence");
		LanguageRegistry.addName(ItemLightBall, "Light Essence");
		LanguageRegistry.addName(ItemDarkIngot, "Darkness Ingot");
		LanguageRegistry.addName(ItemLightIngot, "Light Ingot");
		LanguageRegistry.addName(ItemAbsIngot, "Stabilized Absolution");
		LanguageRegistry.addName(ItemUnstableAbs, "Unstable Absolution");
		LanguageRegistry.addName(ItemAbsRod, "Absolution Rod");
	
	}
	
}
