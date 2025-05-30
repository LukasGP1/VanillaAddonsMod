package de.lulkas_.vanilla_addons.block;

import de.lulkas_.vanilla_addons.VanillaAddons;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModBlocks {
    private static final List<Block> simpleCubeAllBlocks = new ArrayList<>();
    private static final Map<String, String> keyToTranslationMap = new HashMap<>();
    private static final List<Block> blocks = new ArrayList<>();

    private static Block registerBlock(String name, String translation, boolean isSimpleCubeAll, Block block) {
        registerBlockItem(name, block);
        if(isSimpleCubeAll) {
            simpleCubeAllBlocks.add(block);
        }
        keyToTranslationMap.put("block." + VanillaAddons.MOD_ID + "." + name, translation);
        blocks.add(block);
        return Registry.register(Registries.BLOCK, Identifier.of(VanillaAddons.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(VanillaAddons.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        VanillaAddons.LOGGER.info("Registering Blocks for Mod " + VanillaAddons.MOD_ID);
    }

    public static void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for(Block block : simpleCubeAllBlocks) {
            blockStateModelGenerator.registerSimpleCubeAll(block);
        }
    }

    public static void generateTranslations(FabricLanguageProvider.TranslationBuilder translationBuilder) {
        for(Map.Entry<String, String> block : keyToTranslationMap.entrySet()) {
            translationBuilder.add(block.getKey(), block.getValue());
        }
    }

    public static void addItemGroupEntries(ItemGroup.Entries entries) {
        for(Block block : blocks) {
            entries.add(block);
        }
    }
}
