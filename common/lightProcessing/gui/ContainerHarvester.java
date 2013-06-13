package lightProcessing.gui;

import java.util.EnumSet;

import lightProcessing.gui.SlotOutput;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerHarvester extends Container {

        protected TileEntityHarvester tileEntity;

    	public ContainerHarvester(InventoryPlayer var1, TileEntityHarvester var2)
        {
			this.tileEntity = var2;
			this.addSlotToContainer(new SlotOutput(this.tileEntity, 0, 56, 32));
	        this.addSlotToContainer(new SlotOutput(this.tileEntity, 1, 110, 32));
            int var3;

            for (var3 = 0; var3 < 3; ++var3)
            {
                for (int var4 = 0; var4 < 9; ++var4)
                {
                    this.addSlotToContainer(new Slot(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
                }
            }

            for (var3 = 0; var3 < 9; ++var3)
            {
                this.addSlotToContainer(new Slot(var1, var3, 8 + var3 * 18, 142));
            }
        }

        @Override
        public boolean canInteractWith(EntityPlayer player) {
                return tileEntity.isUseableByPlayer(player);
        }

        protected void bindPlayerInventory(InventoryPlayer inventoryPlayer) {
                for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 9; j++) {
                                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9,
                                                8 + j * 18, 84 + i * 18));
                        }
                }

                for (int i = 0; i < 9; i++) {
                        addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
                }
        }

        /**
         * Called to transfer a stack from one inventory to the other eg. when shift clicking.
         */
        @Override
        public ItemStack transferStackInSlot(EntityPlayer player, int slotnumber)
        {
         ItemStack itemstack = null;
         Slot slot = (Slot)inventorySlots.get(slotnumber);

         if (slot != null && slot.getHasStack())
         {
                 ItemStack itemstack1 = slot.getStack();
                 itemstack = itemstack1.copy();

                 if (slotnumber == 2)
                 {
                         if (!mergeItemStack(itemstack1, 3, 38, true))
                         {
                                 return null;
                         }

                         slot.onSlotChange(itemstack1, itemstack);
                 }
                 else if (slotnumber == 1 || slotnumber == 0)
                 {
                         if (!mergeItemStack(itemstack1, 3, 38, false))
                         {
                                 return null;
                         }
                 }
                 else if (slotnumber >= 3 && slotnumber < 30)
                 {
                         if (!mergeItemStack(itemstack1, 30, 38, false))
                         {
                                 return null;
                         }
                 }
                 else if (slotnumber >= 30 && slotnumber < 38 && !mergeItemStack(itemstack1, 3, 30, false))
                 {
                         return null;
                 }

                 if (itemstack1.stackSize == 0)
                 {
                         slot.putStack(null);
                 }
                 else
                 {
                         slot.onSlotChanged();
                 }

                 if (itemstack1.stackSize == itemstack.stackSize)
                 {
                         return null;
                 }
                
                 slot.onPickupFromSlot(player, itemstack);
         }

         return itemstack;
}
}
