package net.asmit.pixle_lucia.registries;

import net.asmit.pixle_lucia.blocks.Modblocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class ModStrippableBlocks {
    public static void  registerStrippableBlocks(){
        StrippableBlockRegistry.register(Modblocks.BALSA_WOOD,Modblocks.STRIPPED_BALSA_WOOD);
        StrippableBlockRegistry.register(Modblocks.BALSA_LOG,Modblocks.STRTIPPED_BALSA_LOG);
    }
}
