package LightProcessing.common.lightProcessing.item;

import LightProcessing.common.lightProcessing.tile.*;
import LightProcessing.resources.mods.ltp.models.ModelCompressor;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemCompressorRenderer implements IItemRenderer {

	private ModelCompressor AbsCompModel;

	public ItemCompressorRenderer() {

		AbsCompModel = new ModelCompressor();
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
		TileEntityRenderer.instance.renderTileEntityAt(new TileEntityCompressor(), 0.0D, 0.0D, 0.0D, 0.0F);
	}

}