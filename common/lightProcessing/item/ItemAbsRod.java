package LightProcessing.common.lightProcessing.item;

import LightProcessing.common.lib.*;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.World;

public class ItemAbsRod extends Item {

	public ItemAbsRod(int par1) {
		super(par1);
		this.setUnlocalizedName("AbsRod");
		this.setCreativeTab(ItemTab.itemTab);
		this.setMaxDamage(50);
		this.maxStackSize = 1;
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

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if(par3World.getBlockId(par4, par5, par6) == Block.blockIron.blockID) {
			WorldCrafting machineCore = new WorldCrafting();
			WorldCraftingRecipeCollection recipe = machineCore.dictionary.get(Block.blockIron.blockID);
			for(int i = 0; i < recipe.getCount(); i++)
				if(Methods.checkRecipe(par3World, par4, par5, par6, recipe.get(i)))
					return true;
			return false;
		}
		if (!par3World.isRemote) {
			int essence = ExtractionList.getEssence(par3World, par4, par5, par6);
			if (essence > 0) {
				par2EntityPlayer.addChatMessage("Worth " + Integer.toString(essence) + " light essence.");
			}
			else if (essence < 0)
				par2EntityPlayer.addChatMessage("Worth " + Integer.toString(essence * -1) + " dark essence.");
			else
				par2EntityPlayer.addChatMessage("Worth 0 essence.");
			par2EntityPlayer.addChatMessage(Integer.toString(par3World.getBlockMetadata(par4, par5, par6)));
			par1ItemStack.useItemRightClick(par3World, par2EntityPlayer);
			par1ItemStack.damageItem(1, par2EntityPlayer);
			return true;
		}
		return false;
	}
	
}