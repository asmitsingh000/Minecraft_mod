package net.asmit.pixle_lucia.worlgen;

import net.asmit.pixle_lucia.Pixle_Lucia;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> OVERWORLD_ORE_PLACED_KEY = registerKey("overworld_ore_placed_key");
    public static final ResourceKey<PlacedFeature> NETHER_ORE_PLACED_KEY = registerKey("nether_ore_placed_key");
    public static final ResourceKey<PlacedFeature> END_ORE_PLACED_KEY = registerKey("end_ore_placed_key");

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
                orePlacement(CountPlacement.of(1),
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(8), VerticalAnchor.absolute(24))));

        // END: jaisa tha waisa hi
        register(context, END_ORE_PLACED_KEY,
                configuredFeatures.getOrThrow(ModConfiguredFeatures.END_FLUROITE_ORE_KEY),
                orePlacement(CountPlacement.of(12),
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(100))));
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