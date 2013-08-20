package lightProcessing.item;

import lib.Methods;
import lib.Reference;
import lightProcessing.LightProcessing;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemLightIngot extends Item{
	public ItemLightIngot(int par1){
	super(par1);
	this.setUnlocalizedName("LightIngot");
	this.setCreativeTab(lib.ItemTab.itemTab);
	}
	@Override
	public boolean hasEffect(ItemStack par1ItemStack){
		return true;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack){
		return EnumRarity.epic;
	}
	
	  @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister iconRegister)
	    {
		  itemIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}
	}