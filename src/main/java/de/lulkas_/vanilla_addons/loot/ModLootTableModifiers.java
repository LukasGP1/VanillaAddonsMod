package de.lulkas_.vanilla_addons.loot;

import de.lulkas_.vanilla_addons.enchantment.ModEnchantments;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetEnchantmentsLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier ZOMBIE_ENTITY_ID = Identifier.of("minecraft", "entities/zombie");
    private static final Identifier HUSK_ENTITY_ID = Identifier.of("minecraft", "entities/husk");
    private static final Identifier DROWNED_ENTITY_ID = Identifier.of("minecraft", "entities/drowned");

    public static void modifyLootTables(RegistryKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, RegistryWrapper.WrapperLookup registry) {
        if(ZOMBIE_ENTITY_ID.equals(key.getValue()) || HUSK_ENTITY_ID.equals(key.getValue()) || DROWNED_ENTITY_ID.equals(key.getValue())) {
            RegistryEntry<Enchantment> totemSaviorEnchantmentEntry = registry.getWrapperOrThrow(RegistryKeys.ENCHANTMENT).getOrThrow(ModEnchantments.TOTEM_SAVIOR);

            LootPool.Builder poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(0.01f))
                    .with(ItemEntry.builder(Items.ENCHANTED_BOOK))
                    .apply(new SetEnchantmentsLootFunction.Builder().enchantment(totemSaviorEnchantmentEntry, ConstantLootNumberProvider.create(1)).build());
            tableBuilder.pool(poolBuilder.build());
        }
    }
}
