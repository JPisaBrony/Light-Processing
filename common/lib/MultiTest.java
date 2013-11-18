package LightProcessing.common.lib;

import net.minecraft.world.World;
import LightProcessing.common.lib.Methods;
import LightProcessing.common.lib.IDRef;

public class MultiTest {
	static int DL = LightProcessing.common.lib.IDRef.DARK_LEAF_ID;
	static int LW = LightProcessing.common.lib.IDRef.LIGHT_WOOD_ID;
	static int HV = LightProcessing.common.lib.IDRef.HARVESTER_ID;
	
public static void HarvesterTest(World world, int x, int y, int z){
	if(!world.isRemote){
	if(world.getBlockId(x + 2, y, z) == DL){
		world.setBlock(x + 2, y, z, 0);
		if(world.getBlockId(x + 2, y, z - 1) == DL){
			world.setBlock(x + 2, y, z - 1, 0);
			if(world.getBlockId(x + 2, y, z + 1) == DL){
				world.setBlock(x + 2, y, z + 1, 0);
				if(world.getBlockId(x - 2, y, z) == DL){
					world.setBlock(x - 2, y, z, 0);
					if(world.getBlockId(x - 2, y, z - 1) == DL){
						world.setBlock(x - 2, y, z - 1, 0);
						if(world.getBlockId(x - 2, y, z + 1) == DL){
							world.setBlock(x - 2, y, z + 1, 0);
							if(world.getBlockId(x, y, z + 2) == DL){
								world.setBlock(x, y, z + 2, 0);
								if(world.getBlockId(x - 1, y, z + 2) == DL){
									world.setBlock(x - 1, y, z + 2, 0);
									if(world.getBlockId(x + 1, y, z + 2) == DL){
										world.setBlock(x + 1, y, z + 2, 0);
										if(world.getBlockId(x, y, z - 2) == DL){
											world.setBlock(x, y, z - 2, 0);
											if(world.getBlockId(x - 1, y, z - 2) == DL){
												world.setBlock(x - 1, y, z - 2, 0);
												if(world.getBlockId(x + 1, y, z - 2) == DL){
													world.setBlock(x + 1, y, z - 2, 0);
													if(world.getBlockId(x + 2, y, z - 2) == LW){
														world.setBlock(x + 2, y, z - 2, 0);
														if(world.getBlockId(x + 2, y, z + 2) == LW){
															world.setBlock(x + 2, y, z + 2, 0);
															if(world.getBlockId(x - 2, y, z - 2) == LW){
																world.setBlock(x - 2, y, z - 2, 0);
																if(world.getBlockId(x - 2, y, z + 2) == LW){
																	world.setBlock(x - 2, y, z + 2, 0);
																	if(world.getBlockId(x + 1, y, z) == 0){
																		if(world.getBlockId(x + 1, y, z - 1) == 0){
																			if(world.getBlockId(x + 1, y, z + 1) == 0){
																				if(world.getBlockId(x - 1, y, z) == 0){
																					if(world.getBlockId(x - 1, y, z - 1) == 0){
																						if(world.getBlockId(x - 1, y, z + 1) == 0){
																							if(world.getBlockId(x, y, z + 1) == 0){
																								if(world.getBlockId(x, y, z - 1) == 0){
																									world.setBlock(x, y, z, HV);
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}	
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
}
}