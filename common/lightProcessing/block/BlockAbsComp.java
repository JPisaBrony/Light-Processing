package lightProcessing.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lib.IDRef;
import lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockAbsComp extends Block{
	
	public BlockAbsComp(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(10);
		this.setCreativeTab(lib.BlockTab.blockTab);
		this.setUnlocalizedName("AbsComp");
	}
	
	
	 @Override
	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister iconRegister) {
	        blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName2());
	 }
	 
	 
	 @SideOnly(Side.CLIENT)
		public void randomDisplayTick(World world, int x, int y, int z, Random random){
	 }
	 
	 @SideOnly(Side.CLIENT)
	 public void particles(World world, int x, int y, int z){
		 
		 Random random = new Random();
		 float f1 = (float)x + 0.5F;
			float f2 = (float)y + 1.1F;
			float f3 = (float)z + 0.5F; 
			float f4 = random.nextFloat() * 0.6F -0.3F;
			float f5 = random.nextFloat() * -0.6F - -0.3F;

			world.playSoundEffect((double)f1, (double)f2, (double)f3, "mob.irongolem.death", 1.0F, world.rand.nextFloat() * 0.1F + 0.9F);
			
			world.spawnParticle("largeexplode", (double)(f1), (double)f2 , (double)(f3), 0.0D, 0.0D, 0.0D);
			world.spawnParticle("largesmoke", (double)(f1), (double)f2 , (double)(f3), 0.0D, 0.0D, 0.0D);
			world.spawnParticle("largesmoke", (double)(f1), (double)f2 , (double)(f3), 0.0D, 0.0D, 0.0D);
			world.spawnParticle("largesmoke", (double)(f1), (double)f2 , (double)(f3), 0.0D, 0.0D, 0.0D);
			world.spawnParticle("largesmoke", (double)(f1), (double)f2 , (double)(f3), 0.0D, 0.0D, 0.0D);
			world.spawnParticle("largesmoke", (double)(f1), (double)f2 , (double)(f3), 0.0D, 0.0D, 0.0D);
			world.spawnParticle("largesmoke", (double)(f1), (double)f2 , (double)(f3), 0.0D, 0.0D, 0.0D);
			world.spawnParticle("largesmoke", (double)(f1), (double)f2 , (double)(f3), 0.0D, 0.0D, 0.0D);
	 }
	 
	 
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		
	 if(par5EntityPlayer.getCurrentItemOrArmor(0) == null){
	 int id = par1World.getBlockId(par2 - 1, par3, par4);
	 int id2 = par1World.getBlockId(par2 + 1, par3, par4);
	 int id3 = par1World.getBlockId(par2, par3, par4 - 1);
	 int id4 = par1World.getBlockId(par2, par3, par4 + 1);
	 int id5 = par1World.getBlockId(par2, par3 + 1, par4);	 
	 int light = IDRef.LIGHT_BLOCK_ID;
	 int dark = IDRef.DARK_BLOCK_ID;
	 
	 ItemStack unAbStack  = new ItemStack(lib.Items.ItemUnstableAbs, 1);
     EntityItem entityitem = new EntityItem(par1World, par2 + 0.5, par3 + 1.15, par4 + 0.5, unAbStack);
     entityitem.motionX = 0;
     entityitem.motionY = 0;
     entityitem.motionZ = 0;
     
	 
	 if(id == light && id2 == dark){
		 if(id5 == 0){
		 par1World.setBlock(par2 -1, par3, par4, 0);
		 par1World.setBlock(par2 +1, par3, par4, 0);
		 particles(par1World, par2, par3, par4);	
		 if(!par1World.isRemote){
	     par1World.spawnEntityInWorld(entityitem);
		 }
		 }
		 }
	 else if(id == dark && id2 == light){
		 if(id5 == 0){
		 par1World.setBlock(par2 -1, par3, par4, 0);
		 par1World.setBlock(par2 +1, par3, par4, 0);
		 particles(par1World, par2, par3, par4);	
		 if(!par1World.isRemote){
		     par1World.spawnEntityInWorld(entityitem);
			 }
		 }
	 }
	 else if(id3 == light && id4 == dark){
		 if(id5 == 0){
		 par1World.setBlock(par2, par3, par4 - 1, 0);
		 par1World.setBlock(par2, par3, par4 + 1, 0);
		 particles(par1World, par2, par3, par4);
		 if(!par1World.isRemote){
		     par1World.spawnEntityInWorld(entityitem);
			 }
		 }
	 }
	 else if(id3 == dark && id4 == light){
		 if(id5 == 0){
		 par1World.setBlock(par2, par3, par4 - 1, 0);
		 par1World.setBlock(par2, par3, par4 + 1, 0);
		 particles(par1World, par2, par3, par4);	
		 if(!par1World.isRemote){
		     par1World.spawnEntityInWorld(entityitem);
			 }
		 }
	 }
	 }
	 return false;
    }
}
