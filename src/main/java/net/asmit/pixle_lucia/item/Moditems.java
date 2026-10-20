package net.asmit.pixle_lucia.item;

import net.asmit.pixle_lucia.Pixle_Lucia;
import net.asmit.pixle_lucia.food.Modfood;
import net.asmit.pixle_lucia.item.custom.ChiselItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.Properties;
import java.util.function.Function;

public class Moditems {
    public static final Item FLUROITE = registerItem("fluroite", Item::new);
    public static final Item AETHERITE_INGOT = registerItem("aetherite_ingot", Item::new);
    public static final Item RAW_FLUROITE = registerItem("raw_fluroite", Item::new);
    public static final Item CHISEL = registerItem("chisel", properties -> new ChiselItem(properties.durability(32).repairable(Moditems.FLUROITE).enchantable(2)));
    public static final Item STRAWBERY = registerItem("strawberry",properties -> new Item(properties
            .food(Modfood.STRAWBERY, Modfood.STRAWBERY_CONSUMABLE)));

    public static final Item COMBUSTABLE_SPORES = registerItem("combustible_spores",properties -> new Item(properties.stacksTo(16)));

    public static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID, name), function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID, name)))));
    }

    public static void registerModitems() {
        Pixle_Lucia.LOGGER.info("Registration mod items for " + Pixle_Lucia.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(FLUROITE);
            output.accept(RAW_FLUROITE);
        });
    }
}
