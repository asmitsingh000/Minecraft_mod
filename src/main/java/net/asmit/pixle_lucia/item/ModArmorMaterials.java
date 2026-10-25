package net.asmit.pixle_lucia.item;

import net.asmit.pixle_lucia.Pixle_Lucia;
import net.asmit.pixle_lucia.tags.ModTags;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.level.block.SoundType;

public class ModArmorMaterials {
    public static final ResourceKey<? extends Registry<EquipmentAsset>> REGISTERY_KEY = ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));
    public static final ResourceKey<EquipmentAsset> FLUROITE_KEY =  ResourceKey.create(REGISTERY_KEY,Identifier.fromNamespaceAndPath(Pixle_Lucia.MOD_ID,"fluroite"));
    public static  final ArmorMaterial FLUROITE_ARMOR_MATERIAL =new ArmorMaterial(
            47, ArmorMaterials.makeDefense(6,12,16,6,38),20, SoundEvents.ARMOR_EQUIP_NETHERITE,4f,0.5f, ModTags.Items.FLUROITE_REPAIR,FLUROITE_KEY
    );
}
