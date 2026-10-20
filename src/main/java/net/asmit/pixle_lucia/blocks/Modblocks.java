package net.asmit.pixle_lucia.blocks;

import net.asmit.pixle_lucia.Pixle_Lucia;
import net.asmit.pixle_lucia.blocks.customBlocks.MagicBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class Modblocks {
    public static final Block FLUROIT_BLOCK = registerBlock("fluroite_block", properties -> new Block(properties.destroyTime(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final Block FLUROIT_DEEPSLATE_ORE = registerBlock("fluroite_deepslate_ore", properties -> new Block(properties.destroyTime(5f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
    public static final Block AETHERITE_ORE = registerBlock("aetherite_ore", properties -> new Block(properties.destroyTime(10f).requiresCorrectToolForDrops().sound(SoundType.NETHER_WOOD)));
    public static final Block AETHERITE_BLOCK = registerBlock("aetherite_block", properties -> new Block(properties.destroyTime(10f).requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)));
    public static final Block FLUROIT_END_ORE = registerBlock("fluroite_end_ore", properties -> new Block(properties.destroyTime(5.5f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final Block RAW_FLUROITE_BLOCK = registerBlock("raw_fluroite_block", properties -> new Block(properties.destroyTime(3.7f).requiresCorrectToolForDrops().sound(SoundType.BONE_BLOCK)));
    public static final Block MAGIC_BLOCKS = registerBlock("magic_blocks", properties -> new MagicBlocks(properties.destroyTime(2f).requiresCorrectToolForDrops().sound(SoundType.GLASS)));
    public static final Block FLUROITE_STARE = registerBlock("fluroite_stair", properties ->
            new StairBlock(Modblocks.FLUROIT_BLOCK.defaultBlockState(),
                    properties.destroyTime(3f).sound(SoundType.SCAFFOLDING).requiresCorrectToolForDrops()));
    public static final Block FLUROITE_SLAB = registerBlock("fluroite_slab", properties ->
            new SlabBlock(properties.strength(3f).sound(SoundType.SCAFFOLDING).requiresCorrectToolForDrops()));

    public static final Block AETHERITE_STAIRS = registerBlock("aetherite_stair", properties ->
            new StairBlock(Modblocks.AETHERITE_BLOCK.defaultBlockState(),
                    properties.strength(3f).sound(SoundType.BONE_BLOCK).requiresCorrectToolForDrops()));
    public static final Block AETHERITE_SLAB = registerBlock("aetherite_slab", properties ->
            new SlabBlock(properties.strength(3f).sound(SoundType.SHELF).requiresCorrectToolForDrops()));


    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID, name))));
        registerBlocksItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID, name), toRegister);
    }

    private static void registerBlocksItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID, name)))));
    }

    public static void RegistryModBlocks() {
        Pixle_Lucia.LOGGER.info("Registration mod blocks for " + Pixle_Lucia.MOD_ID);
    }
}
