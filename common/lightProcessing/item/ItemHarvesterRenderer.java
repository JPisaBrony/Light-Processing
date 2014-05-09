package LightProcessing.common.lightProcessing.item;

import LightProcessing.common.lightProcessing.tile.*;
import LightProcessing.resources.ltp.models.*;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemHarvesterRenderer implements IItemRenderer {

	private ModelHarvester HarvesterModel;

	public ItemHarvesterRenderer() {

		HarvesterModel = new ModelHarvester();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {

		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {

		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRenderer.instance.renderTileEntityAt(new TileEntityHarvester(), 0.0D, 0.0D, 0.0D, 0.0F);
	}

}