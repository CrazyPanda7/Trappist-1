package trappistone.TrappistSystem.planets.trappistOneC.world.gen;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BiomeDecoratorTrappistOneCOre extends BiomeDecoratorSpace
{
	private World world;

	public BiomeDecoratorTrappistOneCOre()
	{

	}	

	@Override
	protected void decorate()
	{
		for (int i = 0; i < 1200; i++) {
			int randPosY = rand.nextInt(140);		
			
			for (int x = 0; x < 16; x++)
				for(int z = 0; z < 16; z++)
				{
					int randPosX = chunkX + x;
					int randPosZ = chunkZ + z;
					
					if (this.world.getBlock(randPosX, randPosY - 1, randPosZ) == GCBlocks.basicBlock && this.world.getBlockMetadata(randPosX, randPosY - 1, randPosZ) == 12 && this.world.isAirBlock(randPosX, randPosY, randPosZ))
					{
						this.world.setBlock(randPosX, randPosY, randPosZ, Blocks.snow_layer);	        	
					}
				}
		}
	}

	@Override
	protected void setCurrentWorld(World world)
	{
		this.world = world;
	}

	@Override
	protected World getCurrentWorld()
	{
		return this.world;
	}
}