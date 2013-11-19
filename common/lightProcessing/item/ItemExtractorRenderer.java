package LightProcessing.common.lightProcessing.item;

import LightProcessing.common.lightProcessing.tile.*;
import LightProcessing.resources.mods.ltp.models.ModelCompressor;
import LightProcessing.resources.mods.ltp.models.ModelExtractor;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemExtractorRenderer implements IItemRenderer {
	
	private ModelExtractor ExtractorModel;

	public ItemExtractorRenderer() {

	ExtractorModel = new ModelExtractor();
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
	TileEntityRenderer.instance.renderTileEntityAt(new TileEntityExtractor(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
	}