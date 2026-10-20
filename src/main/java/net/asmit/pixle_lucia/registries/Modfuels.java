package net.asmit.pixle_lucia.registries;

import net.asmit.pixle_lucia.item.Moditems;
import net.fabricmc.fabric.api.registry.FuelValueEvents;

public class Modfuels {
    public static void RegisterFule(){
        FuelValueEvents.BUILD.register((builder, context) -> {
            builder.add(Moditems.COMBUSTABLE_SPORES,1200);
        });
    }
}
