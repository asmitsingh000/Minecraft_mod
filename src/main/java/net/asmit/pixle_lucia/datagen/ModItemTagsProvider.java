package net.asmit.pixle_lucia.datagen;


import net.asmit.pixle_lucia.item.Moditems;
import net.asmit.pixle_lucia.tags.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

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
        valueLookupBuilder(ItemTags.SPEARS).add(Moditems.FLUORITE_SPEARS);
        valueLookupBuilder(ItemTags.PICKAXES).add(Moditems.FLUROITE_PICKAXE);
        valueLookupBuilder(ItemTags.AXES).add(Moditems.FLUROITE_AXE);
        valueLookupBuilder(ItemTags.HOES).add(Moditems.FLUROITE_HOE);

        valueLookupBuilder(ItemTags.HEAD_ARMOR).add(Moditems.FLUROITE_HELMET);
        valueLookupBuilder(ItemTags.CHEST_ARMOR).add(Moditems.FLUROITE_CHESTPLATE);
        valueLookupBuilder(ItemTags.LEG_ARMOR).add(Moditems.FLUROITE_LEGGINGS);
        valueLookupBuilder(ItemTags.FOOT_ARMOR).add(Moditems.FLUROITE_BOOTS);
    }
}