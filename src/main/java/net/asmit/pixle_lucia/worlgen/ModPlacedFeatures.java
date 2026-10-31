package net.asmit.pixle_lucia.worlgen;

import net.asmit.pixle_lucia.Pixle_Lucia;
import net.asmit.pixle_lucia.blocks.Modblocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.VegetationBlock;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> OVERWORLD_ORE_PLACED_KEY = registerKey("overworld_ore_placed_key");
    public static final ResourceKey<PlacedFeature> NETHER_ORE_PLACED_KEY = registerKey("nether_ore_placed_key");
    public static final ResourceKey<PlacedFeature> END_ORE_PLACED_KEY = registerKey("end_ore_placed_key");
    public static final ResourceKey<PlacedFeature> BALSA_PLACED_KEY = registerKey("balsa_placed_key");
    public static final ResourceKey<PlacedFeature> HONEY_BERRY_BUSH_PLACED_KEY = registerKey("honey_berry_bush_placed_key");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // OVERWORLD: diamond se rare -> 4 veins/chunk, gehrayi pe (deepslate level)
        register(context, OVERWORLD_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_FLUROITE_ORE_KEY),
                orePlacement(CountPlacement.of(4),
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(16))));

        // NETHER: ancient debris jaisa -> 1 vein/chunk, Y 8 se 24 ke beech
        register(context, NETHER_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_FLUROITE_ORE_KEY),
                orePlacement(CountPlacement.of(3),
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(8), VerticalAnchor.absolute(24))));

        // END: jaisa tha waisa hi
        register(context, END_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.END_FLUROITE_ORE_KEY),
                orePlacement(CountPlacement.of(6),
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(100))));

        register(context,BALSA_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.BALSA_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3,0.1f,2),
                        Modblocks.BALSA_SAPLING));

        register(context,HONEY_BERRY_BUSH_PLACED_KEY,configuredFeatures.getOrThrow(ModConfiguredFeatures.HONEY_BERRY_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32),InSquarePlacement.spread(),PlacementUtils.HEIGHTMAP_WORLD_SURFACE,BiomeFilter.biome()));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier count, PlacementModifier height) {
        return List.of(count, InSquarePlacement.spread(), height, BiomeFilter.biome());
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}