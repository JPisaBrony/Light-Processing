package lib;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Methods {
	
	public static String textureName(String unLocNam){
		return Reference.MOD_ID.toLowerCase() + ":" + unLocNam;
	}
}
