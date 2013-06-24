package lightProcessing.tile;

import lib.Reference;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityAbsCompBlock extends BlockContainer{
	
	   public TileEntityAbsCompBlock(int id) {
           super(id, Material.iron);
           this.setCreativeTab(lib.BlockTab.blockTab);
           this.setBlockBounds(0.4F, 0.0F, 0.4F, 0.6F, 3.0F, 0.6F);
           this.setUnlocalizedName("AbsComp");
   }

   //Make sure you set this as your TileEntity class relevant for the block!
   @Override
   public TileEntity createNewTileEntity(World world) {
           return new TileEntityAbsComp();
   }
   
   //You don't want the normal render type, or it wont render properly.
   @Override
   public int getRenderType() {
           return -1;
   }
   
   //It's not an opaque cube, so you need this.
   @Override
   public boolean isOpaqueCube() {
           return false;
   }
   
   //It's not a normal block, so you need this too.
   public boolean renderAsNormalBlock() {
           return false;
   }
   
   //This is the icon to use for showing the block in your hand.


}
