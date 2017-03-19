package trappistone.TrappistSystem.planets.trappistOneC.dimension;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

import trappistone.core.world.gen.ChunkProviderSpaceCraters;
import trappistone.core.world.gen.ChunkProviderSpaceLakes;
import trappistone.core.world.gen.TPBiomeGenBase;
import trappistone.TrappistSystem.planets.trappistOneB.world.gen.BiomeDecoratorTrappistOneBOre;
import trappistone.TrappistSystem.planets.trappistOneB.world.gen.MapGenCavesTrappistOneB;
import trappistone.TrappistSystem.planets.trappistOneC.world.gen.BiomeDecoratorTrappistOneCOre;
import trappistone.TrappistSystem.planets.trappistOneC.world.gen.MapGenCavesTrappistOneC;
import micdoodle8.mods.galacticraft.api.prefab.core.BlockMetaPair;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.MapGenBaseMeta;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.perlin.NoiseModule;
import micdoodle8.mods.galacticraft.core.perlin.generator.Gradient;
import micdoodle8.mods.galacticraft.core.world.gen.EnumCraterSize;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.IChunkProvider;

import com.google.common.collect.Lists;


 

public class ChunkProviderTrappistOneC extends ChunkProviderSpaceLakes {
	
	
    private List<MapGenBaseMeta> worldGenerators;
    
    private BiomeGenBase[] biomesForGeneration = this.getBiomesForGeneration();
    private final MapGenCavesTrappistOneC caveGenerator = new MapGenCavesTrappistOneC();

 @Override
    protected List<MapGenBaseMeta> getWorldGenerators()
    {
        List<MapGenBaseMeta> generators = Lists.newArrayList();
        generators.add(this.caveGenerator);
        return generators;
    }

public ChunkProviderTrappistOneC(World par1World, long seed, boolean mapFeaturesEnabled) 

{
	super(par1World, seed, mapFeaturesEnabled);

}

@Override

protected BiomeDecoratorSpace getBiomeGenerator() {


    return new BiomeDecoratorTrappistOneCOre();

}



 //This should be a custom biome for your mod, but I'm opting to go desert instead out of quickness

//and the fact that biomes are outside the scope of this tutorial

@Override

protected BiomeGenBase[] getBiomesForGeneration() {


    return new BiomeGenBase[]{TPBiomeGenBase.Space};

}



@Override
protected SpawnListEntry[] getCreatures() {

 

    return new SpawnListEntry[]{};

}


@Override
public double getHeightModifier() {

    return 5;

}



@Override

protected SpawnListEntry[] getMonsters() {

    SpawnListEntry skele = new SpawnListEntry(EntityEvolvedSkeleton.class, 100, 4, 4);
    SpawnListEntry creeper = new SpawnListEntry(EntityEvolvedCreeper.class, 100, 4, 4);
    SpawnListEntry spider = new SpawnListEntry(EntityEvolvedSpider.class, 100, 4, 4);
    
    return new SpawnListEntry[]{skele, creeper, spider};

}








@Override

public void onPopulate(IChunkProvider arg0, int arg1, int arg2){
	
	
	

}


@Override

public boolean chunkExists(int x, int y){

    return false;

}


@Override
protected SpawnListEntry[] getWaterCreatures() {

	return new SpawnListEntry[]{};
}

@Override
protected BlockMetaPair getGrassBlock() {
	return new BlockMetaPair(GCBlocks.basicBlock, (byte) 12);
}

@Override
protected BlockMetaPair getDirtBlock() {
	return new BlockMetaPair(GCBlocks.basicBlock, (byte) 12);
}

@Override
protected BlockMetaPair getStoneBlock() {
	return new BlockMetaPair(Blocks.stone, (byte) 0);
}

@Override
protected boolean enableBiomeGenBaseBlock() {
	return false;
}

@Override
public void onChunkProvider(int cX, int cZ, Block[] blocks, byte[] metadata) {
	
}

@Override
public int getWaterLevel() {

	return 70;
}

@Override
public boolean canGenerateWaterBlock() {
	return true;
}

@Override
public boolean canGenerateIceBlock() {

	return false;
}

@Override
protected BlockMetaPair getWaterBlock() {
	return new BlockMetaPair(Blocks.packed_ice, (byte) 0);
}

}