package de.lulkas_.vanilla_addons.event;

import de.lulkas_.vanilla_addons.VanillaAddons;
import de.lulkas_.vanilla_addons.entity.ModRaidWaveMobsSpawner;
import de.lulkas_.vanilla_addons.enchantment.TotemReplacer;
import de.lulkas_.vanilla_addons.event.custom.RaidWaveSpawnCallback;
import de.lulkas_.vanilla_addons.event.custom.TickCallback;
import de.lulkas_.vanilla_addons.event.custom.TotemUseCallback;
import de.lulkas_.vanilla_addons.loot.ModLootTableModifiers;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;

public class ModEvents {
    public static void registerModEvents() {
        VanillaAddons.LOGGER.info("Registering Mod Events for " + VanillaAddons.MOD_ID + " Mod");

        RaidWaveSpawnCallback.EVENT.register((world, raid, pos) -> {
            ModRaidWaveMobsSpawner.spawnMobs(world, pos, raid);
        });

        TotemUseCallback.EVENT.register(TotemReplacer::useTotem);
        TickCallback.EVENT.register(TotemReplacer::tick);

        LootTableEvents.MODIFY.register(ModLootTableModifiers::modifyLootTables);
    }
}
