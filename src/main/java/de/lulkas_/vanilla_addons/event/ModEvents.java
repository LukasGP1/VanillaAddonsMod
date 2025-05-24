package de.lulkas_.vanilla_addons.event;

import de.lulkas_.vanilla_addons.VanillaAddons;
import de.lulkas_.vanilla_addons.util.ModRaidWaveMobsSpawner;

public class ModEvents {
    public static void registerModEvents() {
        VanillaAddons.LOGGER.info("Registering Mod Events for " + VanillaAddons.MOD_ID + " Mod");
        RaidWaveSpawnCallback.EVENT.register((world, raid, pos) -> {
            ModRaidWaveMobsSpawner.spawnMobs(world, pos, raid);
        });
    }
}
