package net.asmit.pixle_lucia.datagen;

import net.asmit.pixle_lucia.blocks.Modblocks;
import net.asmit.pixle_lucia.blocks.customBlocks.HoneyBerryBushBlock;
import net.asmit.pixle_lucia.blocks.customBlocks.StrawberryCropBlock;
import net.asmit.pixle_lucia.item.Moditems;
import net.asmit.pixle_lucia.tags.ModTags;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class ModblockLookTableProvider extends FabricBlockLootSubProvider {
    public ModblockLookTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {

        var enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
//        dropSelf(Modblocks.FLUROIT_DEEPSLATE_ORE);
//        dropSelf(Modblocks.FLUROIT_END_ORE);
        dropSelf(Modblocks.FLUROIT_BLOCK);
        dropSelf(Modblocks.AETHERITE_BLOCK);
        dropSelf(Modblocks.RAW_FLUROITE_BLOCK);
        dropSelf(Modblocks.FLUROITE_STARE);
        dropSelf(Modblocks.AETHERITE_STAIRS);
        dropSelf(Modblocks.FLUROITE_SLAB);
        dropSelf(Modblocks.AETHERITE_SLAB);
        add(Modblocks.FLUROITE_SLAB, this::createSlabItemTable);
        add(Modblocks.AETHERITE_SLAB, this::createSlabItemTable);
        dropSelf(Modblocks.FLUROITE_BUUTTON);
        dropSelf(Modblocks.AETHERITE_BUUTTON);
        dropSelf(Modblocks.FLUROITE_PRESSURE_PLATE);
        dropSelf(Modblocks.AETHERITE_PRESSURE_PLATE);
        dropSelf(Modblocks.FLUROITE_WALLS);
        dropSelf(Modblocks.FLUROITE_FENCE);
        dropSelf(Modblocks.FLUROITE_GATES);
        dropSelf(Modblocks.FLUROITE_DOORS);
        dropSelf(Modblocks.FLUROITE_TRAPDOORS);
        //BALSA TREES THINGS
        add(Modblocks.BALSA_LEAVES,block -> createLeavesDrops(block,Modblocks.BALSA_LEAVES,NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(Modblocks.BALSA_LOG);
        dropSelf(Modblocks.BALSA_PLANKS);
        dropSelf(Modblocks.STRIPPED_BALSA_WOOD);
        dropSelf(Modblocks.STRTIPPED_BALSA_LOG);
        dropSelf(Modblocks.BALSA_SAPLING);
        add(Modblocks.POTTED_BALSA_SAPLING,block -> createPotFlowerItemTable(Modblocks.BALSA_SAPLING));


        this.add(Modblocks.STRAWBERRY_CROP, this.createCropDrops(Modblocks.STRAWBERRY_CROP, Moditems.STRAWBERY, Moditems.STRAWBERRY_SEEDS,
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Modblocks.STRAWBERRY_CROP)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE, StrawberryCropBlock.MAX_AGE))));


        this.add(Modblocks.HONEY_BERRY_BUSH, block -> this.applyExplosionDecay(block,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(Modblocks.HONEY_BERRY_BUSH)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HoneyBerryBushBlock.AGE, 3)))
                        .add(LootItem.lootTableItem(Moditems.HONEY_BERRIES))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Modblocks.HONEY_BERRY_BUSH)
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HoneyBerryBushBlock.AGE, 2)))
                        .add(LootItem.lootTableItem(Moditems.HONEY_BERRIES))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                        .apply(ApplyBonusCount.addUniformBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))))
        );

        //FOR SINGLE DROPS LIKE IF YOU WANT IT TO DROP SOMETHING SINGLE THEN USE createOreDrop
        add(Modblocks.MAGIC_BLOCKS, createOreDrop(Modblocks.MAGIC_BLOCKS, Moditems.CHISEL));
        add(Modblocks.FLUROIT_DEEPSLATE_ORE, createOreDrop(Modblocks.FLUROIT_DEEPSLATE_ORE, Moditems.RAW_FLUROITE));
        add(Modblocks.FLUROIT_ORE, createOreDrop(Modblocks.FLUROIT_ORE, Moditems.RAW_FLUROITE));
        add(Modblocks.FLUROIT_END_ORE, createOreDrop(Modblocks.FLUROIT_END_ORE, Moditems.RAW_FLUROITE));
        add(Modblocks.FLUROIT_NETHER_ORE, createOreDrop(Modblocks.FLUROIT_NETHER_ORE, Moditems.RAW_FLUROITE));

        //IF YOU WANT THAT ENCHANTMENT SHOWS THE SKILLS THEN USE createMultipleOreDrops
        add(Modblocks.FLUROIT_END_ORE, createMultipleOreDrops(Modblocks.FLUROIT_END_ORE, Moditems.RAW_FLUROITE, 5, 8));
        add(Modblocks.FLUROIT_NETHER_ORE, createMultipleOreDrops(Modblocks.FLUROIT_NETHER_ORE, Moditems.RAW_FLUROITE, 5, 8));
        add(Modblocks.FLUROIT_DEEPSLATE_ORE, createMultipleOreDrops(Modblocks.FLUROIT_DEEPSLATE_ORE, Moditems.RAW_FLUROITE, 5, 8));
        add(Modblocks.FLUROIT_ORE, createMultipleOreDrops(Modblocks.FLUROIT_ORE, Moditems.RAW_FLUROITE, 5, 8));
        add(Modblocks.AETHERITE_ORE, createMultipleOreDrops(Modblocks.AETHERITE_ORE, Moditems.AETHERITE_INGOT, 2, 5));
//        add(Modblocks.FLUROIT_DEEPSLATE_ORE,createMultipleOreDrops(Modblocks.FLUROIT_DEEPSLATE_ORE,Moditems.RAW_FLUROITE,5,8));
    }

    public LootTable.Builder createMultipleOreDrops(final Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                block,
                (LootPoolEntryContainer.Builder<?>) this.applyExplosionDecay(
                        block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
