package net.asmit.pixle_lucia.datagen;

import net.asmit.pixle_lucia.blocks.Modblocks;
import net.asmit.pixle_lucia.item.Moditems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                List<ItemLike> FLUROITE_SMELTABLE = List.of(Moditems.RAW_FLUROITE, Modblocks.FLUROIT_DEEPSLATE_ORE, Modblocks.FLUROIT_END_ORE);

                oreSmelting(FLUROITE_SMELTABLE, RecipeCategory.MISC, CookingBookCategory.BLOCKS, Moditems.FLUROITE, 0.3f, 300, "fluroite");
                oreBlasting(FLUROITE_SMELTABLE, RecipeCategory.MISC, CookingBookCategory.BLOCKS, Moditems.FLUROITE, 12f, 100, "fluroite");

                nineBlockStorageRecipes(RecipeCategory.MISC, Moditems.FLUROITE, RecipeCategory.DECORATIONS, Modblocks.FLUROIT_BLOCK);

                shaped(RecipeCategory.MISC, Modblocks.RAW_FLUROITE_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', Moditems.RAW_FLUROITE)
                        .unlockedBy(getHasName(Moditems.RAW_FLUROITE), has(Moditems.RAW_FLUROITE))
                        .group("fluroite")
                        .save(recipeOutput);

                shapeless(RecipeCategory.MISC, Moditems.RAW_FLUROITE, 9)
                        .requires(Modblocks.RAW_FLUROITE_BLOCK)
                        .unlockedBy(getHasName(Modblocks.RAW_FLUROITE_BLOCK), has(Modblocks.RAW_FLUROITE_BLOCK))
                        .group("fluroite").save(recipeOutput);
            }
        };
    }

    @Override
    public String getName() {
        return "New Recipes";
    }
}
