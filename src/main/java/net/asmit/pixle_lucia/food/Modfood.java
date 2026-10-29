package net.asmit.pixle_lucia.food;

import net.asmit.pixle_lucia.Pixle_Lucia;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.function.Function;

public class Modfood {
    public static final FoodProperties STRAWBERY = new FoodProperties.Builder().nutrition(12).saturationModifier(2f).build();
    public static final FoodProperties HONEY_BERRIES = new FoodProperties.Builder().nutrition(12).saturationModifier(2f).build();

    public static final Consumable STRAWBERY_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.6f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION,100),100f)).build();
    public static final Consumable HONEY_BERRIES_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1.3f)
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.STRENGTH,300),50f))
            .build();
    public static void RegisterModfood(){
        Pixle_Lucia.LOGGER.info("Registration of the mod food" + Pixle_Lucia.MOD_ID);
    }
}
