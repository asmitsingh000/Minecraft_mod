package net.asmit.pixle_lucia.worlgen;


import net.asmit.pixle_lucia.Pixle_Lucia;
import net.asmit.pixle_lucia.blocks.Modblocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    // CF => Features with Configuration
    // Tree --> height, what trunks etc etc...
    // How something looks like
    public static final ResourceKey<ConfiguredFeature<?,?>> OVERWORLD_FLUROITE_ORE_KEY =  registerKey("overworld_fluroite_ore_key");
    public static final ResourceKey<ConfiguredFeature<?,?>> NETHER_FLUROITE_ORE_KEY =  registerKey("nether_fluroite_ore_key");
    public static final ResourceKey<ConfiguredFeature<?,?>> END_FLUROITE_ORE_KEY =  registerKey("end_fluroite_ore_key");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);


        register(context,OVERWORLD_FLUROITE_ORE_KEY, Feature.ORE,new OreConfiguration(
                List.of(
                        OreConfiguration.target(stoneReplaceables, Modblocks.FLUROIT_ORE.defaultBlockState()),
                        OreConfiguration.target(deepslateReplaceables,
                                Modblocks.FLUROIT_DEEPSLATE_ORE.defaultBlockState())),
                4));
        register(context,NETHER_FLUROITE_ORE_KEY,Feature.ORE,new OreConfiguration(
                netherReplaceables,Modblocks.FLUROIT_NETHER_ORE.defaultBlockState(),10));
        register(context,END_FLUROITE_ORE_KEY,Feature.ORE,new OreConfiguration(
                endReplaceables,Modblocks.FLUROIT_END_ORE.defaultBlockState(),12
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