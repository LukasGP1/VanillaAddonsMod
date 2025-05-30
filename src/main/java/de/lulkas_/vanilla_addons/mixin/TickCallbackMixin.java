package de.lulkas_.vanilla_addons.mixin;

import de.lulkas_.vanilla_addons.event.custom.TickCallback;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

@Mixin(MinecraftServer.class)
public abstract class TickCallbackMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    public void tickMixin(BooleanSupplier shouldKeepTicking, CallbackInfo ci) {
        TickCallback.EVENT.invoker().onTick();
    }
}
