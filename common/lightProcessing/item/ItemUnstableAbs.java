package lightProcessing.item;

import lib.Methods;
import lib.Reference;
import lightProcessing.LightProcessing;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemUnstableAbs extends Item{
	public ItemUnstableAbs(int par1){
	super(par1);
	this.setUnlocalizedName("UnstableAbs");
	this.setCreativeTab(lib.ItemTab.itemTab);
	}
	private java.util.Random r = new java.util.Random();
	
	
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		int effect;
		
		
        if (!par2World.isRemote)
        {
        	effect = r.nextInt(20);
        	
        	switch(effect){
        	case 0:	
        	{
        par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.harm.getId(),1,50));
        	break;
        	}
        	case 1:
        	{
       par2World.createExplosion(par3EntityPlayer, par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ, 3.0F, true);
       par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.harm.getId(), 1, 1));
       break;
        	}
        	case 2:
        	{
        		
        	break;
        	}
        	case 3:
        	{
        		break;
        	}
        	default:
        	{
        		break;
        	}
        }
        }
        
        
        
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
        return new ItemStack(lib.Items.ItemUnstableAbs, par1ItemStack.stackSize - 1);
        }
        else return par1ItemStack;
    }
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.eat;
    }
	
	 public int getMaxItemUseDuration(ItemStack par1ItemStack)
	    {
	        return 32;
	    }
	 
	 public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
	        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
	        return par1ItemStack;
	    }
	
	
	@Override
	public boolean hasEffect(ItemStack par1ItemStack){
		return true;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack){
		return EnumRarity.epic;
	}
	
	  @SideOnly(Side.CLIENT)
	    public void registerIcons(IconRegister iconRegister)
	    {
		  itemIcon = iconRegister.registerIcon(Methods.textureName(this.getUnlocalizedName()));
	}
	}