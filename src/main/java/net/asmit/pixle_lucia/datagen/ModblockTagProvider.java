package net.asmit.pixle_lucia.datagen;

import net.asmit.pixle_lucia.blocks.Modblocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

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
                .add(Modblocks.AETHERITE_ORE)
                .add(Modblocks.FLUROITE_STARE)
                .add(Modblocks.FLUROITE_SLAB)
                .add(Modblocks.AETHERITE_STAIRS)
                .add(Modblocks.AETHERITE_SLAB)
                .add(Modblocks.MAGIC_BLOCKS);


        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(Modblocks.FLUROIT_END_ORE)
                .add(Modblocks.FLUROITE_STARE)
                .add(Modblocks.FLUROITE_SLAB)
                .add(Modblocks.MAGIC_BLOCKS);


//        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(Modblocks.MAGIC_BLOCKS);
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(Modblocks.FLUROIT_DEEPSLATE_ORE);


        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add((Modblocks.AETHERITE_ORE))
                .add((Modblocks.AETHERITE_BLOCK))
                .add((Modblocks.AETHERITE_SLAB))
                .add(Modblocks.AETHERITE_STAIRS);
        valueLookupBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add((Modblocks.AETHERITE_ORE))
                .add((Modblocks.AETHERITE_BLOCK))
                .add((Modblocks.AETHERITE_SLAB))
                .add(Modblocks.AETHERITE_STAIRS);


    }
}
