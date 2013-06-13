package lightProcessing.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiHarvester extends GuiContainer {

	private static int lightScaler;
	private static int darkScaler;
	public static boolean lightMade;
	public static boolean darkMade;
	
	@Override
	public boolean doesGuiPauseGame()
	{
	return false;
	}
	
	@Override
	protected void keyTyped(char par1, int par2)
	{
	if (par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.keyCode)
	{
	this.mc.thePlayer.closeScreen();
	}
	}
	
	
	public static void updateLightScaler(int par1){
		if(par1 > 0 && darkScaler < 50){
			updateDarkScaler(-1);
		}
		else{
		lightScaler = lightScaler - par1;
		if(lightScaler < 1){
			lightScaler = 50;
			lightMade = true;
		}
		else{
			lightMade = false;
		}
		}
	}
	public static void updateDarkScaler(int par1){
		if(par1 > 0 && lightScaler < 50){
			updateLightScaler(-1);
		}
		else{
		darkScaler = darkScaler - par1;
		if(darkScaler < 1){
			darkScaler = 50;
			darkMade = true;
		}
		else{
			darkMade = false;
		}
		}
	}
	
        public GuiHarvester (InventoryPlayer inventoryPlayer,
                TileEntityHarvester tileEntity) {
                //the container is instantiated and passed to the superclass for handling
                super(new ContainerHarvester(inventoryPlayer, tileEntity));
        }

        @Override
        protected void drawGuiContainerForegroundLayer(int param1, int param2) {
                //draw text and stuff here
                //the parameters for drawString are: string, x, y, color
                fontRenderer.drawString("Harvester", 64, 6, 4210752);
                //draws "Inventory" or your regional equivalent
                fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
        }

        @Override
        protected void drawGuiContainerBackgroundLayer(float par1, int par2,
                int par3) {
                //draw your Gui here, only thing you need to change is the path
                int texture = mc.renderEngine.getTexture("/mods/LightProcessing/textures/gui/HarvesterGUI.png");
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                //this.mc.renderEngine.bindTexture(texture);
                int x = (width - xSize) / 2;
                int y = (height - ySize) / 2;
                this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
                this.drawTexturedModalRect(x + 31, y + 14 + lightScaler, 176, 0 + lightScaler, 15, 50);
                this.drawTexturedModalRect(x + 134, y + 14 + darkScaler, 191, 0 + darkScaler, 15, 50);
             
        }

}