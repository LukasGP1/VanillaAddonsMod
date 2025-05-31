package de.lulkas_.vanilla_addons;

import de.lulkas_.vanilla_addons.screen.ModScreenHandlers;
import de.lulkas_.vanilla_addons.screen.custom.EnchantmentUpgraderScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class VanillaAddonsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.ENCHANTMENT_UPGRADER_SCREEN_HANDLER, EnchantmentUpgraderScreen::new);
    }
}
