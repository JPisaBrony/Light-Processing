package LightProcessing.common.item;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import LightProcessing.common.lib.LPBlocks;
import LightProcessing.common.lib.IDRef;
import LightProcessing.common.lib.ItemTab;
import LightProcessing.common.lib.Methods;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLightAxe extends ItemAxe{
	
	public ItemLightAxe(EnumToolMaterial EnumToolMaterial) {
		super(EnumToolMaterial);
		this.setUnlocalizedName("LightAxe");
		this.setCreativeTab(ItemTab.itemTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		if(player.isSneaking()) {
			if(world.getWorldTime() < 12500) {
				if(Methods.lightCheck(world, x, y, z, 7)) {
					if(Methods.hasItem(player, IDRef.LIGHT_BALL_IDD)) {
						B;pck id = world.getBlock(x, y, z);
						int isizeNS = 0, isizeEW = 0, jsizeNS = 0, jsizeEW = 0, ksizeNS = 0, ksizeEW = 0, i, j, k;
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
				        if (player instanceof EntityPlayerMP) {
				        	((EntityPlayerMP)player).theItemInWorldManager.setBlockReachDistance(6.0D);
				        }
						if(id == Block.wood.blockID && id != 0) {
							for(i = isizeNS; i <= isizeEW; i++) {
								for(j = jsizeNS; j <= jsizeEW; j++) {
									for(k = ksizeNS; k <= ksizeEW; k++) {
										id = world.getBlock(x + i, y + j, z + k);
										if((id == Block.leaves.blockID || id == Block.wood.blockID) && id != 0) {
											Block block = Block.blocksList[id];
											if(block.isLeaves(world, x + i, y + j, z + k)) {
												world.setBlock(x + i, y + j, z + k, 0);
												continue;
											}
											ArrayList<ItemStack> item = block.getBlockDropped(world, x + i, y + j, z + k, 0, 0);
											if(item.isEmpty())
												continue;
											ItemStack itemBlock = item.get(0);
											EntityItem entityBlock = new EntityItem(world, x + i, y + j, z + k, itemBlock);
											if (!world.isRemote)
												world.spawnEntityInWorld(entityBlock);
											world.setBlock(x + i, y + j, z + k, 0);
										}
									}
								}
							}
							Methods.useItem(player, IDRef.LIGHT_BALL_ID);
							return true;
						}
						if(id == LPBlocks.BlockDarkLeaf) {
							if(Methods.spawnItemFromBlockandRemove(world, x, y, z, LPBlocks.BlockLightTreeSapling, 1, 0)) {
								Methods.useItem(player, IDRef.LIGHT_BALL_ID);
								return true;
							}
						}
						if(id == Blocks.leaves) {
							int meta = world.getBlockMetadata(x, y, z);
							switch(meta & 3) {
								case 0:
									Methods.spawnItemFromBlockandRemove(world, x, y, z, Blocks.sapling, 1, 0);
									Methods.useItem(player, IDRef.LIGHT_BALL_ID);
									break;
								case 1:
									Methods.spawnItemFromBlockandRemove(world, x, y, z, Blocks.sapling, 1, 1);
									Methods.useItem(player, IDRef.LIGHT_BALL_ID);
									break;
								case 2:
									Methods.spawnItemFromBlockandRemove(world, x, y, z, Blocks.sapling, 1, 2);
									Methods.useItem(player, IDRef.LIGHT_BALL_ID);
									break;
								case 3:
									Methods.spawnItemFromBlockandRemove(world, x, y, z, Blocks.sapling, 1, 3);
									Methods.useItem(player, IDRef.LIGHT_BALL_ID);
									break;
							default:
								return false;
							}
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
