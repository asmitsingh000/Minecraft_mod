package net.asmit.pixle_lucia.worlgen;


import net.asmit.pixle_lucia.Pixle_Lucia;
import net.asmit.pixle_lucia.blocks.Modblocks;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    // CF => Features with Configuration
    // Tree --> height, what trunks etc etc...
    // How something looks like
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_FLUROITE_ORE_KEY = registerKey("overworld_fluroite_ore_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_FLUROITE_ORE_KEY = registerKey("nether_fluroite_ore_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_FLUROITE_ORE_KEY = registerKey("end_fluroite_ore_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BALSA_KEY = registerKey("balsa_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HONEY_BERRY_BUSH_KEY = registerKey("honey_berry_key");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);


        register(context, OVERWORLD_FLUROITE_ORE_KEY, Feature.ORE, new OreConfiguration(
                List.of(
                        OreConfiguration.target(stoneReplaceables, Modblocks.FLUROIT_ORE.defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables,
                                Modblocks.FLUROIT_DEEPSLATE_ORE.defaultBlockState())),
                4));
        register(context, NETHER_FLUROITE_ORE_KEY, Feature.ORE, new OreConfiguration(
                netherReplaceables, Modblocks.FLUROIT_NETHER_ORE.defaultBlockState(), 10));
        register(context, END_FLUROITE_ORE_KEY, Feature.ORE, new OreConfiguration(
                endReplaceables, Modblocks.FLUROIT_END_ORE.defaultBlockState(), 12
        ));

        register(context, BALSA_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Modblocks.BALSA_LOG),
                new CherryTrunkPlacer(
                        7, 1, 0,
                        new WeightedListInt(WeightedList.<IntProvider>builder()
                                .add(ConstantInt.of(1), 1)
                                .add(ConstantInt.of(2), 1)
                                .add(ConstantInt.of(3), 1)
                                .build()),
                        UniformInt.of(2, 4),
                        UniformInt.of(-4, -3),
                        UniformInt.of(-1, 0)),

                BlockStateProvider.simple(Modblocks.BALSA_LEAVES),
                new CherryFoliagePlacer(
                        ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5),
                        0.25f, 0.5f, 0.16666667f, 0.33333334f),

                new TwoLayersFeatureSize(1, 0, 2)
        ).ignoreVines().build());

        register(context,HONEY_BERRY_BUSH_KEY,Feature.SIMPLE_RANDOM_SELECTOR,
                new SimpleRandomFeatureConfiguration(
                        HolderSet.direct(PlacementUtils.inlinePlaced(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(BlockStateProvider.simple(Modblocks.HONEY_BERRY_BUSH
                                        .defaultBlockState().setValue(SweetBerryBushBlock.AGE,3))),
                                CountPlacement.of(32),
                                RandomOffsetPlacement.ofTriangle(6,3),
                                BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_PREDICATE)
                        ))
                ));


    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}