package de.lulkas_.vanilla_addons.enchantment;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotemReplacer {
    public static List<TotemReplaceSchedule> totemReplaces = new ArrayList<>();
    private static RegistryEntry<Enchantment> totemSaviorEntry;

    public static void useTotem(LivingEntity entity, ItemStack stack, Hand hand) {
        if(entity instanceof ServerPlayerEntity player) {
            Map<Enchantment, Integer> enchantments = new HashMap<>();
            totemSaviorEntry = null;
            for(Object2IntMap.Entry<RegistryEntry<Enchantment>> entry : EnchantmentHelper.getEnchantments(stack).getEnchantmentEntries()) {
                RegistryEntry<Enchantment> registryEntry = entry.getKey();
                enchantments.put(registryEntry.value(), EnchantmentHelper.getLevel(registryEntry, stack));
                if(registryEntry.getKey().get() == ModEnchantments.TOTEM_SAVIOR) {
                    totemSaviorEntry = registryEntry;
                }
            }

            if(totemSaviorEntry != null) {
                if(enchantments.containsKey(totemSaviorEntry.value())) {
                    int level = enchantments.get(totemSaviorEntry.value());
                    if(level <= 5 && level >= 1) {
                        totemReplaces.add(new TotemReplaceSchedule(hand, player, 0, level - 1));
                    }
                }
            }
        }
    }

    public static void tick() {
        for(TotemReplaceSchedule totemReplace : totemReplaces) {
            if(totemReplace.shouldTick()) {
                totemReplace.tick();
            }
        }

        for(TotemReplaceSchedule totemReplace : totemReplaces) {
            if(totemReplace.isReady() && totemReplace.shouldTick()) {
                totemReplace.process();
                if(totemReplace.getHand() == Hand.MAIN_HAND) {
                    PlayerInventory inventory = totemReplace.getPlayer().getInventory();
                    ItemStack stack = new ItemStack(Items.TOTEM_OF_UNDYING);
                    stack.addEnchantment(totemSaviorEntry, totemReplace.getLevel());
                    inventory.setStack(inventory.selectedSlot, stack);
                } else {
                    PlayerInventory inventory = totemReplace.getPlayer().getInventory();
                    ItemStack stack = new ItemStack(Items.TOTEM_OF_UNDYING);
                    stack.addEnchantment(totemSaviorEntry, totemReplace.getLevel());
                    inventory.setStack(PlayerInventory.OFF_HAND_SLOT, stack);
                }
            }
        }
    }
}
