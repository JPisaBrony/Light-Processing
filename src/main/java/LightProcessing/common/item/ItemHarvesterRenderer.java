package LightProcessing.common.item;

import LightProcessing.common.render.ModelHarvester;
import LightProcessing.common.tile.TileEntityHarvester;
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