package LightProcessing.common.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import LightProcessing.common.lib.IDRef;
import LightProcessing.common.lib.ItemTab;
import LightProcessing.common.lib.Methods;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDarkSword extends ItemSword {
	
	public ItemDarkSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setUnlocalizedName("DarkSword");
		this.setCreativeTab(ItemTab.itemTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(player.isSneaking()) {
			if(world.getWorldTime() > 12500) {
				if(!Methods.lightCheck(world, (int)player.posX, (int)player.posY, (int)player.posZ, 7)) {
					if(Methods.hasItem(player, IDRef.DARK_BALL_ID)) {
						int direction = MathHelper.floor_double((double)((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;
						if(player.rotationPitch > 45)
							direction = 4;
						if(player.rotationPitch < -45)
							direction = 5;
						int i = 0, j = 0, k = 0, id, xNS = 0, yNS = -1, zNS = 0, xEW = 0, yEW = 2, zEW = 0;
						switch(direction) {
							case 2:
								xNS = -1;
								zNS = -3;
								zEW = -1;
								xEW = 1;
								break;
							case 0:
								xNS = -1;
								zNS = 1;
								zEW = 3;
								xEW = 1;
								break;
							case 1:
								xNS = -3;
								zNS = -1;
								xEW = -1;
								zEW = 1;
								break;
							case 3:
								xNS = 1;
								zNS = -1;
								xEW = 3;
								zEW = 1;
								break;
							case 4:
								yNS = -3;
								zNS = -1;
								xNS = -1;
								yEW = -1;
								zEW = 1;
								xEW = 1;
								break;
							case 5:
								yNS = 2;
								zNS = -1;
								xNS = -1;
								yEW = 4;
								zEW = 1;
								xEW = 1;
								break;
						}
						if(player.posX < 0) {
							xNS -= 1;
							xEW -= 1;
						}
						if(player.posZ < 0) {
							zNS -= 1;
							zEW -= 1;
						}
						AxisAlignedBB box = AxisAlignedBB.getBoundingBox(player.posX + xNS, player.posY + yNS, player.posZ + zNS, player.posX + xEW, player.posY + yEW, player.posZ + zEW);
						/*
						//code for seeing bounding box
						if(!world.isRemote) {
							world.setBlock((int)player.posX + xNS, (int)player.posY + yNS, (int)player.posZ + zNS, Block.blockLapis.blockID);
							world.setBlock((int)player.posX + xEW, (int)player.posY + yEW, (int)player.posZ + zEW, Block.blockLapis.blockID);
						}
						*/
						int useItem = 0;
						List<Entity> entityList = world.getEntitiesWithinAABB(Entity.class, box);
						if(entityList.size() <= 0)
							return itemstack;
						for(i = 0; i < entityList.size(); i++) {
							if(!world.isRemote) {
								Entity ent = entityList.get(i);
								if(!ent.canBeCollidedWith())
									continue;
								world.removeEntity(entityList.get(i));
								useItem++;
								if(useItem >= 5)
									break;
							}
						}
						if(useItem >= 1)
							Methods.useItem(player, IDRef.DARK_BALL_ID);
					}
				}
			}
		}
		return itemstack;
	}
	
}
