package net.asmit.pixle_lucia.datagen;

import net.asmit.pixle_lucia.blocks.Modblocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModblockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public ModblockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Modblocks.FLUROIT_BLOCK)
                .add(Modblocks.FLUROIT_DEEPSLATE_ORE)
                .add(Modblocks.FLUROIT_END_ORE);
        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
