package LightProcessing.common.lightProcessing.item;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import LightProcessing.common.lib.Blocks;
import LightProcessing.common.lib.IDRef;
import LightProcessing.common.lib.ItemTab;
import LightProcessing.common.lib.Methods;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDarkAxe extends ItemAxe{

	public ItemDarkAxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setUnlocalizedName("DarkAxe");
		this.setCreativeTab(ItemTab.itemTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10) {
		if(player.isSneaking()) {
			if(world.getWorldTime() > 12500) {
				if(!Methods.lightCheck(world, x, y, z, 7)) {
					if(Methods.hasItem(player, IDRef.DARK_BALL_ID)) {
						int id = world.getBlockId(x, y, z);
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
				        if((id == Block.leaves.blockID || id == Block.wood.blockID) && id != 0) {
							for(i = isizeNS; i <= isizeEW; i++) {
								for(j = jsizeNS; j <= jsizeEW; j++) {
									for(k = ksizeNS; k <= ksizeEW; k++) {
										id = world.getBlockId(x + i, y + j, z + k);
										if((id == Block.leaves.blockID || id == Block.wood.blockID) && id != 0) {
											world.setBlock(x + i, y + j, z + k, 0);
										}
									}
								}
							}
							Methods.useItem(player, IDRef.DARK_BALL_ID);
						}
					}
				}
			}
		}
		return false;
	}
	
}
