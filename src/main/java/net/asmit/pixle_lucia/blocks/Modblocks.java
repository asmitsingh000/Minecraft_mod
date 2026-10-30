package net.asmit.pixle_lucia.blocks;

import net.asmit.pixle_lucia.Pixle_Lucia;
import net.asmit.pixle_lucia.blocks.customBlocks.HoneyBerryBushBlock;
import net.asmit.pixle_lucia.blocks.customBlocks.MagicBlocks;
import net.asmit.pixle_lucia.blocks.customBlocks.StrawberryCropBlock;
import net.asmit.pixle_lucia.worlgen.tree.ModTreeGrowers;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class Modblocks {
    public static final Block FLUROIT_BLOCK = registerBlock("fluroite_block", properties -> new Block(properties.destroyTime(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final Block FLUROIT_DEEPSLATE_ORE = registerBlock("fluroite_deepslate_ore", properties -> new Block(properties.destroyTime(5f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
    public static final Block FLUROIT_ORE = registerBlock("fluroite_ore", properties -> new Block(properties.destroyTime(4.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final Block AETHERITE_ORE = registerBlock("aetherite_ore", properties -> new Block(properties.destroyTime(10f).requiresCorrectToolForDrops().sound(SoundType.NETHER_WOOD)));
    public static final Block AETHERITE_BLOCK = registerBlock("aetherite_block", properties -> new Block(properties.destroyTime(10f).requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)));
    public static final Block FLUROIT_END_ORE = registerBlock("fluroite_end_ore", properties -> new Block(properties.destroyTime(5.5f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
    public static final Block FLUROIT_NETHER_ORE = registerBlock("fluroite_nether_ore", properties -> new Block(properties.destroyTime(5.5f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));
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

    public static final Block FLUROITE_BUUTTON = registerBlock("fluroite_button", properties ->
            new ButtonBlock(BlockSetType.IRON,20,
                    properties.strength(3f)
                            .sound(SoundType.SHELF)
                            .noCollision()));

    public static final Block FLUROITE_PRESSURE_PLATE = registerBlock("fluroite_pressure_plate",properties ->
            new PressurePlateBlock(BlockSetType.IRON,
                    properties.strength(3f)
                            .sound(SoundType.NETHER_WOOD)
                            .noCollision()));

    public static final Block AETHERITE_BUUTTON = registerBlock("aetherite_button", properties ->
            new ButtonBlock(BlockSetType.IRON,20,
                    properties.strength(3f)
                            .sound(SoundType.SHELF)
                            .noCollision()));

    public static final Block AETHERITE_PRESSURE_PLATE = registerBlock("aetherite_pressure_plate",properties ->
            new PressurePlateBlock(BlockSetType.IRON,
                    properties.strength(3f)
                            .sound(SoundType.NETHER_WOOD)
                            .noCollision()));

    public static  final  Block FLUROITE_FENCE = registerBlock("fluroite_fence", properties ->
            new FenceBlock(properties.strength(3f).requiresCorrectToolForDrops()));

    public static  final  Block FLUROITE_GATES = registerBlock("fluroite_gates", properties ->
            new FenceGateBlock(WoodType.OAK,properties.strength(3f).requiresCorrectToolForDrops()));

    public static  final  Block FLUROITE_WALLS = registerBlock("fluroite_walls", properties ->
            new WallBlock(properties.strength(3f).requiresCorrectToolForDrops()));

    public  static final Block FLUROITE_DOORS = registerBlock("fluroite_doors", properties ->
            new DoorBlock(BlockSetType.CRIMSON,properties.strength(1f).noOcclusion().requiresCorrectToolForDrops()));

    public  static final Block FLUROITE_TRAPDOORS = registerBlock("fluroite_trapdoors", properties ->
            new TrapDoorBlock(BlockSetType.CRIMSON,properties.strength(1f).noOcclusion().requiresCorrectToolForDrops()));


    public  static final Block STRAWBERRY_CROP = registerBlockWithoutBlockItem("strawberry_crop", properties ->
            new StrawberryCropBlock(properties.noCollision().randomTicks().instabreak().sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY)));

    public  static final Block HONEY_BERRY_BUSH = registerBlockWithoutBlockItem("honey_berry_bush", properties ->
            new HoneyBerryBushBlock(properties.noCollision().randomTicks().instabreak().sound(SoundType.SWEET_BERRY_BUSH)
                    .pushReaction(PushReaction.DESTROY)));

    public static final Block BALSA_LOG = registerBlock("balsa_log", properties ->
            new RotatedPillarBlock(properties
                    .strength(2f)
                    .instrument(NoteBlockInstrument.BASS)
                    .sound(SoundType.WOOD).ignitedByLava()));
    public static final Block BALSA_WOOD = registerBlock("balsa_wood", properties ->
            new RotatedPillarBlock(properties
                    .strength(2f)
                    .instrument(NoteBlockInstrument.BASS)
                    .sound(SoundType.WOOD).ignitedByLava()));
    public static final Block STRTIPPED_BALSA_LOG = registerBlock("stripped_balsa_log", properties ->
            new RotatedPillarBlock(properties
                    .strength(2f)
                    .instrument(NoteBlockInstrument.BASS)
                    .sound(SoundType.WOOD).ignitedByLava()));
    public static final Block STRIPPED_BALSA_WOOD = registerBlock("stripped_balsa_wood", properties ->
            new RotatedPillarBlock(properties
                    .strength(2f)
                    .instrument(NoteBlockInstrument.BASS)
                    .sound(SoundType.WOOD).ignitedByLava()));
    public static final Block BALSA_PLANKS = registerBlock("balsa_planks", properties ->
            new Block(properties.strength(2f, 3f).mapColor(MapColor.COLOR_ORANGE)
                    .instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).ignitedByLava()));

    public static final Block BALSA_LEAVES = registerBlock("balsa_leaves", properties ->
            new UntintedParticleLeavesBlock(0.1f, ParticleTypes.CHERRY_LEAVES,properties
                    .mapColor(MapColor.COLOR_GREEN)
                    .strength(0.2f)
                    .sound(SoundType.GRASS)
                    .noOcclusion()
                    .randomTicks()
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
                    .isValidSpawn(Blocks::never)
                    .isSuffocating(Blocks::never)
                    .isViewBlocking(Blocks::never)
                    .isRedstoneConductor(Blocks::never)));

    public static final Block BALSA_SAPLING = registerBlock("balsa_sapling", properties ->
            new SaplingBlock(ModTreeGrowers.BALSA,properties
                    .mapColor(MapColor.PLANT).noCollision().randomTicks().instabreak()
                    .sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));

    public static final Block POTTED_BALSA_SAPLING = registerBlockWithoutBlockItem("potted_balsa_sapling",
            properties -> new FlowerPotBlock(BALSA_SAPLING, properties
                    .instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID, name))));
        registerBlocksItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID, name), toRegister);
    }



    private static Block registerBlockWithoutBlockItem(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID, name))));
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
