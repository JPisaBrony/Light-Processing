package LightProcessing.common.generation;

import java.util.Random;

import LightProcessing.common.lib.IDRef;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneration implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
				break;
		}
	}

	private void generateSurface(World world, Random random, int BlockX, int BlockZ) {
		// Light Tree Generation
		for(int i = 0; i < 1; i++) {
			int XCoord = BlockX + random.nextInt(16);
			int YCoord = random.nextInt(100);
			int ZCoord = BlockZ + random.nextInt(16);
			
			new WorldGenLightTree(false, 4, 0, 0).generate(world, random, XCoord, YCoord, ZCoord);
		}
		
		// Light Ore Generation
		for(int i = 0; i < 5; i++) {
			int XCoordOre = BlockX + random.nextInt(16);
			int YCoordOre = random.nextInt(70);
			int ZCoordOre = BlockZ + random.nextInt(16);
			
			new WorldGenMinable(IDRef.LIGHT_ORE_ID, 5).generate(world, random, XCoordOre, YCoordOre, ZCoordOre);
		}
	}
	
}