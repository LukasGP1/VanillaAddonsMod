package de.lulkas_.vanilla_addons.item.custom;

import de.lulkas_.vanilla_addons.item.ModArmorMaterials;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class EmeraldArmorItem extends ArmorItem {
    public EmeraldArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasFullEmeraldArmorOn(player)) {
                    if(!player.hasStatusEffect(StatusEffects.SPEED)) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20));
                    }
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean hasFullEmeraldArmorOn(PlayerEntity player) {
        for(ItemStack stack : player.getArmorItems()) {
            if(stack.getItem() instanceof EmeraldArmorItem armorItem) {
                if(armorItem.material == ModArmorMaterials.EMERALD_ARMOR_MATERIAL) {
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.vanilla_addons.emerald_armor.first").formatted(Formatting.GRAY));
        tooltip.add(Text.literal("+2 ").append(Text.translatable("tooltip.vanilla_addons.emerald_armor.speed")).formatted(Formatting.BLUE));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
