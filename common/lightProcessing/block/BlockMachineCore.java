package LightProcessing.common.lightProcessing.block;

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
import LightProcessing.common.lib.WorldCrafting.*;
import LightProcessing.common.lib.BlockTab;
import LightProcessing.common.lightProcessing.LightProcessing;
import LightProcessing.common.lightProcessing.tile.TileEntityCompressor;
import LightProcessing.common.lightProcessing.tile.TileEntityMachineCore;

public class BlockMachineCore extends Block{

	public BlockMachineCore(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(10);
		this.setCreativeTab(BlockTab.blockTab);
		this.setUnlocalizedName("MachineCore");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(Methods.textureName(this
				.getUnlocalizedName()));
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
		if (par5EntityPlayer.getCurrentItemOrArmor(0) == null) {
					if(Methods.setArea(par1World, par2, par3, par4, WorldCrafting.harvester, 0)){
						par1World.setBlock(par2, par3, par4, IDRef.HARVESTER_ID);
					}	
		if(Methods.checkArea(par1World, par2, par3 + 1, par4, WorldCrafting.darkGen2) && Methods.setArea(par1World, par2, par3, par4, WorldCrafting.darkGen, 0)){
			Methods.setArea(par1World, par2, par3 + 1, par4, WorldCrafting.darkGen2, 0);
			par1World.setBlock(par2, par3, par4, IDRef.DARK_GEN_ID);
 		}
		
	}
		return false;
	}

}
