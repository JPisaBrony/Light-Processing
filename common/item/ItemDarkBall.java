package LightProcessing.common.item;

import LightProcessing.common.lib.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class ItemDarkBall extends Item {

	public ItemDarkBall(int par1) {
		super(par1);
		this.setUnlocalizedName("DarkBall");
		this.setCreativeTab(ItemTab.itemTab);
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.epic;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}

	public boolean onItemUse(ItemStack ItemStack, EntityPlayer Player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if(Methods.useItem(Player, IDRef.DARK_BALL_ID)) {
			if (world.getBlockId(par4, par5, par6) != 0) {				
				world.setLightValue(EnumSkyBlock.Block, par4 + 1, par5, par6, 0);
				world.setLightValue(EnumSkyBlock.Block, par4 - 1, par5, par6, 0);
				world.setLightValue(EnumSkyBlock.Block, par4, par5 + 1, par6, 0);
				world.setLightValue(EnumSkyBlock.Block, par4, par5 - 1, par6, 0);
				world.setLightValue(EnumSkyBlock.Block, par4, par5, par6 + 1, 0);
				world.setLightValue(EnumSkyBlock.Block, par4, par5, par6 - 1, 0);
				
				world.setLightValue(EnumSkyBlock.Sky, par4 + 1, par5, par6, 0);
				world.setLightValue(EnumSkyBlock.Sky, par4 - 1, par5, par6, 0);
				world.setLightValue(EnumSkyBlock.Sky, par4, par5 + 1, par6, 0);
				world.setLightValue(EnumSkyBlock.Sky, par4, par5 - 1, par6, 0);
				world.setLightValue(EnumSkyBlock.Sky, par4, par5, par6 + 1, 0);
				world.setLightValue(EnumSkyBlock.Sky, par4, par5, par6 - 1, 0);
				return true;
			}
		}
		return false;
	}

}