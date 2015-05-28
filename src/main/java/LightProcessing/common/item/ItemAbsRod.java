package LightProcessing.common.item;

import LightProcessing.common.lib.*;
import LightProcessing.common.worldCrafting.WorldCrafting;
import LightProcessing.common.worldCrafting.WorldCraftingRecipeCollection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class ItemAbsRod extends Item {

	public ItemAbsRod() {
		super();
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
	public void registerBlockIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
		if(world.getBlock(x, y, z) == Blocks.iron_block || world.getBlock(x, y, z) == Blocks.diamond_block) {
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
							ItemStack theItemStack = new ItemStack(LPItems.ItemLightPickaxe);
							theItemStack.stackTagCompound = new NBTTagCompound();
							theItemStack.getTagCompound().setString("color", "white");
							theItemStack.getTagCompound().setInteger("mode", 1);
							EntityItem theEntityItem = new EntityItem(world, x, y + 1, z, theItemStack);
							if(!world.isRemote)
								world.spawnEntityInWorld(theEntityItem);
							break;
						case 1:
							Methods.spawnItemInWorld(world, x, y, z, LPItems.ItemLightAxe);
							break;
						case 2:
							Methods.spawnItemInWorld(world, x, y, z, LPItems.ItemLightHoe);
							break;
						case 3:
							Methods.spawnItemInWorld(world, x, y, z, LPItems.ItemLightShovel);
							break;
						case 4:
							Methods.spawnItemInWorld(world, x, y, z, LPItems.ItemLightSword);
							break;
						case 5:
							Methods.spawnItemInWorld(world, x, y, z, LPItems.ItemDarkPickaxe);
							break;
						case 6:
							Methods.spawnItemInWorld(world, x, y, z, LPItems.ItemDarkAxe);
							break;
						case 7:
							Methods.spawnItemInWorld(world, x, y, z, LPItems.ItemDarkHoe);
							break;
						case 8:
							Methods.spawnItemInWorld(world, x, y, z, LPItems.ItemDarkShovel);
							break;
						case 9:
							Methods.spawnItemInWorld(world, x, y, z, LPItems.ItemDarkSword);
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
			par1ItemStack.useItemRightClick(world, par2EntityPlayer);
			par1ItemStack.damageItem(1, par2EntityPlayer);
			return true;
		}
		return false;
	}
	
}