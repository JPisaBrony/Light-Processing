package LightProcessing.common.lightProcessing.item;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import LightProcessing.common.lib.IDRef;
import LightProcessing.common.lib.ItemTab;
import LightProcessing.common.lib.Methods;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDarkPickaxe extends ItemPickaxe {
	
	public ItemDarkPickaxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setUnlocalizedName("DarkPickaxe");
		this.setCreativeTab(ItemTab.itemTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		int i = 0, j = 0, k = 0, id, isizeNS = 0, isizeEW = 0, jsizeNS = 0, jsizeEW = 0, ksizeNS = 0, ksizeEW = 0;
		id = world.getBlockId(par4, par5, par6);
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
					if(!(id == Block.dirt.blockID || id == Block.sand.blockID || id == Block.gravel.blockID || id == Block.slowSand.blockID) && id != 0) {
						for(i = isizeNS; i <= isizeEW; i++) {
							for(j = jsizeNS; j <= jsizeEW; j++) {
								for(k = ksizeNS; k <= ksizeEW; k++) {
									id = world.getBlockId(par4 + i, par5 + j, par6 + k);
									if(id == Block.bedrock.blockID)
										continue;
									if(!(id == Block.dirt.blockID || id == Block.sand.blockID || id == Block.gravel.blockID || id == Block.slowSand.blockID) && id != 0)
										world.setBlock(par4 + i, par5 + j, par6 + k, 0);
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
