package LightProcessing.common.item;

import org.lwjgl.opengl.GL11;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import LightProcessing.common.render.ModelEssenceExtractor;
import LightProcessing.common.tile.TileEntityEssenceExtractor;

public class ItemEssenceExtractorRenderer implements IItemRenderer {

	private ModelEssenceExtractor ModelEssenceExtractor;

	public ItemEssenceExtractorRenderer() {
		ModelEssenceExtractor = new ModelEssenceExtractor();
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
		GL11.glRotatef(90, 0, 1, 0);
		GL11.glTranslatef(-1F, -0.1F, 0F);
		TileEntityRenderer.instance.renderTileEntityAt(new TileEntityEssenceExtractor(), 0.0D, 0.0D, 0.0D, 0.0F);
	}

}