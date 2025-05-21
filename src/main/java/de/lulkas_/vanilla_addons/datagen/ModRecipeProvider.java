package de.lulkas_.vanilla_addons.datagen;

import de.lulkas_.vanilla_addons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.EMERALD_BLOCK, RecipeCategory.MISC, ModItems.COMPRESSED_EMERALD);

        offerArmorRecipe(ModItems.COMPRESSED_EMERALD, ModItems.EMERALD_BOOTS, ModItems.EMERALD_LEGGINGS, ModItems.EMERALD_CHESTPLATE, ModItems.EMERALD_HELMET, exporter);
        offerArmorRecipe(Items.NETHERITE_INGOT, Items.NETHERITE_BOOTS, Items.NETHERITE_LEGGINGS, Items.NETHERITE_CHESTPLATE, Items.NETHERITE_HELMET, exporter);
        offerArmorRecipe(Items.COPPER_INGOT, ModItems.COPPER_BOOTS, ModItems.COPPER_LEGGINGS, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_HELMET, exporter);
    }

    public static void offerArmorRecipe(ItemConvertible material, ItemConvertible boots, ItemConvertible leggings, ItemConvertible chestplate, ItemConvertible helmet, RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, boots)
                .pattern("E E")
                .pattern("E E")
                .input('E', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, leggings)
                .pattern("EEE")
                .pattern("E E")
                .pattern("E E")
                .input('E', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, chestplate)
                .pattern("E E")
                .pattern("EEE")
                .pattern("EEE")
                .input('E', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, helmet)
                .pattern("EEE")
                .pattern("E E")
                .input('E', material)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }
}
