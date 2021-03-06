package LightProcessing.common.item;

import LightProcessing.common.render.ModelDarkGen;
import LightProcessing.common.tile.TileEntityDarkGen;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemDarkGenRenderer implements IItemRenderer {

	private ModelDarkGen DarkGenModel;

	public ItemDarkGenRenderer() {

		DarkGenModel = new ModelDarkGen();
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
		TileEntityRenderer.instance.renderTileEntityAt(new TileEntityDarkGen(), 0.0D, 0.0D, 0.0D, 0.0F);
	}

}