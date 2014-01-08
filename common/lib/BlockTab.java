package LightProcessing.common.lib;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BlockTab extends CreativeTabs {
	public BlockTab(String label) {
		super(label);
	}

	public static CreativeTabs blockTab;

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(LightProcessing.common.lib.Blocks.BlockAbsBlock);
	}

	public static void InitTab() {
		blockTab = new BlockTab("blockTab");
		LanguageRegistry.instance().addStringLocalization("itemGroup.blockTab",
				"en_US", "Light Processing Blocks");
	}

}