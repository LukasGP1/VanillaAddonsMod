package de.lulkas_.vanilla_addons.enchantment;

import de.lulkas_.vanilla_addons.VanillaAddons;
import de.lulkas_.vanilla_addons.tags.ModTags;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static RegistryKey<Enchantment> TOTEM_SAVIOR = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(VanillaAddons.MOD_ID, "totem_savior"));

    public static void bootstrap(Registerable<Enchantment> registerable) {
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, TOTEM_SAVIOR, Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ModTags.Items.TOTEM_ENCHANTABLE),
                items.getOrThrow(ModTags.Items.TOTEM_ENCHANTABLE),
                5,
                255,
                Enchantment.leveledCost(5, 7),
                Enchantment.leveledCost(25,9),
                2,
                AttributeModifierSlot.OFFHAND)));
    }

    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}
