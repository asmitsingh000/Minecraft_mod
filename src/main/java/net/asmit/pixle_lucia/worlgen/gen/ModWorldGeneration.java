package net.asmit.pixle_lucia.worlgen.gen;

import net.asmit.pixle_lucia.worlgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModWorldGeneration {
    public static void generateModWorldGen(){
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.UNDERGROUND_ORES,
                ModPlacedFeatures.OVERWORLD_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Decoration.UNDERGROUND_ORES,
                ModPlacedFeatures.NETHER_ORE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Decoration.UNDERGROUND_ORES,
                ModPlacedFeatures.END_ORE_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.PLAINS,Biomes.SAVANNA,Biomes.STONY_SHORE,Biomes.SMALL_END_ISLANDS),
                GenerationStep.Decoration.VEGETAL_DECORATION,ModPlacedFeatures.BALSA_PLACED_KEY);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(Biomes.PLAINS,Biomes.SAVANNA,Biomes.STONY_SHORE,Biomes.SMALL_END_ISLANDS),
                GenerationStep.Decoration.VEGETAL_DECORATION,ModPlacedFeatures.HONEY_BERRY_BUSH_PLACED_KEY);



    }

}
