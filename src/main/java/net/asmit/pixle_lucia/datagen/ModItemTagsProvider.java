package net.asmit.pixle_lucia.datagen;


import net.asmit.pixle_lucia.blocks.Modblocks;
import net.asmit.pixle_lucia.item.Moditems;
import net.asmit.pixle_lucia.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider{

    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(ModTags.Items.TRANSFORMABLE_ITEM)
                .add(Moditems.FLUROITE);


        
        valueLookupBuilder(ItemTags.SWORDS).add(Moditems.FLUROITE_SWORDS);
        valueLookupBuilder(ItemTags.SPEARS).add(Moditems.FLUROITE_SPEAR);
        valueLookupBuilder(ItemTags.PICKAXES).add(Moditems.FLUROITE_PICKAXE);
        valueLookupBuilder(ItemTags.AXES).add(Moditems.FLUROITE_AXE);
        valueLookupBuilder(ItemTags.HOES).add(Moditems.FLUROITE_HOE);

        valueLookupBuilder(ItemTags.HEAD_ARMOR).add(Moditems.FLUROITE_HELMET);
        valueLookupBuilder(ItemTags.CHEST_ARMOR).add(Moditems.FLUROITE_CHESTPLATE);
        valueLookupBuilder(ItemTags.LEG_ARMOR).add(Moditems.FLUROITE_LEGGINGS);
        valueLookupBuilder(ItemTags.FOOT_ARMOR).add(Moditems.FLUROITE_BOOTS);


        valueLookupBuilder(ModTags.Items.BALSA_LOGS)
                .add(Modblocks.BALSA_LOG.asItem())
                .add(Modblocks.BALSA_WOOD.asItem())
                .add(Modblocks.STRTIPPED_BALSA_LOG.asItem())
                .add(Modblocks.STRIPPED_BALSA_WOOD.asItem());

        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
                .addTag(ModTags.Items.BALSA_LOGS);

        valueLookupBuilder(ItemTags.PLANKS)
                .add(Modblocks.BALSA_PLANKS.asItem());

        valueLookupBuilder(ItemTags.LEAVES)
                .add(Modblocks.BALSA_LEAVES.asItem());

    valueLookupBuilder(ItemTags.SAPLINGS)
                .add(Modblocks.BALSA_SAPLING.asItem());

    }
}