package de.lulkas_.vanilla_addons.block.entity.util;

import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;

import java.util.ArrayList;
import java.util.List;

public class EnchantmentUpgraderOutputGeneration {
    public static EnchantmentUpgraderOutput getOutput(ItemStack input) {
        if(hasItem(input)) {
            if(hasOneEnchantment(input)) {
                RegistryEntry<Enchantment> enchantmentEntry = getEnchantmentEntry(input);
                Enchantment enchantment = enchantmentEntry.value();
                if(enchantment != null) {
                    if(isNotMaxLevel(enchantment, input, enchantmentEntry)) {
                        return createOutput(enchantmentEntry, input);
                    }
                }
            }
        }
        return new EnchantmentUpgraderOutput(ItemStack.EMPTY, 0);
    }

    private static EnchantmentUpgraderOutput createOutput(RegistryEntry<Enchantment> enchantmentEntry, ItemStack inputStack) {
        ItemStack stack = inputStack.copy();
        int level = EnchantmentHelper.getEnchantments(stack).getLevel(enchantmentEntry) + 1;
        ItemEnchantmentsComponent.Builder builder = new ItemEnchantmentsComponent.Builder(ItemEnchantmentsComponent.DEFAULT);
        builder.add(enchantmentEntry, level);
        EnchantmentHelper.set(stack, builder.build());
        return new EnchantmentUpgraderOutput(stack, level);
    }

    private static boolean isNotMaxLevel(Enchantment enchantment, ItemStack stack, RegistryEntry<Enchantment> enchantmentEntry) {
        int level = EnchantmentHelper.getEnchantments(stack).getLevel(enchantmentEntry);
        return level < enchantment.getMaxLevel();
    }

    private static RegistryEntry<Enchantment> getEnchantmentEntry(ItemStack stack) {
        List<RegistryEntry<Enchantment>> list = new ArrayList<>(EnchantmentHelper.getEnchantments(stack).getEnchantments());
        return list.get(0);
    }

    private static boolean hasOneEnchantment(ItemStack stack) {
        return EnchantmentHelper.getEnchantments(stack).getEnchantments().size() == 1;
    }

    private static boolean hasItem(ItemStack stack) {
        return !stack.isEmpty();
    }
}