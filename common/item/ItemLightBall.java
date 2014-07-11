package LightProcessing.common.item;

import LightProcessing.common.lib.*;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraftforge.event.world.ChunkWatchEvent;

public class ItemLightBall extends Item {

	public ItemLightBall(int par1) {
		super(par1);
		this.setUnlocalizedName("LightBall");
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
		if(Methods.useItem(Player, IDRef.LIGHT_BALL_ID)) {
			if (world.getBlockId(par4, par5, par6) != 0) {				
				world.setLightValue(EnumSkyBlock.Block, par4 + 1, par5, par6, 15);
				world.setLightValue(EnumSkyBlock.Block, par4 - 1, par5, par6, 15);
				world.setLightValue(EnumSkyBlock.Block, par4, par5 + 1, par6, 15);
				world.setLightValue(EnumSkyBlock.Block, par4, par5 - 1, par6, 15);
				world.setLightValue(EnumSkyBlock.Block, par4, par5, par6 + 1, 15);
				world.setLightValue(EnumSkyBlock.Block, par4, par5, par6 - 1, 15);
				
				world.setLightValue(EnumSkyBlock.Sky, par4 + 1, par5, par6, 15);
				world.setLightValue(EnumSkyBlock.Sky, par4 - 1, par5, par6, 15);
				world.setLightValue(EnumSkyBlock.Sky, par4, par5 + 1, par6, 15);
				world.setLightValue(EnumSkyBlock.Sky, par4, par5 - 1, par6, 15);
				world.setLightValue(EnumSkyBlock.Sky, par4, par5, par6 + 1, 15);
				world.setLightValue(EnumSkyBlock.Sky, par4, par5, par6 - 1, 15);
				return true;
			}
		}
		return false;
	}

}