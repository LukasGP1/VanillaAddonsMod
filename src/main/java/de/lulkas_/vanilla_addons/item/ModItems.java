package de.lulkas_.vanilla_addons.item;

import de.lulkas_.vanilla_addons.VanillaAddons;
import de.lulkas_.vanilla_addons.item.custom.EmeraldArmorItem;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
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

    public static final Item COMPRESSED_EMERALD = registerItem("compressed_emerald", "Compressed Emerald", true,
            new Item(new Item.Settings()));

    public static final Item EMERALD_BOOTS = registerItem("emerald_boots", "Emerald Boots", false,
            new EmeraldArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    public static final Item EMERALD_LEGGINGS = registerItem("emerald_leggings", "Emerald Leggings", false,
            new EmeraldArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item EMERALD_CHESTPLATE = registerItem("emerald_chestplate", "Emerald Chestplate", false,
            new EmeraldArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item EMERALD_HELMET = registerItem("emerald_helmet", "Emerald Helmet", false,
            new EmeraldArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));

    public static final Item COPPER_BOOTS = registerItem("copper_boots", "Copper Boots", false,
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings", "Copper Leggings", false,
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate", "Copper Chestplate", false,
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item COPPER_HELMET = registerItem("copper_helmet", "Copper Helmet", false,
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));

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
