package net.asmit.pixle_lucia.blocks;

import net.asmit.pixle_lucia.Pixle_Lucia;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class Modblocks {
    public static final Block FLUROIT_BLOCK  = registerBlock("fluroite_block",properties -> new Block(properties.destroyTime(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final Block FLUROIT_DEEPSLATE_ORE  = registerBlock("fluroite_deepslate_ore",properties -> new Block(properties.destroyTime(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
    public static final Block FLUROIT_END_ORE  = registerBlock("fluroite_end_ore",properties -> new Block(properties.destroyTime(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));


    private static Block registerBlock(String name, Function<BlockBehaviour.Properties,Block> function){
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK,Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID,name))));
        registerBlocksItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK,Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID,name),toRegister);
    }

    private static void registerBlocksItem(String name, Block block){
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID,name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM,Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID,name)))));
    }

    public static void RegistryModBlocks(){
        Pixle_Lucia.LOGGER.info("Registration mod blocks for " + Pixle_Lucia.MOD_ID);
    }
}
