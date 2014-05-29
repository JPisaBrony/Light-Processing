package LightProcessing.common.lightProcessing.item;

import LightProcessing.common.lightProcessing.tile.TileEntityMachineCore;
import LightProcessing.common.lightProcessing.render.ModelMachineCore;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemMachineCoreRenderer implements IItemRenderer {
	
	private ModelMachineCore MachineCoreModel;

	public ItemMachineCoreRenderer() {

	MachineCoreModel = new ModelMachineCore();
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
	TileEntityRenderer.instance.renderTileEntityAt(new TileEntityMachineCore(), 0.0D, 0.0D, 0.0D, 0.0F);
	}
	}