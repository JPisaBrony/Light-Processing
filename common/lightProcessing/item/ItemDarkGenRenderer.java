package LightProcessing.common.lightProcessing.item;


import LightProcessing.common.lightProcessing.tile.TileEntityDarkGen;
import LightProcessing.resources.mods.ltp.models.ModelDarkGen;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
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