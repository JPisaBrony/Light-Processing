package LightProcessing.common.lightProcessing.item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet15Place;
import net.minecraft.util.Direction;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.World;
import LightProcessing.common.lib.*;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLightPickaxe extends ItemPickaxe {
	
	public ItemLightPickaxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setUnlocalizedName("LightPickaxe");
		this.setCreativeTab(ItemTab.itemTab);
	}
	
	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean bool)
    {
		if (itemstack.stackTagCompound == null) {
			itemstack.stackTagCompound = new NBTTagCompound();
			itemstack.getTagCompound().setString("color", "white");
			itemstack.getTagCompound().setInteger("mode", 1);
			itemstack.getTagCompound().setBoolean("flag", true);
		}
    }

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(!world.isRemote) {
			if(player.isSneaking()) {
				int mode = itemstack.getTagCompound().getInteger("mode");
				mode++;
				if(mode > 3)
					mode = 1;
				switch(mode) {
					case 1:
						itemstack.getTagCompound().setString("color", "white");
						break;
					case 2:
						itemstack.getTagCompound().setString("color", "gold");
						break;
					case 3:
						itemstack.getTagCompound().setString("color", "purple");
						break;
				}
				getColorFromItemStack(itemstack, 0);
				itemstack.getTagCompound().setInteger("mode", mode);
			}
		}
		return itemstack;
	}
	
	
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemstack, int par2){
		if (itemstack.stackTagCompound != null) {
			String color = itemstack.getTagCompound().getString("color");
			if(color == "white")
				return 0xffffff;
			else if(color == "gold")
				return 0xffed97;
			else if(color == "purple")
				return 0xbb63ff;
		}
		return 0xffffff;
	}
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if(player.isSneaking())
			return false;
		int mode = itemstack.getTagCompound().getInteger("mode");
		switch(mode) {
			case 1:
				return mode1(player, world, par4, par5, par6, par7, itemstack);
			case 2:
				return mode2(player, world, par4, par5, par6);
			case 3:
				return mode3(player, world);
			default:
				return false;
		}
	}
	
	public boolean mode1(EntityPlayer player, World world, int par4, int par5, int par6, int par7, ItemStack itemstack) {
		int i = 0, j = 0, k = 0, id, isizeNS = 0, isizeEW = 0, jsizeNS = 0, jsizeEW = 0, ksizeNS = 0, ksizeEW = 0;
		id = world.getBlockId(par4, par5, par6);
		if(world.getWorldTime() < 12500) {
			if(Methods.lightCheck(world, par4, par5, par6, 7)) {
				if(Methods.hasItem(player, IDRef.LIGHT_BALL_IDD)) {
					switch(par7) {
						case 5:
							isizeNS = -2;
							isizeEW = 0;
							jsizeNS = -1;
							jsizeEW = 1;
							ksizeNS = -1;
							ksizeEW = 1;
							break;
						case 4:
							isizeNS = 0;
							isizeEW = 2;
							jsizeNS = -1;
							jsizeEW = 1;
							ksizeNS = -1;
							ksizeEW = 1;
							break;
						case 3:
							isizeNS = -1;
							isizeEW = 1;
							jsizeNS = -1;
							jsizeEW = 1;
							ksizeNS = -2;
							ksizeEW = 0;
							break;
						case 2:
							isizeNS = -1;
							isizeEW = 1;
							jsizeNS = -1;
							jsizeEW = 1;
							ksizeNS = 0;
							ksizeEW = 2;
							break;
						case 1:
							isizeNS = -1;
							isizeEW = 1;
							jsizeNS = -2;
							jsizeEW = 0;
							ksizeNS = -1;
							ksizeEW = 1;
							break;
						case 0:
							isizeNS = -1;
							isizeEW = 1;
							jsizeNS = 0;
							jsizeEW = 2;
							ksizeNS = -1;
							ksizeEW = 1;
							break;
					}
					if((id == Block.cobblestone.blockID || id == Block.stone.blockID || id == Block.sandStone.blockID) && id != 0) {
						for(i = isizeNS; i <= isizeEW; i++) {
							for(j = jsizeNS; j <= jsizeEW; j++) {
								for(k = ksizeNS; k <= ksizeEW; k++) {
									id = world.getBlockId(par4 + i, par5 + j, par6 + k);
									if((id == Block.cobblestone.blockID || id == Block.stone.blockID || id == Block.sandStone.blockID) && id != 0) {
										Block block = Block.blocksList[id];
										ArrayList<ItemStack> item = block.getBlockDropped(world, par4 + i, par5 + j, par6 + k, 0, 0);
										if(item.isEmpty())
											continue;
										ItemStack itemBlock = item.get(0);
										EntityItem entityBlock = new EntityItem(world, par4 + i, par5 + j, par6 + k, itemBlock);
										if (!world.isRemote)
											world.spawnEntityInWorld(entityBlock);
										world.setBlock(par4 + i, par5 + j, par6 + k, 0);
									}
								}
							}
						}
						Methods.useItem(player, IDRef.LIGHT_BALL_ID);
					}
					else
						return false;
				}
			}
		}
		return true;
	}
	
	public boolean mode2(EntityPlayer player, World world, int par4, int par5, int par6) {
		if(Methods.lightCheck(world, par4, par5, par6, 7)) {
			if(Methods.useItem(player, IDRef.LIGHT_BALL_IDD)) {
				int id = world.getBlockId(par4, par5, par6);
				if(id == Block.bedrock.blockID)
					return false;
				Block block = Block.blocksList[id];
				ItemStack item = new ItemStack(block, 1);
				EntityItem entityBlock = new EntityItem(world, par4, par5, par6, item);
				if (!world.isRemote)
					world.spawnEntityInWorld(entityBlock);
				world.setBlock(par4, par5, par6, 0);
				return true;
			}
		}
		return true;
	}
	
	public boolean mode3(EntityPlayer player, World world) {
		if(!world.isRemote)
			player.addChatMessage("Twilight Sparkle is best Pony");
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}
	
}
