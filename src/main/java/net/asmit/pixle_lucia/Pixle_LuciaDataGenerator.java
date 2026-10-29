package net.asmit.pixle_lucia;

import net.asmit.pixle_lucia.datagen.*;
import net.asmit.pixle_lucia.worlgen.ModConfiguredFeatures;
import net.asmit.pixle_lucia.worlgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class Pixle_LuciaDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();

        pack.addProvider(ModmodelProvider::new);
        pack.addProvider(ModblockTagProvider::new);
        pack.addProvider(ModblockLookTableProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModItemTagsProvider::new);
        pack.addProvider(ModEquipmentAssetProvider::new);
        pack.addProvider(ModRegistryDataProvider::new);
	}

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
    }
}
