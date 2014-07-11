package LightProcessing.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import LightProcessing.common.lib.*;
import LightProcessing.common.lib.Methods.*;
import LightProcessing.common.lib.BlockTab;
import LightProcessing.common.main.LightProcessing;
import LightProcessing.common.tile.TileEntityCompressor;
import LightProcessing.common.tile.TileEntityMachineCore;
import LightProcessing.common.worldCrafting.WorldCrafting;
import LightProcessing.common.worldCrafting.WorldCraftingRecipeCollection;
import LightProcessing.common.worldCrafting.WorldCrafting.*;

public class BlockMachineCore extends Block {

	public BlockMachineCore(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(10);
		this.setCreativeTab(BlockTab.blockTab);
		this.setUnlocalizedName("MachineCore");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return new TileEntityMachineCore();
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		WorldCrafting harvester = new WorldCrafting();
		if (par5EntityPlayer.getCurrentItemOrArmor(0) == null) {
			WorldCraftingRecipeCollection recipe = harvester.dictionary.get(IDRef.MACHINE_CORE_ID);
			for(int i = 0; i < recipe.getCount(); i++)
				if(Methods.checkRecipe(par1World, par2, par3, par4, recipe.get(i)))
					return true;
		}
		return false;
	}

}
