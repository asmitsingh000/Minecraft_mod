package net.asmit.pixle_lucia.item;

import net.asmit.pixle_lucia.Pixle_Lucia;
import net.asmit.pixle_lucia.blocks.Modblocks;
import net.asmit.pixle_lucia.food.Modfood;
import net.asmit.pixle_lucia.item.custom.ChiselItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import java.util.Properties;
import java.util.function.Function;

public class Moditems {
    public static final Item FLUROITE = registerItem("fluroite", Item::new);
    public static final Item AETHERITE_INGOT = registerItem("aetherite_ingot", Item::new);
    public static final Item RAW_FLUROITE = registerItem("raw_fluroite", Item::new);
//    public static final Item FLUROTIE_BUTTON = registerItem("fluroite_button", properties -> new But);
//    public static final Item AETHERITE_BUTTON = registerItem("aetherite_button", properties -> new But);
    public static final Item CHISEL = registerItem("chisel", properties -> new ChiselItem(properties.durability(32).repairable(Moditems.FLUROITE).enchantable(2)));
    public static final Item STRAWBERY = registerItem("strawberry",properties -> new Item(properties
            .food(Modfood.STRAWBERY, Modfood.STRAWBERY_CONSUMABLE)));

    public static final Item COMBUSTABLE_SPORES = registerItem("combustible_spores",properties ->
            new Item(properties.stacksTo(16)));

    public static final Item FLUROITE_SWORDS = registerItem("fluroite_sword", properties ->
            new Item(properties.sword(ModToolMaterials.FLUROITE, 3f, -2.4f).fireResistant()));

//    public static final Item FLUROITE_AXE = registerItem("fluroite_axe", properties ->
//            new AxeItem(properties.axe(ModToolMaterials.FLUROITE, 5f, -3.0f,properties));
public static final Item FLUROITE_AXE = registerItem("fluroite_axe",
        properties -> new AxeItem(ModToolMaterials.FLUROITE, 6f, -3.2f, properties.fireResistant()));

    public static final Item FLUROITE_PICKAXE = registerItem("fluroite_pickaxe", properties ->
            new Item(properties.pickaxe(ModToolMaterials.FLUROITE, 1f, -2.8f).fireResistant()));

    public static final Item FLUROITE_HOE = registerItem("fluroite_hoe", properties ->
            new HoeItem(ModToolMaterials.FLUROITE,5f,-3.0f,properties.fireResistant()));

    public static final Item FLUROITE_SHOVEL = registerItem("fluroite_shovel", properties ->
            new ShovelItem(ModToolMaterials.FLUROITE,5f,-3.0f,properties.fireResistant()));

    public static final Item FLUROITE_SPEAR = registerItem("fluroite_spear",properties ->
            new Item(properties.spear(ModToolMaterials.FLUROITE,
                    1.15F,
                    1.2F,
                    0.4F,
                    2.5F,
                    9.0F,
                    5.5F,
                    5.1F,
                    8.75F,
                    4.6F).fireResistant()));


    public static final Item FLUROITE_HELMET = registerItem("fluroite_helmet",properties ->
            new Item(properties.humanoidArmor(ModArmorMaterials.FLUROITE_ARMOR_MATERIAL,ArmorType.HELMET)));
    public static final Item FLUROITE_CHESTPLATE = registerItem("fluroite_chestplate",properties ->
            new Item(properties.humanoidArmor(ModArmorMaterials.FLUROITE_ARMOR_MATERIAL,ArmorType.CHESTPLATE)));
    public static final Item FLUROITE_LEGGINGS = registerItem("fluroite_leggings",properties ->
            new Item(properties.humanoidArmor(ModArmorMaterials.FLUROITE_ARMOR_MATERIAL,ArmorType.LEGGINGS)));
    public static final Item FLUROITE_BOOTS = registerItem("fluroite_boots",properties ->
            new Item(properties.humanoidArmor(ModArmorMaterials.FLUROITE_ARMOR_MATERIAL,ArmorType.BOOTS)));




    public static final Item STRAWBERRY_SEEDS = registerItem("strawberry_seeds",properties ->
            new BlockItem(Modblocks.STRAWBERRY_CROP,properties.useItemDescriptionPrefix()));
    public static final Item HONEY_BERRIES = registerItem("honey_berries",properties ->
            new BlockItem (Modblocks.HONEY_BERRY_BUSH,
                    properties
                            .useItemDescriptionPrefix()
//                            .useBlockDescriptionPrefix()
                    .food(Modfood.HONEY_BERRIES,Modfood.HONEY_BERRIES_CONSUMABLE)));

    public static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID, name)))));


    }

    public static void registerModitems() {
        Pixle_Lucia.LOGGER.info("Registration mod items for " + Pixle_Lucia.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(FLUROITE);
            output.accept(RAW_FLUROITE);
        });
    }
}
