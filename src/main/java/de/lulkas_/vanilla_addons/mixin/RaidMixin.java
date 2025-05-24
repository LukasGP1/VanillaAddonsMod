package de.lulkas_.vanilla_addons.mixin;

import de.lulkas_.vanilla_addons.event.RaidWaveSpawnCallback;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.raid.Raid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Raid.class)
public abstract class RaidMixin {
    @Inject(method = "spawnNextWave", at = @At(value = "INVOKE", target = "Lnet/minecraft/village/raid/Raid;updateBar()V", ordinal = 0))
    private void onWaveSpawn(BlockPos pos, CallbackInfo ci) {
        Raid instance = (Raid) (Object) this;
        if(instance.getWorld() instanceof ServerWorld serverWorld) {
            RaidWaveSpawnCallback.EVENT.invoker().onSpawn(serverWorld, instance, pos);
        }
    }
}
