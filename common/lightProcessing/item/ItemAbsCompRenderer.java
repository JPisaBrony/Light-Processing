package lightProcessing.item;

import lightProcessing.tile.TileEntityAbsComp;
import mods.LtP.models.ModelAbsComp;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemAbsCompRenderer implements IItemRenderer {
	
	private ModelAbsComp AbsCompModel;

	public ItemAbsCompRenderer() {

	AbsCompModel = new ModelAbsComp();
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
	TileEntityRenderer.instance.renderTileEntityAt(new TileEntityAbsComp(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
	}