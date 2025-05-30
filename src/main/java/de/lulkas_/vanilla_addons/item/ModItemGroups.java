package de.lulkas_.vanilla_addons.item;

import de.lulkas_.vanilla_addons.VanillaAddons;
import de.lulkas_.vanilla_addons.enchantment.ModEnchantments;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.stream.IntStream;

public class ModItemGroups {
    public static final ItemGroup VANILLA_ADDONS_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(VanillaAddons.MOD_ID, "vanilla_addons"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(Items.GRASS_BLOCK))
                    .displayName(Text.translatable("item_group.vanilla_addons.vanilla_addons"))
                    .entries((displayContext, entries) -> {
                        ModItems.addItemGroupEntries(entries);
                        addEnchantment(displayContext, entries, ModEnchantments.TOTEM_SAVIOR);
                    }).build()
    );

    private static void addEnchantment(ItemGroup.DisplayContext displayContext, ItemGroup.Entries entries, RegistryKey<Enchantment> enchantment) {
        displayContext.lookup().getOptionalWrapper(RegistryKeys.ENCHANTMENT).ifPresent(registryWrapper -> {
            registryWrapper.streamEntries().flatMap(enchantmentEntry -> {
                if(enchantmentEntry.getKey().isPresent()) {
                    if(enchantmentEntry.getKey().get() == enchantment) {
                        return IntStream.rangeClosed(enchantmentEntry.value().getMinLevel(), enchantmentEntry.value().getMaxLevel()).mapToObj(level -> EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(enchantmentEntry, level)));
                    }
                }
                return IntStream.empty().mapToObj(level -> EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(enchantmentEntry, level)));
            }).forEach(entries::add);
        });
    }

    public static void registerModItemGroups() {
        VanillaAddons.LOGGER.info("Registering Item Groups for Mod " + VanillaAddons.MOD_ID + " Mod");
    }
}
