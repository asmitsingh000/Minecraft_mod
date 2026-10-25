package net.asmit.pixle_lucia.tags;

import net.asmit.pixle_lucia.Pixle_Lucia;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final  TagKey<Block> NEED_FLUROITE_TOOLS = createTag("need_fluroite_tools");
        public static final  TagKey<Block> INCORRECT_FOR_FLUROITE_TOOLS = createTag("incorrect_for_fluroite_tools");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEM = createTag("transformable_item");
         public static final  TagKey<Item> FLUROITE_REPAIR = createTag("fluroite_repair");
        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID, name));
        }
    }
}