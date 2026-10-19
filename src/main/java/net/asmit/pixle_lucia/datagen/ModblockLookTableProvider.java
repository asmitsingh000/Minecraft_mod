package net.asmit.pixle_lucia.datagen;

import net.asmit.pixle_lucia.blocks.Modblocks;
import net.asmit.pixle_lucia.item.Moditems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class ModblockLookTableProvider extends FabricBlockLootSubProvider {
    public ModblockLookTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
//        dropSelf(Modblocks.FLUROIT_DEEPSLATE_ORE);
//        dropSelf(Modblocks.FLUROIT_END_ORE);
        dropSelf(Modblocks.FLUROIT_BLOCK);
        dropSelf(Modblocks.RAW_FLUROITE_BLOCK);

        //FOR SINGLE DROPS LIKE IF YOU WANT IT TO DROP SOMETHING SINGLE THEN USE createOreDrop
        add(Modblocks.MAGIC_BLOCKS,createOreDrop(Modblocks.MAGIC_BLOCKS,Moditems.CHISEL));
        add(Modblocks.FLUROIT_DEEPSLATE_ORE, createOreDrop(Modblocks.FLUROIT_DEEPSLATE_ORE, Moditems.RAW_FLUROITE));
        add(Modblocks.FLUROIT_END_ORE,createOreDrop(Modblocks.FLUROIT_END_ORE,Moditems.RAW_FLUROITE));

        //IF YOU WANT THAT ENCHANTMENT SHOWS THE SKILLS THEN USE createMultipleOreDrops
        add(Modblocks.FLUROIT_END_ORE,createMultipleOreDrops(Modblocks.FLUROIT_END_ORE,Moditems.RAW_FLUROITE,5,8));
//        add(Modblocks.FLUROIT_DEEPSLATE_ORE,createMultipleOreDrops(Modblocks.FLUROIT_DEEPSLATE_ORE,Moditems.RAW_FLUROITE,5,8));
    }

    public LootTable.Builder createMultipleOreDrops(final Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                block,
                (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(
                        block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
