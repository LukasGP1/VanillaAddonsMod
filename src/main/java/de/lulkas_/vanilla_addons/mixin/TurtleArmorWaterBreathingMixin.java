package de.lulkas_.vanilla_addons.mixin;

import de.lulkas_.vanilla_addons.item.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.FluidTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class TurtleArmorWaterBreathingMixin {
	@Inject(method = "updateTurtleHelmet", at = @At("HEAD"))
	private void updateTurtleHelmet(CallbackInfo ci) {
		PlayerEntity instance = (PlayerEntity) (Object) this;

		if(!instance.isSubmergedIn(FluidTags.WATER)) {
			ItemStack itemStack = instance.getEquippedStack(EquipmentSlot.CHEST);
			if (itemStack.isOf(ModItems.TURTLE_CHESTPLATE)) {
				instance.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 200, 0, false, false, true));
			}

			ItemStack itemStack1 = instance.getEquippedStack(EquipmentSlot.LEGS);
			if (itemStack1.isOf(ModItems.TURTLE_LEGGINGS)) {
				instance.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 200, 0, false, false, true));
			}

			ItemStack itemStack2 = instance.getEquippedStack(EquipmentSlot.FEET);
			if (itemStack2.isOf(ModItems.TURTLE_BOOTS)) {
				instance.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 200, 0, false, false, true));
			}

			ItemStack itemStack3 = instance.getEquippedStack(EquipmentSlot.HEAD);
			if(itemStack.isOf(ModItems.TURTLE_CHESTPLATE) && itemStack1.isOf(ModItems.TURTLE_LEGGINGS) && itemStack2.isOf(ModItems.TURTLE_BOOTS) && itemStack3.isOf(Items.TURTLE_HELMET)) {
				instance.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 2000, 0, false, false, true));
			}
		}
	}
}