package net.asmit.pixle_lucia;

import net.asmit.pixle_lucia.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class Pixle_LuciaDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();

        pack.addProvider(ModmodelProvider::new);
        pack.addProvider(ModblockTagProvider::new);
        pack.addProvider(ModblockLookTableProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModItemTagsProvider::new);
	}
}
