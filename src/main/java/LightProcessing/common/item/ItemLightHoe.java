package LightProcessing.common.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import LightProcessing.common.lib.LPBlocks;
import LightProcessing.common.lib.IDRef;
import LightProcessing.common.lib.ItemTab;
import LightProcessing.common.lib.Methods;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLightHoe extends ItemHoe{
	
	public ItemLightHoe(EnumToolMaterial EnumToolMaterial) {
		super(EnumToolMaterial);
		this.setUnlocalizedName("LightHoe");
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
						Block id = world.getBlock(x, y, z);
						if(id == Blocks.pumpkin) {
							if(Methods.spawnItemFromBlockandRemove(world, x, y, z, Blocks.pumpkin, 2, 0)) {
								Methods.useItem(player, IDRef.LIGHT_BALL_ID);
								return true;
							}
						}
						if(id == Blocks.melon_block) {
							if(Methods.spawnItemFromBlockandRemove(world, x, y, z, Blocks.melon_block, 2, 0)) {
								Methods.useItem(player, IDRef.LIGHT_BALL_ID);
								return true;
							}
						}
						if(id == Blocks.wheat) {
							if(world.getBlockMetadata(x, y, z) >= 7) {
								Methods.spawnItemFromItemandRemove(world, x, y, z, Items.wheat_seeds, 3, 0);
								Methods.spawnItemFromItemandRemove(world, x, y, z, Items.wheat, 2, 0);
								Methods.useItem(player, IDRef.LIGHT_BALL_ID);
								return true;
							}
						}
						if(id == Blocks.carrots) {
							if(world.getBlockMetadata(x, y, z) >= 7) {
								Methods.spawnItemFromItemandRemove(world, x, y, z, Items.carrot, 5, 0);
								Methods.useItem(player, IDRef.LIGHT_BALL_ID);
								return true;
							}
						}
						if(id == Blocks.potatoes) {
							if(world.getBlockMetadata(x, y, z) >= 7) {
								Methods.spawnItemFromItemandRemove(world, x, y, z, Items.potato, 5, 0);
								Methods.useItem(player, IDRef.LIGHT_BALL_ID);
								return true;
							}
						}
						if(id == Blocks.tallgrass) {
							if(Methods.spawnItemFromItemandRemove(world, x, y, z, Items.wheat_seeds, 1, 0)) {
								Methods.useItem(player, IDRef.LIGHT_BALL_ID);
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
