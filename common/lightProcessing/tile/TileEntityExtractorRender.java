package LightProcessing.common.lightProcessing.tile;

import org.lwjgl.opengl.GL11;
import LightProcessing.common.lib.ExtractionList;
import LightProcessing.common.lib.ExtractionList;
import LightProcessing.common.lib.Reference;
import LightProcessing.common.lightProcessing.block.BlockExtractor;
import LightProcessing.resources.mods.ltp.models.ModelDarkGen;
import LightProcessing.resources.mods.ltp.models.ModelExtractor;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class TileEntityExtractorRender extends TileEntitySpecialRenderer {

	private final ModelExtractor model;
	public static final ResourceLocation Extractor = new ResourceLocation(Reference.MOD_ID.toLowerCase(), "/textures/models/ModelExtractor.png");
	static boolean running = false;

	public TileEntityExtractorRender() {
		this.model = new ModelExtractor();
	}

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		GL11.glPushMatrix();
		GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		
		//TEXUTRE FIX
		//Minecraft.getMinecraft().renderEngine.func_110577_a(Extractor);
		
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		TileEntityExtractor tile = (TileEntityExtractor) te;
		GL11.glRotatef(te.blockMetadata * 90, 0.0F, 1.0F, 0.0F);
		if (tile.blockMetadata > 3) {
			if (tile.flag) {
				tile.animationOffset = System.currentTimeMillis() * -1;
				tile.flag = false;
			}
			if (!(ExtractionList.getEssence(tile.worldObj, tile.xCoord, tile.yCoord + 1, tile.zCoord) == 0)) {
				this.model.pump(tile.animationOffset, tile.worldObj, tile.xCoord, tile.yCoord, tile.zCoord, tile);
			}
		}
		else {
			this.model.slider1.offsetY = 0;
			this.model.slider2.offsetY = 0;
			tile.flag = true;
		}
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	private void adjustLightFixture(World world, int i, int j, int k, Block block) {
		Tessellator tess = Tessellator.instance;
		float brightness = block.getBlockBrightness(world, i, j, k);
		int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
		int modulousModifier = skyLight % 65536;
		int divModifier = skyLight / 65536;
		tess.setColorOpaque_F(brightness, brightness, brightness);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) modulousModifier, divModifier);
	}
	
}