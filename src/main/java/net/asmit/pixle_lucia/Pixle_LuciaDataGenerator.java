package net.asmit.pixle_lucia;

import net.asmit.pixle_lucia.datagen.ModblockLookTableProvider;
import net.asmit.pixle_lucia.datagen.ModblockTagProvider;
import net.asmit.pixle_lucia.datagen.ModmodelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.client.data.models.ModelProvider;

public class Pixle_LuciaDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();

        pack.addProvider(ModmodelProvider::new);
        pack.addProvider(ModblockTagProvider::new);
        pack.addProvider(ModblockLookTableProvider::new);



	}
}
