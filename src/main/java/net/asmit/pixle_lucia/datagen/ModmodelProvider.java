package net.asmit.pixle_lucia.datagen;

import net.asmit.pixle_lucia.blocks.Modblocks;
import net.asmit.pixle_lucia.item.Moditems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TexturedModel;

public class ModmodelProvider extends FabricModelProvider {
    public ModmodelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        //THIS PART IS USED WHEN YOU HAVE ADDED NEW BLOCKS
        blockModelGenerators.createTrivialBlock(Modblocks.FLUROIT_BLOCK, TexturedModel.CUBE);
        blockModelGenerators.createTrivialBlock(Modblocks.FLUROIT_DEEPSLATE_ORE, TexturedModel.CUBE);
        blockModelGenerators.createTrivialBlock(Modblocks.FLUROIT_END_ORE, TexturedModel.CUBE);
        blockModelGenerators.createTrivialBlock(Modblocks.RAW_FLUROITE_BLOCK, TexturedModel.CUBE);
        blockModelGenerators.createTrivialBlock(Modblocks.MAGIC_BLOCKS, TexturedModel.CUBE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        //THIS PART IS USED WHEN YOU HAVE ADDED NEW ITEMS
        itemModelGenerators.generateFlatItem(Moditems.FLUROITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(Moditems.RAW_FLUROITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(Moditems.CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
    }
}
