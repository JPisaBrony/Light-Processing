package LightProcessing.common.lightProcessing.item;

import org.lwjgl.opengl.GL11;
import LightProcessing.common.lightProcessing.tile.*;
import LightProcessing.resources.mods.ltp.models.ModelCompressor;
import LightProcessing.resources.mods.ltp.models.ModelExtractinator;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemExtractinatorRenderer implements IItemRenderer {

	private ModelExtractinator ExtractinatorModel;

	public ItemExtractinatorRenderer() {
		ExtractinatorModel = new ModelExtractinator();
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
		TileEntityRenderer.instance.renderTileEntityAt(new TileEntityExtractinator(), 0.0D, 0.0D, 0.0D, 0.0F);
	}

}