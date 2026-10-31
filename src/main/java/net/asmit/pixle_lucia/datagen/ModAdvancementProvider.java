package net.asmit.pixle_lucia.datagen;

import net.asmit.pixle_lucia.Pixle_Lucia;
import net.asmit.pixle_lucia.blocks.Modblocks;
import net.asmit.pixle_lucia.item.Moditems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.*;
import net.minecraft.advancements.criterion.ImpossibleTrigger;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registries, Consumer<AdvancementHolder> output) {
        HolderGetter<Item> items = registries.lookupOrThrow(Registries.ITEM);

        // 1. ROOT: pehli baar fluroite mila
        AdvancementHolder root = Advancement.Builder.advancement()
                .display(Moditems.FLUROITE,
                        Component.translatable("advancement.pixle_lucia.root.title"),
                        Component.translatable("advancement.pixle_lucia.root.description"),
                        Identifier.withDefaultNamespace("gui/advancement/backgrounds/adventure"),
                        AdvancementType.TASK, true, true, false)
                .addCriterion("has_fluroite", has(items, Moditems.FLUROITE))
                .save(output, id("root"));

        // 2. Koi bhi ek fluroite armor piece (4 mein se koi bhi ek chalega)
        AdvancementHolder armorPiece = Advancement.Builder.advancement().parent(root)
                .display(Moditems.FLUROITE_CHESTPLATE,
                        Component.translatable("advancement.pixle_lucia.armor_piece.title"),
                        Component.translatable("advancement.pixle_lucia.armor_piece.description"),
                        null, AdvancementType.TASK, true, true, false)
                .addCriterion("has_helmet",
                        has(items, Moditems.FLUROITE_HELMET))
                .addCriterion("has_chestplate",
                        has(items, Moditems.FLUROITE_CHESTPLATE))
                .addCriterion("has_leggings",
                        has(items, Moditems.FLUROITE_LEGGINGS))
                .addCriterion("has_boots",
                        has(items, Moditems.FLUROITE_BOOTS))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(output, id("armor_piece"));

        // 3. Poora fluroite armor set
        AdvancementHolder fullArmor = Advancement.Builder.advancement().parent(armorPiece)
                .display(Moditems.FLUROITE_HELMET,
                        Component.translatable("advancement.pixle_lucia.full_armor.title"),
                        Component.translatable("advancement.pixle_lucia.full_armor.description"),
                        null, AdvancementType.GOAL, true, true, false)
                .addCriterion("has_full_set", has(items,
                        Moditems.FLUROITE_HELMET,
                        Moditems.FLUROITE_CHESTPLATE,
                        Moditems.FLUROITE_LEGGINGS,
                        Moditems.FLUROITE_BOOTS))
                .save(output, id("full_armor"));

        // 4. Chisel
        AdvancementHolder chisel = Advancement.Builder.advancement().parent(root)
                .display(Moditems.CHISEL,
                        Component.translatable("advancement.pixle_lucia.chisel.title"),
                        Component.translatable("advancement.pixle_lucia.chisel.description"),
                        null, AdvancementType.TASK, true, true, false)
                .addCriterion("has_chisel", has(items, Moditems.CHISEL))
                .save(output, id("chisel"));

        // 5. Magic block mila (End city chest se)
        AdvancementHolder magicFound = Advancement.Builder.advancement().parent(root)
                .display(Modblocks.MAGIC_BLOCKS,
                        Component.translatable("advancement.pixle_lucia.magic_found.title"),
                        Component.translatable("advancement.pixle_lucia.magic_found.description"),
                        null, AdvancementType.GOAL, true, true, false)
                .addCriterion("has_magic_block", has(items, Modblocks.MAGIC_BLOCKS))
                .save(output, id("magic_found"));

        // 6. Magic block use kiya (code se award hota hai, neeche dekh)
        AdvancementHolder magicUsed = Advancement.Builder.advancement().parent(magicFound)
                .display(Moditems.FLUROITE,
                        Component.translatable("advancement.pixle_lucia.magic_used.title"),
                        Component.translatable("advancement.pixle_lucia.magic_used.description"),
                        null, AdvancementType.GOAL, true, true, false)
                .addCriterion("used_magic_block",
                        CriteriaTriggers.IMPOSSIBLE.createCriterion(new ImpossibleTrigger.TriggerInstance()))
                .save(output, id("magic_used"));

        // 7. TOP TIER: sab kuch (challenge, minecraft ke "Overkill/Beaconator" jaisa)
        Advancement.Builder.advancement().parent(magicUsed)
                .display(Moditems.FLUROITE_SWORDS,
                        Component.translatable("advancement.pixle_lucia.king.title"),
                        Component.translatable("advancement.pixle_lucia.king.description"),
                        null, AdvancementType.CHALLENGE, true, true, true)
                .addCriterion("has_everything", has(items,
                        Moditems.FLUROITE_HELMET,
                        Moditems.FLUROITE_CHESTPLATE,
                        Moditems.FLUROITE_LEGGINGS,
                        Moditems.FLUROITE_BOOTS,
                        Moditems.FLUROITE_SWORDS,
                        Moditems.FLUROITE_PICKAXE,
                        Moditems.FLUROITE_AXE,
                        Moditems.FLUROITE_HOE,
                        Moditems.FLUROITE_SPEAR,
                        Moditems.CHISEL,
                        Modblocks.MAGIC_BLOCKS))
                .rewards(AdvancementRewards.Builder.experience(100))
                .save(output, id("king"));
    }

    private static String id(String name) {
        return Pixle_Lucia.MOD_ID + ":pixlemod/" + name;
    }

    // Ek ya zyada items inventory mein hone chahiye
    private static Criterion<InventoryChangeTrigger.TriggerInstance> has(HolderGetter<Item> items, ItemLike... list) {
        ItemPredicate.Builder[] predicates = new ItemPredicate.Builder[list.length];
        for (int i = 0; i < list.length; i++) {
            predicates[i] = ItemPredicate.Builder.item().of(items, list[i]);
        }
        return InventoryChangeTrigger.TriggerInstance.hasItems(predicates);
    }
}