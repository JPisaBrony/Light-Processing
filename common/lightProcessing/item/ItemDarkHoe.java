package LightProcessing.common.lightProcessing.item;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import LightProcessing.common.lib.IDRef;
import LightProcessing.common.lib.ItemTab;
import LightProcessing.common.lib.Methods;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDarkHoe extends ItemHoe{
	
	public ItemDarkHoe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		this.setUnlocalizedName("DarkHoe");
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
						if(id == Block.pumpkin.blockID) {
							if(Methods.spawnItemFromBlockandRemove(world, x, y, z, Block.pumpkin, 2, 0)) {
								Methods.useItem(player, IDRef.DARK_BALL_ID);
								return true;
							}
						}
						if(id == Block.melon.blockID) {
							if(Methods.spawnItemFromBlockandRemove(world, x, y, z, Block.melon, 2, 0)) {
								Methods.useItem(player, IDRef.DARK_BALL_ID);
								return true;
							}
						}
						if(id == Block.crops.blockID) {
							if(world.getBlockMetadata(x, y, z) >= 7) {
								Methods.spawnItemFromItemandRemove(world, x, y, z, Item.seeds, 3, 0);
								Methods.spawnItemFromItemandRemove(world, x, y, z, Item.wheat, 2, 0);
								Methods.useItem(player, IDRef.DARK_BALL_ID);
								return true;
							}
						}
						if(id == Block.carrot.blockID) {
							if(world.getBlockMetadata(x, y, z) >= 7) {
								Methods.spawnItemFromItemandRemove(world, x, y, z, Item.carrot, 5, 0);
								Methods.useItem(player, IDRef.DARK_BALL_ID);
								return true;
							}
						}
						if(id == Block.potato.blockID) {
							if(world.getBlockMetadata(x, y, z) >= 7) {
								Methods.spawnItemFromItemandRemove(world, x, y, z, Item.potato, 5, 0);
								Methods.useItem(player, IDRef.DARK_BALL_ID);
								return true;
							}
						}
						if(id == Block.tallGrass.blockID) {
							if(Methods.spawnItemFromItemandRemove(world, x, y, z, Item.seeds, 1, 0)) {
								Methods.useItem(player, IDRef.DARK_BALL_ID);
								return true;
							}
						}
						
					}
				}
			}
		}
		
        if (!player.canPlayerEdit(x, y, z, par7, itemstack))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(player, itemstack, world, x, y, z);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }

            if (event.getResult() == Result.ALLOW)
            {
            	itemstack.damageItem(1, player);
                return true;
            }

            int i1 = world.getBlockId(x, y, z);
            boolean air = world.isAirBlock(x, y + 1, z);

            if (par7 != 0 && air && (i1 == Block.grass.blockID || i1 == Block.dirt.blockID))
            {
                Block block = Block.tilledField;
                world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

                if (world.isRemote)
                {
                    return true;
                }
                else
                {
                    world.setBlock(x, y, z, block.blockID);
                    itemstack.damageItem(1, player);
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
	}
	
}
