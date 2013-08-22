package LightProcessing.common.lightProcessing.item;

import LightProcessing.common.lib.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemLightBall extends Item{
	public ItemLightBall(int par1){
	super(par1);
	this.setUnlocalizedName("LightBall");
	this.setCreativeTab(ItemTab.itemTab);
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