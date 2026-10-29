package net.asmit.pixle_lucia.additionaltab;

import net.asmit.pixle_lucia.Pixle_Lucia;
import net.asmit.pixle_lucia.blocks.Modblocks;
import net.asmit.pixle_lucia.item.Moditems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.ItemStack;

public class Creativetab {

    // ---------- TABS ----------

    public static final CreativeModeTab ITEMS_TAB = register(
            "fluroite_items_tab",
            "creaivemodtab.pixle_lucia.fluroite_items",
            Moditems.FLUROITE,
            (parameters, output) -> {
                output.accept(Moditems.FLUROITE);
                output.accept(Moditems.RAW_FLUROITE);
                output.accept(Moditems.AETHERITE_INGOT);
                output.accept(Moditems.FLUROITE_HELMET);
                output.accept(Moditems.FLUROITE_CHESTPLATE);
                output.accept(Moditems.FLUROITE_LEGGINGS);
                output.accept(Moditems.FLUROITE_BOOTS);
            });

    public static final CreativeModeTab BLOCK_TAB = register(
            "fluroite_block_tab",
            "creaivemodtab.pixle_lucia.fluroites_blocks",
            Modblocks.FLUROIT_BLOCK,
            (parameters, output) -> {
                // Ores
                output.accept(Modblocks.FLUROIT_DEEPSLATE_ORE);
                output.accept(Modblocks.FLUROIT_ORE);
                output.accept(Modblocks.AETHERITE_ORE);
                output.accept(Modblocks.FLUROIT_NETHER_ORE);

                // Storage blocks
                output.accept(Modblocks.RAW_FLUROITE_BLOCK);
                output.accept(Modblocks.FLUROIT_BLOCK);
                output.accept(Modblocks.AETHERITE_BLOCK);

                // Building: Fluroite
                output.accept(Modblocks.FLUROITE_STARE);
                output.accept(Modblocks.FLUROITE_SLAB);
                output.accept(Modblocks.FLUROITE_FENCE);
                output.accept(Modblocks.FLUROITE_GATES);
                output.accept(Modblocks.FLUROITE_WALLS);
                output.accept(Modblocks.FLUROITE_DOORS);
                output.accept(Modblocks.FLUROITE_TRAPDOORS);

                // Building: Aetherite
                output.accept(Modblocks.AETHERITE_STAIRS);
                output.accept(Modblocks.AETHERITE_SLAB);

                // Redstone
                output.accept(Modblocks.FLUROITE_BUUTTON);
                output.accept(Modblocks.FLUROITE_PRESSURE_PLATE);
                output.accept(Modblocks.AETHERITE_BUUTTON);
                output.accept(Modblocks.AETHERITE_PRESSURE_PLATE);

                // Special
                output.accept(Modblocks.MAGIC_BLOCKS);
            });

    public static final CreativeModeTab TOOLS_TAB = register(
            "fluroite_tools_tab",
            "creaivemodtab.pixle_lucia.fluroite_tools",
            Moditems.CHISEL,
            (parameters, output) -> {
                output.accept(Moditems.CHISEL);
                output.accept(Moditems.FLUROITE_SWORDS);
                output.accept(Moditems.FLUROITE_PICKAXE);
                output.accept(Moditems.FLUROITE_AXE);
                output.accept(Moditems.FLUROITE_SPEAR);
                output.accept(Moditems.FLUROITE_HOE);
                output.accept(Modblocks.BALSA_LEAVES);
                output.accept(Modblocks.BALSA_WOOD);
                output.accept(Modblocks.BALSA_LOG);
                output.accept(Modblocks.BALSA_PLANKS);
                output.accept(Modblocks.STRIPPED_BALSA_WOOD);
                output.accept(Modblocks.STRTIPPED_BALSA_LOG);
            });

    public static final CreativeModeTab FOOD_TAB = register(
            "custom_food_tab",
            "creaivemodtab.pixle_lucia.fluroite_food",
            Moditems.STRAWBERY,
            (parameters, output) -> {
                output.accept(Moditems.STRAWBERY);
                output.accept(Moditems.HONEY_BERRIES);

            });

    public static final CreativeModeTab CROPS_TAB = register(
            "custom_crop_tab",
            "creativemodtab.pixle_lucia.fluroite_crops",
            Moditems.STRAWBERRY_SEEDS,
            (parameters, output) -> {
                output.accept(Moditems.STRAWBERRY_SEEDS);

            });

    public static final CreativeModeTab FUEL_TAB = register(
            "custom_fuels_tab",
            "creaivemodtab.pixle_lucia.fluroite_fuels",
            Moditems.COMBUSTABLE_SPORES,
            (parameters, output) -> output.accept(Moditems.COMBUSTABLE_SPORES));

    // ---------- HELPER ----------

    private static CreativeModeTab register(String id, String titleKey, ItemLike icon,
                                            CreativeModeTab.DisplayItemsGenerator items) {
        return Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID, id),
                FabricCreativeModeTab.builder()
                        .icon(() -> new ItemStack(icon))
                        .title(Component.translatable(titleKey))
                        .displayItems(items)
                        .build());
    }

    public static void registerModcreativeTab() {
        Pixle_Lucia.LOGGER.info("Registering creative tabs for " + Pixle_Lucia.MOD_ID);
    }
}