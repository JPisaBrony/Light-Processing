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
import LightProcessing.common.lib.BlockTab;
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
		if (par5EntityPlayer.getCurrentItemOrArmor(0) == null) {
			int DL = IDRef.DARK_LEAF_ID;
			int LW = IDRef.LIGHT_WOOD_ID;
			int HV = IDRef.HARVESTER_ID;
			int MC = IDRef.MACHINE_CORE_ID;
			int harvester[][] = {
					{LW,DL,DL,DL,LW},
					{DL,0,0,0,DL},
					{DL,0,MC,0,DL},
					{DL,0,0,0,DL},
					{LW,DL,DL,DL,LW}
				};
			if(Methods.setArea(par1World, par2, par3, par4, harvester))
				par1World.setBlock(par2, par3, par4, HV);
				
		}
		return false;
	}
}
