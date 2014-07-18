package LightProcessing.LightTweeks;

import net.minecraft.block.Block;
import net.minecraft.util.Facing;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class LightTweeksMethods {
	
	public static int updateLight(int x, int y, int z, EnumSkyBlock enumSkyBlock, World world) {
		//System.out.println("update light called");
		if (enumSkyBlock == EnumSkyBlock.Sky && world.canBlockSeeTheSky(x, y, z)) {
			if(world.getLightBrightness(x, y, z) == 0)
	    		return 0;
			return 15;
		}
		else {
			if(world.getLightBrightness(x, y, z) == 0)
	    		return 0;
			int blockLight, newLightValue, lightOpacity, blockID;
            blockID = world.getBlockId(x, y, z);
            Block block = Block.blocksList[blockID];
            if(block == null) {
            	blockLight = 0;
            	lightOpacity = 0;
            }
            else {
            	blockLight = block.getLightValue(world, x, y, z);
            	lightOpacity = block.getLightOpacity(world, x, y, z);
            }
            
            if(enumSkyBlock == EnumSkyBlock.Sky)
            	newLightValue = 0;
            else
            	newLightValue = blockLight;

            if((lightOpacity >= 15 && blockLight > 0) || lightOpacity < 1)
                lightOpacity = 1;

            if(lightOpacity >= 15)
                return 0;
            
            else if(newLightValue >= 14)
                return newLightValue;
            
            else {
            	int x1, y1, z1;
                for (int i = 0; i < 6; i++) {
                    x1 = x + Facing.offsetsXForSide[i];
                    y1 = y + Facing.offsetsYForSide[i];
                    z1 = z + Facing.offsetsZForSide[i];
                    int savedLight = world.getSavedLightValue(enumSkyBlock, x1, y1, z1) - lightOpacity;

                    if (savedLight > newLightValue)
                        newLightValue = savedLight;

                    if (newLightValue >= 14)
                        return newLightValue;
                }

                return newLightValue;
            }
        }
	}
	
}
