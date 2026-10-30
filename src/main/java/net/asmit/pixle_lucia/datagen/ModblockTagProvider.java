package net.asmit.pixle_lucia.datagen;

import net.asmit.pixle_lucia.blocks.Modblocks;
import net.asmit.pixle_lucia.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModblockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public ModblockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Modblocks.FLUROIT_BLOCK)
                .add(Modblocks.AETHERITE_BLOCK)
                .add(Modblocks.RAW_FLUROITE_BLOCK)
                .add(Modblocks.FLUROIT_DEEPSLATE_ORE)
                .add(Modblocks.FLUROIT_END_ORE)
                .add(Modblocks.FLUROIT_NETHER_ORE)
                .add(Modblocks.AETHERITE_ORE)
                .add(Modblocks.FLUROITE_STARE)
                .add(Modblocks.FLUROITE_SLAB)
                .add(Modblocks.AETHERITE_STAIRS)
                .add(Modblocks.AETHERITE_SLAB)
                .add(Modblocks.FLUROITE_PRESSURE_PLATE)
                .add(Modblocks.FLUROITE_BUUTTON)
                .add(Modblocks.FLUROITE_GATES)
                .add(Modblocks.FLUROITE_TRAPDOORS)
                .add(Modblocks.AETHERITE_BUUTTON)
                .add(Modblocks.AETHERITE_PRESSURE_PLATE)
                .add(Modblocks.FLUROITE_WALLS)
                .add(Modblocks.FLUROIT_ORE)
                .add(Modblocks.MAGIC_BLOCKS);

        valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(Modblocks.FLUROITE_GATES)
                .add(Modblocks.FLUROITE_FENCE);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(Modblocks.FLUROIT_END_ORE)
                .add(Modblocks.FLUROIT_NETHER_ORE)
                .add(Modblocks.FLUROIT_ORE)
                .add(Modblocks.FLUROITE_GATES)
                .add(Modblocks.FLUROITE_TRAPDOORS)
                .add(Modblocks.FLUROITE_GATES)
                .add(Modblocks.FLUROITE_WALLS)
                .add(Modblocks.FLUROITE_FENCE)
                .add(Modblocks.FLUROITE_STARE)
                .add(Modblocks.FLUROITE_SLAB)
                .add(Modblocks.FLUROITE_PRESSURE_PLATE)
                .add(Modblocks.FLUROITE_BUUTTON);
//                .add(Modblocks.MAGIC_BLOCKS)
//                .add(Modblocks.AETHERITE_ORE)
//                .add(Modblocks.AETHERITE_BLOCK)
//                .add(Modblocks.AETHERITE_SLAB)
//                .add(Modblocks.AETHERITE_BUUTTON)
//                .add(Modblocks.AETHERITE_PRESSURE_PLATE)
//                .add(Modblocks.AETHERITE_STAIRS);

        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(Modblocks.FLUROIT_DEEPSLATE_ORE);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(Modblocks.AETHERITE_ORE)
                .add(Modblocks.AETHERITE_BLOCK)
                .add(Modblocks.AETHERITE_SLAB)
                .add(Modblocks.AETHERITE_BUUTTON)
                .add(Modblocks.AETHERITE_PRESSURE_PLATE)
                .add(Modblocks.AETHERITE_STAIRS);

        // Connection ke liye zaruri tags (yehi missing the)
        valueLookupBuilder(BlockTags.FENCES).add(Modblocks.FLUROITE_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES).add(Modblocks.FLUROITE_GATES);
        valueLookupBuilder(BlockTags.WALLS).add(Modblocks.FLUROITE_WALLS);

        valueLookupBuilder(BlockTags.STAIRS)
                .add(Modblocks.FLUROITE_STARE)
                .add(Modblocks.AETHERITE_STAIRS);
        valueLookupBuilder(BlockTags.SLABS)
                .add(Modblocks.FLUROITE_SLAB)
                .add(Modblocks.AETHERITE_SLAB);
        valueLookupBuilder(BlockTags.BUTTONS)
                .add(Modblocks.FLUROITE_BUUTTON)
                .add(Modblocks.AETHERITE_BUUTTON);
        valueLookupBuilder(BlockTags.PRESSURE_PLATES)
                .add(Modblocks.FLUROITE_PRESSURE_PLATE)
                .add(Modblocks.AETHERITE_PRESSURE_PLATE);

        valueLookupBuilder(ModTags.Blocks.NEED_FLUROITE_TOOLS)
                .addTag(BlockTags.NEEDS_IRON_TOOL)
                .add(Modblocks.MAGIC_BLOCKS)
                .add(Modblocks.AETHERITE_ORE)
                .add(Modblocks.AETHERITE_BLOCK)
                .add(Modblocks.AETHERITE_SLAB)
                .add(Modblocks.AETHERITE_BUUTTON)
                .add(Modblocks.AETHERITE_BUUTTON)
                .add(Modblocks.AETHERITE_PRESSURE_PLATE)
                .add(Modblocks.AETHERITE_STAIRS);

//        valueLookupBuilder(ModTags.Blocks.INCORRECT_FOR_FLUROITE_TOOLS)
//                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);


        valueLookupBuilder(BlockTags.CROPS)
                .add(Modblocks.STRAWBERRY_CROP);

        valueLookupBuilder(ModTags.Blocks.BALSA_LOGS)
                .add(Modblocks.STRTIPPED_BALSA_LOG)
                .add(Modblocks.BALSA_LEAVES)
                .add(Modblocks.BALSA_PLANKS)
                .add(Modblocks.STRIPPED_BALSA_WOOD);

        valueLookupBuilder(BlockTags.LOGS)
                .addTag(ModTags.Blocks.BALSA_LOGS);

        valueLookupBuilder(BlockTags.PLANKS)
                .add(Modblocks.BALSA_PLANKS);

        valueLookupBuilder(BlockTags.LEAVES)
                .add(Modblocks.BALSA_LEAVES);

        valueLookupBuilder(BlockTags.SAPLINGS)
                .add(Modblocks.BALSA_SAPLING);

        valueLookupBuilder(BlockTags.FLOWER_POTS)
                .add(Modblocks.POTTED_BALSA_SAPLING);

    }
}