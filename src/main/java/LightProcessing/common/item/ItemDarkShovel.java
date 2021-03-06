package LightProcessing.common.item;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import LightProcessing.common.lib.IDRef;
import LightProcessing.common.lib.ItemTab;
import LightProcessing.common.lib.Methods;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDarkShovel extends ItemSpade {
	
	public ItemDarkShovel(EnumToolMaterial EnumToolMaterial) {
		super(par2EnumToolMaterial);
		this.setUnlocalizedName("DarkShovel");
		this.setCreativeTab(ItemTab.itemTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		int i = 0, j = 0, k = 0, isizeNS = 0, isizeEW = 0, jsizeNS = 0, jsizeEW = 0, ksizeNS = 0, ksizeEW = 0;
		Block id = world.getBlock(par4, par5, par6);
		if(world.getWorldTime() > 12500) {
			if(!Methods.lightCheck(world, par4, par5, par6, 7)) {
				if(Methods.hasItem(player, IDRef.DARK_BALL_ID)) {
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
					if((id == Blocks.dirt || id == Blocks.sand || id == Blocks.gravel) && id != Blocks.air) {
						for(i = isizeNS; i <= isizeEW; i++) {
							for(j = jsizeNS; j <= jsizeEW; j++) {
								for(k = ksizeNS; k <= ksizeEW; k++) {
									id = world.getBlock(par4 + i, par5 + j, par6 + k);
									if((id == Blocks.dirt || id == Blocks.sand || id == Blocks.gravel) && id != Blocks.air) {
										world.setBlockToAir(par4 + i, par5 + j, par6 + k);
									}
								}
							}
						}
						Methods.useItem(player, IDRef.DARK_BALL_ID);
					}
					else
						return false;
				}
			}
		}
		return true;
	}
	
}
