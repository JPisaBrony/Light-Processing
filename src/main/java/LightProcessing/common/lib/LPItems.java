package LightProcessing.common.lib;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import LightProcessing.common.item.*;

public class LPItems {

	public static Item ItemDarkBall;
	public static Item ItemLightBall;
	public static Item ItemDarkIngot;
	public static Item ItemLightIngot;
	public static Item ItemAbsIngot;
	public static Item ItemUnstableAbs;
	public static Item ItemAbsRod;
	public static Item ItemDarkBucketEmpty;
	public static Item ItemDarkBucketFull;
	public static Item ItemLightSword;
	public static Item ItemLightPickaxe;
	public static Item ItemLightShovel;
	public static Item ItemLightAxe;
	public static Item ItemLightHoe;
	public static Item ItemDarkSword;
	public static Item ItemDarkPickaxe;
	public static Item ItemDarkShovel;
	public static Item ItemDarkAxe;
	public static Item ItemDarkHoe;

	public static void InitItems() {
		ItemDarkBall = new ItemDarkBall();
		ItemLightBall = new ItemLightBall();
		ItemDarkIngot = new ItemDarkIngot();
		ItemLightIngot = new ItemLightIngot();
		ItemUnstableAbs = new ItemUnstableAbs();
		ItemAbsIngot = new ItemAbsIngot();
		ItemAbsRod = new ItemAbsRod();
		ItemDarkBucketEmpty = new ItemDarkBucket(0).setUnlocalizedName("dark_bucket_empty");
		ItemDarkBucketFull = (new ItemDarkBucket(IDRef.DARK_BUCKET_FULL_IDD, Block.waterMoving.blockID).setUnlocalizedName("dark_bucket_water").setContainerItem(ItemDarkBucketEmpty));
		ItemLightSword = (new ItemLightSword(IDRef.LIGHT_SWORD_ID, IDRe));
		ItemLightPickaxe = (new ItemLightPickaxe(IDRef.LIGHT_PICKAXE_ID, IDRef.light));
		ItemLightShovel = (new ItemLightShovel(IDRef.LIGHT_SHOVEL_ID, IDRef.light));
		ItemLightAxe = (new ItemLightAxe(IDRef.LIGHT_AXE_ID, IDRef.light));
		ItemLightHoe = new ItemLightHoe();
		ItemDarkSword = (new ItemDarkSword(IDRef.DARK_SWORD_ID, IDRef.dark));
		ItemDarkPickaxe = (new ItemDarkPickaxe(IDRef.DARK_PICKAXE_ID, IDRef.dark));
		ItemDarkShovel = (new ItemDarkShovel(IDRef.DARK_SHOVEL_ID, IDRef.dark));
		ItemDarkAxe = (new ItemDarkAxe(IDRef.DARK_AXE_ID, IDRef.dark));
		ItemDarkHoe = (new ItemDarkHoe(IDRef.DARK_HOE_ID, IDRef.dark));
		
		LanguageRegistry.addName(ItemDarkBall, "Darkness Essence");
		LanguageRegistry.addName(ItemLightBall, "Light Essence");
		LanguageRegistry.addName(ItemDarkIngot, "Darkness Ingot");
		LanguageRegistry.addName(ItemLightIngot, "Light Ingot");
		LanguageRegistry.addName(ItemAbsIngot, "Stabilized Absolution");
		LanguageRegistry.addName(ItemUnstableAbs, "Unstable Absolution");
		LanguageRegistry.addName(ItemAbsRod, "Absolution Rod");
		LanguageRegistry.addName(ItemDarkBucketEmpty, "Empty Dark Bucket");
		LanguageRegistry.addName(ItemDarkBucketFull, "Water Dark Bucket");
		LanguageRegistry.addName(ItemLightSword, "Light Sword");
		LanguageRegistry.addName(ItemLightPickaxe, "Light Pickaxe");
		LanguageRegistry.addName(ItemLightShovel, "Light Shovel");
		LanguageRegistry.addName(ItemLightAxe, "Light Axe");
		LanguageRegistry.addName(ItemLightHoe, "Light Hoe");
		LanguageRegistry.addName(ItemDarkSword, "Dark Sword");
		LanguageRegistry.addName(ItemDarkPickaxe, "Dark Pickaxe");
		LanguageRegistry.addName(ItemDarkShovel, "Dark Shovel");
		LanguageRegistry.addName(ItemDarkAxe, "Dark Axe");
		LanguageRegistry.addName(ItemDarkHoe, "Dark Hoe");
	}

}
