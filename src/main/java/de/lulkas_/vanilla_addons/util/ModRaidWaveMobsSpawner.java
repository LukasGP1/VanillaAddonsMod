package de.lulkas_.vanilla_addons.util;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.raid.RaiderEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.raid.Raid;

public class ModRaidWaveMobsSpawner {
    enum ModRaidWaveMobs {
        ILLUSIONER(EntityType.ILLUSIONER, new int[]{0, 0, 1, 1, 1, 2, 2, 2});

        static final ModRaidWaveMobs[] VALUES = values();
        final EntityType<? extends RaiderEntity> type;
        final int[] countInWave;

        ModRaidWaveMobs(final EntityType<? extends RaiderEntity> type, final int[] countInWave) {
            this.type = type;
            this.countInWave = countInWave;
        }
    }

    public static void spawnMobs(ServerWorld world, BlockPos pos, Raid raid) {
        for(ModRaidWaveMobs mod : ModRaidWaveMobs.VALUES) {
            int count = mod.countInWave[raid.getGroupsSpawned() - 1];
            for(int i = 0; i < count; i++) {
                RaiderEntity raiderEntity = mod.type.create(world);
                if(raiderEntity == null)  {
                    break;
                }
                raid.addRaider(raid.getGroupsSpawned(), raiderEntity, pos, false);
            }
        }
    }
}
