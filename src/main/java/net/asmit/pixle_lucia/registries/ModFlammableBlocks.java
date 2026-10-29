package net.asmit.pixle_lucia.registries;

import net.asmit.pixle_lucia.blocks.Modblocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammableBlocks {
    public static void  registerFlammableBlocks(){
        FlammableBlockRegistry.getDefaultInstance().add(Modblocks.BALSA_WOOD,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(Modblocks.BALSA_LOG,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(Modblocks.STRTIPPED_BALSA_LOG,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(Modblocks.STRIPPED_BALSA_WOOD,5,5);
        FlammableBlockRegistry.getDefaultInstance().add(Modblocks.BALSA_PLANKS,5,20);
        FlammableBlockRegistry.getDefaultInstance().add(Modblocks.BALSA_LEAVES,30,60);
    }
}
