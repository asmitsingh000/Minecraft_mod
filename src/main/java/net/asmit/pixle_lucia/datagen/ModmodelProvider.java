package net.asmit.pixle_lucia.datagen;

import net.asmit.pixle_lucia.blocks.Modblocks;
import net.asmit.pixle_lucia.blocks.customBlocks.HoneyBerryBushBlock;
import net.asmit.pixle_lucia.blocks.customBlocks.StrawberryCropBlock;
import net.asmit.pixle_lucia.item.ModArmorMaterials;
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
        blockModelGenerators.createTrivialBlock(Modblocks.FLUROIT_DEEPSLATE_ORE, TexturedModel.CUBE);
        blockModelGenerators.createTrivialBlock(Modblocks.FLUROIT_ORE, TexturedModel.CUBE);
        blockModelGenerators.createTrivialBlock(Modblocks.FLUROIT_END_ORE, TexturedModel.CUBE);
        blockModelGenerators.createTrivialBlock(Modblocks.FLUROIT_NETHER_ORE, TexturedModel.CUBE);
        blockModelGenerators.createTrivialBlock(Modblocks.RAW_FLUROITE_BLOCK, TexturedModel.CUBE);
        blockModelGenerators.createTrivialBlock(Modblocks.MAGIC_BLOCKS, TexturedModel.CUBE);
        blockModelGenerators.createTrivialBlock(Modblocks.AETHERITE_ORE, TexturedModel.CUBE);
//        blockModelGenerators.createTrivialBlock(Modblocks.AETHERITE_BLOCK, TexturedModel.CUBE);
        blockModelGenerators.family(Modblocks.FLUROIT_BLOCK)
                .stairs(Modblocks.FLUROITE_STARE)
                .button(Modblocks.FLUROITE_BUUTTON)
                .pressurePlate(Modblocks.FLUROITE_PRESSURE_PLATE)
                .fence(Modblocks.FLUROITE_FENCE)
                .fenceGate(Modblocks.FLUROITE_GATES)
                .wall(Modblocks.FLUROITE_WALLS)
                .slab(Modblocks.FLUROITE_SLAB);
        blockModelGenerators.family(Modblocks.AETHERITE_BLOCK)
                .stairs(Modblocks.AETHERITE_STAIRS)
                .button(Modblocks.AETHERITE_BUUTTON)
                .pressurePlate(Modblocks.AETHERITE_PRESSURE_PLATE)
                .slab(Modblocks.AETHERITE_SLAB);

        //FOR THE DOORS AND TRAPDOORS
        blockModelGenerators.createDoor(Modblocks.FLUROITE_DOORS);
        blockModelGenerators.createTrapdoor(Modblocks.FLUROITE_TRAPDOORS);


        blockModelGenerators.createCropBlock(Modblocks.STRAWBERRY_CROP, StrawberryCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockModelGenerators.createCrossBlock(Modblocks.HONEY_BERRY_BUSH, BlockModelGenerators.PlantType.NOT_TINTED, HoneyBerryBushBlock.AGE, 0, 1, 2, 3);

        blockModelGenerators.woodProvider(Modblocks.BALSA_LOG).log(Modblocks.BALSA_LOG).wood(Modblocks.BALSA_WOOD);
        blockModelGenerators.woodProvider(Modblocks.STRTIPPED_BALSA_LOG).log(Modblocks.STRTIPPED_BALSA_LOG).wood(Modblocks.STRIPPED_BALSA_WOOD);

        blockModelGenerators.createTrivialCube(Modblocks.BALSA_PLANKS);
        blockModelGenerators.createTrivialBlock(Modblocks.BALSA_LEAVES,TexturedModel.LEAVES);

        blockModelGenerators.createPlantWithDefaultItem(Modblocks.BALSA_SAPLING,Modblocks.POTTED_BALSA_SAPLING,BlockModelGenerators.PlantType.NOT_TINTED);


    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        //THIS PART IS USED WHEN YOU HAVE ADDED NEW ITEMS
        itemModelGenerators.generateFlatItem(Moditems.FLUROITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(Moditems.RAW_FLUROITE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(Moditems.AETHERITE_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(Moditems.CHISEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(Moditems.STRAWBERY, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(Moditems.COMBUSTABLE_SPORES, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(Moditems.FLUROITE_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(Moditems.FLUROITE_SWORDS, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(Moditems.FLUROITE_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateFlatItem(Moditems.FLUROITE_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerators.generateSpear(Moditems.FLUROITE_SPEAR);

        itemModelGenerators.generateTrimmableItem(Moditems.FLUROITE_HELMET, ModArmorMaterials.FLUROITE_KEY, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModelGenerators.generateTrimmableItem(Moditems.FLUROITE_CHESTPLATE, ModArmorMaterials.FLUROITE_KEY, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModelGenerators.generateTrimmableItem(Moditems.FLUROITE_LEGGINGS, ModArmorMaterials.FLUROITE_KEY, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModelGenerators.generateTrimmableItem(Moditems.FLUROITE_BOOTS, ModArmorMaterials.FLUROITE_KEY, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);
    }
}