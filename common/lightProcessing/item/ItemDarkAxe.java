package LightProcessing.common.lightProcessing.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import LightProcessing.common.lib.ItemTab;
import LightProcessing.common.lib.Methods;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDarkAxe extends ItemAxe{

	public ItemDarkAxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setUnlocalizedName("DarkAxe");
		this.setCreativeTab(ItemTab.itemTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}
	
}
