package net.asmit.pixle_lucia.item.custom;

import net.asmit.pixle_lucia.blocks.Modblocks;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.STONE, Blocks.STONE_BRICKS,
                    Blocks.END_STONE, Blocks.END_STONE_BRICKS,
                    Blocks.DEEPSLATE, Modblocks.FLUROIT_BLOCK,
                    Modblocks.FLUROIT_BLOCK, Blocks.NETHERITE_BLOCK,
                    Modblocks.RAW_FLUROITE_BLOCK, Blocks.DIAMOND_BLOCK
            );

    public ChiselItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        if (CHISEL_MAP.containsKey(clickedBlock) && !level.isClientSide()) {
            //WE WANT IT TO BE IN SERVER SIDE TO UPDATE THE DATA

            level.setBlockAndUpdate(context.getClickedPos(),CHISEL_MAP.get(clickedBlock).defaultBlockState());
            context.getItemInHand().hurtAndBreak(1,context.getPlayer(),context.getHand());
        }

        return InteractionResult.SUCCESS;
    }
}
