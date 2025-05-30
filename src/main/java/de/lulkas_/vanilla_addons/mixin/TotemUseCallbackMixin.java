package de.lulkas_.vanilla_addons.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import de.lulkas_.vanilla_addons.event.TotemUseCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class TotemUseCallbackMixin {
    @Inject(method = "tryUseTotem", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;decrement(I)V"))
    private void makeTotemNotDecrement(DamageSource source, CallbackInfoReturnable<Boolean> cir, @Local(ordinal = 1) ItemStack stack, @Local(ordinal = 0) Hand hand) {
        LivingEntity entity = (LivingEntity)(Object)this;

        TotemUseCallback.EVENT.invoker().onTotemUsed(entity, stack, hand);
    }
}
