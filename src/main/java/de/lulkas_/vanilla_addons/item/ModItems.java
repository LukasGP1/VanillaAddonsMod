package de.lulkas_.vanilla_addons.item;

import de.lulkas_.vanilla_addons.VanillaAddons;
import de.lulkas_.vanilla_addons.item.custom.EmeraldArmorItem;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModItems {
    private static final Map<Item, Model> itemModelMap = new HashMap<>();
    private static final List<Item> items = new ArrayList<>();
    private static final Map<String, String> keyToTranslationMap = new HashMap<>();

    public static final Item COMPRESSED_EMERALD = registerItem("compressed_emerald", "Compressed Emerald", Models.GENERATED,
            new Item(new Item.Settings()));

    public static final Item EMERALD_BOOTS = registerItem("emerald_boots", "Emerald Boots", null,
            new EmeraldArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));
    public static final Item EMERALD_LEGGINGS = registerItem("emerald_leggings", "Emerald Leggings", null,
            new EmeraldArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item EMERALD_CHESTPLATE = registerItem("emerald_chestplate", "Emerald Chestplate", null,
            new EmeraldArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item EMERALD_HELMET = registerItem("emerald_helmet", "Emerald Helmet", null,
            new EmeraldArmorItem(ModArmorMaterials.EMERALD_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));

    public static final Item COPPER_BOOTS = registerItem("copper_boots", "Copper Boots", null,
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(10))));
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings", "Copper Leggings", null,
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(10))));
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate", "Copper Chestplate", null,
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(10))));
    public static final Item COPPER_HELMET = registerItem("copper_helmet", "Copper Helmet", null,
            new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(10))));

    public static final Item TURTLE_BOOTS = registerItem("turtle_boots", "Turtle Boots", null,
            new ArmorItem(ArmorMaterials.TURTLE, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(25))));
    public static final Item TURTLE_LEGGINGS = registerItem("turtle_leggings", "Turtle Leggings", null,
            new ArmorItem(ArmorMaterials.TURTLE, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(25))));
    public static final Item TURTLE_CHESTPLATE = registerItem("turtle_chestplate", "Turtle Chestplate", null,
            new ArmorItem(ArmorMaterials.TURTLE, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(25))));

    public static final Item EMERALD_SWORD = registerItem("emerald_sword", "Emerald Sword", Models.HANDHELD,
            new SwordItem(ModToolMaterials.EMERALD, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.EMERALD, 3, -2.4f))));
    public static final Item EMERALD_PICKAXE = registerItem("emerald_pickaxe", "Emerald Pickaxe", Models.HANDHELD,
            new PickaxeItem(ModToolMaterials.EMERALD, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.EMERALD, 1, -2.8f))));
    public static final Item EMERALD_AXE = registerItem("emerald_axe", "Emerald Axe", Models.HANDHELD,
            new AxeItem(ModToolMaterials.EMERALD, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.EMERALD, 6f, -3.2f))));
    public static final Item EMERALD_SHOVEL = registerItem("emerald_shovel", "Emerald Shovel", Models.HANDHELD,
            new ShovelItem(ModToolMaterials.EMERALD, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.EMERALD, 1.5f, -3f))));
    public static final Item EMERALD_HOE = registerItem("emerald_hoe", "Emerald Hoe", Models.HANDHELD,
            new HoeItem(ModToolMaterials.EMERALD, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.EMERALD, 0, -3f))));

    public static final Item COPPER_SWORD = registerItem("copper_sword", "Copper Sword", Models.HANDHELD,
            new SwordItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COPPER, 3, -2.4f))));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe", "Copper Pickaxe", Models.HANDHELD,
            new PickaxeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.COPPER, 1, -2.8f))));
    public static final Item COPPER_AXE = registerItem("copper_axe", "Copper Axe", Models.HANDHELD,
            new AxeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.COPPER, 6f, -3.2f))));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel", "Copper Shovel", Models.HANDHELD,
            new ShovelItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.COPPER, 1.5f, -3f))));
    public static final Item COPPER_HOE = registerItem("copper_hoe", "Copper Hoe", Models.HANDHELD,
            new HoeItem(ModToolMaterials.COPPER, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.COPPER, 0, -3f))));

    private static Item registerItem(String name, String translation, Model model, Item item) {
        if(model != null) {
            itemModelMap.put(item, model);
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
        for(Map.Entry<Item, Model> item : itemModelMap.entrySet()) {
            itemModelGenerator.register(item.getKey(), item.getValue());
        }
    }

    public static void registerModItems() {
        VanillaAddons.LOGGER.info("Registering Items of " + VanillaAddons.MOD_ID + " Mod");
    }
}
