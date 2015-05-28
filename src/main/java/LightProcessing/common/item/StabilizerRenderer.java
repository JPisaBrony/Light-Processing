package LightProcessing.common.item;

import LightProcessing.common.render.ModelStabilizer;
import LightProcessing.common.tile.TileEntityStabilizer;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class StabilizerRenderer implements IItemRenderer {

	private ModelStabilizer StabilizerModel;

	public StabilizerRenderer() {

		StabilizerModel = new ModelStabilizer();
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
		TileEntityRenderer.instance.renderTileEntityAt(new TileEntityStabilizer(), 0.0D, 0.0D, 0.0D, 0.0F);
	}

}