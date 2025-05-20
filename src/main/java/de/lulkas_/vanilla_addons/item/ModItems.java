package de.lulkas_.vanilla_addons.item;

import de.lulkas_.vanilla_addons.VanillaAddons;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModItems {
    private static final List<Item> defaultItemModels = new ArrayList<>();
    private static final List<Item> items = new ArrayList<>();
    private static final Map<String, String> keyToTranslationMap = new HashMap<>();

    public static final Item TEST_ITEM = registerItem("test_item", "Test Item", true, new Item(new Item.Settings()));

    private static Item registerItem(String name, String translation, boolean useDefaultModel, Item item) {
        if(useDefaultModel) {
            defaultItemModels.add(item);
        }
        items.add(item);
        keyToTranslationMap.put("item." + VanillaAddons.MOD_ID + "." + name, translation);
        return Registry.register(Registries.ITEM, Identifier.of(VanillaAddons.MOD_ID, name), item);
    }

    public static void addItemGroupEntries(ItemGroup.Entries entries) {
        for(Item item : items) {
            entries.add(item);
        }
    }

    public static void generateTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder) {
        for(Map.Entry<String, String> item : keyToTranslationMap.entrySet()) {
            translationBuilder.add(item.getKey(), item.getValue());
        }
    }

    public static void generateDefaultItemModels(ItemModelGenerator itemModelGenerator) {
        for(Item item : defaultItemModels) {
            itemModelGenerator.register(item, Models.GENERATED);
        }
    }

    public static void registerModItems() {
        VanillaAddons.LOGGER.info("Registering Items of " + VanillaAddons.MOD_ID + " Mod");
    }
}
