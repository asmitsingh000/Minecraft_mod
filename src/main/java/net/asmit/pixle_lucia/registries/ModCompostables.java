package net.asmit.pixle_lucia.registries;

import net.asmit.pixle_lucia.blocks.Modblocks;
import net.asmit.pixle_lucia.item.Moditems;
import net.fabricmc.fabric.api.registry.CompostableRegistry;

public class ModCompostables {
    public static void registerCompostables(){
        CompostableRegistry.INSTANCE.add(Moditems.STRAWBERY,0.5f);
        CompostableRegistry.INSTANCE.add(Moditems.STRAWBERRY_SEEDS,0.5f);
//        CompostableRegistry.INSTANCE.add(Moditems.STRAWBERY,0.5f);
    }
}
