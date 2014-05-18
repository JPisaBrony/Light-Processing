package LightProcessing.common.lib;

import java.awt.Event;
import java.util.ArrayList;
import java.util.Random;
import LightProcessing.common.lightProcessing.block.BlockLightTreeSapling;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class Events {

	@ForgeSubscribe
	public void bonemealUsed(BonemealEvent event) {
		if (event.world.getBlockId(event.X, event.Y, event.Z) == Blocks.BlockLightTreeSapling.blockID) {
			((BlockLightTreeSapling)Blocks.BlockLightTreeSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
		}
	}
	
}