package de.lulkas_.vanilla_addons.event.custom;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.raid.Raid;

public interface RaidWaveSpawnCallback {
    Event<RaidWaveSpawnCallback> EVENT = EventFactory.createArrayBacked(
            RaidWaveSpawnCallback.class,
            (listeners) -> (world, raid, pos) -> {
                for(RaidWaveSpawnCallback listener : listeners) {
                    listener.onSpawn(world, raid, pos);
                }
            }
    );

    void onSpawn(ServerWorld world, Raid raid, BlockPos pos);
}
