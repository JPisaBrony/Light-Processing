package LightProcessing.common.lightProcessing.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import LightProcessing.common.lib.BlockTab;
import LightProcessing.common.lib.IDRef;
import LightProcessing.common.lib.Methods;

public class BlockLightWoodPlanks extends Block{
	public BlockLightWoodPlanks(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setUnlocalizedName("LightWoodPlanks");
		this.setCreativeTab(BlockTab.blockTab);
		this.setHardness(2.0F);
		this.setLightValue(1.0F);
	}
	
	public int idDropped(int par1, Random par2Random, int par3) {
		return IDRef.LIGHT_WOOD_PLANKS_ID;
	}

	public int quantityDropped(Random par1Random) {
		return 1;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}

}
