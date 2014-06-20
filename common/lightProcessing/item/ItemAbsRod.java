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

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
		if(world.getBlockId(x, y, z) == Block.blockIron.blockID || world.getBlockId(x, y, z) == Block.blockDiamond.blockID) {
			int i;
			WorldCrafting crafting = new WorldCrafting();
			WorldCraftingRecipeCollection recipe = crafting.dictionary.get(Block.blockIron.blockID);
			WorldCraftingRecipeCollection recipe2 = crafting.dictionary.get(Block.blockDiamond.blockID);
			for(i = 0; i < recipe.getCount(); i++) {
				if(Methods.checkRecipe(world, x, y, z, recipe.get(i)))
					return true;
				}
				for(i = 0; i < recipe2.getCount(); i++) {
					if(Methods.checkRecipe(world, x, y, z, recipe2.get(i))) {
						switch(i) {
						case 0:
							ItemStack theItemStack = new ItemStack(Items.ItemLightPickaxe);
							theItemStack.stackTagCompound = new NBTTagCompound();
							theItemStack.getTagCompound().setString("color", "white");
							theItemStack.getTagCompound().setInteger("mode", 1);
							EntityItem theEntityItem = new EntityItem(world, x, y + 1, z, theItemStack);
							if(!world.isRemote)
								world.spawnEntityInWorld(theEntityItem);
							break;
						case 1:
							Methods.spawnItemInWorld(world, x, y, z, Items.ItemLightAxe);
							break;
						case 2:
							Methods.spawnItemInWorld(world, x, y, z, Items.ItemLightHoe);
							break;
						case 3:
							Methods.spawnItemInWorld(world, x, y, z, Items.ItemLightShovel);
							break;
						case 4:
							Methods.spawnItemInWorld(world, x, y, z, Items.ItemLightSword);
							break;
						case 5:
							Methods.spawnItemInWorld(world, x, y, z, Items.ItemDarkPickaxe);
							break;
						case 6:
							Methods.spawnItemInWorld(world, x, y, z, Items.ItemDarkAxe);
							break;
						case 7:
							Methods.spawnItemInWorld(world, x, y, z, Items.ItemDarkHoe);
							break;
						case 8:
							Methods.spawnItemInWorld(world, x, y, z, Items.ItemDarkShovel);
							break;
						case 9:
							Methods.spawnItemInWorld(world, x, y, z, Items.ItemDarkSword);
							break;
						default:
							break;
					}
					return true;
				}
			}
			return false;
		}
		if (!world.isRemote) {
			int essence = ExtractionList.getEssence(world, x, y, z);
			if (essence > 0) {
				par2EntityPlayer.addChatMessage("Worth " + Integer.toString(essence) + " light essence.");
			}
			else if (essence < 0)
				par2EntityPlayer.addChatMessage("Worth " + Integer.toString(essence * -1) + " dark essence.");
			else
				par2EntityPlayer.addChatMessage("Worth 0 essence.");
			par2EntityPlayer.addChatMessage(Integer.toString(world.getBlockMetadata(x, y, z)));
			par1ItemStack.useItemRightClick(world, par2EntityPlayer);
			par1ItemStack.damageItem(1, par2EntityPlayer);
			return true;
		}
		return false;
	}
	
}