package LightProcessing.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
//import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
//import net.minecraftforge.common.ForgeDirection;
import LightProcessing.common.lib.BlockTab;
import LightProcessing.common.lib.LPBlocks;
import LightProcessing.common.lib.IDRef;
import LightProcessing.common.lib.LPItems;
import LightProcessing.common.lib.Methods;
import LightProcessing.common.tile.TileEntityCompressor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCompressor extends Block {
	
	public class BlockCompressorEntity extends EntityItemFrame {

		public BlockCompressorEntity(World par1World) {
			super(par1World);
		}
		
	    public BlockCompressorEntity(World par1World, int par2, int par3, int par4, int par5)
	    {
	        super(par1World, par2, par3, par4, par5);
	        this.setDirection(par5);
	    }
	}
	
	public static boolean flag1;

	public BlockCompressor(Material material) {
		super(material);
		this.setHardness(10);
		this.setCreativeTab(BlockTab.blockTab);
	}

	@Override
	public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side) {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
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
		return new TileEntityCompressor();
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	public static void particles(World world, int x, int y, int z) {

		Random random = new Random();
		float f1 = (float) x + 0.5F;
		float f2 = (float) y + 1.1F;
		float f3 = (float) z + 0.5F;
		float f4 = random.nextFloat() * 0.6F - 0.3F;
		float f5 = random.nextFloat() * -0.6F - -0.3F;

		world.playSoundEffect((double) f1, (double) f2, (double) f3, "mob.irongolem.death", 1.0F, world.rand.nextFloat() * 0.1F + 0.9F);

		world.spawnParticle("largeexplode", (double) (f1), (double) f2, (double) (f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f1), (double) f2, (double) (f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f1), (double) f2, (double) (f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f1), (double) f2, (double) (f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f1), (double) f2, (double) (f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f1), (double) f2, (double) (f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f1), (double) f2, (double) (f3), 0.0D, 0.0D, 0.0D);
		world.spawnParticle("largesmoke", (double) (f1), (double) f2, (double) (f3), 0.0D, 0.0D, 0.0D);
	}

	public static void compress(World par1World, int par2, int par3, int par4) {
		
		Block id = par1World.getBlock(par2 - 1, par3, par4);
		int met = par1World.getBlockMetadata(par2 - 1, par3, par4);
		Block id2 = par1World.getBlock(par2 + 1, par3, par4);
		int met2 = par1World.getBlockMetadata(par2 + 1, par3, par4);
		Block id3 = par1World.getBlock(par2, par3, par4 - 1);
		int met3 = par1World.getBlockMetadata(par2, par3, par4 - 1);
		Block id4 = par1World.getBlock(par2, par3, par4 + 1);
		int met4 = par1World.getBlockMetadata(par2, par3, par4 + 1);
		Block id5 = par1World.getBlock(par2, par3 + 1, par4);
		Block light = LPBlocks.BlockLightBlock;
		Block dark = LPBlocks.BlockDarkBlock;

		ItemStack unAbStack = new ItemStack(LPItems.ItemUnstableAbs, 1);
		EntityItem UnAbsItem = new EntityItem(par1World, par2 + 0.5, par3 + 1.15, par4 + 0.5, unAbStack);
		UnAbsItem.motionX = 0;
		UnAbsItem.motionY = 0;
		UnAbsItem.motionZ = 0;
		if (id == light && id2 == dark && met2 != 2) {
			if (id5 == Blocks.air) {
				par1World.setBlockToAir(par2 - 1, par3, par4);
				par1World.setBlockToAir(par2 + 1, par3, par4);
				particles(par1World, par2, par3, par4);
				if (!par1World.isRemote) {
					par1World.spawnEntityInWorld(UnAbsItem);
					flag1 = true;
				}
			}
		}
		else if (id == dark && id2 == light && met != 2) {
			if (id5 == Blocks.air) {
				par1World.setBlockToAir(par2 - 1, par3, par4);
				par1World.setBlockToAir(par2 + 1, par3, par4);
				particles(par1World, par2, par3, par4);
				if (!par1World.isRemote) {
					par1World.spawnEntityInWorld(UnAbsItem);
					flag1 = true;
				}
			}
		}
		else if (id3 == light && id4 == dark && met4 != 2) {
			if (id5 == Blocks.air) {
				par1World.setBlockToAir(par2, par3, par4 - 1);
				par1World.setBlockToAir(par2, par3, par4 + 1);
				particles(par1World, par2, par3, par4);
				if (!par1World.isRemote) {
					par1World.spawnEntityInWorld(UnAbsItem);
					flag1 = true;
				}
			}
		}
		else if (id3 == dark && id4 == light && met3 != 2) {
			if (id5 == Blocks.air) {
				par1World.setBlockToAir(par2, par3, par4 - 1);
				par1World.setBlockToAir(par2, par3, par4 + 1);
				particles(par1World, par2, par3, par4);
				if (!par1World.isRemote) {
					par1World.spawnEntityInWorld(UnAbsItem);
					flag1 = true;
				}
			}
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        ItemStack itemstack = player.getCurrentEquippedItem();
        
        if(itemstack != null) {
	        itemstack = itemstack.copy();
	        itemstack.stackSize = 1;
	        //this.isBlockSolidOnSide(world, x, y, z, ForgeDirection.NORTH);
	        BlockCompressorEntity blockEntity = new BlockCompressorEntity(world, x, y, z, 0);
	        EntityItemFrame itemframe = new EntityItemFrame(world, x, y, z, 0);
	        itemstack.setItemFrame(blockEntity);
	        blockEntity.getDataWatcher().updateObject(2, itemstack);
	        blockEntity.getDataWatcher().setObjectWatched(2);
        }
        
        if (player.getCurrentArmor(0) == null) {
			compress(world, x, y, z);
		}
		return false;
	}
}
