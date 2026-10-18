package net.asmit.pixle_lucia.datagen;

import net.asmit.pixle_lucia.item.Moditems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModmodelProvider extends FabricModelProvider {


    public ModmodelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(Moditems.FLUROITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(Moditems.RAW_FLUROITE, ModelTemplates.FLAT_ITEM);
    }
}
