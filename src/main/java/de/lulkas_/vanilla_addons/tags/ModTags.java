package de.lulkas_.vanilla_addons.tags;

import de.lulkas_.vanilla_addons.VanillaAddons;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_EMERALD_TOOL = createTag("incorrect_for_emerald_tool");
        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = createTag("incorrect_for_copper_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(VanillaAddons.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TOTEM_ENCHANTABLE = createTag("totem_enchantable");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(VanillaAddons.MOD_ID, name));
        }
    }
}
