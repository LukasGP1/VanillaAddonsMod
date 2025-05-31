package de.lulkas_.vanilla_addons.block;

import de.lulkas_.vanilla_addons.VanillaAddons;
import de.lulkas_.vanilla_addons.datagen.ModLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
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
import java.util.function.BiConsumer;

public class ModBlocks {
    private static final Map<Block, BiConsumer<BlockStateModelGenerator, Block>> blockToBlockStateModelGenerationMap = new HashMap<>();
    private static final Map<String, String> keyToTranslationMap = new HashMap<>();
    private static final List<Block> blocks = new ArrayList<>();
    private static final Map<Block, BiConsumer<ModLootTableProvider, Block>> blockToLootTableGenerationMap = new HashMap<>();

    public static final Block COMPRESSED_EMERALD_BLOCK = registerBlock("compressed_emerald_block", "Compressed Emerald Block",
            BlockStateModelGenerator::registerSimpleCubeAll,
            BlockLootTableGenerator::addDrop,
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool()));

    private static Block registerBlock(String name, String translation, BiConsumer<BlockStateModelGenerator, Block> blockStateModelGeneration, BiConsumer<ModLootTableProvider, Block> lootTableGeneration, Block block) {
        registerBlockItem(name, block);
        blockToBlockStateModelGenerationMap.put(block, blockStateModelGeneration);
        blockToLootTableGenerationMap.put(block, lootTableGeneration);
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
        for(Map.Entry<Block, BiConsumer<BlockStateModelGenerator, Block>> entry : blockToBlockStateModelGenerationMap.entrySet()) {
            entry.getValue().accept(blockStateModelGenerator, entry.getKey());
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

    public static void generateLootTables(ModLootTableProvider lootTableProvider) {
        for(Map.Entry<Block, BiConsumer<ModLootTableProvider, Block>> entry : blockToLootTableGenerationMap.entrySet()) {
            entry.getValue().accept(lootTableProvider, entry.getKey());
        }
    }
}
