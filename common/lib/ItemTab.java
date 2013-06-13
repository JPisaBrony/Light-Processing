package lib;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ItemTab extends CreativeTabs{
	public ItemTab(String label) {
		super(label);
	}
	public static CreativeTabs itemTab;
	
	@Override
	public ItemStack getIconItemStack(){
		return new ItemStack(lib.Items.ItemUnstableAbs);
	}
	
	
	public static void InitTab(){
		itemTab = new ItemTab("itemTab");
		LanguageRegistry.instance().addStringLocalization("itemGroup.itemTab", "en_US", "Light Processing Items");
	}
	
}
