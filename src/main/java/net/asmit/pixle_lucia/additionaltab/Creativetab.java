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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class Creativetab {
    public static final CreativeModeTab ORE_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID,"fluroite_tab"),
            FabricCreativeModeTab.builder().icon(()->new ItemStack(Moditems.FLUROITE)).title(Component.translatable("creaivemodtab.pixle_lucia.fluroite_items")).displayItems((parameters, output) -> {
                output.accept(Moditems.FLUROITE);
                output.accept(Moditems.RAW_FLUROITE);
                    })
                    .build());

    public static final CreativeModeTab BLOCK_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID,"fluroite_block_tab"),
            FabricCreativeModeTab.builder().icon(()->new ItemStack(Modblocks.FLUROIT_BLOCK)).title(Component.translatable("creaivemodtab.pixle_lucia.fluroites_blocks")).displayItems((parameters, output) -> {
//                        output.accept(Moditems.FLUROITE);
//                        output.accept(Moditems.RAW_FLUROITE);
                        output.accept(Modblocks.FLUROIT_BLOCK);
                        output.accept(Modblocks.FLUROIT_DEEPSLATE_ORE);
                        output.accept(Modblocks.FLUROIT_END_ORE);
                    })
                    .build());

    public static void registerModcreativeTab() {
        Pixle_Lucia.LOGGER.info("Registration of mod is :" + Pixle_Lucia.MOD_ID);
    }
}
