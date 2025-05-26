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
        offerArmorRecipe(Items.CHAIN, Items.CHAINMAIL_BOOTS, Items.CHAINMAIL_LEGGINGS, Items.CHAINMAIL_CHESTPLATE, Items.CHAINMAIL_HELMET, exporter);
        offerArmorRecipe(Items.COPPER_INGOT, ModItems.COPPER_BOOTS, ModItems.COPPER_LEGGINGS, ModItems.COPPER_CHESTPLATE, ModItems.COPPER_HELMET, exporter);
        offerArmorRecipe(Items.TURTLE_SCUTE, ModItems.TURTLE_BOOTS, ModItems.TURTLE_LEGGINGS, ModItems.TURTLE_CHESTPLATE, null, exporter);

        offerToolRecipe(ModItems.COMPRESSED_EMERALD, ModItems.EMERALD_SWORD, ModItems.EMERALD_PICKAXE, ModItems.EMERALD_AXE, ModItems.EMERALD_SHOVEL, ModItems.EMERALD_HOE, exporter);
    }

    public static void offerArmorRecipe(ItemConvertible material, ItemConvertible boots, ItemConvertible leggings, ItemConvertible chestplate, ItemConvertible helmet, RecipeExporter exporter) {
        if(boots != null) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, boots)
                    .pattern("E E")
                    .pattern("E E")
                    .input('E', material)
                    .criterion(hasItem(material), conditionsFromItem(material))
                    .offerTo(exporter);
        }
        if(leggings != null) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, leggings)
                    .pattern("EEE")
                    .pattern("E E")
                    .pattern("E E")
                    .input('E', material)
                    .criterion(hasItem(material), conditionsFromItem(material))
                    .offerTo(exporter);
        }
        if(chestplate != null) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, chestplate)
                    .pattern("E E")
                    .pattern("EEE")
                    .pattern("EEE")
                    .input('E', material)
                    .criterion(hasItem(material), conditionsFromItem(material))
                    .offerTo(exporter);
        }
        if(helmet != null) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, helmet)
                    .pattern("EEE")
                    .pattern("E E")
                    .input('E', material)
                    .criterion(hasItem(material), conditionsFromItem(material))
                    .offerTo(exporter);
        }
    }

    public static void offerToolRecipe(ItemConvertible material, ItemConvertible sword, ItemConvertible pickaxe, ItemConvertible axe, ItemConvertible shovel, ItemConvertible hoe, RecipeExporter exporter) {
        if(sword != null) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, sword)
                    .pattern("E")
                    .pattern("E")
                    .pattern("S")
                    .input('S', Items.STICK)
                    .input('E', material)
                    .criterion(hasItem(material), conditionsFromItem(material))
                    .offerTo(exporter);
        }
        if(pickaxe != null) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, pickaxe)
                    .pattern("EEE")
                    .pattern(" S ")
                    .pattern(" S ")
                    .input('S', Items.STICK)
                    .input('E', material)
                    .criterion(hasItem(material), conditionsFromItem(material))
                    .offerTo(exporter);
        }
        if(axe != null) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, axe)
                    .pattern(" EE")
                    .pattern(" SE")
                    .pattern(" S ")
                    .input('S', Items.STICK)
                    .input('E', material)
                    .criterion(hasItem(material), conditionsFromItem(material))
                    .offerTo(exporter);
        }
        if(shovel != null) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, shovel)
                    .pattern("E")
                    .pattern("S")
                    .pattern("S")
                    .input('S', Items.STICK)
                    .input('E', material)
                    .criterion(hasItem(material), conditionsFromItem(material))
                    .offerTo(exporter);
        }
        if(hoe != null) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, hoe)
                    .pattern(" EE")
                    .pattern(" S ")
                    .pattern(" S ")
                    .input('S', Items.STICK)
                    .input('E', material)
                    .criterion(hasItem(material), conditionsFromItem(material))
                    .offerTo(exporter);
        }
    }
}
